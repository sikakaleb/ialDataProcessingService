package com.service.service.service;

import com.service.service.model.SpO2Data;
import com.service.service.repository.SpO2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class SpO2Service {

    private final SpO2Repository spO2Repository;

    @Autowired
    public SpO2Service(SpO2Repository spO2Repository) {
        this.spO2Repository = spO2Repository;
    }

    public void saveSpO2Data(String patientId, String deviceId, int oxygenSaturation) {
        SpO2Data spO2Data = new SpO2Data();
        spO2Data.setPatientId(patientId);
        spO2Data.setDeviceId(deviceId);
        spO2Data.setOxygenSaturation(oxygenSaturation);
        spO2Data.setRecordedAt(Instant.now());
        spO2Repository.save(spO2Data);
    }

    public List<SpO2Data> getSpO2Data(String patientId, Instant start, Instant end) {
        return spO2Repository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }

    public List<SpO2Data> getAllSpO2Data(String patientId) {
        return spO2Repository.findByPatientId(patientId);
    }

}
