package com.publicPhone.GDSC.repository;

import com.publicPhone.GDSC.domain.Compliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ComplimentRepository extends JpaRepository<Compliment,Long> {
    List<String> findBySentence(String sentence);
}
