package co.edu.uniquindio.clinica.modelo.enums;

public enum EstadoUsuario {

    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private String nombre;

    EstadoUsuario(String nombre) {this.nombre = nombre;}
}
