package com.example.apirest.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ExemploController {

    @GetMapping("/mensagem")
    public String receberMensagem(@RequestParam String texto) {
        return "Mensagem recebida: " + texto;
    }
}