create table professores(

    id bigint not null auto_increment,
    matricula varchar(100) not null,
    nome varchar(100) not null,
    disciplina varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar (20) not null,

    primary key (id)

)