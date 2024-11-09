package com.service.service.entities;

import lombok.Data;

@Data
public class RespiratoryRateDataDTO {
    private String patientId;
    private String deviceId;
    private int respiratoryRate;
    private String unit = "rpm"; // Unité de mesure en respirations par minute
    private long recordedAt; // Timestamp pour indiquer quand la mesure a été prise
}
