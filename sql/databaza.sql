drop database if exists knk;

create database knk;

use knk;

create table prof(
pid integer,
pname varchar(20),
psurname varchar(20),
pdate date ,
primary key(pid));

create table studenti(
sid integer,
sname varchar(20),
ssurname varchar(20),
sdate date ,
primary key(sid));

