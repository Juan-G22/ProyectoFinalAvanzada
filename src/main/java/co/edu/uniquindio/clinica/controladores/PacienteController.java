package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteServicio pacienteServicio;

       @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.editarPerfil(pacienteDTO);
      return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente actualizado correctamete") );
  }

    @DeleteMapping("/eliminar-cuenta/{cedulaPaciente}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable String cedulaPaciente) throws Exception{
        pacienteServicio.eliminarCuenta(cedulaPaciente);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente eliminado correctamete") );
  }

    @GetMapping("/ver-detalle-paciente/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.verDetallePaciente(codigo)) );
  }



    @PostMapping("/agendar-cita")
    public ResponseEntity<MensajeDTO<String>> agendarCita(@Valid @RequestBody RegistroCitaDTO registroCitaDTO) throws Exception{
        pacienteServicio.agendarCita(registroCitaDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "La cita ha sido agendada correctamente") );
    }


    @PutMapping("/cambiar-cita")
    public ResponseEntity<MensajeDTO<String>> cambiarCita(@Valid @RequestBody CambioCitaDTO cambioCitaDTO )throws Exception{
        pacienteServicio.cambiarCita(cambioCitaDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "La cita se ha cambiado correctamete") );
    } //Preguntar



    @PostMapping("/crear-PQRS")
    public  ResponseEntity<MensajeDTO<String>> crearPQRS(@Valid @RequestBody RegistroPQRSDTO registroPQRSDTO) throws Exception{
        pacienteServicio.crearPQRS(registroPQRSDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se ha creado el PQR correctamente") );
    }

    @GetMapping("/listar-PQRS-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemPQRSDTO>>> listarPQRSPaciente(@PathVariable int codigoPaciente) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarPQRSPaciente(codigoPaciente)));

    }


    @GetMapping("/ver-detalle-PQRS/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePQRSDTO>> verDetallePQRS(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.verDetallePQRS(codigo)) );
    }




    @PostMapping("/responder-PQRS")
   public ResponseEntity<MensajeDTO<String>>  responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
      pacienteServicio.responderPQRS(registroRespuestaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se ha respondido  el PQR correctamente") );
   }


    @GetMapping("/listar-citas-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaAdminDTO>>>listarCitasPaciente(@PathVariable int codigoPaciente) throws Exception{
     return ResponseEntity.ok().body(new MensajeDTO<> (false,pacienteServicio.listarCitasPaciente(codigoPaciente)));
    }


    @GetMapping("/ver-detalle-cita/{codigoCita}")
   public  ResponseEntity<MensajeDTO <DetalleAtencionMedicaDTO>> verDetalleCita(@PathVariable int codigoCita) throws Exception{
         return  ResponseEntity.ok().body( new MensajeDTO<>(false,pacienteServicio.verDetalleCita(codigoCita)));
   }


    @PostMapping("/enviar-link-recuperacion/{email}")
    public ResponseEntity<MensajeDTO<String>> enviarLinkRecuperacion(@PathVariable String email) throws Exception{
        pacienteServicio.enviarLinkRecuperacion(email);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se ha enviado el link de recuperación al email regustrado") );
    }

    @PutMapping("/cambiar-password")
    public ResponseEntity<MensajeDTO<String>> cambiarPassword(@Valid @RequestBody NuevaPasswordDTO nuevaPasswordDTO) throws Exception{
        pacienteServicio.cambiarPassword(nuevaPasswordDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Contraseña actualizada correctamete") );
    }
    @PostMapping("/asignar-especialista")
    public ResponseEntity<MensajeDTO<String>> asignarCitaEspecialista(@Valid @RequestBody RegistroCitaDTO registroCitaDTO) throws Exception{
        pacienteServicio.asignarCitaEspecialista(registroCitaDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se ha asignado un especialista correctamente") );
    } //Preguntar


    @GetMapping("/filtrar-citas")
    public ResponseEntity<MensajeDTO<List<ItemCitaAdminDTO>>> filtrarCitas(@Valid @RequestBody  FiltroBusquedaDTO filtroBusquedaDTO) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.filtrarCitas(filtroBusquedaDTO)));
    }




}
