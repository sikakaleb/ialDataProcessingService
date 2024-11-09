package com.service.service.controller;

import com.service.service.core.SpO2DataMapper;
import com.service.service.entities.SpO2DataDTO;
import com.service.service.model.SpO2Data;
import com.service.service.service.SpO2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/spo2")
public class SpO2Controller {

    private final SpO2Service spO2Service;
    private final SpO2DataMapper spO2DataMapper;

    @Autowired
    public SpO2Controller(SpO2Service spO2Service, SpO2DataMapper spO2DataMapper) {
        this.spO2Service = spO2Service;
        this.spO2DataMapper = spO2DataMapper;
    }

    @PostMapping("/data")
    public void receiveSpO2Data(@RequestBody SpO2DataDTO spO2DataDTO) {
        SpO2Data spO2Data = spO2DataMapper.toEntity(spO2DataDTO);
        spO2Service.saveSpO2Data(
                spO2Data.getPatientId(),
                spO2Data.getDeviceId(),
                spO2Data.getOxygenSaturation()
        );
    }

    @GetMapping("/{patientId}")
    public List<SpO2DataDTO> getSpO2Data(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<SpO2Data> spO2DataList = spO2Service.getSpO2Data(patientId, start, end);
        return spO2DataMapper.toDTOList(spO2DataList);
    }
}
