package co.edu.uniquindio.clinica.dto;

public record NuevaPasswordDTO(


        int codigoPaciente,
        String antiguaPassword,
        String nuevaPassword
) {
}
