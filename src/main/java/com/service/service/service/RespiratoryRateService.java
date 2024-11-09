package com.service.service.service;

import com.service.service.model.RespiratoryRateData;
import com.service.service.repository.RespiratoryRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class RespiratoryRateService {

    private final RespiratoryRateRepository respiratoryRateRepository;

    @Autowired
    public RespiratoryRateService(RespiratoryRateRepository respiratoryRateRepository) {
        this.respiratoryRateRepository = respiratoryRateRepository;
    }

    public void saveRespiratoryRate(String patientId, String deviceId, int respiratoryRate) {
        RespiratoryRateData rrData = new RespiratoryRateData();
        rrData.setPatientId(patientId);
        rrData.setDeviceId(deviceId);
        rrData.setRespiratoryRate(respiratoryRate);
        rrData.setRecordedAt(Instant.now());
        respiratoryRateRepository.save(rrData);
    }

    public List<RespiratoryRateData> getRespiratoryRateData(String patientId, Instant start, Instant end) {
        return respiratoryRateRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }
}
