# Shop API
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Tiago-Fernandes-Avila/ShopAPI/blob/main/LICENSE)

## Sobre o projeto

A aplicação **Shop API** é um Web Service desenvolvido com **Spring Boot**, construída durante o curso **Java COMPLETO - Programação Orientada a Objetos + Projetos**, ministrado pelo professor Nelio Alves.

Este projeto possui um modelo de domínio com entidades relacionadas via **JPA**, além de endpoints REST para operações **CRUD**. Foram aplicados diversos padrões de projeto (Design Patterns), arquitetura **MVC**, uso de perfis com **Project Profiles**, e tratamento global de exceções com `@ControllerAdvice`, oferecendo mensagens de erro personalizadas nas respostas HTTP.

🔗 Curso: [Java COMPLETO Programação Orientada a Objetos + Projetos (Udemy)](https://www.udemy.com/course/java-curso-completo)

## Modelo Conceitual

![Modelo Conceitual](https://raw.githubusercontent.com/Tiago-Fernandes-Avila/Imagens/refs/heads/main/Modelo.png)

## Tecnologias utilizadas

### Back end

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- Maven
- Banco de dados H2 (para testes)

### Produção

- PostgreSQL

## Como executar o projeto

### Pré-requisitos

- Java 21 instalado

> **Observação:** Caso não tenha o banco PostgreSQL instalado, altere o perfil ativo para `test`, que utiliza o banco H2 em memória.

No arquivo `application.properties`:

```properties
spring.profiles.active=test

Se estiver utilizando PostgreSQL e ocorrer erro de conexão JDBC, verifique se a porta está correta. A porta padrão é 5432, mas no exemplo pode estar configurada como 5433.
No arquivo application-dev.properties:

```spring.datasource.url=jdbc:postgresql://localhost:5432/Shop_database```

```bash
# clonar repositório
git clone https://github.com/Tiago-Fernandes-Avila/ShopAPI

# entrar na pasta do projeto back end
cd ShopAPI

# executar o projeto
mac/linux:
./mvnw spring-boot:run

windows
mvnw.cmd spring-boot:run

```


# Autor

Tiago Fernandes Ávila

