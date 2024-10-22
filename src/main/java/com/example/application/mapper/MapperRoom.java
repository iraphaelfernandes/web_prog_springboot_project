package com.example.application.mapper;

import com.example.application.dto.Room;
import com.example.application.entity.EntityRoom;

import java.util.stream.Collectors;

public class MapperRoom {
    public static Room of(EntityRoom entity) {
        return new Room(
                entity.getId(),
                entity.getName(),
                entity.getWindows().stream().map(MapperWindow::of).collect(Collectors.toList())
        );
    }
}
