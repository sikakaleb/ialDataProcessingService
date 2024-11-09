package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document(collection = "respiratory_rate_data")
public class RespiratoryRateData {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private int respiratoryRate;
    private String unit = "rpm"; // Unité de mesure en respirations par minute
    private Instant recordedAt;
}
