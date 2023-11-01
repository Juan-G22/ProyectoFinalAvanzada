package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.dto.admin.*;
import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;

import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@SpringBootTest
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;
    @Test
    @Sql("classpath:dataset.sql" )
    public void crearMedicoTest() throws Exception{

        HorarioDTO horarioDTO1 = new HorarioDTO(
                LocalDateTime.of(2023,10,18,0,0),
                LocalDateTime.of(2023,10,18,6,0),
                LocalDateTime.of(2023,10,18,16,0)
        );
        HorarioDTO horarioDTO2 = new HorarioDTO(
                LocalDateTime.of(2023,10,19,0,0),
                LocalDateTime.of(2023,10,19,9,0),
                LocalDateTime.of(2023,10,19,20,0)
        );

        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(horarioDTO1);
        horarios.add(horarioDTO2);

        RegistroMedicoDTO registroMedicoDTO = new RegistroMedicoDTO(
                "Maria Camila Pérez",
                "1078298712",
                Ciudad.CALARCA,
                Especialidad.CIRUGIA_GENERAL,
                "3213458796",
                "maripe@gmail.com",
                "123456",
                "Url_Foto",
                horarios
        );
        int nuevo = administradorServicio.crearMedico(registroMedicoDTO);

        Assertions.assertNotEquals(0,nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void actualizarMedicoTest() throws Exception{
        DetalleMedicoDTO detalleMedicoDTO = administradorServicio.obtenerMedico(9);

        DetalleMedicoDTO modificado = new DetalleMedicoDTO(
                detalleMedicoDTO.codigo(),
                detalleMedicoDTO.nombre(),
                detalleMedicoDTO.cedula(),
                detalleMedicoDTO.ciudad(),
                detalleMedicoDTO.especialidad(),
                "3213569087",
                "cualquiera@gmail.com",
                detalleMedicoDTO.urlFoto(),
                detalleMedicoDTO.horarios());

        administradorServicio.actualizarMedico(modificado);

        DetalleMedicoDTO actualizado = administradorServicio.obtenerMedico(9);

        Assertions.assertEquals("3213569087", actualizado.telefono());
        Assertions.assertEquals("cualquiera@gmail.com", actualizado.correo());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMedicoTest() throws Exception{
        DetalleMedicoDTO detalleMedicoDTO = administradorServicio.obtenerMedico(12);
        Assertions.assertNotEquals(1, detalleMedicoDTO.codigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMedicosTest() throws Exception{
        List<ItemMedicoDTO> medicos = administradorServicio.listarMedicos();
        medicos.forEach(System.out::println);

        Assertions.assertEquals(5, medicos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMedicoTest() throws Exception {

        boolean respuesta = this.administradorServicio.eliminarMedico(8);
        Assertions.assertTrue(respuesta);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePQRSTest() throws Exception{
        DetallePQRSDTO detallePQRSDTO = administradorServicio.verDetallePQRS(5);
        System.out.println(detallePQRSDTO.toString());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void responderPQRSTest() throws Exception {
        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(
                12,
                4,
                "respuesta del administrador"
        );
        administradorServicio.responderPQRS(registroRespuestaDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoPQRSTest() throws Exception{
        administradorServicio.cambiarEstadoPQRS(2, EstadoPQRS.ARCHIVADO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasTest() throws Exception{
        List<ItemCitaAdminDTO> listarCitas = administradorServicio.listarCitas();
        Assertions.assertEquals(5, listarCitas.size());
    }






}
