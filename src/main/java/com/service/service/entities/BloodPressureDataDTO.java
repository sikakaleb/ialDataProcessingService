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

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
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

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
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

