package com.publicPhone.GDSC.service;

import com.publicPhone.GDSC.domain.Compliment;
import com.publicPhone.GDSC.repository.ComplimentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ComplimentServiceTest {
    @Autowired
    private ComplimentRepository complimentRepository;
    
    @Autowired
    private ComplimentService complimentService;
    
    @Rollback(false)
    @BeforeEach
    public void setUp() {
        Compliment compliment = new Compliment();
        compliment.setSentence("너는 멋져!");

        Compliment compliment1 = new Compliment();
        compliment1.setSentence("너는 짱이야!");

        Compliment compliment2 = new Compliment();
        compliment2.setSentence("너는 기여워!");

        complimentRepository.save(compliment);
        complimentRepository.save(compliment1);
        complimentRepository.save(compliment2);
    }

    @Test
    @Transactional
    void 저장확인() {
        Compliment compliment = Compliment.builder()
                .sentence("너는 멋있어!")
                .build();
        complimentRepository.save(compliment);
        List<Compliment> complimentList = complimentRepository.findAll();
        System.out.println("complimentList = " + complimentList);
    }

    @Test
    @Transactional
    void 랜덤으로_문장가져오기() {
        String sentence = complimentService.getSentence();
        System.out.println("sentence = " + sentence);
        String sentence1 = complimentService.getSentence();
        System.out.println("sentence = " + sentence1);
    }

}