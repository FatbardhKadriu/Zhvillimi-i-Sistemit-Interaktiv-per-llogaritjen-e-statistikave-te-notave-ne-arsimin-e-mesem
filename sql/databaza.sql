drop database if exists knk;

create database knk;

use knk;

create table prof(
pid integer,
pname varchar(20),
psurname varchar(20),
pdate date ,
primary key(pid));
