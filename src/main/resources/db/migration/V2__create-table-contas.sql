CREATE TABLE contas(

    contaID bigint not null auto_increment,
    clienteID bigint not null,
    login varchar(20) not null unique,
    senha varchar(20) not null,
    saldo decimal(20,2) not null,

    primary key(contaID),
    foreign key(clienteID) REFERENCES clientes(clienteID)
);