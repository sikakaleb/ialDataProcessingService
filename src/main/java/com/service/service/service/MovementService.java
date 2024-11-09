package com.service.service.service;

import com.service.service.model.MovementData;
import com.service.service.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    @Autowired
    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void saveMovementData(String patientId, String deviceId, List<MovementData.AccelerationData> accelerationValues) {
        MovementData movementData = new MovementData();
        movementData.setPatientId(patientId);
        movementData.setDeviceId(deviceId);
        movementData.setAccelerationValues(accelerationValues);
        movementData.setRecordedAt(Instant.now());
        movementRepository.save(movementData);
    }

    public List<MovementData> getAllRespiratoryRateDataByDateRange(String patientId, Instant start, Instant end) {
        return movementRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }

    public List<MovementData> getAllMovementData(String patientId) {
        return movementRepository.findByPatientId(patientId);
    }

}
