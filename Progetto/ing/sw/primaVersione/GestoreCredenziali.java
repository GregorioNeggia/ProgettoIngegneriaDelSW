package Progetto.ing.sw.primaVersione;
import java.io.*;

public class GestoreCredenziali {

    private static final String FILE_CREDENZIALI = "configuratore_credentials.txt";

    public static Configuratore caricaCredenziali() {
        File file = new File(FILE_CREDENZIALI);
        if (!file.exists()) {
            return null; // Se il file non esiste, il primo accesso deve essere con credenziali predefinite
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String username = reader.readLine();
            String password = reader.readLine();
            return new Configuratore(username, password);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void salvaCredenziali(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_CREDENZIALI))) {
            writer.write(username + "\n" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
