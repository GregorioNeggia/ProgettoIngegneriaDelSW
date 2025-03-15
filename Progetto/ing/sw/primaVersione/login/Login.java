package Progetto.ing.sw.primaVersione.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static Progetto.ing.sw.generico.Utilità.Grafica.*;

public class Login extends JFrame {
    private static final String FILE_CONFIGURATORE = "configuratori.ser";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin123";

    //costanti per i testi
    private static final String ERRORE_SALVATAGGIO = "Errore durante il salvataggio delle credenziali.";
    private static final String ERRORE_CARICAMENTO = "Errore durante il caricamento delle credenziali.";
    private static final String INSERISCI_USERNAME_DEFAULT = "Inserisci username (Di default): ";
    private static final String INSERISCI_PASSWORD_DEFAULT = "Inserisci password: (Di default): ";
    private static final String CREA_PROFILO = "Ora puoi creare il tuo profilo configuratore\n";
    private static final String INSERISCI_USERNAME = "Inserisci username: ";
    private static final String INSERISCI_PASSWORD = "Inserisci password: ";
    private static final String USERNAME_PASSWORD_ERRATI = "Username o password errati.\n Devi inserire quelli di default Riprova\n";
    private static final String NESSUN_CONFIGURATORE = "Nessun configuratore presente. Creazione di un nuovo configuratore...";



    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton = bottoneAzione("Login");
    private JLabel messageLabel;

    public Login() {
        setTitle("Login Configuratore");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);//Rimuove il bordo
        setOpacity(0.97f);//Trasparenza

        schermataAvvio(); // Usa il frame esistente invece di crearne uno nuovo
        setVisible(true); // Mostra il frame alla fine
    }

    private void schermataAvvio() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(44, 62, 80), getWidth(), getHeight(), new Color(52, 152, 219));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout()); //Per centrare tutto
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Spazio tra gli elementi
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;


        JLabel benvenuto = new JLabel("Benvenuto nel sistema di configurazione");
        benvenuto.setFont(new Font("Arial", Font.BOLD, 18));
        benvenuto.setForeground(Color.WHITE);


        JButton iscriviti = createStyledButton("Iscriviti", new Color(52, 152, 219), new Color(41, 128, 185));
        JButton login = createStyledButton("Login", new Color(46, 204, 113), new Color(39, 174, 96));

        iscriviti.addActionListener(e -> checkUsername());
        login.addActionListener(e -> handleLogin());

        panel.add(benvenuto, gbc);
        gbc.gridy++;
        panel.add(iscriviti, gbc);
        gbc.gridy++;
        panel.add(login, gbc);

        add(panel);
    }

    private JButton createStyledButton(String text, Color baseColor, Color hoverColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
                g2.dispose();
            }
        };

        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(baseColor);
        button.setBorder(BorderFactory.createLineBorder(baseColor.darker(), 2));
        button.setPreferredSize(new Dimension(150, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(baseColor);
            }
        });

        return button;
    }


    private void checkUsername() {
        String username = usernameField.getText();
        List<Configuratore> configuratori = GestoreConfiguratori.caricaConfiguratori();
        boolean userExists = configuratori != null && configuratori.stream().anyMatch(c -> c.getUsername().equals(username));

        if (userExists) {
            passwordField.setEnabled(true);
            messageLabel.setText("Inserisci la password.");
        } else {
            passwordField.setEnabled(false);
            messageLabel.setText("Username non trovato. Usa le credenziali di default.");
        }
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        List<Configuratore> configuratori = GestoreConfiguratori.caricaConfiguratori();
        boolean userExists = configuratori != null && configuratori.stream().anyMatch(c -> c.getUsername().equals(username) && c.getPassword().equals(password));

        if (userExists) {
            messageLabel.setText("Login riuscito.");
            //logica post login
        } else if (username.equals(DEFAULT_USERNAME) && password.equals(DEFAULT_PASSWORD)) {
            messageLabel.setText("Login con credenziali di default riuscito. Crea il tuo profilo.");
           /*Configuratore nuovoConfiguratore = GestoreConfiguratori.creaConfiguratore();
            if (nuovoConfiguratore != null) {
                GestoreConfiguratori.aggiungiConfiguratore(nuovoConfiguratore);
                messageLabel.setText("Profilo creato con successo.");
            }*/
        } else {
            messageLabel.setText("Credenziali errate.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
