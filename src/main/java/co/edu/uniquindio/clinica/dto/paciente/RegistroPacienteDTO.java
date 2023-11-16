package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.EPS;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import jakarta.validation.constraints.Email;
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
        @NotBlank         String urlFoto,
        @NotNull Ciudad ciudad,

        @NotNull
        LocalDate fechaNacimiento,
       @NotBlank String alergias,
        @NotNull EPS eps,
        @NotNull  TipoSangre tipoSangre,
        @NotNull @Length(max = 80)@NotBlank
        @Length(max = 80, message = "El correo debe tener máximo 80 caracteres")
        @Email(message = "Ingrese una dirección de correo electrónico válida")

        String correo,
       @NotBlank String password


) {
}
