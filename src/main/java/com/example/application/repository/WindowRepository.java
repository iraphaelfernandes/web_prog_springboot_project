package com.example.application.repository;

import com.example.application.entity.EntityWindow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindowRepository extends JpaRepository<EntityWindow, Long> {
}