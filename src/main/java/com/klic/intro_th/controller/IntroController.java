package com.klic.intro_th.controller;

import com.klic.intro_th.dto.IntroRequest;
import com.klic.intro_th.service.IntroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class IntroController {

    private final IntroService introService;

    @GetMapping("/")
    public String list(Model model){
        List<IntroRequest> introList = introService.findAll();
        model.addAttribute("intro", introList);
        return "index";
    }

    @PostMapping("/intro/new")
    public String save(@ModelAttribute IntroRequest request){
        introService.createIntro(request);
        return "redirect:/";
    }

    @PostMapping("/intro/delete/{id}")
    public String delete(@PathVariable Long id){
        introService.deleteIntro(id);
        return "redirect:/";
    }

    @PostMapping("/intro/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute IntroRequest request){
        introService.updateIntro(id, request);
        return "redirect:/";
    }

    public IntroController(IntroService introService) {
        this.introService = introService;
    }
}
