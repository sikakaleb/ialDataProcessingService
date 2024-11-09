package com.service.service.service;

import com.service.service.entities.PatientDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class PatientDataService {

    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private SpO2Service spO2Service;
    @Autowired
    private RespiratoryRateService respiratoryRateService;
    @Autowired
    private MovementService movementService;
    @Autowired
    private HeartRateService heartRateService;
    @Autowired
    private EmgService emgService;
    @Autowired
    private EdaService edaService;
    @Autowired
    private EcgService ecgService;
    @Autowired
    private BloodPressureService bloodPressureService;

    public PatientDataDTO getAllDataByPatientId(String patientId) {
        PatientDataDTO patientData = new PatientDataDTO();
        patientData.setPatientId(patientId);
        patientData.setTemperatureData(temperatureService.getAllTemperatureData(patientId));
        patientData.setSpO2Data(spO2Service.getAllSpO2Data(patientId));
        patientData.setRespiratoryRateData(respiratoryRateService.getAllRespiratoryRateData(patientId));
        patientData.setMovementData(movementService.getAllMovementData(patientId));
        patientData.setHeartRateData(heartRateService.getAllHeartRateData(patientId));
        patientData.setEmgData(emgService.getAllEmgData(patientId));
        patientData.setEdaData(edaService.getAllEdaData(patientId));
        patientData.setEcgData(ecgService.getAllEcgData(patientId));
        patientData.setBloodPressureData(bloodPressureService.getAllBloodPressureData(patientId));

        return patientData;
    }

    public PatientDataDTO getAllDataByPatientIdAndDateRange(String patientId, Instant startDate, Instant  endDate) {
        PatientDataDTO patientData = new PatientDataDTO();
        patientData.setPatientId(patientId);
        patientData.setTemperatureData(temperatureService.getAllTemperatureDataByDateRange(patientId, startDate, endDate));
        patientData.setSpO2Data(spO2Service.getAllSpO2DataByDateRange(patientId, startDate, endDate));
        patientData.setRespiratoryRateData(respiratoryRateService.getAllRespiratoryRateDataByDateRange(patientId, startDate, endDate));
        patientData.setMovementData(movementService.getAllMovementDataByDateRange(patientId, startDate, endDate));
        patientData.setHeartRateData(heartRateService.getAllHeartRateDataByDateRange(patientId, startDate, endDate));
        patientData.setEmgData(emgService.getAllEmgDataByDateRange(patientId, startDate, endDate));
        patientData.setEdaData(edaService.getAllEdaDataByDateRange(patientId, startDate, endDate));
        patientData.setEcgData(ecgService.getAllEcgDataByDateRange(patientId, startDate, endDate));
        patientData.setBloodPressureData(bloodPressureService.getAllBloodPressureDataByDateRange(patientId, startDate, endDate));

        return patientData;
    }
}
