package Progetto.ing.sw.primaVersione.credenziali;

import Progetto.ing.sw.Utility;

public class Configuratore {

    private String usernameIniziale= "admin";
    private String passwordIniziale = "123";
    private boolean primoAccesso = false;
    private String username;
    private String password;

    public boolean primoAccessoControllo(){
        boolean accesso = false;
        String username = Utility.leggiStringa("Inserisci username: ");
        String password = Utility.leggiStringa("Inserisci password: ");
        if (username.equalsIgnoreCase(usernameIniziale)){;
            if (password.equals(passwordIniziale)){
                accesso = true;
            }
        }

        return accesso;
    }

    public Configuratore(String usernameIniziale, String passwordIniziale, boolean primoAccesso){
        boolean accesso = primoAccessoControllo();
        if(primoAccesso){
            this.username = username;
            this.password = password;
            this.primoAccesso = accesso;
        }


    }



}
