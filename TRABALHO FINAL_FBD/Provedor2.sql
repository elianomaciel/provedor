CREATE TABLE cliente(
	id_cliente serial,
	cpf integer,
	nome varchar(50),
	rua varchar(50),
	numero integer,
	bairro varchar(50),
	cidade varchar(50),
	cep integer,
	telefone varchar(30),
	CONSTRAINT cliente_pkey PRIMARY KEY(id_cliente)
	);
	
CREATE TABLE pacote (
    id_pacote serial,
    tipo varchar(50),
    plano varchar(50),
    CONSTRAINT pacote_pkey PRIMARY KEY (id_pacote)
	);
	
CREATE TABLE financeiro (
    id_cliente integer,
    id_pacote integer,
    vencimento date,
    valor real,
    CONSTRAINT finaceiro_pkey PRIMARY KEY (id_cliente, id_pacote),
    CONSTRAINT financeiro_id_pacote_fkey FOREIGN KEY (id_pacote)
        REFERENCES pacote (id_pacote)
	);
	
select c.nome, p.tipo from financeiro f, cliente c, pacote p
where c.id_cliente = p.id_pacote

SELECT * FROM cliente
