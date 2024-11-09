package com.service.service.entities;

import lombok.Data;

@Data
public class SpO2DataDTO {
    private String patientId;
    private String deviceId;
    private int oxygenSaturation;
    private String unit = "%"; // Unité de mesure en pourcentage
    private long recordedAt; // Timestamp pour indiquer quand la mesure a été prise
}
