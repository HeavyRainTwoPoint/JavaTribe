package com.javatribe.apidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyr
 * @create 2020/11/11 12:27
 */
@RestController
public class ExampleClass {

    @GetMapping("/hello")
    public String hh() {
        return "hello world!!";
    }
}
