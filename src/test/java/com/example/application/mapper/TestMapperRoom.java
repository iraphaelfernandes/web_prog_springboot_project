package com.example.application.mapper;

import com.example.application.dto.Room;
import com.example.application.entity.EntityRoom;
import com.example.application.entity.EntityWindow;
import org.junit.jupiter.api.Test;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class TestMapperRoom {

    @Test
    void shouldMapRoomEntityToDto() {
        EntityRoom entityRoom = new EntityRoom();
        entityRoom.setId(1L);
        entityRoom.setName("Room 1");

        EntityWindow entityWindow1 = new EntityWindow();
        entityWindow1.setId(1L);
        entityWindow1.setName("Window 1");

        EntityWindow entityWindow2 = new EntityWindow();
        entityWindow2.setId(2L);
        entityWindow2.setName("Window 2");

        entityRoom.setWindows(Set.of(entityWindow1, entityWindow2));

        Room roomDto = MapperRoom.of(entityRoom);

        assertEquals(1L, roomDto.id());
        assertEquals("Room 1", roomDto.name());
        assertEquals(2, roomDto.windows().size());
    }
}
