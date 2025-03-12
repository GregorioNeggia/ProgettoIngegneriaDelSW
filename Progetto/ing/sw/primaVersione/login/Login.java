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
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordField.setEnabled(false);


        messageLabel = new JLabel();

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        panel.add(messageLabel);

        add(panel, BorderLayout.CENTER);

        usernameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkUsername();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
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
