package com.service.service.repository;

import com.service.service.model.MovementData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface MovementRepository extends MongoRepository<MovementData, String> {
    List<MovementData> findByPatientId(String patientId);
    List<MovementData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}

