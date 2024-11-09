package com.service.service.repository;

import com.service.service.model.TemperatureData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface TemperatureRepository extends MongoRepository<TemperatureData, String> {
    List<TemperatureData> findByPatientId(String patientId);
    List<TemperatureData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
