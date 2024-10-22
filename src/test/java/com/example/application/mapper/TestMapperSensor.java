package com.example.application.mapper;

import com.example.application.dto.SensorDto;
import com.example.application.entity.EntitySensor;
import com.example.application.entity.SensorType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestMapperSensor {

    @Test
    void shouldMapSensorEntityToDto() {
        EntitySensor entitySensor = new EntitySensor();
        entitySensor.setId(1L);
        entitySensor.setName("Temperature Sensor");
        entitySensor.setSensorType(SensorType.TEMPERATURE);
        entitySensor.setValue(25.0);

        SensorDto sensorDto = MapperSensor.of(entitySensor);

        assertEquals(1L, sensorDto.id());
        assertEquals("Temperature Sensor", sensorDto.name());
        assertEquals(SensorType.TEMPERATURE, sensorDto.sensorType());
        assertEquals(25.0, sensorDto.value());
    }
}
