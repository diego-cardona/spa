create table if not exists serviciospa (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 precio int(11) not null,
 primary key (id)
);