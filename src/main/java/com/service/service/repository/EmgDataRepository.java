package com.service.service.repository;

import com.service.service.model.EmgData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface EmgDataRepository extends MongoRepository<EmgData, String> {
    List<EmgData> findByPatientId(String patientId);
    List<EmgData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
