package com.service.service.repository;

import com.service.service.model.EdaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface EdaDataRepository extends MongoRepository<EdaData, String> {
    List<EdaData> findByPatientId(String patientId);
    List<EdaData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
