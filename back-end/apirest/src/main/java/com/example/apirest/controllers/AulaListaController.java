/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.apirest.controllers;

import com.example.apirest.dto.AulaDTO;
import com.example.apirest.service.AulaListaService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Definiu que a classe AulaLista seja uma requisição
@RequestMapping("/servico") //define a requisição tenha o nome pagina servico
@CrossOrigin(origins = "*") //define a segura da aplicação
public class AulaListaController {

    
    //Define que o tipo da requisição seja um GET
    //Define o nome do servico
    @GetMapping("/nome") 
    
    // criação de metodo dados que retorna a referencia de AulaDTO
    // LIST< OBJETO > define uma coleção de objetos.
    public List<AulaDTO> dados() {     
        return new AulaListaService().getDados();
    }
}
