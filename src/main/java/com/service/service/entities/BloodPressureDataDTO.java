package com.service.service.entities;

import lombok.Data;

@Data
public class BloodPressureDataDTO {
    private String patientId;
    private String deviceId;
    private int systolic;    // Pression systolique
    private int diastolic;   // Pression diastolique
    private String unit = "mmHg"; // Unité de mesure en mmHg
    private long recordedAt; // Timestamp pour indiquer quand la mesure a été prise
}

