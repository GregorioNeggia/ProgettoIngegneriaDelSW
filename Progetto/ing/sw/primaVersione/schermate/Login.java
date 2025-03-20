package Progetto.ing.sw.primaVersione.schermate;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private static final String FILE_CONFIGURATORE = "configuratori.ser";
    private static final String DEFAULT_USERNAME = "user";
    private static final String DEFAULT_PASSWORD = "123";

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    private JButton iscriviti;
    private JButton login;
    private JButton indietro;

    public Login() {
        setTitle("Login Configuratore");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Se mettiamo queste due tiglie la 'x' nella barra sopra per poter uscire dal programma
        //setUndecorated(true); // Finestra senza bordi
        //setOpacity(0.97f); // Per la trasparenza

        schermataAvvio(); // Mostra la schermata iniziale
        setVisible(true);
    }

    private void schermataAvvio() {
        getContentPane().removeAll();//Pulisce la finestra così non abbiamo sovrapposizioni
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
        panel.setLayout(new GridBagLayout()); // Centra tutto
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Spazio tra gli elementi
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel benvenuto = new JLabel("Benvenuto nel sistema");
        benvenuto.setFont(new Font("Arial", Font.BOLD, 22));
        benvenuto.setForeground(Color.WHITE);

        JButton iscriviti = creaPulsanti("Iscriviti", new Color(52, 152, 219), new Color(41, 128, 185));
        JButton login = creaPulsanti("Login", new Color(46, 204, 113), new Color(39, 174, 96));

        // Eventi per cambiare schermata
        login.addActionListener(e -> schermataLogin());
        iscriviti.addActionListener(e -> schermataDefault());

        panel.add(benvenuto, gbc);
        gbc.gridy++;
        panel.add(iscriviti, gbc);
        gbc.gridy++;
        panel.add(login, gbc);

        setContentPane(panel); // Imposta il nuovo pannello come contenuto principale
        revalidate(); // Ricarica il layout
        repaint(); // Ridisegna la finestra
    }

    private JButton creaPulsanti(String text, Color baseColor, Color hoverColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                super.paintComponent(g);
                g2.dispose();
            }
        };

        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(baseColor);
        button.setBorder(BorderFactory.createLineBorder(baseColor.darker(), 3));
        button.setPreferredSize(new Dimension(250, 50));
        button.setFont(new Font("Arial", Font.BOLD, 18));

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

    private void schermataLogin() {
        getContentPane().removeAll(); // Pulisce la finestra
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout verticale


        JLabel label = new JLabel("Inserisci le credenziali:");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campi di testo ridotti
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        usernameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));
        usernameField.setMaximumSize(new Dimension(200, 30));
        passwordField.setMaximumSize(new Dimension(200, 30));

        // Etichette per i campi
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        login = creaPulsanti("Accedi", new Color(46, 204, 113), new Color(39, 174, 96));
        indietro = creaPulsanti("Indietro", new Color(231, 76, 60), new Color(192, 57, 43)); // Pulsante per tornare indietro
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        indietro.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Pannello per username e password
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(userLabel);
        inputPanel.add(usernameField);
        inputPanel.add(Box.createVerticalStrut(10)); // Spazio tra i campi
        inputPanel.add(passLabel);
        inputPanel.add(passwordField);

        // Evento per il login (da implementare)
        //login.addActionListener(e -> handleLogin());

        // Evento per tornare alla schermata principale
        indietro.addActionListener(e -> schermataAvvio());

        /* questo dava i problemi dei pulsanti 'accedi' e 'indietro' enormi
        // Pannello per i pulsanti
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0)); // Affianca i pulsanti
        buttonPanel.add(indietro);
        buttonPanel.add(login);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        */

        // Aggiunta componenti al pannello principale
        panel.add(label);
        panel.add(Box.createVerticalStrut(10)); // Spazio dopo il titolo
        panel.add(inputPanel);
        panel.add(Box.createVerticalStrut(20)); // Spazio tra campi e pulsanti
        panel.add(login);
        panel.add(indietro);

        add(panel);
        revalidate();
        repaint();
    }

    private void schermataRegistrazione(){

    }

    private void schermataDefault() {
        getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //<html> ho letto che serve per formattare il testo nei JLabel, <br> è il tag di html che serve per andare a capo
        JLabel label = new JLabel("<html>Registrazione:<br>(inserire le credenziali di default)</html>");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Campi di testo ridotti
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        usernameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));
        usernameField.setMaximumSize(new Dimension(200, 30));
        passwordField.setMaximumSize(new Dimension(200, 30));

        // Etichette per i campi
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        login = creaPulsanti("Accedi", new Color(46, 204, 113), new Color(39, 174, 96));
        indietro = creaPulsanti("Indietro", new Color(231, 76, 60), new Color(192, 57, 43)); // Pulsante per tornare indietro
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        indietro.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Pannello per username e password
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(userLabel);
        inputPanel.add(usernameField);
        inputPanel.add(Box.createVerticalStrut(10)); // Spazio tra i campi
        inputPanel.add(passLabel);
        inputPanel.add(passwordField);

        // Evento per tornare indietro
        indietro.addActionListener(e -> schermataAvvio());


        // Aggiunta componenti al pannello principale
        panel.add(label);
        panel.add(Box.createVerticalStrut(10)); // Spazio dopo il titolo
        panel.add(inputPanel);
        panel.add(Box.createVerticalStrut(20)); // Spazio tra campi e pulsanti
        panel.add(login);
        panel.add(indietro);


        add(panel);
        revalidate();
        repaint();

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
