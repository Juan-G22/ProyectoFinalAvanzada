package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteServicio pacienteServicio;

  public int registrarse(RegistroPacienteDTO registroPacienteDTO)throws Exception{


     return 0;


  }

  public  int editarPerfil(DetallePacienteDTO PacienteDTO) throws Exception{


      return 0;

  }




}
