package com.example.application.controller;

import com.example.application.dto.Room;
import com.example.application.entity.EntityRoom;
import com.example.application.mapper.MapperRoom;
import com.example.application.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class ControllerRoom {

    private final RoomService roomService;

    public ControllerRoom(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> findAll() {
        return roomService.findAll().stream()
                .map(MapperRoom::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable Long id) {
        return roomService.findById(id).map(MapperRoom::of).orElse(null);
    }

    @PostMapping
    public Room create(@RequestBody EntityRoom entityRoom) {
        return MapperRoom.of(roomService.create(entityRoom));
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable Long id, @RequestBody EntityRoom entityRoom) {
        return MapperRoom.of(roomService.update(id, entityRoom));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}
