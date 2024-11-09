package com.service.service.controller;

import com.service.service.core.HeartRateDataMapper;
import com.service.service.entities.HeartRateDataDTO;
import com.service.service.model.HeartRateData;
import com.service.service.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/heart-rate")
public class HeartRateController {

    private final HeartRateService heartRateService;
    private final HeartRateDataMapper heartRateDataMapper;

    @Autowired
    public HeartRateController(HeartRateService heartRateService, HeartRateDataMapper heartRateDataMapper) {
        this.heartRateService = heartRateService;
        this.heartRateDataMapper = heartRateDataMapper;
    }

    @PostMapping("/data")
    public void receiveHeartRateData(@RequestBody HeartRateDataDTO heartRateDataDTO) {
        HeartRateData heartRateData = heartRateDataMapper.toEntity(heartRateDataDTO);
        heartRateService.saveHeartRate(
                heartRateData.getPatientId(),
                heartRateData.getDeviceId(),
                heartRateData.getHeartRate()
        );
    }

    @GetMapping("/{patientId}")
    public List<HeartRateDataDTO> getHeartRateData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<HeartRateData> heartRateDataList = heartRateService.getHeartRateData(patientId, start, end);
        return heartRateDataMapper.toDTOList(heartRateDataList);
    }
}
