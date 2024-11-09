package com.service.service.entities;

import lombok.Data;
import java.util.List;

@Data
public class EdaDataDTO {
    private String patientId;
    private String deviceId;
    private List<TimestampedValue> timestampedValues;

    @Data
    public static class TimestampedValue {
        private float timestamp;
        private float conductance;
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
}

