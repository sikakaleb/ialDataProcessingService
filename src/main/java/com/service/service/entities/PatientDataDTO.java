package com.service.service.entities;

import com.service.service.model.*;

import java.util.List;

public class PatientDataDTO {
    private String patientId;
    private List<TemperatureData> temperatureData;
    private List<SpO2Data> spO2Data;
    private List<RespiratoryRateData> respiratoryRateData;
    private List<MovementData> movementData;
    private List<HeartRateData> heartRateData;
    private List<EmgData> emgData;
    private List<EdaData> edaData;
    private List<EcgData> ecgData;
    private List<BloodPressureData> bloodPressureData;

    // Getters and Setters


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public List<BloodPressureData> getBloodPressureData() {
        return bloodPressureData;
    }

    public void setBloodPressureData(List<BloodPressureData> bloodPressureData) {
        this.bloodPressureData = bloodPressureData;
    }

    public List<EcgData> getEcgData() {
        return ecgData;
    }

    public void setEcgData(List<EcgData> ecgData) {
        this.ecgData = ecgData;
    }

    public List<EdaData> getEdaData() {
        return edaData;
    }

    public void setEdaData(List<EdaData> edaData) {
        this.edaData = edaData;
    }

    public List<EmgData> getEmgData() {
        return emgData;
    }

    public void setEmgData(List<EmgData> emgData) {
        this.emgData = emgData;
    }

    public List<HeartRateData> getHeartRateData() {
        return heartRateData;
    }

    public void setHeartRateData(List<HeartRateData> heartRateData) {
        this.heartRateData = heartRateData;
    }

    public List<MovementData> getMovementData() {
        return movementData;
    }

    public void setMovementData(List<MovementData> movementData) {
        this.movementData = movementData;
    }

    public List<RespiratoryRateData> getRespiratoryRateData() {
        return respiratoryRateData;
    }

    public void setRespiratoryRateData(List<RespiratoryRateData> respiratoryRateData) {
        this.respiratoryRateData = respiratoryRateData;
    }

    public List<SpO2Data> getSpO2Data() {
        return spO2Data;
    }

    public void setSpO2Data(List<SpO2Data> spO2Data) {
        this.spO2Data = spO2Data;
    }

    public List<TemperatureData> getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(List<TemperatureData> temperatureData) {
        this.temperatureData = temperatureData;
    }
}
