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
```js
src/
└── main/
    ├── java/
    │   └── com/
    │       └── exemplo/
    │           └── apirest/
    │               ├── ApiRestApplication.java   -> Usado unicamente para definir um nome da API
    │               │   
    │               ├── controllers/              -> Usado para criação dos cabeçalhos de serviços ou requisições
    │               │   └── ExemploController.java
    │               │   
    │               ├── service/                  -> Regras de negócio (Implementação de serviço)
    │               │   └── ExemploService.java
    │               │   
    │               ├── repository/               -> Interfaces JPA ou acesso ao banco de dados
    │               │   │
    │               │   ├─── custom/              -> Pasta Onde definimos as interfaces para implementar o banco de dados.
    │               │   │     └── ExemploRepositoryCustom.java 
    │               │   │
    │               │   ├──  impl/                 -> Pasta onde de fato vamos implementar os sql para acessar o banco de dados.
    │               │   │     └── ExemploRepositoryImpl.java 
    │               │   │
    │               │   └── ExemploRepository.java -> Classe onde definimos as anotações que representam o banco de dados.
    │               │        
    │               ├── model/                    -> Entidades (JPA) ou modelos de banco de dados, tabelas
    │               │   └── ExemploModel.java
    │               │   
    │               ├── dto/                      -> Objetos de transferência de dados (entrada/saída) usado chamadas do front-end
    │               │   └── ExemploDTO.java
    │               │   
    │               └── vo/                       -> Objetos de transferência de dados somente dentro da própria API.
    │                   └── ExemploVO.java
    └── resources/
        └── application.properties               -> Objeto chave valor para variáveis de inicialização de projeto

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



# CASO DER ERRO AO SE CONECTAR NO BANCO DE DADOS

PRIMEIROS PASSO
```
  1 - COPIAR O ARQUIVO driver_banco_dados/mssql-jdbc_auth-12.10.0.x64.dll para a pasta C:\drivers\sqljdbc
  
  2 - COM O BOTÃO DIRETO DO MAUSE, CLIQUE EM CIMA DO PROJETO PRINCIPAL NO NETBEANS, VA EM PROPRIEDADES > RUN > VM OPTIONS > E ADICIONE ESSA LINHA
        -Djava.library.path=C:\\drivers\\sqljdbc

  3 - NAVEGE ATE A PASTA C:\Windows\SysWOW64\SQLServerManager16.msc

  4 - Ao abrir o programa va em "Configuração de Rede do SQL Server" > "Protocoloes para MSSQLSERVER" >  e HABILITE O TCP/IP

```




# BANCO DE DADOS CHAMADA EM JAVA
  1 - ADICIONE ESSES PROJETOS DENTRO DE dependencies DO ARQUIVO POM.XML
```js
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
```
  2 - CRIE AS PASTAS REPOSITORY, E DENTRO DESSA PASTA CRIE AINDA AS PASTAS CUSTOM, IMPL

  3 - DENTRO DA PASTA RESOURCES NO ARQUIVO APPLICATION.PROPERTIES ADICIONE AS LINHAS ABAIXO:
```java
      # Configurações de conexão com o banco de dados
      #spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=BANCO_DADOS
      #spring.datasource.username=username
      #spring.datasource.password=password
      #spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver


      spring.aot.enabled=false


```

USO


```JAVA

public interface UsuarioRepositoryCustom {
     public boolean inserirUsuario(UsuarioDTO usuarioDTO);
}

```

```JAVA

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>, UsuarioRepositoryCustom{
    
}

```



```JAVA
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    
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
}

```

# BANCO DE DADOS TABELA
```SQL
CREATE TABLE TB_USUARIO (
    id INT IDENTITY(1,1) PRIMARY KEY,
    TX_NOME VARCHAR(100),
    TX_SENHA VARCHAR(100)
);

```