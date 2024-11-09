package com.service.service.controller;

import com.service.service.core.BloodPressureDataMapper;
import com.service.service.entities.BloodPressureDataDTO;
import com.service.service.model.BloodPressureData;
import com.service.service.service.BloodPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/blood-pressure")
public class BloodPressureController {

    private final BloodPressureService bloodPressureService;
    private final BloodPressureDataMapper bloodPressureDataMapper;

    @Autowired
    public BloodPressureController(BloodPressureService bloodPressureService, BloodPressureDataMapper bloodPressureDataMapper) {
        this.bloodPressureService = bloodPressureService;
        this.bloodPressureDataMapper = bloodPressureDataMapper;
    }

    @PostMapping("/data")
    public void receiveBloodPressureData(@RequestBody BloodPressureDataDTO bloodPressureDataDTO) {
        BloodPressureData bloodPressureData = bloodPressureDataMapper.toEntity(bloodPressureDataDTO);
        bloodPressureService.saveBloodPressure(
                bloodPressureData.getPatientId(),
                bloodPressureData.getDeviceId(),
                bloodPressureData.getSystolic(),
                bloodPressureData.getDiastolic()
        );
    }

    @GetMapping("/{patientId}")
    public List<BloodPressureDataDTO> getBloodPressureData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<BloodPressureData> bloodPressureDataList = bloodPressureService.getBloodPressureData(patientId, start, end);
        return bloodPressureDataMapper.toDTOList(bloodPressureDataList);
    }
    @GetMapping("/data/{patientId}")
    public List<BloodPressureDataDTO> getAllBloodPressureData(@PathVariable String patientId) {
        List<BloodPressureData> bloodPressureDataList = bloodPressureService.getAllBloodPressureData(patientId);
        return bloodPressureDataMapper.toDTOList(bloodPressureDataList);
    }

}
