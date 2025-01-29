package com.database.medicine.service;

import com.database.medicine.dto.mail.MailResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaListenerMail {

    private final EmailSenderService emailSenderService;

    @KafkaListener(topics = "mail", groupId = "my-group")
    public void listen(MailResponse mailResponse) throws JsonProcessingException {
        log.debug("Отправляем email с записью на почту {}...", mailResponse.getEmail());
        emailSenderService.Send(mailResponse);
        log.debug("Успешно!");
    }

}
