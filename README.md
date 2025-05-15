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
# ESTRUTURA DO PROJETO BACK-END JAVA SPRING BOOT
![Texto Alternativo](img.png)



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


# BANCO DE DADOS

PRIMEIROS PASSO
```
  1 - COPIAR O ARQUIVO driver_banco_dados/mssql-jdbc_auth-12.10.0.x64.dll para a pasta C:\drivers\sqljdbc
  
  2 - COM O BOTÃO DIRETO DO MAUSE, CLIQUE EM CIMA DO PROJETO PRINCIPAL NO NETBEANS, VA EM PROPRIEDADES > RUN > VM OPTIONS > E ADICIONE ESSA LINHA
        -Djava.library.path=C:\\drivers\\sqljdbc

  3 - ADICIONE ESSES PROJETOS DENTRO DE dependencies DO ARQUIVO POM.XML

              <dependency>
                    <groupId>jakarta.persistence</groupId>
                    <artifactId>jakarta.persistence-api</artifactId>
                    <version>3.1.0</version>
                </dependency>
                
                <dependency>
                    <groupId>com.microsoft.sqlserver</groupId>
                    <artifactId>mssql-jdbc</artifactId>
                    <version>12.10.0.jre11</version>
                    <scope>compile</scope>
                </dependency>            

                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-data-jpa</artifactId>
                </dependency>

  4 - CRIE AS PASTAS REPOSITORY, E DENTRO DESSA PASTA CRIE AINDA AS PASTAS CUSTOM, IMPL

```

USO

```JAVA

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>, UsuarioCustom{
    
}
```

```JAVA
public interface UsuarioCustom {
     public boolean inserirUsuario(UsuarioDTO usuarioDTO);
}
```


```JAVA
@Override
@Transactional
public boolean inserirUsuario(UsuarioDTO usuarioDTO){
      String sql = "INSERT INTO TB_USUARIO(TX_NOME, TX_SENHA) VALUES ";
      sql += "(:nome, :senha);";
      
      
    Query query = entityManager.createNativeQuery(sql);
    query.setParameter("nome",usuarioDTO.getNome());
    query.setParameter("senha",usuarioDTO.getSenha());
    
    query.executeUpdate();
              
    return true;
      
}

```