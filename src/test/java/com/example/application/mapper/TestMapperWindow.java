package com.example.application.mapper;

import com.example.application.dto.Window;
import com.example.application.entity.EntityRoom;
import com.example.application.entity.EntityWindow;
import com.example.application.entity.StatusWindow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestMapperWindow {

    @Test
    void shouldMapWindowEntityToDto() {
        EntityRoom entityRoom = new EntityRoom();
        entityRoom.setId(1L);

        EntityWindow entityWindow = new EntityWindow();
        entityWindow.setId(1L);
        entityWindow.setName("Window 1");
        entityWindow.setWindowStatus(StatusWindow.CLOSED);
        entityWindow.setRoom(entityRoom);

        Window windowDto = MapperWindow.of(entityWindow);

        assertEquals(1L, windowDto.id());
        assertEquals("Window 1", windowDto.name());
        assertEquals(StatusWindow.CLOSED, windowDto.statusWindow());
        assertEquals(1L, windowDto.roomId());
    }
}
