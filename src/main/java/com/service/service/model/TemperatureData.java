package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document(collection = "temperature_data")
public class TemperatureData {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private float temperature;
    private String unit = "°C"; // Unité de mesure en degrés Celsius
    private Instant recordedAt;
}
