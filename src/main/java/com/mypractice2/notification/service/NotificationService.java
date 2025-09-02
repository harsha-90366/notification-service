package com.mypractice2.notification.service;

import com.mypractice2.notification.Utils;
import com.mypractice2.notification.dto.TemplateDTO;
import com.mypractice2.notification.repository.TemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class NotificationService {

    private final TemplateRepository templateRepository;

    public NotificationService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public void sendNotification(TemplateDTO templateDTO) {

        if (checkIfTemplateIdIsNull(templateDTO.getTemplateId())||checkIfTemplateIdDoesNotExists(templateDTO.getTemplateId())) {
            log.error("Template ID cannot be null or Template ID does not exist");
            throw new IllegalArgumentException("Template ID cannot be null or Template ID does not exist");
        } else {

            Map<String, String> placeholders = templateDTO.getTemplatePlaceHolders();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(templateDTO.getFromAddress());
            message.setTo(templateDTO.getToAddress());
            message.setSubject(templateRepository.findByTemplateId(templateDTO.getTemplateId()).get(0).getSubject());
            String body = templateRepository.findByTemplateId(templateDTO.getTemplateId()).get(0).getMessageBody();
            body = Utils.replacePlaceholders(body, placeholders);
            log.info(body);
            message.setText(body);
        }
    }

    public boolean checkIfTemplateIdIsNull(int templateId) {
        return templateId <= 0;
    }

    public boolean checkIfTemplateIdDoesNotExists(int templateId) {
        return templateRepository.findByTemplateId(templateId).isEmpty();
    }
}
