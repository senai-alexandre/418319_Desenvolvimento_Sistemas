package com.example.apirest.service;

import com.example.apirest.dto.AulaDTO;
import java.util.ArrayList;
import java.util.List;

public class AulaListaService {
    
    public List<AulaDTO> getDados(){
        // Criação de uma lista vazia
        ArrayList<AulaDTO> lista = new ArrayList();
        
        for (int i = 0; i < 10; i++) {            
            // criação de um objeto
            AulaDTO aula = new AulaDTO();
            aula.setDescricao("descricao da aula:" + i);
            aula.setProfessor("alexandre:" + i);
            aula.setTitulo("desenvolvimento de sistema:" + i);
            
            //Adicionando o objeto a lista
            lista.add(aula);
        }
        
        return lista;
    }
}
