package com.publicPhone.GDSC.controller;

import com.publicPhone.GDSC.service.ComplimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HelloController {
    private final ComplimentService complimentService;
    @GetMapping("hello")
    public String hello(Model model) {
        String tmp = "gg";
        String temp = complimentService.getSentence();
        model.addAttribute("data",temp);
        return "hello";
    }
}