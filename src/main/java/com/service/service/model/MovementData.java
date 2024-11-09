package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "movement_data")
public class MovementData {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private List<AccelerationData> accelerationValues; // Accélérations avec timestamps
    private Instant recordedAt;

    @Data
    public static class AccelerationData {
        private float timestamp;
        private float x; // Accélération en X
        private float y; // Accélération en Y
        private float z; // Accélération en Z
    }
}
