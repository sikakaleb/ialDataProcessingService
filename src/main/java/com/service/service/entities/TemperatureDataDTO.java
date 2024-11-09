package com.service.service.entities;

import lombok.Data;

@Data
public class TemperatureDataDTO {
    private String patientId;
    private String deviceId;
    private float temperature;
    private String unit = "°C"; // Unité de mesure en degrés Celsius
    private long recordedAt; // Timestamp pour indiquer quand la mesure a été prise
}
