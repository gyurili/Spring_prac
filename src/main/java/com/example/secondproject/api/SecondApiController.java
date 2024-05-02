package com.example.secondproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //API용 컨트롤러
public class SecondApiController {
    @GetMapping("/api/hello")
    public String hello(){
        return "hello world!";
    }
}
