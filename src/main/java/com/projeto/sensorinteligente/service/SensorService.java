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

    public void salvarLuminosidade(int valor) {
        Sensor sensor = new Sensor();
        sensor.setLuminosidade(valor);
        sensor.setTemperatura(0);
        sensor.setUmidade(0);
        sensorRepository.save(sensor);
    }

    public void salvarTemperatura(int valor) {
        Sensor sensor = new Sensor();
        sensor.setTemperatura(valor);
        sensor.setLuminosidade(0);
        sensor.setUmidade(0);
        sensorRepository.save(sensor);
    }

    public void salvarUmidade(int valor) {
        Sensor sensor = new Sensor();
        sensor.setUmidade(valor);
        sensor.setLuminosidade(0);
        sensor.setTemperatura(0);
        sensorRepository.save(sensor);
    }
    public void salvarSensor(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();
        sensor.setLuminosidade(sensorDTO.getLuminosidade());
        sensor.setTemperatura(sensorDTO.getTemperatura());
        sensor.setUmidade(sensorDTO.getUmidade());
        sensorRepository.save(sensor);
    }

}
