package co.edu.uniquindio.clinica.dto.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record HorarioDTO(

        LocalDate dia,
        LocalDateTime horaInicio,
        LocalDateTime horaSalida


) {
}
