package com.service.service.service;

import com.service.service.model.BloodPressureData;
import com.service.service.repository.BloodPressureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class BloodPressureService {

    private final BloodPressureRepository bloodPressureRepository;

    @Autowired
    public BloodPressureService(BloodPressureRepository bloodPressureRepository) {
        this.bloodPressureRepository = bloodPressureRepository;
    }

    public void saveBloodPressure(String patientId, String deviceId, int systolic, int diastolic) {
        BloodPressureData bpData = new BloodPressureData();
        bpData.setPatientId(patientId);
        bpData.setDeviceId(deviceId);
        bpData.setSystolic(systolic);
        bpData.setDiastolic(diastolic);
        bpData.setRecordedAt(Instant.now());
        bloodPressureRepository.save(bpData);
    }

    public List<BloodPressureData> getBloodPressureData(String patientId, Instant start, Instant end) {
        return bloodPressureRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }
    public List<BloodPressureData> getAllBloodPressureData(String patientId) {
        return bloodPressureRepository.findByPatientId(patientId);
    }

}
