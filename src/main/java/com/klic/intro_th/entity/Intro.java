package com.klic.intro_th.entity;

import com.klic.intro_th.dto.IntroRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Intro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String message;

    private LocalDateTime createdAt;

    public Intro() {

    }

    public Intro(String name, String message, LocalDateTime createdAt) {
        this.name = name;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Intro(Long id, String name, String message, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public IntroRequest toDto(Intro intro){
        return new IntroRequest(
                intro.getId(),
                intro.getName(),
                intro.getMessage(),
                intro.getCreatedAt()
        );
    }
}
