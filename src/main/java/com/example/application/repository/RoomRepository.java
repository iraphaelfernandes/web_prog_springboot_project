package com.example.application.repository;

import com.example.application.entity.EntityRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<EntityRoom, Long> {
}
