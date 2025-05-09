# COMO CRIAR O PROJETO BACK-END
```
SITE: https://start.spring.io/

Project: Maven

Language: Java

Spring Boot: 3.2+

Group: com.exemplo

Artifact: apirest

Dependencies:
  -> Spring Web
  -> Spring Boot DevTools
```


# EXEMPLO DE CHAMADA DE REQUISIÇÃO EM JAVASCRIPT

```js
 const dados = {
      usuario: "seuUsuario",
      senha: "suaSenha"
    };

    fetch("http://localhost:8080/autenticar/usuario", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(dados)
    })
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro na requisição: ${response.status}`);
        }
        return response.json(); // ou .text() dependendo do retorno da API
      })
      .then(data => {
        console.log("Resposta da API:", data);
      })
      .catch(error => {
        console.error("Erro ao fazer a requisição:", error);
      });

```
# EXEMPLO DE SERVIÇO EM JAVA SPRING BOOT

```java
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

```


# ESTRUTURA DO PROJETO BACK-END JAVA SPRING BOOT
![Texto Alternativo](img.png)
