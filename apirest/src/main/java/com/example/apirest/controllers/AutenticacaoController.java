package com.example.apirest.controllers;

import com.example.apirest.dto.AutenticacaoDTO;
import com.example.apirest.service.AutenticacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticar")
@CrossOrigin(origins = "*")
public class AutenticacaoController {
   
    @PostMapping("/usuario")
    public ResponseEntity<?> usuario(@RequestBody AutenticacaoDTO autenticacaoDTO) {
        AutenticacaoService service = new AutenticacaoService();
        Object resposta = service.autenticar(autenticacaoDTO);
        return ResponseEntity.ok(resposta);
    }
}