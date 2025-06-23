package com.secure.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String gretings(){
        return  "hello";
    }
    @GetMapping("/contact")
    public String getContants(){
        return  "contact";
    }
}
