package Progetto.ing.sw.generico;

public class Luogo {
    private String nome;
    private String descrizione;
    private String posizioneGeografica;
    private String ambitoTerritoriale;
    private boolean accessibile;


    public Luogo(String nome, String descrizione, String posizioneGeografica, String ambitoTerritoriale, boolean accessibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.posizioneGeografica = posizioneGeografica;
        this.ambitoTerritoriale = ambitoTerritoriale;
        this.accessibile = accessibile;
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

    public String getAmbitoTerritoriale() {
        return ambitoTerritoriale;
    }

    public boolean isAccessibile() {
        return accessibile;
    }

    @Override
    public String toString() {
        return "Luogo: \n" +
                " nome: \n" + nome +
                " descrizione: \n" + descrizione +
                " posizioneGeografica: \n" + posizioneGeografica +
                " Ambito Territoriale: \n" + ambitoTerritoriale;
    }
}
