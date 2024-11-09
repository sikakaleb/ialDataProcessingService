package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "emg_data")
public class EmgData {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private List<TimestampedValue> timestampedValues; // Liste des valeurs avec timestamps
    private Instant recordedAt;

    @Data
    public static class TimestampedValue {
        private float timestamp;
        private float amplitude;
    }
}
