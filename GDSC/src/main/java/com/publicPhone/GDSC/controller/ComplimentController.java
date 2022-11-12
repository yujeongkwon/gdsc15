package com.publicPhone.GDSC.controller;

import com.publicPhone.GDSC.service.ComplimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ComplimentController {
    private final ComplimentService complimentService;

    @GetMapping("/compliment")
    public String compliment(){
        String compliment = complimentService.getSentence();
        return compliment;
    }

}
