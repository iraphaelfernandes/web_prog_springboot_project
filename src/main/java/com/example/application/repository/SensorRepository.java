package com.example.application.repository;

import com.example.application.entity.EntitySensor;
import com.example.application.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<EntitySensor, Long> {
    List<EntitySensor> findBySensorType(SensorType sensorType);
}