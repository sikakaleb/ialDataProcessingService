package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document(collection = "blood_pressure_data")
public class BloodPressureData {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private int systolic;    // Pression systolique
    private int diastolic;   // Pression diastolique
    private String unit = "mmHg"; // Unité de mesure en mmHg
    private Instant recordedAt;
}
