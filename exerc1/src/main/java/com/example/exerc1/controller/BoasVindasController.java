package com.example.exerc1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoasVindasController {
    @GetMapping("/clamed/hello")
    public String exibirMensagem(@RequestParam("name") String name){
        return "Bem vindo " + name + "!";
    }
}
