package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

import java.time.LocalDateTime;

public record DetalleAtencionMedicaDTO(

    int codigoCita,
    String nombrePaciente,
    String nombreMedico,
    Especialidad especialidad,
    LocalDateTime fechaAtencion,
    String tratamiento,
    String notasMedicas,
    String diagnostico
)
     {
}

