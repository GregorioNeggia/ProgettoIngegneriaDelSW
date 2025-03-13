package Progetto.ing.sw.generico.Utilità;

import javax.swing.*;
import java.awt.*;

public class Grafica {

    public static JButton bottoneAzione(String messaggio){
        JButton bottoneAzione = new JButton(messaggio);
        bottoneAzione.setSize(50,50);
        bottoneAzione.setFont(new Font("Arial", Font.BOLD, 16)); // Cambia font e dimensione testo
        bottoneAzione.setForeground(Color.black); // Cambia colore del testo
        bottoneAzione.setBackground(Color.GRAY);  // Cambia colore sfondo
        bottoneAzione.setBorder(BorderFactory.createLineBorder(Color.black, 4));

        return bottoneAzione;
    }

    public static JFrame framePrincipale(String titolo){
        JFrame frame = new JFrame();
        frame.setTitle(titolo);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }





}
