package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.EPS;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetallePacienteDTO(

        int codigo,
        String cedula,
        String nombre,
        String telefono,
        String urlFoto,
        Ciudad ciudad,
        LocalDate fechaNacimiento,
        String alergias,
        String correo,
        EPS eps,
        TipoSangre tipoSangre
) {
}
