package com.service.service.entities;

import lombok.Data;

@Data
public class HeartRateDataDTO {
    private String patientId;
    private String deviceId;
    private int heartRate;
    private String unit = "bpm"; // Unité de mesure en battements par minute
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

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
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
