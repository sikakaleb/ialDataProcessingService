package com.service.service.repository;

import com.service.service.model.HeartRateData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface HeartRateRepository extends MongoRepository<HeartRateData, String> {
    List<HeartRateData> findByPatientId(String patientId);
    List<HeartRateData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
