package Progetto.ing.sw.primaVersione.login;
import java.io.Serializable;

public class Configuratore implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean check;

    public Configuratore(String username, String password) {
        this.username = username;
        this.password = password;
        this.check = check;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }






    }




