package co.edu.uniquindio.clinica.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public record ValidacionDTO(
       String campo,
       String error
) {

}
