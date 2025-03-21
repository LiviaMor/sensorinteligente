package com.projeto.sensorinteligente.repository;

import com.projeto.sensorinteligente.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}

