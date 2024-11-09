package com.service.service.entities;

import lombok.Data;

@Data
public class HeartRateDataDTO {
    private String patientId;
    private String deviceId;
    private int heartRate;
    private String unit = "bpm"; // Unité de mesure en battements par minute
    private long recordedAt; // Timestamp pour indiquer quand la mesure a été prise
}
