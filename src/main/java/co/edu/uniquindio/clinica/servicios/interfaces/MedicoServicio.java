package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;

import java.util.List;

public interface MedicoServicio {

    List<ItemCitaAdminDTO> listarCitasPendientes(int codigoMedico) throws Exception;

    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception;

    List<ItemCitaAdminDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception;

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<ItemCitaAdminDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;

    DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception;
}
