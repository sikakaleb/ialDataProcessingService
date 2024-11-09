package com.service.service.service;

import com.service.service.model.HeartRateData;
import com.service.service.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class HeartRateService {

    private final HeartRateRepository heartRateRepository;

    @Autowired
    public HeartRateService(HeartRateRepository heartRateRepository) {
        this.heartRateRepository = heartRateRepository;
    }

    public void saveHeartRate(String patientId, String deviceId, int heartRate) {
        HeartRateData heartRateData = new HeartRateData();
        heartRateData.setPatientId(patientId);
        heartRateData.setDeviceId(deviceId);
        heartRateData.setHeartRate(heartRate);
        heartRateData.setRecordedAt(Instant.now());
        heartRateRepository.save(heartRateData);
    }

    public List<HeartRateData> getHeartRateData(String patientId, Instant start, Instant end) {
        return heartRateRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }

    public List<HeartRateData> getAllHeartRateData(String patientId) {
        return heartRateRepository.findByPatientId(patientId);
    }
}
