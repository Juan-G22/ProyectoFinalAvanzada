<<<<<<< HEAD
package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente,Integer> {

    Paciente findByCedula(String cedula);


    Paciente findByEmail(String email);
}
=======
package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente,Integer> {

     Paciente findByCedula(String cedula);


    Paciente findByEmail(String email);


}
>>>>>>> a1fbc5df0bf041db5bb0b10581effb04e2914c06
