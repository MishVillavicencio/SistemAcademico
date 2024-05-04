package Modelo;

import java.util.Date;

public class Estudiante extends Persona{

    private int id_estudiante;
    private String carrera;
    private Date fecha_inscripcion;
    private int id_usuario;

    public Estudiante() {
    }

    public Estudiante(int id_estudiante, String carrera, Date fecha_inscripcion, int id_usuario, String nombre, String apellido, String direccion, String telefono) {
        super(nombre, apellido, direccion, telefono);
        this.id_estudiante = id_estudiante;
        this.carrera = carrera;
        this.fecha_inscripcion = fecha_inscripcion;
        this.id_usuario = id_usuario;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    

}
