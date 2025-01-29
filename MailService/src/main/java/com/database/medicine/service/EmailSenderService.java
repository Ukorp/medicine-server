package com.database.medicine.service;

import com.database.medicine.dto.mail.MailResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender mailSender;

    public void Send(MailResponse mailResponse) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailResponse.getEmail());
        message.setSubject("Вы записались к врачу");
        message.setText("Информация по записи:\nВрач: " + mailResponse.getDoctorName() +
                "\nУслуга: " + mailResponse.getServiceName() +
                "\nМесто: " + mailResponse.getBranchAddress() +
                "\nВремя: " + Strings.join(Arrays.asList(mailResponse.getDate().toString().split("T")), ' ') +
                "\nЦена: " + mailResponse.getPrice() +
                "\n\nЖдём Вас!");
        mailSender.send(message);
    }
}
