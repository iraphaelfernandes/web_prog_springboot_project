package com.example.application.service;

import com.example.application.entity.EntityRoom;
import com.example.application.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<EntityRoom> findAll() {
        return roomRepository.findAll();
    }

    public Optional<EntityRoom> findById(Long id) {
        return roomRepository.findById(id);
    }

    public EntityRoom create(EntityRoom entityRoom) {
        return roomRepository.save(entityRoom);
    }

    public EntityRoom update(Long id, EntityRoom updatedEntityRoom) {
        Optional<EntityRoom> existingRoom = roomRepository.findById(id);
        if (existingRoom.isPresent()) {
            EntityRoom entityRoom = existingRoom.get();
            entityRoom.setName(updatedEntityRoom.getName());
            return roomRepository.save(entityRoom);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}
