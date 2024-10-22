package com.example.application.mapper;

import com.example.application.dto.SensorDto;
import com.example.application.entity.EntitySensor;

public class MapperSensor {

    public static SensorDto of(EntitySensor entity) {
        return new SensorDto(
                entity.getId(),
                entity.getName(),
                entity.getValue(),
                entity.getSensorType()
        );
    }

    public static EntitySensor toEntity(SensorDto dto) {
        EntitySensor entity = new EntitySensor();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setValue(dto.value());
        entity.setSensorType(dto.sensorType());
        return entity;
    }
}
