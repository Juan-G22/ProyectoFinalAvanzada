package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO registroPacienteDTO)throws Exception;

    int editarPerfil(DetallePacienteDTO PacienteDTO) throws Exception;

    void eliminarCuenta(int codigoPaciente) throws Exception;

    DetallePacienteDTO verDetallePaciente(int codigo) throws Exception;

    void enviarLinkRecuperacion(String email) throws Exception;

    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    void cambiarCita(CambioCitaDTO cambioCitaDTO )throws Exception; //Preguntar

    void asignarCitaEspecialista(RegistroCitaDTO registroCitaDTO) throws Exception; //Preguntar

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaAdminDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception;

    DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception;
}
