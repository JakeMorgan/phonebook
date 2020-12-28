package com.example.phonebook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
        @GetMapping(value="/")
        public String hello(){
            return "Hello World!!";
        }
}
