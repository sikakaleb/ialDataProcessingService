package com.service.service.repository;

import com.service.service.model.RespiratoryRateData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface RespiratoryRateRepository extends MongoRepository<RespiratoryRateData, String> {
    List<RespiratoryRateData> findByPatientId(String patientId);
    List<RespiratoryRateData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
