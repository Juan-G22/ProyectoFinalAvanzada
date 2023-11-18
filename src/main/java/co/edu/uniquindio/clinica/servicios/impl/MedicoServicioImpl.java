package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Atencion;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import co.edu.uniquindio.clinica.modelo.entidades.PQRS;
import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;
import co.edu.uniquindio.clinica.repositorios.AtencionRepo;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicoServicioImpl implements MedicoServicio {

    private final MedicoRepo medicoRepo;
    private final CitaRepo citaRepo;
    private final AtencionRepo atencionRepo;

@Override
    // Listar las citas que el medico tiene pendiente
    public List<ItemCitaAdminDTO> listarCitasPendientes(int codigoMedico) throws Exception {

        List<Cita> citasPendientes = citaRepo.findByMedicoCodigo(codigoMedico);


        if (citasPendientes.isEmpty()) {
            throw new Exception("No hay citas pendientes para el médico" + codigoMedico);
        }

    List<ItemCitaAdminDTO> respuesta = new ArrayList<>();


            Iterator var4 = citasPendientes.iterator();

            while (var4.hasNext()) {
                Cita p = (Cita) var4.next();
                respuesta.add(new ItemCitaAdminDTO(p.getCodigo(),
                        p.getPaciente().getCedula(),
                        p.getPaciente().getNombre(),
                        p.getMedico().getNombre(),
                       p.getMedico().getEspecialidad(),
                       p.getEstadoCita(),
                       p.getFechaCita()));

            }


        return respuesta;
}




    @Override
// Registar notas medicas,tratamiento ,asignacion especialista al hacer una consulta
    public void atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {

        Optional<Cita> citas = citaRepo.findById(registroAtencionDTO.codigoCita());


        if (citas.isEmpty()) {
            throw new Exception("No existe una cita con el codigo" + registroAtencionDTO.codigoCita());
        }
        Cita cita = citas.get();
        Atencion atencion =new Atencion();
        atencion.setNotasMedicas(registroAtencionDTO.notasMedicas());
        atencion.setTratamiento(registroAtencionDTO.tratamiento());
        atencion.setDiagnostico(registroAtencionDTO.diagnostico());
        atencion.setAsignacionEspecialista(registroAtencionDTO.asignaciónEspecialista());
        cita.setEstadoCita(EstadoCita.COMPLETADA);

        atencionRepo.save(atencion);
        citaRepo.save(cita);



    }

@Override
    // Listar historial medico del paciente
    public List<ItemCitaAdminDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {

        List<Cita> listaCitas = citaRepo.findByPacienteCodigo(codigoPaciente);

    if (listaCitas.isEmpty()) {
        throw new Exception("No tiene citas pendientes");
    }
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        for (Cita c : listaCitas) {

            respuesta.add(new ItemCitaAdminDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getEstadoCita(),
                    c.getFechaCita()
            ));
        }
        return respuesta;
    }


    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {


        // Verificar si el médico existe
        Optional<Medico> opcional = medicoRepo.findById(diaLibreDTO.codigoMedico());


        if (opcional.isEmpty()) {
            throw new Exception("El médico no existe.");
        }

        Medico buscado = opcional.get();

        // Verificar si ya existe un día libre activo para el médico
        if (buscado.getDiaLibres().isEmpty() && buscado.getDiaLibres().equals(diaLibreDTO.fecha())) {
            throw new Exception("El médico ya tiene un día libre activo.");
        }


        // Verificar si hay citas agendadas para la fecha que se quiere dejar libre
        List<Cita> citasAgendadas = citaRepo.findByMedicoCodigo(diaLibreDTO.codigoMedico());
        if (!citasAgendadas.isEmpty()) {
            throw new Exception("No se puede registrar un día libre si ya hay citas agendadas.");
        }

        // Verificar si el día libre a agendar es el día libre activo para el médico
        if (buscado.getDiaLibres() == null || !buscado.getDiaLibres().equals(diaLibreDTO.fecha())) {
            throw new Exception("No se puede agendar un día libre que no coincide con el día libre activo del médico.");
        }


        buscado.setDiaLibres(opcional.get().getDiaLibres());

        medicoRepo.save(buscado);

        return buscado.getCodigo();


    }


    @Override
    public List<ItemCitaAdminDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {


        List<Cita> citasDelMedico = citaRepo.findByMedicoCodigo(codigoMedico);

        if (citasDelMedico.isEmpty()) {
            throw new Exception("No hay citas para este médico.");
        }


        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        for (Cita cita : citasDelMedico) {
            respuesta.add(new ItemCitaAdminDTO(
                    cita.getCodigo(),
                    cita.getPaciente().getCedula(),
                    cita.getPaciente().getNombre(),
                    cita.getMedico().getNombre(),
                    cita.getMedico().getEspecialidad(),
                    cita.getEstadoCita(),
                    cita.getFechaCita()
            ));
        }

        return respuesta;
    }


    @Override
    public DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception {

        Optional<Cita> opcional = citaRepo.findById(codigoCita);

        if (opcional.isEmpty()) {

            throw new Exception("No tiene registradas atenciones realizadas");
        }

        Cita cita = opcional.get();

        return new DetalleAtencionMedicaDTO(

                cita.getCodigo(),
                cita.getPaciente().getNombre(),
                cita.getMedico().getNombre(),
                cita.getMedico().getEspecialidad(),
                cita.getFechaCita(),
                cita.getAtencion().getTratamiento(),
                cita.getAtencion().getNotasMedicas(),
                cita.getAtencion().getDiagnostico()


        );
    }


}