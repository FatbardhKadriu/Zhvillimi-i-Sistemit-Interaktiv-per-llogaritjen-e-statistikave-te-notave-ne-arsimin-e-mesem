drop database if exists knk;

create database knk;

use knk;

create table profesori(
pid integer,
pname varchar(20),
psurname varchar(20),
pdate date ,
primary key(pid));

create table palidhje(
nr int primary key);

create table prova(
dd int primary key
);

create table palidhje1(
ad integer primary key
);
