package davidnavarronavarro_developer.gestionsqlite;

/**
 * Created by david on 28/01/15.
 */
public class Usuario {
    private String  login;
    private String password;
    private String nombre;
    private String apellidos;
    private Integer telefono;

    public Usuario(String login, String password, String nombre, String apellidos, Integer telefono){

        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;

    }

    public String getLogin(){

        return login;
    }

    public String getPassword(){

        return password;
    }

    public String getNombre(){

        return nombre;
    }

    public String getApellidos(){

        return apellidos;
    }

    public Integer getTelefono(){

        return telefono;
    }
}
