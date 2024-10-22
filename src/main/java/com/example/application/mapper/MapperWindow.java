package com.example.application.mapper;

import com.example.application.dto.Window;
import com.example.application.entity.EntityRoom;
import com.example.application.entity.EntityWindow;

public class MapperWindow {

    public static Window of(EntityWindow entity) {
        return new Window(
                entity.getId(),
                entity.getName(),
                entity.getWindowStatus(),
                entity.getRoom() != null ? entity.getRoom().getId() : null
        );
    }

    public static EntityWindow toEntity(Window dto, EntityRoom entityRoom) {
        EntityWindow entity = new EntityWindow();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setWindowStatus(dto.statusWindow());
        entity.setRoom(entityRoom);
        return entity;
    }
}
