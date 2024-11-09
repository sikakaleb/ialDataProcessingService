package com.service.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "eda_data")
public class EdaData {
    @Id
    private String id;
    private String patientId;
    private String deviceId;
    private List<TimestampedValue> timestampedValues; // Liste des valeurs de conductance avec timestamps
    private Instant recordedAt;

    @Data
    public static class TimestampedValue {
        private float timestamp;
        private float conductance;
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

    public List<TimestampedValue> getTimestampedValues() {
        return timestampedValues;
    }

    public void setTimestampedValues(List<TimestampedValue> timestampedValues) {
        this.timestampedValues = timestampedValues;
    }

    public Instant getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Instant recordedAt) {
        this.recordedAt = recordedAt;
    }
}
