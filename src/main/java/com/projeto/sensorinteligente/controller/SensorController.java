package com.projeto.sensorinteligente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.projeto.sensorinteligente.service.SensorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.projeto.sensorinteligente.controller.SensorController;
import org.springframework.http.ResponseEntity;

@Repository
@RequestMapping ("/sensor")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping ("/luminosidade")
    public ResponseEntity<Void> salvarLuminosidade(@RequestBody int valor) {
        sensorService.salvarLuminosidade(valor);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/temperatura")
    public ResponseEntity<Void> salvarTemperatura(@RequestBody int valor) {
        sensorService.salvarTemperatura(valor);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/umidade")
    public ResponseEntity<Void> salvarUmidade(@RequestBody int valor) {
        sensorService.salvarUmidade(valor);
        return ResponseEntity.ok().build();
    }
}
