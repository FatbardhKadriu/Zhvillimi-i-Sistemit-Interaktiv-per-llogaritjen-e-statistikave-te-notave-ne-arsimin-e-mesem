DROP DATABASE IF EXISTS KNK;
CREATE DATABASE KNK;
USE KNK;


#Tabela per lendet mesimore
CREATE TABLE Subjects
(
	subjectID VARCHAR(255),
	subjectName VARCHAR(255), 
	PRIMARY KEY(subjectID)
); 


#Tabela per qytetet
CREATE TABLE City
(
	cityID VARCHAR(255),
	cityName VARCHAR(255),
	state VARCHAR(255),
	postalCode INTEGER,
    PRIMARY KEY(cityID)
);


#Tabela per adresat e banimit
CREATE TABLE Address
( 
	addressID VARCHAR(255),
	cityID VARCHAR(255),
	street VARCHAR(255),
	PRIMARY KEY (addressID),
	FOREIGN KEY (cityID) REFERENCES City(cityID) ON DELETE CASCADE ON UPDATE CASCADE
);


/*
	Tabela per paralelet ku zhvillohet mesimi. ID lexohet si ne vijim:
    Marrim shembull ID: 101 (10/1), 113 (11/3), 125 (12/5).
    Dy numrat e pare tregojne klasen ndersa i fundit tregon paralelen.
*/
CREATE TABLE ClassRoom 
(
	classRoomNumber VARCHAR(255),
	PRIMARY KEY(classRoomNumber)
);


#Tabela per te dhenat e prinderve te nxeneseve.
CREATE TABLE Parents
(
	parentID VARCHAR(255),
	parentName VARCHAR(15),
	parentSurname VARCHAR(15),
	parentEmail	VARCHAR(15),
	parentPhoneNumber INTEGER,
	parentJob VARCHAR(20),
	PRIMARY KEY(parentID)
);


#Tabela per studentet (nxenesit)
CREATE TABLE Student
(
	studentID VARCHAR(255),
    studentName VARCHAR(255),
    parentID VARCHAR(255),
    studentSurname VARCHAR(255),
    gender CHAR(1),
    phoneNumber VARCHAR(255),
    email VARCHAR(255),
    classRoomNumber VARCHAR(255),
    addressID VARCHAR(255),
    birthDate DATE,
    age INTEGER,
    PRIMARY KEY(studentID),
    FOREIGN KEY(parentID) REFERENCES Parents(parentID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(classRoomNumber) REFERENCES ClassRoom(classRoomNumber) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(addressID) REFERENCES Address(addressID) ON DELETE CASCADE ON UPDATE CASCADE
);


/*
	Tabela per notat ne nje periode te caktuare. 
    Vleresimi behet duke llogaritur noten ne dy pjese bazuar ne angazhimet e meposhtme. 
*/
CREATE TABLE Grades
(
	periodID VARCHAR(255),
	studentID VARCHAR(255),
	subjectID VARCHAR(255),
    commitment REAL,
    tasks REAL,
	essay REAL,
    debates REAL,
    projects REAL,
    tests REAL,
    quizzess REAL,
	portfolio REAL,
	markPart1 REAL,
    finalTest REAL,
	markPart2 REAL,
    finalPeriodMark REAL,
	PRIMARY KEY(periodID),
	FOREIGN KEY(studentID) REFERENCES Student(studentID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE
 );