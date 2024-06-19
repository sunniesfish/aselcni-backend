package com.learnway.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TestController {

    private TestService testService;

    @PostMapping("/test.do")
    public String test(@RequestParam("value") String value) {
        testService.writeValue(value);
        return "index";
    }
}
