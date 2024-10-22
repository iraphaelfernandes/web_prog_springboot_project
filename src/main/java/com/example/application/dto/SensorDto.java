package com.example.application.dto;

import com.example.application.entity.SensorType;

public record SensorDto(Long id, String name, Double value, SensorType sensorType) {
}