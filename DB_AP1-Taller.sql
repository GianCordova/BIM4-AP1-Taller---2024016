drop database if exists ap1_taller_2024016;
create database ap1_taller_2024016;
use ap1_taller_2024016;
 
create table Pacientes(
	idPaciente integer auto_increment,
    nombre varchar (64),
    apellido varchar (64),
    fechadeNacimiento varchar(64),
    telefono varchar (16),
    constraint pk_cliente primary key (idPaciente)
);
 
 
insert into Pacientes (nombre, apellido, fechadeNacimiento, telefono)
values
('Carlos', 'Ramírez', '2001-02-26', '5551-2345'),
('Ana', 'González', '1999-08-19', '5551-6789'),
('Luis', 'Mendoza', '2002-06-01', '5552-9876');
 
select * from Pacientes;