CREATE DATABASE Projeto_Teste;
USE Projeto_Teste;

CREATE TABLE Cidadao(
id INT PRIMARY KEY AUTO_INCREMENT,
nome varchar(150) not null,
endereco varchar(150) not null,
dataNascimento varchar(10) not null,
email varchar(100) not null,
celular varchar(20) not null,
cpf varchar(14) not null unique,
associado_saude varchar(5) not null,
nomeVacina varchar(150) not null,
dosesTomadas varchar(10) not null,
dataVacinacao varchar(10) not null
);
DROP TABLE Cidadao;

CREATE TABLE Atendente(
id INT PRIMARY KEY AUTO_INCREMENT,
nome varchar(150) not null,
endereco varchar(150) not null,
dataNascimento varchar(10) not null,
email varchar(100) not null,
celular varchar(20) not null,
cpf varchar(14) not null,
login varchar(25) not null,
senha varchar(30) not null
);
DROP TABLE Atendente;

CREATE TABLE Adm(
id INT PRIMARY KEY AUTO_INCREMENT,
nome varchar(150) not null,
endereco varchar(150) not null,
dataNascimento varchar(10) not null,
email varchar(100) not null,
celular varchar(20) not null,
cpf varchar(14) not null,
login varchar(25) not null,
senha varchar(30) not null
);
DROP TABLE Adm;

INSERT INTO Adm (nome, endereco, dataNascimento, email, celular, cpf, login, senha)
VALUES('Guilherme Farias Menoci', 'Av testando', '28/04/2002', 'guimenoci@gmail.com', '(11)94152-4931', '512.410.684-07', 'guimenoci', '12345');

CREATE TABLE Vacina(
id int primary key auto_increment,
fornecedor varchar(150) not null,
nomeVacina varchar(150) not null,
quantidadeVacinas varchar(30) not null,
quantidadeDoses varchar(10) not null,
imunidade varchar(20) not null,
vacinaData varchar(10) not null,
vacinaHora varchar(6) not null,
validade varchar(10) not null
);
DROP TABLE Vacina;

CREATE TABLE Relatorio(
id int primary key auto_increment,
fk_id int,
nome varchar(150),
email varchar(150),
celular varchar(150),
foreign key(fk_id) references Cidadao(id)
);
DROP TABLE Relatorio;

select * from Cidadao;
select * from Vacina;
select * from Adm;