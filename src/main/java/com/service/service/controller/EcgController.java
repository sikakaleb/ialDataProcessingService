package com.service.service.controller;

import com.service.service.core.EcgDataMapper;
import com.service.service.entities.EcgDataDTO;
import com.service.service.model.EcgData;
import com.service.service.service.EcgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/ecg")
public class EcgController {

    private final EcgService ecgService;
    private final EcgDataMapper ecgDataMapper;

    @Autowired
    public EcgController(EcgService ecgService, EcgDataMapper ecgDataMapper) {
        this.ecgService = ecgService;
        this.ecgDataMapper = ecgDataMapper;
    }

    @PostMapping("/data")
    public void receiveEcgData(@RequestBody EcgDataDTO ecgDataDTO) {
        EcgData ecgData = ecgDataMapper.toEntity(ecgDataDTO);
        ecgService.saveEcgData(
                ecgData.getPatientId(),
                ecgData.getDeviceId(),
                ecgData.getTimestampedValues()
        );
    }

    @GetMapping("/{patientId}")
    public List<EcgDataDTO> getEcgData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<EcgData> ecgDataList = ecgService.getEcgData(patientId, start, end);
        return ecgDataMapper.toDTOList(ecgDataList);
    }
}
