package com.example.application.controller;

import com.example.application.dto.Room;
import com.example.application.entity.EntityRoom;
import com.example.application.service.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ControllerRoom.class)
class ControllerRoomTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFindAllRooms() throws Exception {
        Room room1 = new Room(1L, "Room 1", List.of());
        Room room2 = new Room(2L, "Room 2", List.of());

        Mockito.when(roomService.findAll()).thenReturn(List.of(new EntityRoom(), new EntityRoom()));

        mockMvc.perform(get("/api/rooms").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].name").value("Room 1"))
                .andExpect(jsonPath("[1].name").value("Room 2"));
    }

    @Test
    void shouldFindRoomById() throws Exception {
        Room roomDto = new Room(1L, "Room 1", List.of());
        Mockito.when(roomService.findById(1L)).thenReturn(Optional.of(new EntityRoom()));

        mockMvc.perform(get("/api/rooms/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Room 1"));
    }

    @Test
    void shouldReturnNotFoundForInvalidRoomId() throws Exception {
        Mockito.when(roomService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/rooms/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateRoom() throws Exception {
        EntityRoom entityRoom = new EntityRoom();
        Room roomDto = new Room(null, "Room 1", List.of());
        Room savedRoom = new Room(1L, "Room 1", List.of());

        Mockito.when(roomService.create(Mockito.any())).thenReturn(entityRoom);

        mockMvc.perform(post("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(roomDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Room 1"));
    }

    @Test
    void shouldUpdateRoom() throws Exception {
        EntityRoom entityRoom = new EntityRoom();
        Room updatedRoom = new Room(1L, "Updated Room", List.of());
        Mockito.when(roomService.update(Mockito.anyLong(), Mockito.any())).thenReturn(entityRoom);

        mockMvc.perform(put("/api/rooms/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedRoom)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Updated Room"));
    }

    @Test
    void shouldDeleteRoom() throws Exception {
        mockMvc.perform(delete("/api/rooms/1"))
                .andExpect(status().isOk());

        Mockito.verify(roomService, Mockito.times(1)).delete(1L);
    }
}
