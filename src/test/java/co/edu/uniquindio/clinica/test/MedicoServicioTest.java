package co.edu.uniquindio.clinica.test;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;


@SpringBootTest
public class MedicoServicioTest {

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:dataset.sql" )
    public void testListarCitasPendientes() throws Exception {

        int codigoMedico = 13;

        List<ItemCitaAdminDTO> citasPendientes =  medicoServicio.listarCitasPendientes(codigoMedico);
        // Llama al método de servicio y verifica los resultados
        citasPendientes.forEach(System.out::println);

//Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertNotNull(citasPendientes);
        Assertions.assertEquals(0, citasPendientes.size());


    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void testAtenderCita() throws Exception {
        // Crear un objeto RegistroAtencionDTO con datos de prueba

        // Crear un objeto RegistroAtencionDTO con datos de prueba
        RegistroAtencionDTO registroAtencionDTO = new RegistroAtencionDTO(
                6,
                14,
                "No presenta novedaddes",
                "Tomar medicamentos por un año",
                "Sin novedades",
                false);


        int nuevo = medicoServicio.atenderCita(registroAtencionDTO );
        Assertions.assertEquals(0, nuevo);


    }


}
