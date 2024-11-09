package com.service.service.controller;

import com.service.service.core.EdaDataMapper;
import com.service.service.entities.EdaDataDTO;
import com.service.service.model.EdaData;
import com.service.service.service.EdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/eda")
public class EdaController {

    private final EdaService edaService;
    private final EdaDataMapper edaDataMapper;

    @Autowired
    public EdaController(EdaService edaService, EdaDataMapper edaDataMapper) {
        this.edaService = edaService;
        this.edaDataMapper = edaDataMapper;
    }

    @PostMapping("/data")
    public void receiveEdaData(@RequestBody EdaDataDTO edaDataDTO) {
        EdaData edaData = edaDataMapper.toEntity(edaDataDTO);
        edaService.saveEdaData(
                edaData.getPatientId(),
                edaData.getDeviceId(),
                edaData.getTimestampedValues()
        );
    }

    @GetMapping("/{patientId}")
    public List<EdaDataDTO> getEdaData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<EdaData> edaDataList = edaService.getAllEdaDataByDateRange(patientId, start, end);
        return edaDataMapper.toDTOList(edaDataList);
    }

    @GetMapping("/data/{patientId}")
    public List<EdaDataDTO> getAllEdaData(@PathVariable String patientId) {
        List<EdaData> edaDataList = edaService.getAllEdaData(patientId);
        return edaDataMapper.toDTOList(edaDataList);
    }

}
