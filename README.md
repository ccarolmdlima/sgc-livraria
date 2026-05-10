# Sistema de Gestão Comercial para Pequenos Negócios (SGC): Livraria

Sistema de Gestão Comercial para Livraria.

## Tecnologias
- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT
- MySQL
- Maven

## Funcionalidades
- CRUD de clientes
- CRUD de produtos
- Registro de vendas
- Autenticação JWT
- API REST

## Endpoints

### Auth
POST /auth/login

### Clientes
GET /clientes
POST /clientes
PUT /clientes/{id}
DELETE /clientes/{id}

### Produtos
GET /produtos
POST /produtos
PUT /produtos/{id}
DELETE /produtos/{id}

## Como executar

1. Criar banco MySQL:
```sql
CREATE DATABASE ProjetoLivraria;
