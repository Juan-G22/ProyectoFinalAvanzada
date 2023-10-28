package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.modelo.entidades.*;
import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PacienteServicioImpl implements PacienteServicio {



    private final PacienteRepo pacienteRepo;
    private final CuentaRepo cuentaRepo;
    private final CitaRepo citaRepo;
    private final PQRSRepo pqrsRepo;
    private final MensajeRepo mensajeRepo;


    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {

    //    if( estaRepetidaCedula(registroPacienteDTO.cedula()) ){
    //        throw new Exception("La cédula ya se encuentra registrada");
    //    }

    //    if( estaRepetidoCorreo(registroPacienteDTO.correo()) ){
        //throw new Exception("El correo ya se encuentra registrado");
      //  }

        Paciente paciente = new Paciente();
        paciente.setCedula(registroPacienteDTO.cedula());
        paciente.setNombre(registroPacienteDTO.nombre());
        paciente.setTelefono(registroPacienteDTO.telefono());
        paciente.setUrlFoto(registroPacienteDTO.urlFoto());
        paciente.setCiudad(registroPacienteDTO.ciudad());
        paciente.setEmail(registroPacienteDTO.correo());
        paciente.setPassword(registroPacienteDTO.password());
        paciente.setFechaNacimiento(registroPacienteDTO.fechaNacimiento());
        paciente.setAlergias(registroPacienteDTO.alergias());
        paciente.setEps(registroPacienteDTO.eps());
        paciente.setTipoSangre(registroPacienteDTO.tipoSangre());


        Paciente pacienteNuevo = pacienteRepo.save(paciente);
        return pacienteNuevo.getCodigo();



    }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByEmail(correo) != null;
    }

    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO PacienteDTO) throws Exception {

        Optional<Paciente> pacienteBuscado = this.pacienteRepo.findById(PacienteDTO.codigo());
        if (pacienteBuscado.isEmpty()) {
            throw new Exception("No existe un paciente con el codigo" + PacienteDTO.codigo());
        } else {
            Paciente pacienteActualizado = pacienteBuscado.get();
            pacienteActualizado.setCedula(PacienteDTO.cedula());
            pacienteActualizado.setNombre(PacienteDTO.nombre());
            pacienteActualizado.setTelefono(PacienteDTO.telefono());
            pacienteActualizado.setCiudad(PacienteDTO.ciudad());
            pacienteActualizado.setEmail(PacienteDTO.correo());
            pacienteActualizado.setFechaNacimiento(PacienteDTO.fechaNacimiento());
            pacienteActualizado.setAlergias(PacienteDTO.alergias());
            pacienteActualizado.setEps(PacienteDTO.eps());
            pacienteActualizado.setTipoSangre(PacienteDTO.tipoSangre());
            this.pacienteRepo.save(pacienteActualizado);
            return pacienteActualizado.getCodigo();
        }

    }

    @Override
    public void eliminarCuenta(int codigoPaciente) throws Exception {

        Optional<Paciente> pacienteBuscado = this.pacienteRepo.findById(codigoPaciente);
        if (pacienteBuscado.isEmpty()) {
            throw new Exception("No existe un paciente con el codigo " + codigoPaciente);
        } else {
            Paciente obtenido = pacienteBuscado.get();
            obtenido.setEstado(EstadoUsuario.INACTIVO);
            this.pacienteRepo.save(obtenido);

        }

    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {

        Optional<Paciente> buscado = this.pacienteRepo.findById(codigo);
        if (buscado.isEmpty()) {
            throw new Exception("No existe un paciente con el codigo " + codigo);
        } else {
            Paciente obtenido = buscado.get();
            DetallePacienteDTO detallePacienteDTO = new DetallePacienteDTO(obtenido.getCodigo(), obtenido.getCedula(), obtenido.getNombre(), obtenido.getTelefono(), obtenido.getUrlFoto(), obtenido.getCiudad(), obtenido.getFechaNacimiento(), obtenido.getAlergias(), obtenido.getEmail(),obtenido.getEps() ,obtenido.getTipoSangre());
            return detallePacienteDTO;
        }
    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {

        Cita cita = new Cita();
        cita.setCodigo(registroCitaDTO.codigoPaciente());
        cita.setFechaCita(registroCitaDTO.fecha());
        cita.setCodigo(registroCitaDTO.codigoMedico());
        cita.setMotivo(registroCitaDTO.motivo());
        cita.setEstadoCita(EstadoCita.PROGRAMADA);
        cita.setFechaCreacion(LocalDateTime.now());
        Cita citaNueva = citaRepo.save(cita);
        return citaNueva.getCodigo();

    }

    @Override
    public void cambiarCita(CambioCitaDTO cambioCitaDTO) throws Exception {

        Optional<Cita> opcional = this.citaRepo.findById(cambioCitaDTO.codigoCita());
        if (opcional.isEmpty()) {
            throw new Exception("El codigo " + cambioCitaDTO.codigoCita() + "no esta asociado a ninguna cita");
        } else {
            Cita buscada = opcional.get();
            buscada.setFechaCita(cambioCitaDTO.fecha());
            buscada.setMotivo(cambioCitaDTO.motivo());
            this.citaRepo.save(buscada);
        }

    }

    @Override
    public void asignarCitaEspecialista(RegistroCitaDTO registroCitaDTO) throws Exception {

    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {

        PQRS pqrs = new PQRS();
        pqrs.setCodigo(registroPQRSDTO.codigoCita());
        pqrs.setMotivo(registroPQRSDTO.motivo());
        pqrs.setCodigo(registroPQRSDTO.codigoPaciente());
        pqrs.setTipoPQRS(registroPQRSDTO.tipoPQRS());
        pqrs.setEstadoPQRS(EstadoPQRS.NUEVO);
        pqrs.setFechaCreacion(LocalDateTime.now());
        PQRS pqrsNuevo = pqrsRepo.save(pqrs);
        return pqrsNuevo.getCodigo();

    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {

        List<PQRS> listaPqrs = this.pqrsRepo.findAllByCitaPacienteCodigo(codigoPaciente);
        List<ItemPQRSDTO> respuesta = new ArrayList();
        Iterator var4 = listaPqrs.iterator();

        while(var4.hasNext()) {
            PQRS p = (PQRS)var4.next();
            respuesta.add(new ItemPQRSDTO(p.getCodigo(), p.getEstadoPQRS(), p.getMotivo(), p.getFechaCreacion(), p.getCita().getPaciente().getNombre()));
        }

        return respuesta;

    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<PQRS> opcional = this.pqrsRepo.findById(codigo);
        if (opcional.isEmpty()) {
            throw new Exception("El codigo " + codigo + " no esta asociado a ningun PQRS");
        } else {
            PQRS pqrs = opcional.get();
            return new DetallePQRSDTO(pqrs.getCodigo(), pqrs.getEstadoPQRS(), pqrs.getMotivo(), pqrs.getCita().getPaciente().getNombre(), pqrs.getCita().getMedico().getNombre(), pqrs.getCita().getMedico().getEspecialidad(), pqrs.getFechaCreacion(), new ArrayList());
        }

    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        Optional<PQRS> opcionalPQRS = this.pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());
        if (opcionalPQRS.isEmpty()) {
            throw new Exception("No existe un PQRS con el codigo " + registroRespuestaDTO.codigoPQRS());
        } else {
            Optional<Cuenta> opcionalCuenta = this.cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());
            if (opcionalCuenta.isEmpty()) {
                throw new Exception("No existe una cuenta con el codigo " + registroRespuestaDTO.codigoCuenta());
            } else {
                Mensaje mensajeNuevo = new Mensaje();

                mensajeNuevo.setPqrs(opcionalPQRS.get());
                mensajeNuevo.setFechaCreacion(LocalDateTime.now());
                mensajeNuevo.setCuenta(opcionalCuenta.get());
                mensajeNuevo.setMensaje(registroRespuestaDTO.mensaje());
                Mensaje respuesta = mensajeRepo.save(mensajeNuevo);
                return respuesta.getCodigo();
            }
        }
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> listaCitas = this.citaRepo.findAllByPacienteCodigo(codigoPaciente);
        List<ItemCitaAdminDTO> respuesta = new ArrayList();
        Iterator var4 = listaCitas.iterator();

        while(var4.hasNext()) {
            Cita c = (Cita)var4.next();
            respuesta.add(new ItemCitaAdminDTO(c.getCodigo(), c.getPaciente().getCedula(), c.getPaciente().getNombre(), c.getMedico().getNombre(), c.getMedico().getEspecialidad(), c.getEstadoCita(), c.getFechaCita()));
        }

        return respuesta;
    }

    @Override
    public void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception {

    }

    @Override
    public DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception {

        Optional<Cita> citaOpcional = this.citaRepo.findById(codigoCita);
        if (citaOpcional.isEmpty()) {
            throw new Exception("El codigo " + codigoCita + " no esta asociado a ninguna cita");
        } else {
            Cita cita = (Cita)citaOpcional.get();
            return new DetalleAtencionMedicaDTO(cita.getCodigo(), cita.getPaciente().getNombre(), cita.getMedico().getNombre(), cita.getMedico().getEspecialidad(), cita.getFechaCita(), cita.getAtencion().getTratamiento(), cita.getAtencion().getNotasMedicas(), cita.getAtencion().getDiagnostico());
        }
    }
}
