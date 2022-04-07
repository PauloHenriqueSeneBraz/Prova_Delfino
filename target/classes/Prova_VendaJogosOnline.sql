drop database if exists Prova_VendaJogosOnline;

create database Prova_VendaJogosOnline;

use Prova_VendaJogosOnline;

create table genero (
gen_id tinyint unsigned auto_increment not null,
gen_nome varchar (100) not null,
primary key (gen_id),
unique key (gen_nome)
);

create table desenvolvedor (
dev_id tinyint unsigned auto_increment not null,
dev_nome varchar (100) not null,
primary key (dev_id)
);

create table jogo (
jog_id tinyint unsigned auto_increment not null,
jog_titulo varchar (100) not null,
jog_preco_unitario double not null,
jog_gen_id tinyint unsigned not null,
jog_dev_id tinyint unsigned not null,
primary key (jog_id),
foreign key (jog_gen_id) references genero (gen_id),
foreign key (jog_dev_id) references desenvolvedor (dev_id)
);

create table usuario (
usu_id tinyint unsigned auto_increment not null,
usu_nome varchar (100) not null,
usu_cpf varchar(100) not null,
usu_email varchar(100) not null,
usu_senha varchar(100) not null,
primary key (usu_id),
unique key (usu_cpf),
unique key (usu_email)
);

create table analise (
ana_id tinyint unsigned auto_increment not null,
ana_data date not null,
ana_titulo varchar(100) not null,
ana_descricao varchar(100) not null,
ana_situacao varchar(100) not null,
ana_usu_id tinyint unsigned not null,
ana_jog_id tinyint unsigned not null,
primary key (ana_id),
foreign key (ana_usu_id) references usuario (usu_id),
foreign key (ana_jog_id) references jogo (jog_id)
);

create table compra (
com_id tinyint unsigned auto_increment not null,
com_horario time not null,
com_preco_total double not null,
com_usu_id tinyint unsigned not null,
com_jog_id tinyint unsigned not null,
primary key (com_id),
foreign key (com_usu_id) references usuario (usu_id),
foreign key (com_jog_id) references jogo (jog_id)
);

/* inserindo dados tabela genero*/
insert genero (gen_nome) values ('Corrida');
insert genero (gen_nome) values ('Ação');
insert genero (gen_nome) values ('Mundo Aberto');

/* inserindo dados tabela desenvolvedor*/
insert desenvolvedor (dev_nome) values ('Rockstar Games');
insert desenvolvedor (dev_nome) values ('Ubisoft');

/* inserindo dados tabela jogo*/
insert jogo (jog_titulo, jog_preco_unitario, jog_gen_id, jog_dev_id) values ('Need For Speed', 100, 1, 1);
insert jogo (jog_titulo, jog_preco_unitario, jog_gen_id, jog_dev_id) values ('Assasins Creed', 200, 2, 2);
insert jogo (jog_titulo, jog_preco_unitario, jog_gen_id, jog_dev_id) values ('GTA', 300, 3, 1);

/* inserindo dados tabela usuario*/
insert usuario (usu_nome, usu_cpf, usu_email, usu_senha) values ('Lucas Zanon', '000000000', 'lucaszanon@gmail.com', '0000');
insert usuario (usu_nome, usu_cpf, usu_email, usu_senha) values ('Paulo Braz', '111111111', 'paulobraz@gmail.com', '1111');
insert usuario (usu_nome, usu_cpf, usu_email, usu_senha) values ('Renam Mello', '2222222222', 'renammello@gmail.com', '2222');

/* inserindo dados tabela analise*/
insert analise (ana_data, ana_titulo, ana_descricao, ana_situacao, ana_usu_id, ana_jog_id) values ('2022-03-12', 'Jogo', 'Jogo de Ação', 'Aprovado', 1, 2);

/* inserindo dados tabela compra*/
insert compra (com_horario, com_preco_total, com_usu_id, com_jog_id) values ('12:00', 200, 1, 2 );