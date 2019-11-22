create table CATEGORIAS (
    idCategoria INT NOT NULL PRIMARY KEY,
    categoria varchar(100) not null
);

create table CLIENTES (
    idCliente int NOT NULL PRIMARY KEY,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(10) not null,
    rua varchar(100) not null,
    cidade varchar(50) not null,
    bairro varchar(50) not null,
    cep varchar(9) not null,
    estado varchar(2) not null
);

CREATE TABLE PRODUTOS (
    idProduto int NOT NULL PRIMARY KEY,
    FOREIGN KEY (idCategoria) REFERENCES CATEGORIAS
    produto varchar(100) not null,
    preco decimal(8,2) not null,
    quantidade int DEFAULT 0 NULL,
    descricao varchar(100) DEFAULT '' NULL,
    foto blob null
);

create table PEDIDOS (
    idPedido int NOT NULL PRIMARY KEY,
    FOREIGN KEY (idCliente) REFERENCES CLIENTES,
    data DATE NULL,
    status boolean,
    sessao varchar(50) null
);

create table PEDIDOITENS (
    idItem int NOT NULL PRIMARY KEY,
    idProduto int NOT NULL,
    idPedido int NOT NULL,
    nmProduto varchar(100) not null,
    quantidade int DEFAULT 0 NULL,
    valor decimal(8,2) not null,
    subtotal decimal(8,2) not null
);

ALTER TABLE PEDIDOITENS
ADD FOREIGN KEY (fk_idProduto) 
REFERENCES PRODUTOS(idProduto);

ALTER TABLE PEDIDOITENS
ADD FOREIGN KEY (fk_idPedido) 
REFERENCES PEDIDOS(idPedido);






