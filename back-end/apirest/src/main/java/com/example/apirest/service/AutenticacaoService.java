package com.example.apirest.service;

import com.example.apirest.controllers.*;
import com.example.apirest.dto.AutenticacaoDTO;
import org.springframework.web.bind.annotation.*;


public class AutenticacaoService {
    private static final String usuario= "certo";
    private static final String senha= "certo";
        
    public boolean autenticar(AutenticacaoDTO dto ) {
        String user = dto.getUsuario();
        String senha = dto.getSenha();
        
       return this.usuario.equals(user) && 
               this.senha.equals(senha);
    }
}