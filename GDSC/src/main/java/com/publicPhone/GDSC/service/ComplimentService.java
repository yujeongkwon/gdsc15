package com.publicPhone.GDSC.service;

import com.publicPhone.GDSC.domain.Compliment;
import com.publicPhone.GDSC.repository.ComplimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplimentService {
    public final ComplimentRepository complimentRepository;
    static Random random = new Random();

    @Transactional
    public void save(String sentence){
        Compliment compliment = new Compliment();
        compliment.setSentence(sentence);
        complimentRepository.save(compliment);
    }

    @Transactional
    public String getSentence(){
        List<Compliment> complimentList = complimentRepository.findAll();
        Compliment compliment = complimentList.get(random.nextInt(complimentList.size()));
        return compliment.getSentence();
    }
}
