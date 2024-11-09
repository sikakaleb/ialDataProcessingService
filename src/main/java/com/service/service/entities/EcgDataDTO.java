package com.service.service.entities;

import lombok.Data;
import java.util.List;

@Data
public class EcgDataDTO {
    private String patientId;
    private String deviceId;
    private List<TimestampedValue> timestampedValues;

    @Data
    public static class TimestampedValue {
        private float timestamp;
        private float amplitude;
    }
}
