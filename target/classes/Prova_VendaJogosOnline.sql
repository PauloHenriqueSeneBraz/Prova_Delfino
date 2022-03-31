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


