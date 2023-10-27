package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteServicioImpl implements PacienteServicio {


    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO PacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public void eliminarCuenta(int codigoPaciente) throws Exception {

    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {
        return null;
    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        return 0;
    }

    @Override
    public void cambiarCita(CambioCitaDTO cambioCitaDTO) throws Exception {

    }

    @Override
    public void asignarCitaEspecialista(RegistroCitaDTO registroCitaDTO) throws Exception {

    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception {

    }

    @Override
    public DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception {
        return null;
    }
}
