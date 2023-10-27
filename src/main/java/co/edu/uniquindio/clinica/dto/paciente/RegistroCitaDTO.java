package co.edu.uniquindio.clinica.dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record RegistroCitaDTO(

       @NotNull int codigoPaciente,
       @Past(message = "Seleccione una fecha correcta") LocalDateTime fecha,
       @NotNull int codigoMedico,
       @NotBlank String motivo
) {
}
