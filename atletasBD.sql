CREATE DATABASE gerenciamento_atletas;
USE gerenciamento_atletas;
CREATE TABLE atleta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    esporte VARCHAR(100) NOT NULL,
    categoria ENUM('FEMININA','MASCULINA', 'NONE') NOT NULL DEFAULT 'NONE',
    profissional BOOLEAN NOT NULL,
    olimpiadas BOOLEAN NOT NULL,
    tipo_olimpico ENUM('OLYMPIC','PARALYMPIC','NONE') NOT NULL DEFAULT 'NONE'
);
