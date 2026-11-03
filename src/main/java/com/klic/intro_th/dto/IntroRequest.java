package com.klic.intro_th.dto;

import com.klic.intro_th.entity.Intro;

import java.time.LocalDateTime;

public record IntroRequest(
        Long id,
        String name,
        String message,
        LocalDateTime createdAt
) {

    public Intro toEntity(IntroRequest request){
        return new Intro(
                request.id,
                request.name,
                request.message,
                LocalDateTime.now()
        );
    }
}
