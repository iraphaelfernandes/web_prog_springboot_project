package com.example.application.service;

import com.example.application.dto.Window;
import com.example.application.entity.EntityRoom;
import com.example.application.entity.EntityWindow;
import com.example.application.mapper.MapperWindow;
import com.example.application.repository.WindowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WindowService {

    private final WindowRepository windowRepository;
    private final RoomService roomService;

    public WindowService(WindowRepository windowRepository, RoomService roomService) {
        this.windowRepository = windowRepository;
        this.roomService = roomService;
    }

    // Fetch all windows and convert them to DTOs
    public List<Window> findAll() {
        return windowRepository.findAll().stream()
                .map(MapperWindow::of)
                .collect(Collectors.toList());
    }

    // Fetch a window by ID and convert to DTO
    public Optional<Window> findById(Long id) {
        return windowRepository.findById(id)
                .map(MapperWindow::of);
    }

    // Create a new window from DTO
    public Window create(Window dto) {
        EntityRoom entityRoom = roomService.findById(dto.roomId()).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        EntityWindow entityWindow = MapperWindow.toEntity(dto, entityRoom);
        EntityWindow savedEntity = windowRepository.save(entityWindow);
        return MapperWindow.of(savedEntity);
    }

    // Update an existing window
    public Window update(Long id, Window dto) {
        EntityRoom entityRoom = roomService.findById(dto.roomId()).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        Optional<EntityWindow> existingWindowOpt = windowRepository.findById(id);

        if (existingWindowOpt.isPresent()) {
            EntityWindow entityWindow = existingWindowOpt.get();
            entityWindow.setName(dto.name());
            entityWindow.setWindowStatus(dto.statusWindow());
            entityWindow.setRoom(entityRoom);

            EntityWindow updatedEntity = windowRepository.save(entityWindow);
            return MapperWindow.of(updatedEntity);
        } else {
            throw new IllegalArgumentException("Window not found");
        }
    }

    public void deleteWindow(Long id) {
        windowRepository.deleteById(id);
    }
}
