package br.com.marcelino.parking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/")
@ApiIgnore
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello Spring Teste!";
    }
}
