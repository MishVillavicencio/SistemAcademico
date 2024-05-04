
package Modelo;

public class Administrador extends Persona{
    private int id_admin;
    private String cargo;
    private int id_usuario;

    public Administrador() {
    }

    public Administrador(int id_admin, String cargo, int id_usuario, String nombre, String apellido, String direccion, String telefono) {
        super(nombre, apellido, direccion, telefono);
        this.id_admin = id_admin;
        this.cargo = cargo;
        this.id_usuario = id_usuario;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    
}
