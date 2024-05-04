package Modelo;

public class Usuario {

    private int id_usuario;
    private String nombre_usuario;
    private String contrasenia;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, Rol rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // Método para convertir una cadena de texto en un enum Rol
    public static Rol parseRol(String rolStr) {
        switch (rolStr.toLowerCase()) {
            case "administrador":
                return Rol.ADMINISTRADOR;
            case "docente":
                return Rol.DOCENTE;
            case "estudiante":
                return Rol.ESTUDIANTE;
            default:
                // Si la cadena no coincide con ningún valor enum se lanza una excepción
                throw new IllegalArgumentException("Rol no válido: " + rolStr);
        }
    }
}
