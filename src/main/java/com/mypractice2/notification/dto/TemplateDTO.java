package com.mypractice2.notification.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Data
public class TemplateDTO {

    @NotNull(message = "Template Id cannot be null")
    private int templateId;

    @NotNull(message = "From Address cannot be null")
    private String fromAddress;

    @NotNull(message = "To Address cannot be null")
    private String toAddress;

    @NotNull(message = "Communication Mode cannot be null")
    private String communicationMode;

    private Map<String,String> templatePlaceHolders;
}
