package Progetto.ing.sw;

public class Luogo {
    private String nome;
    private String descrizione;
    private String posizioneGeografica;

    public Luogo(String n, String d, String p) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.posizioneGeografica = posizioneGeografica;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getPosizioneGeografica() {
        return posizioneGeografica;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPosizioneGeografica(String posizioneGeografica) {
        this.posizioneGeografica = posizioneGeografica;
    }

    @Override
    public String toString() {
        return "Luogo: \n" +
                " nome: \n" + nome +
                " descrizione: \n" + descrizione +
                " posizioneGeografica: \n" + posizioneGeografica ;
    }
}
