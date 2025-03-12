package Progetto.ing.sw.generico.Utilità;

import Progetto.ing.sw.generico.Utilità.Input;

public class Menu {

    public static int gestisciMenu(String[] opzioni) {
        for (int i = 0; i < opzioni.length; i++) {
            System.out.println((i + 1) + ". " + opzioni[i]);
        }
        int scelta = -1;
        while (scelta < 1 || scelta > opzioni.length) {
            scelta = Input.leggiIntero("Seleziona un'opzione: ");
            if (scelta < 1 || scelta > opzioni.length) {
                System.out.println("Opzione non valida. Riprova.");
            }
        }
        return scelta;
    }
}