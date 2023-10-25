package co.edu.uniquindio.clinica.modelo.enums;

public enum EstadoPQRS {

    NUEVO("Nuevo"),
    EN_PROCESO("En proceso"),
    RESUELTO("Resuelto"),
    ARCHIVADO("Archivado");

    private String nombre;

    EstadoPQRS(String nombre) {this.nombre = nombre;}
}
