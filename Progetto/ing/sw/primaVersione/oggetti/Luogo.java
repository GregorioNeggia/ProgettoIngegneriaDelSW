package Progetto.ing.sw.primaVersione.oggetti;
import java.util.*;
public class Luogo {

    private String nome;
    private List<String> tipiDiVisita;
    private List<Volontario> volontari;

    public Luogo(String nome, List<String> tipiDiVisita, List<Volontario> volontari) {
        this.nome = nome;
        this.tipiDiVisita = tipiDiVisita;
        this.volontari = volontari;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getTipiDiVisita() {
        return tipiDiVisita;
    }
    public List<Volontario> getVolontari() {
        return volontari;
    }



}
