package com.example.application.dto;

import java.util.List;

public record Room(Long id, String name, List<Window> windows) {
}
