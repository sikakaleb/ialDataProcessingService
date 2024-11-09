package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document(collection = "heart_rate_data")
public class HeartRateData {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private int heartRate;
    private String unit = "bpm"; // Unité de mesure en battements par minute
    private Instant recordedAt;
}
