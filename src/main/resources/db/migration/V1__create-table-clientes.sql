CREATE TABLE clientes(

    clienteID bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20) not null,
    cpf varchar(14) not null unique,

    primary key(clienteID)
);