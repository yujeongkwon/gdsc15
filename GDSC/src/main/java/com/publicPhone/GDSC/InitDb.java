package com.publicPhone.GDSC;

import com.publicPhone.GDSC.domain.Compliment;
import com.publicPhone.GDSC.repository.ComplimentRepository;

import com.publicPhone.GDSC.service.ComplimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

//h2에서 확인하기 위함
@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;
    @Autowired
    private ComplimentRepository complimentRepository;

    @PostConstruct
    public void init() {

        initService.dbInit1();
        initService.dbInit2();
        List<Compliment> complimentList = complimentRepository.findAll();
        System.out.println("complimentList = " + complimentList);

    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        @Autowired
        private ComplimentService complimentService;

        public void dbInit1() {
            complimentService.save("너는 멋져!");
            complimentService.save("너는 짱이야!");
            complimentService.save("너는 기여워!");
             }

        public void dbInit2() {
            complimentService.save("너는 쩌러!");
            complimentService.save("너는 잘생겼어!");
            complimentService.save("너는 이뻐!");

        }
    }


}
