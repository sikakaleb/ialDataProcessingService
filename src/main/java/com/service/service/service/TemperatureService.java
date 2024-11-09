package com.service.service.service;

import com.service.service.model.TemperatureData;
import com.service.service.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class TemperatureService {

    private final TemperatureRepository temperatureRepository;

    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public void saveTemperature(String patientId, String deviceId, float temperature) {
        TemperatureData temperatureData = new TemperatureData();
        temperatureData.setPatientId(patientId);
        temperatureData.setDeviceId(deviceId);
        temperatureData.setTemperature(temperature);
        temperatureData.setRecordedAt(Instant.now());
        temperatureRepository.save(temperatureData);
    }

    public List<TemperatureData> getAllTemperatureDataByDateRange(String patientId, Instant start, Instant end) {
        return temperatureRepository.findByPatientIdAndRecordedAtBetween(patientId, start, end);
    }
    public List<TemperatureData> getAllTemperatureData(String patientId) {
        return temperatureRepository.findByPatientId(patientId);
    }


}
