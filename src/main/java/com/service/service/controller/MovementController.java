package com.service.service.controller;

import com.service.service.core.MovementDataMapper;
import com.service.service.entities.MovementDataDTO;
import com.service.service.model.MovementData;
import com.service.service.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/movement")
public class MovementController {

    private final MovementService movementService;
    private final MovementDataMapper movementDataMapper;

    @Autowired
    public MovementController(MovementService movementService, MovementDataMapper movementDataMapper) {
        this.movementService = movementService;
        this.movementDataMapper = movementDataMapper;
    }

    @PostMapping("/data")
    public void receiveMovementData(@RequestBody MovementDataDTO movementDataDTO) {
        MovementData movementData = movementDataMapper.toEntity(movementDataDTO);
        movementService.saveMovementData(
                movementData.getPatientId(),
                movementData.getDeviceId(),
                movementData.getAccelerationValues()
        );
    }

    @GetMapping("/{patientId}")
    public List<MovementDataDTO> getMovementData(
            @PathVariable String patientId,
            @RequestParam Instant start,
            @RequestParam Instant end) {
        List<MovementData> movementDataList = movementService.getMovementData(patientId, start, end);
        return movementDataMapper.toDTOList(movementDataList);
    }
}
