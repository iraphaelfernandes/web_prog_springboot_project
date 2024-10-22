package com.example.application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "windows")
public class EntityWindow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private StatusWindow statusWindow;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private EntityRoom room;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusWindow getWindowStatus() {
        return statusWindow;
    }

    public void setWindowStatus(StatusWindow statusWindow) {
        this.statusWindow = statusWindow;
    }

    public EntityRoom getRoom() {
        return room;
    }

    public void setRoom(EntityRoom room) {
        this.room = room;
    }
}
