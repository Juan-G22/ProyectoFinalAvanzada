package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AtencionRepo extends JpaRepository<Atencion,Integer> {

    Optional<Atencion> findByCodigo(int codigo );
}
