
package dto;

public class Usuario {
    
    private int idUsuario;
    private String rol;
    private String username;
    private String pass;
    
    public Usuario (){
    
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "role=" + rol + ", username=" + username + ", password=" + pass + '}';
    }
    
    
    
}
