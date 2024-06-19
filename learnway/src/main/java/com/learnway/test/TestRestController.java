package com.learnway.test;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestRestController {

    private TestService testService;

    @GetMapping("/api/test")
    public ResponseEntity getTest(){
        Test test = testService.getTest();
        return new ResponseEntity(test, HttpStatus.OK);
    }
}
