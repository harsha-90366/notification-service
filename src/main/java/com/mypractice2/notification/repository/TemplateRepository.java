package com.mypractice2.notification.repository;

import com.mypractice2.notification.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    Template findByCommunicationMode(String communicationMode);

    String findSubjectByCommunicationMode(String communicationMode);

    List<Template> findByTemplateId(int templateId);
}
