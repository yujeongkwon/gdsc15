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
            complimentService.save("2070년에도 넌 멋지구 사랑스러운 아이양 (❁´◡`❁)");
            complimentService.save("2070년에도 넌 사랑받고 있고 사랑 받기위해 태어난 존재야 ༼ つ ◕_◕ ༽つ");
            complimentService.save("2070년에도 잘하고 있고 넌 칭찬받아 마땅한 존재야 ☆*: .｡. o(≧▽≦)o .｡.:");
            complimentService.save("2070년에도 아주 멋지게 숨을 쉬고 있어!! 어떻게 그러케 숨도 잘쉬니!? (☞ﾟヮﾟ)☞");
            complimentService.save("2070년의 미래인이 이러니까 놀라워? 어이없어 하지마 그 표정마저 귀여우니까 o((>ω< ))o");
        }

        public void dbInit2() {
            complimentService.save("2070년에도 너는 아주 잘 먹고 있어서 사랑스러워 ╰(*°▽°*)╯");
            complimentService.save("2070년에도 너는 귀엽기 떄문에 함들면 때려쳐버려 넌 귀여우니까 ☆… (╯°□°）╯︵ ┻━┻");
            complimentService.save("2070년에도 너는 당당하게 살고있어 자신감을 가져 나의 아기 고양이 (¬‿¬)");
            complimentService.save("2070년의 넌 아주아주 잘난 사람이되었어 자심감을 가져 귀여운 존재 ( ͡° ͜ʖ ͡°)_/¯*☆");
            complimentService.save("힘들 땐 너가 귀여워서 그랬던 거라고 생각해 (○｀ 3′○) 2070년 되어서 보니까 아무것도 아니다 야~〜(￣▽￣〜)");

        }
    }


}
