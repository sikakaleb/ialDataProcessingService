package com.service.service.service;

import com.service.service.model.EcgData;
import com.service.service.repository.EcgDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class EcgService {

    private final EcgDataRepository ecgDataRepository;

    @Autowired
    public EcgService(EcgDataRepository ecgDataRepository) {
        this.ecgDataRepository = ecgDataRepository;
    }

    public void saveEcgData(String patientId, String deviceId, List<EcgData.TimestampedValue> timestampedValues) {
        EcgData ecgData = new EcgData();
        ecgData.setPatientId(patientId);
        ecgData.setDeviceId(deviceId);
        ecgData.setTimestampedValues(timestampedValues);
        ecgData.setRecordedAt(Instant.now());
        ecgDataRepository.save(ecgData);
    }

    public List<EcgData> getAllEcgDataByDateRange(String patientId, Instant start, Instant end) {
        return ecgDataRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }

    public List<EcgData> getAllEcgData(String patientId) {
        return ecgDataRepository.findByPatientId(patientId);
    }
}
