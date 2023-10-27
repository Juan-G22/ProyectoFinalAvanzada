package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.EPS;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegistroPacienteDTO(

        @NotBlank @Length(max = 10)String cedula,
        @NotBlank @Length(max = 200) String nombre,
        @NotBlank @Length(max = 20) String telefono,
        @NotBlank
        String urlFoto,
        @NotNull Ciudad ciudad,

        @NotNull
        @Future(message = "Seleccione una fecha de nacimiento correcta")
        LocalDate fechaNacimiento,
       @NotBlank String alergias,
        @NotNull EPS eps,
        @NotNull  TipoSangre tipoSangre,
        @NotNull @Length(max = 80)String correo,
       @NotBlank String password


) {
}
