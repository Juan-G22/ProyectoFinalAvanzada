package co.edu.uniquindio.clinica.modelo.enums;

public enum TipoPQRS {

    PETICIONES("Petición"),
    QUEJAS("Queja"),
    RECLAMOS("Reclamo"),
    SUGERENCIAS("Sugerencia");

    private String nombre;

    TipoPQRS(String nombre) {this.nombre = nombre;}
}
