CREATE DATABASE sgc_livraria;

USE sgc_livraria;

CREATE TABLE usuarios (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(50) UNIQUE NOT NULL,
 senha VARCHAR(255) NOT NULL,
 perfil VARCHAR(20) NOT NULL
);

CREATE TABLE clientes (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 cpf VARCHAR(14) UNIQUE NOT NULL,
 email VARCHAR(100),
 telefone VARCHAR(20),
 endereco VARCHAR(200)
);

CREATE TABLE produtos (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 nome VARCHAR(150) NOT NULL,
 descricao TEXT,
 preco DECIMAL(10,2) NOT NULL,
 estoque INT NOT NULL
);

CREATE TABLE vendas (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 data DATETIME,
 cliente_id BIGINT,
 usuario_id BIGINT,
 valor_total DECIMAL(10,2),

 FOREIGN KEY (cliente_id) REFERENCES clientes(id),
 FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE itens_venda (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 venda_id BIGINT,
 produto_id BIGINT,
 quantidade INT,
 preco_unitario DECIMAL(10,2),

 FOREIGN KEY (venda_id) REFERENCES vendas(id),
 FOREIGN KEY (produto_id) REFERENCES produtos(id)
);