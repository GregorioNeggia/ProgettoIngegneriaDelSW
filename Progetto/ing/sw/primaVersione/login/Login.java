package Progetto.ing.sw.primaVersione.login;

import javax.swing.*;
import java.awt.*;
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
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        schermataAvvio(); // Usa il frame esistente invece di crearne uno nuovo
        setVisible(true); // Mostra il frame alla fine
    }

    private void schermataAvvio() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spaziatura tra i componenti
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel benvenuto = new JLabel("Benvenuto nel sistema di configurazione");
        benvenuto.setFont(new Font("Arial", Font.BOLD, 18));

        JButton iscriviti = new JButton("Iscriviti");
        JButton login = new JButton("Login");

        iscriviti.setPreferredSize(new Dimension(150, 40));
        login.setPreferredSize(new Dimension(150, 40));
        //Colori per i pulsanti
        iscriviti.setBackground(new Color(52, 152, 219)); // Blu chiaro
        iscriviti.setForeground(Color.WHITE);
        iscriviti.setFocusPainted(false);
        iscriviti.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2));
        login.setBackground(new Color(46, 204, 113)); // Verde chiaro
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createLineBorder(new Color(39, 174, 96), 2));


        iscriviti.addActionListener(e -> apriRegistrazione());
        login.addActionListener(e -> apriLogin());

        panel.add(benvenuto, gbc);

        gbc.gridy++;
        panel.add(iscriviti, gbc);

        gbc.gridy++;
        panel.add(login, gbc);

        // Aggiunta del pannello al frame
        add(panel);
    }

    // Metodi per aprire le nuove finestre
    private void apriRegistrazione() {
        System.out.println("Apertura finestra registrazione...");
        //Apertura nuova finestra per la registrazione

    }

    private void apriLogin() {
        System.out.println("Apertura finestra login...");
        // Qui puoi aprire una nuova finestra per il login vero e proprio
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
            Configuratore nuovoConfiguratore = GestoreConfiguratori.creaConfiguratore();
            if (nuovoConfiguratore != null) {
                GestoreConfiguratori.aggiungiConfiguratore(nuovoConfiguratore);
                messageLabel.setText("Profilo creato con successo.");
            }
        } else {
            messageLabel.setText("Credenziali errate.");
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
