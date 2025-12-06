CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

CREATE TABLE usuarios(
    id DOUBLE PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE productos(
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DOUBLE
);

CREATE TABLE pedidos(
    id DOUBLE PRIMARY KEY,
    usuario_id DOUBLE,
    estado VARCHAR(50)
);

CREATE TABLE items(
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id DOUBLE,
    producto_id INT,
    cantidad INT
);
