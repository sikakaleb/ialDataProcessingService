package com.service.service.controller;

import com.service.service.core.RespiratoryRateDataMapper;
import com.service.service.entities.RespiratoryRateDataDTO;
import com.service.service.model.RespiratoryRateData;
import com.service.service.service.RespiratoryRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/respiratory-rate")
public class RespiratoryRateController {

    private final RespiratoryRateService respiratoryRateService;
    private final RespiratoryRateDataMapper respiratoryRateDataMapper;

    @Autowired
    public RespiratoryRateController(RespiratoryRateService respiratoryRateService, RespiratoryRateDataMapper respiratoryRateDataMapper) {
        this.respiratoryRateService = respiratoryRateService;
        this.respiratoryRateDataMapper = respiratoryRateDataMapper;
    }

    @PostMapping("/data")
    public void receiveRespiratoryRateData(@RequestBody RespiratoryRateDataDTO respiratoryRateDataDTO) {
        RespiratoryRateData respiratoryRateData = respiratoryRateDataMapper.toEntity(respiratoryRateDataDTO);
        respiratoryRateService.saveRespiratoryRate(
                respiratoryRateData.getPatientId(),
                respiratoryRateData.getDeviceId(),
                respiratoryRateData.getRespiratoryRate()
        );
    }

    @GetMapping("/{patientId}")
    public List<RespiratoryRateDataDTO> getRespiratoryRateData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<RespiratoryRateData> respiratoryRateDataList = respiratoryRateService.getAllRespiratoryRateDataByDateRange(patientId, start, end);
        return respiratoryRateDataMapper.toDTOList(respiratoryRateDataList);
    }

    @GetMapping("/data/{patientId}")
    public List<RespiratoryRateDataDTO> getAllRespiratoryRateData(@PathVariable String patientId) {
        List<RespiratoryRateData> respiratoryRateDataList = respiratoryRateService.getAllRespiratoryRateData(patientId);
        return respiratoryRateDataMapper.toDTOList(respiratoryRateDataList);
    }



}

