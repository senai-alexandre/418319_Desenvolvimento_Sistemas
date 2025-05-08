# rest

https://start.spring.io/


Project: Maven

Language: Java

Spring Boot: 3.2+

Group: com.exemplo

Artifact: apirest

Dependencies:

Spring Web

Spring Boot DevTools (opcional)



#Uso em HTML

const fetchPromise = fetch("http://localhost:8080/api/mensagem?texto=Ola", {
  method: "GET",
  mode: "cors",
  headers: {
    "Content-Type": "text/html;charset=UTF-8", 
    "Access-Control-Allow-Origin": "*"   
  }
});

fetchPromise.then((response) => {
  console.log(response.status);
});

#USO EM JAVA
package com.example.apirest.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ExemploController {

    @GetMapping("/mensagem")
    public String mensagem(@RequestParam String texto) {
        return "Mensagem recebida: " + texto;
    }
    
    @GetMapping("/mensagem2")
    public String mensagem2() {
        return "OLA SOU UMA MENSAGEM";
    }
}


# Estrutura do Projeto
<img src="img.png" >
