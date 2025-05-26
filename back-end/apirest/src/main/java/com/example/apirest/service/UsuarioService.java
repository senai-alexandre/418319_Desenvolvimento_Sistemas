package com.example.apirest.service;

import com.example.apirest.controllers.*;
import com.example.apirest.dto.UsuarioDTO;
import com.example.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
           
    public Boolean inserirUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("ALEXANDRE");
        usuarioDTO.setSenha("SENHAA");
        
       return usuarioRepository.inserirUsuario(usuarioDTO);
    }
}