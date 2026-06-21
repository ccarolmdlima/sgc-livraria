# Sistema de Gestão Comercial para Pequenos Negócios (SGC): Livraria

Sistema desenvolvido para gerenciamento de uma livraria, permitindo controle de clientes, produtos, vendas e usuários através de uma API REST integrada a uma interface gráfica Java Swing.

---

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* MySQL
* Maven
* Java Swing
* Git/GitHub

---

## Arquitetura

O projeto segue Arquitetura em Camadas:

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL
```

### Principais Entidades

* Cliente
* Produto
* Venda
* ItemVenda
* Usuario

---

## Funcionalidades

### Clientes

* Cadastrar cliente
* Listar clientes
* Atualizar cliente
* Excluir cliente

### Produtos

* Cadastrar produto
* Listar produtos
* Atualizar produto
* Excluir produto
* Controle de estoque

### Vendas

* Registrar venda
* Associar cliente à venda
* Associar produtos à venda
* Calcular valor total da venda

### Segurança

* Login de usuários
* Autenticação JWT

### Relatórios

* Relatório de clientes
* Relatório de produtos
* Consulta de vendas

---

## Estrutura do Projeto

```text
src/main/java

├── config
├── controller
├── service
├── repository
├── domain/model
├── dto
├── exception
├── util
├── client
└── view
```

---

## Endpoints da API

### Autenticação

```http
POST /auth/login
```

### Clientes

```http
GET    /clientes
POST   /clientes
PUT    /clientes/{id}
DELETE /clientes/{id}
```

### Produtos

```http
GET    /produtos
POST   /produtos
PUT    /produtos/{id}
DELETE /produtos/{id}
```

### Vendas

```http
GET    /vendas
GET    /vendas/{id}
POST   /vendas
```

### Usuários

```http
GET    /usuarios
POST   /usuarios
```

---

## Banco de Dados

Crie o banco MySQL:

```sql
CREATE DATABASE projetolivraria;
```

Configuração do `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projetolivraria
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8081
```

---

## Interface Swing

A aplicação possui interface gráfica desenvolvida em Java Swing contendo:

* Tela de Login
* Cadastro de Clientes
* Cadastro de Produtos
* Registro de Vendas
* Consulta de Vendas
* Relatórios

### Telas

* LoginFrame
* MainFrame
* ClientePanel
* ProdutoPanel
* VendaPanel
* RelatorioPanel

---

## Como Executar

### 1. Banco de Dados

Inicie o MySQL.

### 2. Backend

Execute:

```bash
ProjetoLivrariaApplication
```

O servidor iniciará em:

```text
http://localhost:8081
```

### 3. Interface Swing

Execute:

```bash
LoginFrame
```

Login padrão:

```text
Usuário: admin
Senha: 1234
```

---

## Testes

Os endpoints podem ser testados utilizando:

* Postman
* Swagger (quando configurado)

---

## Repositório

```text
https://github.com/SEU-USUARIO/ProjetoLivraria
```

---

## Desenvolvido para a disciplina de Desenvolvimento de Sistemas

Centro Universitário de Brasília – CEUB
Curso de Ciência da Computação
