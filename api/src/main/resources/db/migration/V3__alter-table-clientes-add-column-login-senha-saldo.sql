alter table clientes add login varchar(15) not null;
alter table clientes add senha varchar(15) not null;
alter table clientes add saldo DECIMAL(10,2) default 0 not null;
