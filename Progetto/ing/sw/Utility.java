package Progetto.ing.sw;
import java.util.*;

public class Utility {
    private static Scanner scanner = new Scanner(System.in);
//metodi per input dati
    public static int leggiIntero(String messaggio) {
            System.out.print(messaggio);
            while (!scanner.hasNextInt()) {
                System.out.print("Per favore, inserisci un numero intero: ");
                scanner.next();
            }
            return scanner.nextInt();
        }

        public static String leggiStringa(String messaggio) {
            System.out.print(messaggio);
            return scanner.next();
        }
    }



