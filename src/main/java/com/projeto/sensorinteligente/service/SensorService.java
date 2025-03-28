package com.projeto.sensorinteligente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.sensorinteligente.repository.SensorRepository;
import com.projeto.sensorinteligente.dto.SensorDTO;
import com.projeto.sensorinteligente.entity.Sensor;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public void salvarSensor(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();
        sensor.setLuminosidade(sensorDTO.getLuminosidade());
        sensor.setTemperatura(sensorDTO.getTemperatura());
        sensor.setUmidade(sensorDTO.getUmidade());
        sensorRepository.save(sensor);
    }
}
