package com.service.service.entities;

import lombok.Data;

@Data
public class SpO2DataDTO {
    private String patientId;
    private String deviceId;
    private int oxygenSaturation;
    private String unit = "%"; // Unité de mesure en pourcentage
    private long recordedAt; // Timestamp pour indiquer quand la mesure a été prise

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

    public int getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(int oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(long recordedAt) {
        this.recordedAt = recordedAt;
    }
}
