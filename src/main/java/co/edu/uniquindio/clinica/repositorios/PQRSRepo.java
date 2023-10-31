package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRSRepo extends JpaRepository<PQRS,Integer> {
    List<PQRS> findAllByCitaPacienteCodigo(int codigoPaciente);

}
