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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<AccelerationData> getAccelerationValues() {
        return accelerationValues;
    }

    public void setAccelerationValues(List<AccelerationData> accelerationValues) {
        this.accelerationValues = accelerationValues;
    }

    public Instant getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Instant recordedAt) {
        this.recordedAt = recordedAt;
    }
}
