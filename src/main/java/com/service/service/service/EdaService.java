package com.service.service.service;

import com.service.service.model.EdaData;
import com.service.service.repository.EdaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class EdaService {

    private final EdaDataRepository edaDataRepository;

    @Autowired
    public EdaService(EdaDataRepository edaDataRepository) {
        this.edaDataRepository = edaDataRepository;
    }

    public void saveEdaData(String patientId, String deviceId, List<EdaData.TimestampedValue> timestampedValues) {
        EdaData edaData = new EdaData();
        edaData.setPatientId(patientId);
        edaData.setDeviceId(deviceId);
        edaData.setTimestampedValues(timestampedValues);
        edaData.setRecordedAt(Instant.now());
        edaDataRepository.save(edaData);
    }

    public List<EdaData> getAllEdaDataByDateRange(String patientId, Instant start, Instant end) {
        return edaDataRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }

    public List<EdaData> getAllEdaData(String patientId) {
        return edaDataRepository.findByPatientId(patientId);
    }

}

