package Progetto.ing.sw;

public class Data {
    private int numero_giorno;
    private String nome_mese;
    private int anno;
    private String nome_giorno;
    private String nome_mese_abbreviato;

    public Data(int n, String m, int a, String g, String m_abbreviato) {
        this.numero_giorno = n;
        this.nome_mese = m;
        this.anno = a;
        this.nome_giorno = g;
        this.nome_mese_abbreviato = m_abbreviato;
    }

    public int getNumeroGiorno() {
        return this.numero_giorno;
    }

    public String getNomeMese() {
        return this.nome_mese;
    }

    public int getAnno() {
        return this.anno;
    }

    public String getNomeGiorno() {
        return this.nome_giorno;
    }

    public String getNomeMeseAbbreviato() {
        return this.nome_mese_abbreviato;
    }

    public void SetNumeroGiorno(int n) {
        this.numero_giorno = n;
    }

    public void SetNomeMese(String m) {
        this.nome_mese = m;
    }

    public void SetAnno(int a) {
        this.anno = a;
    }
}
