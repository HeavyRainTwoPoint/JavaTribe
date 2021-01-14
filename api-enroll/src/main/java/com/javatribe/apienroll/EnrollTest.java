package com.javatribe.apienroll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollTest {

    @GetMapping("/enroll_test")
    public String enroll(){
        return "new world";
    }
}
