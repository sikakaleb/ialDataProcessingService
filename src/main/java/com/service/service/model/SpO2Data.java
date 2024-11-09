package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document(collection = "spo2_data")
public class SpO2Data {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private int oxygenSaturation;
    private String unit = "%"; // Unité de mesure en pourcentage
    private Instant recordedAt;
}
