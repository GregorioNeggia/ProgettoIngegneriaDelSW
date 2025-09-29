package Progetto.ing.sw.primaVersione.gestioni;

import Progetto.ing.sw.primaVersione.oggetti.Configuratore;

import java.io.*;
import java.util.*;

public class GestoreConfiguratori {

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

    public static void salvaConfiguratore(List<Configuratore> configuratori) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_CONFIGURATORE))) {
            oos.writeObject(configuratori);
        } catch (IOException e) {
            System.out.println(ERRORE_SALVATAGGIO);
            e.printStackTrace();
        }
    }

    public static List<Configuratore> caricaConfiguratori() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_CONFIGURATORE))) {
            return (List<Configuratore>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(ERRORE_CARICAMENTO);
            return null;
        }
    }

    public static void aggiungiConfiguratore(Configuratore configuratore) {
        List<Configuratore> configuratori = caricaConfiguratori();
        configuratori.add(configuratore);
        salvaConfiguratore(configuratori);
    }

    public static void creaConfiguratore(List<Configuratore> configuratori) {

        


    }


}



















