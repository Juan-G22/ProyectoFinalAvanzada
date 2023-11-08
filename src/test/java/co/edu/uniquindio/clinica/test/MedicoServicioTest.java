package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import net.bytebuddy.implementation.bind.annotation.This;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@SpringBootTest
public class MedicoServicioTest {

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPendientesTest() throws Exception {

        List<ItemCitaAdminDTO> listarCitasPendientes = medicoServicio.listarCitasPendientes(8);
        Assertions.assertEquals(2, listarCitasPendientes.size());

    }

}




















