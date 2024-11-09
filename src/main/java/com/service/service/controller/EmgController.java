package com.service.service.controller;

import com.service.service.core.EmgDataMapper;
import com.service.service.entities.EmgDataDTO;
import com.service.service.model.EmgData;
import com.service.service.service.EmgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/emg")
public class EmgController {

    private final EmgService emgService;
    private final EmgDataMapper emgDataMapper;

    @Autowired
    public EmgController(EmgService emgService, EmgDataMapper emgDataMapper) {
        this.emgService = emgService;
        this.emgDataMapper = emgDataMapper;
    }

    @PostMapping("/data")
    public void receiveEmgData(@RequestBody EmgDataDTO emgDataDTO) {
        EmgData emgData = emgDataMapper.toEntity(emgDataDTO);
        emgService.saveEmgData(
                emgData.getPatientId(),
                emgData.getDeviceId(),
                emgData.getTimestampedValues()
        );
    }

    @GetMapping("/{patientId}")
    public List<EmgDataDTO> getEmgData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<EmgData> emgDataList = emgService.getEmgData(patientId, start, end);
        return emgDataMapper.toDTOList(emgDataList);
    }

    @GetMapping("/data/{patientId}")
    public List<EmgDataDTO> getAllEmgData(@PathVariable String patientId) {
        List<EmgData> emgDataList = emgService.getAllEmgData(patientId);
        return emgDataMapper.toDTOList(emgDataList);
    }

}
