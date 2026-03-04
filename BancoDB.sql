CREATE DATABASE IF NOT EXISTS Banco;
USE Banco;

CREATE TABLE IF NOT EXISTS empleados (
    id BIGINT NOT NULL AUTO_INCREMENT, 
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    salario DOUBLE NOT NULL,
    estatus VARCHAR(10) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_email (email)
);