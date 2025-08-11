package com.mypractice2.notification.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "communication_template")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id", nullable = false, unique = true)
    private int templateId;

    @Column(name="communication_mode", length = 8, nullable = false)
    private String communicationMode;

    @Column(name="message_body", length = 100, nullable = false)
    private String messageBody;

    @Column(name="subject", length = 50, nullable = false)
    private String subject;

}
