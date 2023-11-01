package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
@RequiredArgsConstructor
public class EmailServicioImpl implements EmailServicio {


    private final JavaMailSender javaMailSender;
    @Override
    public void enviarEmail(EmailDTO emailDTO) throws Exception {

        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.mensaje(), true);
        helper.setTo(emailDTO.para());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(mensaje);

    }
}
