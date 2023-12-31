package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface CitaRepo extends JpaRepository<Cita,Integer> {

    Cita findByCodigo(int codigo);



    List<Cita> findByMedicoCodigo(int codigoMedico);
    List<Cita> findByPacienteCodigo(int codigoPaciente);
    List<Cita> findAllByPacienteCodigo(int codigoPaciente);

}
