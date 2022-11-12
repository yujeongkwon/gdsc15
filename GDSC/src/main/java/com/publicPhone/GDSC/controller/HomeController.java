package com.publicPhone.GDSC.controller;

import com.publicPhone.GDSC.service.ComplimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ComplimentService complimentService;

    @GetMapping("/home")
    public String home(Model model) {
        String sentence = complimentService.getSentence();
        System.out.println("sentence = " + sentence);
        model.addAttribute("com", sentence);
        return "show";
    }
}
