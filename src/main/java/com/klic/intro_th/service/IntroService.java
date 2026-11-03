package com.klic.intro_th.service;

import com.klic.intro_th.dto.IntroRequest;
import com.klic.intro_th.entity.Intro;
import com.klic.intro_th.repository.IntroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntroService {
    private final IntroRepository introRepository;

    @Transactional
    public Long createIntro(IntroRequest request){
        Intro intro = request.toEntity(request);
        return introRepository.save(intro).getId();
    }

    public void deleteIntro(Long id){
        introRepository.deleteById(id);
    }

    @Transactional
    public void updateIntro(Long id, IntroRequest request){
        Intro intro = introRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("error")
        );

        intro.setName(request.name());
        intro.setMessage(request.message());

    }

    public IntroRequest findIntro(Long id){
        Intro intro = introRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("error")
        );

        return intro.toDto(intro);
    }

    public List<IntroRequest> findAll(){
        List<IntroRequest> requestList = new ArrayList<>();
        List<Intro> introList = introRepository.findAll();

        for(Intro i : introList){
            requestList.add(i.toDto(i));
        }

        return requestList;
    }

    public IntroService(IntroRepository introRepository){
        this.introRepository = introRepository;
    }
}
