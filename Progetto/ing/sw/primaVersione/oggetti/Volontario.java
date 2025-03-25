package Progetto.ing.sw.primaVersione.oggetti;
import java.util.*;
public class Volontario {
    private String nome;
    private List<String> tipiVisita;

    public Volontario(String nome, List<String> tipiVisita) {
        this.nome = nome;
        this.tipiVisita = tipiVisita;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getTipiVisita() {
        return tipiVisita;
    }

}
