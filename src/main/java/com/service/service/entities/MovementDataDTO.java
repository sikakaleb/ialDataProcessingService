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
}
