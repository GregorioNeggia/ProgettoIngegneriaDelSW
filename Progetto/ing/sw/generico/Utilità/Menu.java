package Progetto.ing.sw.generico.Utilità;

public class Menu {


    private static final String TITOLO = "MENU";
    private static final String SPAZIO = "******************************";
    private static final String SELEZIONA_UN_OPZIONE = "Seleziona un'opzione: ";
    private static final String OPZIONE_INVALIDA = "Opzione non valida. Riprova.";

    public static int gestisciMenu(String[] opzioni) {
        System.out.println(SPAZIO);
        System.out.println(TITOLO);
        System.out.println(SPAZIO);
        for (int i = 0; i < opzioni.length; i++) {
            System.out.println((i + 1) + ". " + opzioni[i]);
        }
        System.out.println(SPAZIO);
        int scelta = -1;
        while (scelta < 1 || scelta > opzioni.length) {
            scelta = Input.leggiIntero(SELEZIONA_UN_OPZIONE);
            if (scelta < 1 || scelta > opzioni.length) {
                System.out.println(OPZIONE_INVALIDA);
            }
        }
        return scelta;
    }
}