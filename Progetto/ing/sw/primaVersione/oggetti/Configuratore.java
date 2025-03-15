package Progetto.ing.sw.primaVersione.oggetti;
import java.io.Serializable;


public class Configuratore implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;


    public Configuratore(String username, String password) {
        this.username = username;
        this.password = password;

    }

@Override
    public  String toString(){
        StringBuffer sb = new StringBuffer();

        sb.append("Username: ").append(username).append("\n");
        sb.append("Password: ").append(password).append("\n");

        return sb.toString();
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




