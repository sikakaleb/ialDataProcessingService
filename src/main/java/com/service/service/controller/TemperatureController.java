package com.service.service.controller;

import com.service.service.core.TemperatureDataMapper;
import com.service.service.entities.TemperatureDataDTO;
import com.service.service.model.TemperatureData;
import com.service.service.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {

    private final TemperatureService temperatureService;
    private final TemperatureDataMapper temperatureDataMapper;

    @Autowired
    public TemperatureController(TemperatureService temperatureService, TemperatureDataMapper temperatureDataMapper) {
        this.temperatureService = temperatureService;
        this.temperatureDataMapper = temperatureDataMapper;
    }

    @PostMapping("/data")
    public void receiveTemperatureData(@RequestBody TemperatureDataDTO temperatureDataDTO) {
        TemperatureData temperatureData = temperatureDataMapper.toEntity(temperatureDataDTO);
        temperatureService.saveTemperature(
                temperatureData.getPatientId(),
                temperatureData.getDeviceId(),
                temperatureData.getTemperature()
        );
    }

    @GetMapping("/{patientId}")
    public List<TemperatureDataDTO> getTemperatureData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<TemperatureData> temperatureDataList = temperatureService.getTemperatureData(patientId, start, end);
        return temperatureDataMapper.toDTOList(temperatureDataList);
    }
}
