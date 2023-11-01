package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.dto.admin.*;
import co.edu.uniquindio.clinica.modelo.entidades.*;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdministradorImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final MensajeRepo mensajeRepo;
    private final CuentaRepo cuentaRepo;
    private final HorarioRepo horarioRepo;


    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {
        if( estaRepetidaCedula(medicoDTO.cedula()) ){
            throw new Exception("La cédula "+medicoDTO.cedula()+" ya se encuentra registrada");
        }

        if( estaRepetidoCorreo(medicoDTO.correo()) ){
            throw new Exception("El correo "+medicoDTO.correo()+" ya se encuentra registrado");
        }

        Medico medico = new Medico();

        medico.setCedula(medicoDTO.cedula() );
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre() );
        medico.setEspecialidad( medicoDTO.especialidad() );
        medico.setCiudad(medicoDTO.ciudad());
        medico.setEmail(medicoDTO.correo() );

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(medicoDTO.password());
        medico.setPassword(passwordEncriptada);
        medico.setUrlFoto(medicoDTO.urlFoto());
        medico.setEstado(EstadoUsuario.ACTIVO);

        Medico medicoNuevo = medicoRepo.save(medico);
        registrarHorariosMedico( medicoNuevo, medicoDTO.horarios() );

        return medicoNuevo.getCodigo();


    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findByEmail(correo) != null;
    }

    private boolean estaRepetidaCedula(String cedula) {
        return medicoRepo.findByCedula(cedula) != null;
    }

    private void registrarHorariosMedico(Medico medicoNuevo, List<HorarioDTO> horarios){

        for( HorarioDTO h : horarios ) {

            HorarioMedico horarioNuevo = new HorarioMedico();

            horarioNuevo.setDia(h.dia());
            horarioNuevo.setHoraInicio(h.horaInicio());
            horarioNuevo.setHoraFin(h.horaSalida());

            horarioNuevo.setMedico(medicoNuevo);

            horarioRepo.save(horarioNuevo);
        }
    }
    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(medicoDTO.codigo());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        buscado.setCedula(medicoDTO.cedula() );
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setNombre(medicoDTO.nombre() );
        buscado.setEspecialidad( medicoDTO.especialidad() );
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setEmail(medicoDTO.correo() );
        buscado.setUrlFoto(medicoDTO.urlFoto());

        medicoRepo.save( buscado );

        return buscado.getCodigo();
    }

    @Override
    public boolean eliminarMedico(int codigo) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }

        Medico buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);
        medicoRepo.save( buscado );

        return true;
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {

        List<Medico> medicos = medicoRepo.findAll();

        if(medicos.isEmpty()){
            throw new Exception("No hay médicos registrados");
        }

        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for(Medico m: medicos){
            respuesta.add( new ItemMedicoDTO(
                    m.getCodigo(),
                    m.getCedula(),
                    m.getNombre(),
                    m.getUrlFoto(),
                    m.getEspecialidad()) );
        }
        return respuesta;

    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {

        Optional<Medico> opcional = medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }

        Medico buscado = opcional.get();

        List<HorarioMedico> horarios = horarioRepo.findAllByMedicoCodigo(codigo);
        List<HorarioDTO> horariosDTO = new ArrayList<>();

        for( HorarioMedico h : horarios ){
            horariosDTO.add( new HorarioDTO(
                    h.getDia(),
                    h.getHoraInicio(),
                    h.getHoraFin()
            ) );
        }
        return new DetalleMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getTelefono(),
                buscado.getEmail(),
                buscado.getUrlFoto(),
                horariosDTO
        );
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

        List<PQRS> listaPqrs = pqrsRepo.findAll();//select * from pqrs

        if (listaPqrs.isEmpty()) {
            throw new Exception("No hay PQRS registradas hasta el momento");
        }

        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for( PQRS p : listaPqrs ){

            respuesta.add( new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstadoPQRS(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()
            ) );
        }
        return respuesta;

    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("El código "+codigo+" no está asociado a ningún PQRS");
        }

        PQRS pqrs = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByPqrsCodigo(codigo);

        return new DetallePQRSDTO(
                pqrs.getCodigo(),
                pqrs.getEstadoPQRS(),
                pqrs.getMotivo(),
                pqrs.getCita().getPaciente().getNombre(),
                pqrs.getCita().getMedico().getNombre(),
                pqrs.getCita().getMedico().getEspecialidad(),
                pqrs.getFechaCreacion(),
                convertirRespuestasDTO(mensajes)
        );

    }

    private List<RespuestaDTO> convertirRespuestasDTO(List<Mensaje> mensajes) {
        return mensajes.stream().map(m -> new RespuestaDTO(
                m.getCodigo(),
                m.getMensaje(),
                m.getCuenta().getEmail(),
                m.getFechaCreacion()
        )).toList();
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        //Obtener el PQRS
        Optional<PQRS> opcionalPqrs = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if( opcionalPqrs.isEmpty() ){
            throw new Exception("El código "+registroRespuestaDTO.codigoPQRS()+" no está asociado a ningún PQRS");
        }

        //Obtener la cuenta
        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if( opcionalCuenta.isEmpty() ){
            throw new Exception("La cuenta con el código "+registroRespuestaDTO.codigoCuenta()+" no está asociada a ningún PQRS");
        }

        Mensaje mensaje = new Mensaje();
        mensaje.setFechaCreacion( LocalDateTime.now() );
        mensaje.setMensaje(registroRespuestaDTO.mensaje() );
        mensaje.setPqrs( opcionalPqrs.get() );
        mensaje.setCuenta( opcionalCuenta.get() );

        return mensajeRepo.save(mensaje).getCodigo();

    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {

        Optional<PQRS> opcional = pqrsRepo.findById(codigoPQRS);

        if( opcional.isEmpty() ){
            throw new Exception("El código "+codigoPQRS+" no está asociado a ningún PQRS");
        }

        PQRS pqrs = opcional.get();
        pqrs.setEstadoPQRS(estadoPQRS);

        pqrsRepo.save(pqrs);

    }

    @Override
    public List<ItemCitaAdminDTO> listarCitas() throws Exception {

        List<Cita> listaCitas = citaRepo.findAll();//select * from cita
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        for( Cita c : listaCitas ){

            respuesta.add( new ItemCitaAdminDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getEstadoCita(),
                    c.getFechaCita()
            ) );
        }
        return respuesta;
    }
}
