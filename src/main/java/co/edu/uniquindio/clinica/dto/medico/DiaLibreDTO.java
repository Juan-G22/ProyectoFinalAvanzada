package co.edu.uniquindio.clinica.dto.medico;

import java.time.LocalDate;

public record DiaLibreDTO(
        int codigoMedico,
        LocalDate fecha
) {
}
