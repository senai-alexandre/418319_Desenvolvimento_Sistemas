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



# Estrutura do Projeto

src/
 └── main/
     ├── java/
     │   └── com/
     │       └── exemplo/
     │           └── apirest/
     │               ├── ApiRestApplication.java   -> Usado unicamento para definir um nome da API
     |               |
     │               ├── controllers/    -> Usado para crição dos cabeçalhos de serviços ou requisições
     │               |   └── ExemploController.java
     |               |
     |               ├── service/        --> Regras de negócio (Implementação de serviço)
     │               |   └── ExemploService.java
     |               |  
     |               ├── repository/     --> Interfaces JPA ou acesso ao banco de dados
     |               |   └── ExemploRepository.java
     |               |  
     |               ├── model/          --> Entidades (JPA) ou modelos de banco de dados, tabelas
     |               |   └── ExemploModel.java
     |               |  
     |               ├── dto/            --> Objetos de transferência de dados (entrada/saída) usado para retornar dados para o front-end
     |               |   └── ExemploDTO.java
     |               |  
     |               ├── vo/            --> Objetos de transferência de dados somente dentro da propria API, passar por parâmetro   
     |               |   └── ExemploVO.java
     └── resources/
         └── application.properties     --> Objeto chave valor para variaveis de inicialização de projeto