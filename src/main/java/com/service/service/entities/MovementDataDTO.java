package com.service.service.entities;

import lombok.Data;
import java.util.List;

@Data
public class MovementDataDTO {
    private String patientId;
    private String deviceId;
    private List<AccelerationData> accelerationValues;

    @Data
    public static class AccelerationData {
        private float timestamp;
        private float x; // Accélération sur l'axe X
        private float y; // Accélération sur l'axe Y
        private float z; // Accélération sur l'axe Z
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
}
