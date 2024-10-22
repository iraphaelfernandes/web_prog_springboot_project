package com.example.application;

import com.example.application.entity.EntityRoom;
import com.example.application.entity.EntitySensor;
import com.example.application.entity.SensorType;
import com.example.application.entity.EntityWindow;

import java.util.Set;

public class FakeEntityBuilder {

    public static EntityRoom createRoomEntity(Long id, String name) {
        EntityRoom entityRoom = new EntityRoom();
        entityRoom.setId(id);
        entityRoom.setName(name);

        entityRoom.setWindows(Set.of(
                createWindowEntity(id * 10 + 1L, "Window1" + name, entityRoom),
                createWindowEntity(id * 10 + 2L, "Window2" + name, entityRoom)
        ));

        return entityRoom;
    }

    public static EntityWindow createWindowEntity(Long id, String name, EntityRoom entityRoom) {
        EntityWindow entityWindow = new EntityWindow();
        entityWindow.setId(id);
        entityWindow.setName(name);
        entityWindow.setRoom(entityRoom);
        return entityWindow;
    }

    public static EntitySensor createSensorEntity(Long id, String name, SensorType type, Double value) {
        EntitySensor entitySensor = new EntitySensor();
        entitySensor.setId(id);
        entitySensor.setName(name);
        entitySensor.setSensorType(type);
        entitySensor.setValue(value);
        return entitySensor;
    }
}
