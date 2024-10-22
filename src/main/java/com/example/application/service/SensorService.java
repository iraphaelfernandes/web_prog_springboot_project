package com.example.application.service;

import com.example.application.dto.SensorDto;
import com.example.application.entity.EntitySensor;
import com.example.application.mapper.MapperSensor;
import com.example.application.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    // Fetch all sensors and convert them to DTOs
    public List<SensorDto> findAll() {
        return sensorRepository.findAll().stream()
                .map(MapperSensor::of)
                .collect(Collectors.toList());
    }

    // Fetch a sensor by ID and convert to DTO
    public Optional<SensorDto> findById(Long id) {
        return sensorRepository.findById(id)
                .map(MapperSensor::of);
    }

    // Create a new sensor from DTO
    public SensorDto create(SensorDto dto) {
        EntitySensor entitySensor = MapperSensor.toEntity(dto);
        EntitySensor savedEntity = sensorRepository.save(entitySensor);
        return MapperSensor.of(savedEntity);
    }

    // Update an existing sensor
    public SensorDto update(Long id, SensorDto dto) {
        Optional<EntitySensor> existingSensorOpt = sensorRepository.findById(id);

        if (existingSensorOpt.isPresent()) {
            EntitySensor entitySensor = existingSensorOpt.get();
            entitySensor.setName(dto.name());
            entitySensor.setValue(dto.value());
            entitySensor.setSensorType(dto.sensorType());

            EntitySensor updatedEntity = sensorRepository.save(entitySensor);
            return MapperSensor.of(updatedEntity);
        } else {
            throw new IllegalArgumentException("Sensor not found");
        }
    }

    public void deleteById(Long id) {
        sensorRepository.deleteById(id);
    }
}
