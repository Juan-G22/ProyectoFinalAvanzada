package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Medico extends Usuario implements Serializable {

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> diaLibres;

    @OneToMany(mappedBy = "medico")
    private List<HorarioMedico> horariosMedico;

    @Column(nullable = false)
    private Especialidad especialidad;
}
