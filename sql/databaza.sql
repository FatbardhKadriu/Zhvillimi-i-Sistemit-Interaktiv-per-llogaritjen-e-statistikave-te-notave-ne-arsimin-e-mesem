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


#Tabele per paraqitjen e notes perfundimtare te llogariture nga tre periodat (Nota vjetore).
 CREATE TABLE finalGrade
(	
	studentID VARCHAR(255),
    subjectID VARCHAR(255),
    finalGrade REAL,
    PRIMARY KEY(studentID, subjectID),
    FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(studentID) REFERENCES Student(studentID) ON DELETE CASCADE ON UPDATE CASCADE
);


#Tabela per te dhenat e mesimdheneseve.
CREATE TABLE Teacher
(
	teacherID VARCHAR(255),
	teacherName VARCHAR (20) NOT NULL,
	teacherSurname VARCHAR(20) NOT NULL,
	phoneNumber INTEGER,
	email VARCHAR(40),
    addressID VARCHAR(255),
	subjectID VARCHAR(50),
    PRIMARY KEY(teacherID),
	FOREIGN KEY(addressID) REFERENCES Address(addressID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE
);


#Tabela per te dhenat e vijueshmerise.
CREATE TABLE Attendance
(
    studentID VARCHAR(255),
	authorised INTEGER,
    unauthorised INTEGER,
    PRIMARY KEY(studentID),
	FOREIGN KEY(studentID) REFERENCES Student(studentID) ON DELETE CASCADE ON UPDATE CASCADE
);


#Krijimi i tabeles me mundesi pershkrimi per noten. P.s. 5 - Shkelqyeshem.
CREATE TABLE gradeDescription 
(
	gradeID VARCHAR(255),
	descriptionGrade VARCHAR(255),
    PRIMARY KEY(gradeID)
);


#Krijimi i tabeles per llogaritjen e notes mesatare te secilit student.
CREATE TABLE StudentsGPA 
(
	studentID VARCHAR(255),
    excellentNumber INTEGER,
    exceedsAcceptableNumber INTEGER,
    acceptableNumber INTEGER,
    belowAcceptableNumber INTEGER,
    failingNumber INTEGER,
    unGradedNumber INTEGER,
    GPA REAL,
    gradeID VARCHAR(255),
    PRIMARY KEY(studentID),
	FOREIGN KEY(studentID) REFERENCES Student(studentID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(gradeID) REFERENCES gradeDescription(gradeID) ON DELETE CASCADE ON UPDATE CASCADE
);


#Tabela per statistikat e pergjithshme per secilen lende.
CREATE TABLE overallSucessSubjects
(
	subjectID VARCHAR(255),
    excellentNumber INTEGER,
    excellentPercentage REAL,
    exceedsAcceptableNumber INTEGER,
    exceedsAcceptablePercentage REAL,
    acceptableNumber INTEGER,
    acceptablePercentage REAL,
    belowAcceptableNumber INTEGER,
    belowAcceptablePercentage REAL,
    positiveResultNumber INTEGER,
    positiveResultPercetange REAL,
    failingNumber INTEGER,
    failingPercentage REAL,
    unGradedNumber INTEGER,
    unGradedPercentage REAL,
    GPA REAL,
    PRIMARY KEY(subjectID),
    FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID)
);
