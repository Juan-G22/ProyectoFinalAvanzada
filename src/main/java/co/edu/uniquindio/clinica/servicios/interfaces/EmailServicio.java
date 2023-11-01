package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.EmailDTO;

public interface EmailServicio {
    void enviarEmail(EmailDTO emailDTO) throws Exception;
}
