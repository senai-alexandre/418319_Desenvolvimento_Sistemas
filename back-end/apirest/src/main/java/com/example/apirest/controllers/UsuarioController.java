package com.example.apirest.controllers;

import com.example.apirest.dto.UsuarioDTO;
import com.example.apirest.repository.UsuarioRepository;
import com.example.apirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
       
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastrar")
    public Boolean cadastrar() {
        return  usuarioService.inserirUsuario();
    }
}