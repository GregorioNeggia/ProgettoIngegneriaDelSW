package Progetto.ing.sw.primaVersione.gestioni;

import Progetto.ing.sw.primaVersione.oggetti.Configuratore;
import Progetto.ing.sw.primaVersione.schermate.Login;

public class GestioneLogin {

    private Configuratore configuratore;
    private Login login;

    public GestioneLogin(Configuratore configuratore, Login login) {
        this.configuratore = configuratore;
        this.login = login;


        login.setVisible(true);

    }


}
