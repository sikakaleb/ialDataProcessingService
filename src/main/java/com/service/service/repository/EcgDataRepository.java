package com.service.service.repository;

import com.service.service.model.EcgData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface EcgDataRepository extends MongoRepository<EcgData, String> {
    List<EcgData> findByPatientId(String patientId);
    List<EcgData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
