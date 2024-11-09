package com.service.service.repository;

import com.service.service.model.SpO2Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface SpO2Repository extends MongoRepository<SpO2Data, String> {
    List<SpO2Data> findByPatientId(String patientId);
    List<SpO2Data> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
