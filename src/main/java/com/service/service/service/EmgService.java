package com.service.service.service;

import com.service.service.model.EmgData;
import com.service.service.repository.EmgDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class EmgService {

    private final EmgDataRepository emgDataRepository;

    @Autowired
    public EmgService(EmgDataRepository emgDataRepository) {
        this.emgDataRepository = emgDataRepository;
    }

    public void saveEmgData(String patientId, String deviceId, List<EmgData.TimestampedValue> timestampedValues) {
        EmgData emgData = new EmgData();
        emgData.setPatientId(patientId);
        emgData.setDeviceId(deviceId);
        emgData.setTimestampedValues(timestampedValues);
        emgData.setRecordedAt(Instant.now());
        emgDataRepository.save(emgData);
    }

    public List<EmgData> getAllEmgDataByDateRange(String patientId, Instant start, Instant end) {
        return emgDataRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }
    public List<EmgData> getAllEmgData(String patientId) {
        return emgDataRepository.findByPatientId(patientId);
    }

}
