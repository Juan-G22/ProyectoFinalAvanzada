package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.TipoPQRS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroPQRSDTO(

        @NotNull int codigoCita,
        @NotBlank String motivo,
        @NotNull int codigoPaciente,
        @NotNull TipoPQRS tipoPQRS
) {
}
