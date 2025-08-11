package com.mypractice2.notification.controller;

import com.mypractice2.notification.dto.TemplateDTO;
import com.mypractice2.notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/notification")
public class NotificationController {
    private final Logger logger = LoggerFactory.getLogger(NotificationController.class);
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody @Valid TemplateDTO templateDTO) {
        notificationService.sendNotification(templateDTO);
        logger.info("Notification sent successfully");
        return ResponseEntity.ok("Notification sent successfully");
    }
}
