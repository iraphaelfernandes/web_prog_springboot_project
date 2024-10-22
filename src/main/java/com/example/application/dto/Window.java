package com.example.application.dto;

import com.example.application.entity.StatusWindow;

public record Window(Long id, String name, StatusWindow statusWindow, Long roomId) {
}