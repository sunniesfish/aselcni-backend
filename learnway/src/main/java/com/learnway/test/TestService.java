package com.learnway.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TestService {
    private final TestRepository testRepository;

    public void writeValue(String value) {
        Test test = new Test();
        test.setTestValue(value);
        testRepository.save(test);
    }

    public Test getTest(){
        return testRepository.findAll().get(0);
    }
}
