
package Modelo;

public class Docente extends Persona{
    private int id_docente;
    private String area;
    private int id_usuario;

    public Docente() {
    }

    public Docente(int id_docente, String area, int id_usuario, String nombre, String apellido, String direccion, String telefono) {
        super(nombre, apellido, direccion, telefono);
        this.id_docente = id_docente;
        this.area = area;
        this.id_usuario = id_usuario;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
