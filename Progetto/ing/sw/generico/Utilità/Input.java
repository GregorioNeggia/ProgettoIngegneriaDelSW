package Progetto.ing.sw.generico.Utilità;
import java.util.*;
import java.io.*;

public class Input {
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







    //metodi per serializzazione input e output
        public static <T> void salvaOggetto(String filePath, T oggetto) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(oggetto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static <T> T caricaOggetto(String filePath) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                return (T) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

    }



