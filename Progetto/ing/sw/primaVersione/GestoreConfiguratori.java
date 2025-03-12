package Progetto.ing.sw.primaVersione;
import Progetto.ing.sw.Utility;

import java.io.*;
import java.util.*;

public class GestoreConfiguratori {
    private static final String FILE_CONFIGURATORE = "configuratori.ser";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin123";

    public static void salvaConfiguratore(List<Configuratore> configuratori) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_CONFIGURATORE))) {
            oos.writeObject(configuratori);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio delle credenziali.");
            e.printStackTrace();
        }
    }



    public static List<Configuratore> caricaConfiguratori() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_CONFIGURATORE))) {
            return (List<Configuratore>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante il caricamento delle credenziali.");
            return new ArrayList<>();
        }
    }

    public static void aggiungiConfiguratore(Configuratore configuratore) {
        List<Configuratore> configuratori = caricaConfiguratori();
        configuratori.add(configuratore);
        salvaConfiguratore(configuratori);
    }

    public static Configuratore creaConfiguratore(){

        Configuratore configuratore = new Configuratore(DEFAULT_USERNAME, DEFAULT_PASSWORD);
        String username = Utility.leggiStringa("Inserisci username (Di default): ");
        String password = Utility.leggiStringa("Inserisci password: (Di default): ");
        if(username.equals(configuratore.getUsername()) && password.equals(configuratore.getPassword())){
            System.out.println("Ora puoi creare il tuo profilo configuratore\n");
            configuratore.setUsername(Utility.leggiStringa("Inserisci username: "));
            configuratore.setPassword(Utility.leggiStringa("Inserisci password: "));
            return configuratore;
        }else
            System.out.println("Username o password errati.\n Devi inserire quelli di default Riprova\n");

        return null;

    }

    public static void loginConfiguratore(){
        if(caricaConfiguratori().isEmpty()){
            System.out.println("Nessun configuratore presente. Creazione di un nuovo configuratore...");
            aggiungiConfiguratore(new Configuratore(DEFAULT_USERNAME, DEFAULT_PASSWORD));

        }





    }


}
