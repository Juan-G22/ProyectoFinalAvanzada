package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.dto.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MedicoController {


    private final MedicoServicio medicoServicio;

    @GetMapping("/listar-citas-pendientes/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaAdminDTO>>> listarCitasPendientes(int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,medicoServicio.listarCitasPendientes(codigoMedico)));
    }


    @PostMapping("/atender-cita")
    public  ResponseEntity<MensajeDTO<String>> atenderCita(@Valid @RequestBody RegistroAtencionDTO registroAtencionDTO) throws Exception{
         medicoServicio.atenderCita(registroAtencionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cita atendida ") );
    }




    @GetMapping("/listar-historial-atenciones-paciente/{codigoPciente}")
    public ResponseEntity<MensajeDTO< List<ItemCitaAdminDTO>>> listarHistorialAtencionesPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarHistorialAtencionesPaciente(codigoPaciente)));
    }



    @PostMapping("/agendar-dia-libre")
    public  ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Día agendado  correctamente") );
    }



    @GetMapping("/historial-citas-realizadas-medico/{codigoMedico}")
    public ResponseEntity<MensajeDTO< List<ItemCitaAdminDTO>>> listarCitasRealizadasMedico(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,medicoServicio.listarCitasRealizadasMedico(codigoMedico)));
    }


    @GetMapping("/ver-detalle-atencion/{codigoCita}")
    public ResponseEntity<MensajeDTO <DetalleAtencionMedicaDTO>> verDetalleAtencion(@PathVariable int codigoCita) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,medicoServicio.verDetalleAtencion(codigoCita)));
    }


}
