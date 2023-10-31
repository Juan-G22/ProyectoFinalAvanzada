package co.edu.uniquindio.clinica.dto.admin;

import java.time.LocalDateTime;

public record HorarioDTO(

        LocalDateTime dia,
        LocalDateTime horaInicio,
        LocalDateTime horaSalida


) {
}
