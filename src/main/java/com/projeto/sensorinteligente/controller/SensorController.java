package com.projeto.sensorinteligente.controller;

import com.projeto.sensorinteligente.dto.SensorDTO;
import com.projeto.sensorinteligente.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {

        this.sensorService = sensorService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarSensor(@RequestBody SensorDTO sensorDTO) {
        sensorService.salvarSensor(sensorDTO);
        return ResponseEntity.ok().build();


    }
}
