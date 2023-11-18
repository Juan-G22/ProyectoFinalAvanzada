package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroCitaDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPQRSDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.EPS;
import co.edu.uniquindio.clinica.modelo.enums.TipoPQRS;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.boot.test.context.SpringBootTest;


@Transactional
@SpringBootTest
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;


    @Test
        public void registrarPacienteTest()throws Exception{

        RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO("1004917855", "Juan Sebastian Murcia", "3005073525", "aqui va la direccion url de la foto", Ciudad.PEREIRA, LocalDate.of(2000,6,21), "Alergia a los lacteos", EPS.CAFESALUD, TipoSangre.A_POSITIVO, "JuanMurcia@gmail.com", "1234");
        int nuevo = this.pacienteServicio.registrarse(pacienteDTO);
        Assertions.assertNotEquals(0, nuevo);

    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void editarPerfilTest() throws Exception {
        DetallePacienteDTO guardado = this.pacienteServicio.verDetallePaciente(5);
        DetallePacienteDTO modificado = new DetallePacienteDTO(guardado.codigo(), guardado.cedula(), guardado.nombre(), "3146578903", "La Ruta de la foto es la misma",Ciudad.MANIZALES, guardado.fechaNacimiento(), guardado.alergias(), guardado.correo(), guardado.eps(), guardado.tipoSangre());
        this.pacienteServicio.editarPerfil(modificado);
        DetallePacienteDTO objetoModificado = this.pacienteServicio.verDetallePaciente(5);
        Assertions.assertEquals("3146578903", objetoModificado.telefono());
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void eliminarTest() throws Exception {



       boolean respuesta = pacienteServicio.eliminarCuenta("338521427");

        Assertions.assertTrue(respuesta);

    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void verDetallePacienteTest() throws Exception {
        DetallePacienteDTO detallePaciente = this.pacienteServicio.verDetallePaciente(3);
        Assertions.assertNotEquals(0, detallePaciente.codigo());
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void agendarCitaTest() throws Exception {

        RegistroCitaDTO citaDTO = new RegistroCitaDTO(7, LocalDateTime.of(2023, 6, 17, 15, 20), 23, "Nauseas y falta de apetito");
        int nuevaCita = this.pacienteServicio.agendarCita(citaDTO);
        Assertions.assertNotEquals(0, nuevaCita);
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void CrearPQRSTest() throws Exception {
        RegistroPQRSDTO registroPQRSDTO = new RegistroPQRSDTO(5, "Despues de la atencion medica segui con fuertes dolores en mi rodilla izquiera aun despues de tomar pastillas de complejo B", 5, TipoPQRS.QUEJAS);
        int nuevoPQRS = this.pacienteServicio.crearPQRS(registroPQRSDTO);
        Assertions.assertNotEquals(0, nuevoPQRS);
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void PQRSPacienteTest() throws Exception {
        List<ItemPQRSDTO> listaPQRS = this.pacienteServicio.listarPQRSPaciente(6);
        Assertions.assertEquals(2, listaPQRS.size());
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void verDetallePQRSTest() throws Exception {
        DetallePQRSDTO detallePQRS = this.pacienteServicio.verDetallePQRS(3);
        Assertions.assertNotEquals(0, detallePQRS.codigo());
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void responderPQRSTest() throws Exception {
        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(9, 3, "Lo sentimos disculpe la incorformidad");
        int codigo = this.pacienteServicio.responderPQRS(registroRespuestaDTO);
        Assertions.assertNotEquals(0, codigo);
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void CitasPacienteTest() throws Exception{

        List<ItemCitaAdminDTO> listaPQRS = this.pacienteServicio.listarCitasPaciente(3);
        Assertions.assertEquals(1, listaPQRS.size());

    }


    @Test
    @Sql({"classpath:dataset.sql"})
    public void verDetalleCitaTest() throws Exception {
        DetalleAtencionMedicaDTO detalleCita = this.pacienteServicio.verDetalleCita(4);
        Assertions.assertNotEquals(0, detalleCita.codigoCita());
    }







}
