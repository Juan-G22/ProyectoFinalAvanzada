package co.edu.uniquindio.clinica.dto;

public record MensajeDTO<T>(

        boolean error,

        T respuesta
) {
}
