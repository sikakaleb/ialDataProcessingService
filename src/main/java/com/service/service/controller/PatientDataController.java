package com.service.service.controller;


import com.service.service.entities.PatientDataDTO;
import com.service.service.service.PatientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/patient")
public class PatientDataController {

    @Autowired
    private PatientDataService patientDataService;

    @GetMapping("/{patientId}/data")
    public ResponseEntity<PatientDataDTO> getAllDataByPatientId(@PathVariable String patientId) {
        PatientDataDTO patientData = patientDataService.getAllDataByPatientId(patientId);
        return ResponseEntity.ok(patientData);
    }
    @GetMapping("/{patientId}/data-range")
    public PatientDataDTO getPatientDataByTimeRange(
            @PathVariable String patientId,
            @RequestParam Instant startTime,
            @RequestParam Instant endTime) {

        return patientDataService.getAllDataByPatientIdAndDateRange(patientId, startTime, endTime);
    }
}
