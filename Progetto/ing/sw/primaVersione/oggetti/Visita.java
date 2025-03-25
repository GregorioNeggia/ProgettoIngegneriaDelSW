package Progetto.ing.sw.primaVersione.oggetti;

public class Visita {
    private String nome;
    private String tipo;
    private String stato;

    public Visita(String nome, String tipo, String stato) {
        this.nome = nome;
        this.tipo = tipo;
        this.stato = stato;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStato() {
        return stato;
    }

}
