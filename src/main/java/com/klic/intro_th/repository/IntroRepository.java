package com.klic.intro_th.repository;

import com.klic.intro_th.entity.Intro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroRepository extends JpaRepository<Intro, Long> {
}
