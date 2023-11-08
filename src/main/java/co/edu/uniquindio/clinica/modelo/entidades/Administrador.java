package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Administrador extends Cuenta implements Serializable {


}
