package com.service.service.entities;

import lombok.Data;

@Data
public class RespiratoryRateDataDTO {
    private String patientId;
    private String deviceId;
    private int respiratoryRate;
    private String unit = "rpm"; // Unité de mesure en respirations par minute
    private long recordedAt; // Timestamp pour indiquer quand la mesure a été prise

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
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
