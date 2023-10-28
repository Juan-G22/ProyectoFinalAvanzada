package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.EPS;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@SpringBootTest
@Transactional
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
     public void registrarPacienteTest()throws Exception{

        RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO("1004917855", "Juan Sebastian Murcia", "3005073525", "aqui va la direccion url de la foto", Ciudad.PEREIRA, LocalDate.of(2000,6,21), "Alergia a los lacteos", EPS.CAFESALUD, TipoSangre.A_POSITIVO, "JuanMurcia@gmail.com", "1234");
        int nuevo = this.pacienteServicio.registrarse(pacienteDTO);
        Assertions.assertNotEquals(0, nuevo);

    }






}
