package Progetto.ing.sw.primaVersione;
import java.io.Serializable;
import Progetto.ing.sw.Utility;

public class Configuratore implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public Configuratore(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }






    }




