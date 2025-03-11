package Progetto.ing.sw.generico;

public class Data {
    private int[] numero_giornoNB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31};
    private int[] numero_giornoB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28};
    private int numero_giorno;
    private String[] nome_meseArr = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno",
            "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
    private String nome_mese;
    private int anno;
    private boolean bisestile;
    private String[] giorniArr = {"Domenica", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato"};

    public Data(int numero_giorno, String nome_mese, int anno) {
        this.numero_giorno = numero_giorno;
        this.nome_mese = nome_mese;
        this.anno = anno;
        this.bisestile = isBisestile(anno);
    }







    private boolean isBisestile(int anno) {
        if (anno % 4 == 0) {
            if (anno % 100 == 0) {
                if (anno % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }










    //getter
    public int getNumero_giorno() {
        return this.numero_giorno;
    }

    public String getNome_mese() {
        return this.nome_mese;
    }


    public int getAnno() {
        return this.anno;
    }



    //setter



    public void SetAnno(int a) {
        this.anno = a;
    }




}
