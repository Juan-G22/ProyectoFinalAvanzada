package co.edu.uniquindio.clinica.dto.paciente;

import java.time.LocalDateTime;

public record CambioCitaDTO(

        int codigoCita,
        int codigoPaciente,
        LocalDateTime fecha,
        String motivo
) {
}
