package com.example.application.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class EntityRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<EntityWindow> windows;

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

    public Set<EntityWindow> getWindows() {
        return windows;
    }

    public void setWindows(Set<EntityWindow> windows) {
        this.windows = windows;
    }
}
