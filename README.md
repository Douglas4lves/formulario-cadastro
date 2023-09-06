<h1 align="center">
  Formulário
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=LinkedIn&message=https://www.linkedin.com/in/douglas-alves-7a55b0210/&color=black&labelColor=red" alt="@DouglasAlves" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=black&labelColor=red" alt="Desafio" />
</p>

API baseada em um formulario simples de cadastro
## Requisitos
- Cadastrar dados
- Retornar um E-mail confirmando que os dados foram registrados
- CPF deve ser válido e único 

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)
- [Java](https://www.oracle.com/java/technologies/)

## Práticas adotadas

- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3
- Envio de E-mail com SMTP do GMAIL

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/validation-form-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080) utilizando [Postman](https://www.postman.com/downloads/).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) diretamente no browser.

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/downloads/):

- Salvar Dados
```
Metodo Post
URL:
$ 127.0.0.1:8080/cadastro
body:
{
    "name": "Rodrigo Goes",
    "email": "Rodrigo@gmail.com",
    "cpf": "04727095009",
    "contact": "37999552626",
}

[
  {
    "id": 0,
    "name": "Rodrigo Goes",
    "email": "Rodrigo@gmail.com",
    "cpf": "04727095009",
    "contact": "37999552626",
    "creation_date": "2023-09-06T00:58:10.352Z"
  }
]
```

- Listar Dados 
```
metodo GET
URL:
$ 127.0.0.1:8080/cadastro

[
  {
    "id": 0,
    "name": "Rodrigo Goes",
    "email": "Rodrigo@gmail.com",
    "cpf": "04727095009",
    "contact": "37999552626",
    "creation_date": "2023-09-06T00:58:10.352Z"
  }
]
```

- Deletar
```
metodo DELETE / removendo usuario com CPF 04727095009
URL:
127.0.0.1:8080/cadastro/04727095009
return
{
    "Cadastro deletado"
}

[ ]