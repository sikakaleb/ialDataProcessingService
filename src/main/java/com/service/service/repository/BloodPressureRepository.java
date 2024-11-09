package com.service.service.repository;

import com.service.service.model.BloodPressureData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface BloodPressureRepository extends MongoRepository<BloodPressureData, String> {
    List<BloodPressureData> findByPatientId(String patientId);
    List<BloodPressureData> findByPatientIdAndRecordedAtBetween(String patientId, Instant start, Instant end);
}
