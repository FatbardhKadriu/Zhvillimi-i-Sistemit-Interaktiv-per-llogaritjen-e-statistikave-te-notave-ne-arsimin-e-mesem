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

insert into city values('1', 'Prishtine', 'Kosove', '10000');

select * from student;

#Tabela per adresat e banimit
CREATE TABLE Address
( 
	addressID VARCHAR(255),
	cityID VARCHAR(255),
	street VARCHAR(255),
	PRIMARY KEY (addressID),
	FOREIGN KEY (cityID) REFERENCES City(cityID) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into Address values('1', '1', 'Skenderbeu');


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

#Tabela per studentet (nxenesit)
CREATE TABLE Student
(
	studentID VARCHAR(255) not null,
    studentName VARCHAR(255) not null,
    studentSurname VARCHAR(255) not null,
    gender CHAR(1) not null,
    phoneNumber VARCHAR(255) not null,
    email VARCHAR(255) not null,
    classRoomNumber VARCHAR(255) not null,
    addressID VARCHAR(255) not null,
    birthDate varchar(255) not null,
    age INTEGER not null,
    PRIMARY KEY(studentID),
    FOREIGN KEY(classRoomNumber) REFERENCES ClassRoom(classRoomNumber) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(addressID) REFERENCES Address(addressID) ON DELETE CASCADE ON UPDATE CASCADE
);


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
	PRIMARY KEY(periodID, studentID, subjectID),
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


#Tabela per statistikat e pergjithshme te seciles klase.
CREATE TABLE overallSucessClass
(
	classRoomNumber VARCHAR(255),
	totalExcellentNumber INTEGER,
    totalExcellentPercentage REAL,
    totalExceedsAcceptableNumber INTEGER,
    totalExceedsAcceptablePercentage REAL,
    totalAcceptableNumber INTEGER,
    totalAcceptablePercentage REAL,
    totalBelowAcceptableNumber INTEGER,
    totalBelowAcceptablePercentage REAL,
    totalPositiveResultNumber INTEGER,
    totalPositiveResultPercetange REAL,
    totalFailingNumber INTEGER,
    totalFailingPercentage REAL,
    totalUnGradedNumber INTEGER,
    totalUnGradedPercentage REAL,
    totalGPA REAL,
    PRIMARY KEY(classRoomNumber),
    FOREIGN KEY(classRoomNumber) REFERENCES ClassRoom(classRoomNumber) ON DELETE CASCADE ON UPDATE CASCADE
);


#Tabela per llogaritjen e statistikave te pergjithshme te studenteve.
CREATE TABLE overallSucessStudents
(
	classRoomNumber VARCHAR(255),
    positiveResultNumber INTEGER,
    positiveResultPercetange REAL,
    negativeResultNumber INTEGER,
    negativeResultPercetange REAL,
    authorisedTotal INTEGER,
    unAuthorisedTotal INTEGER,
    PRIMARY KEY(classRoomNumber),
    FOREIGN KEY(classRoomNumber) REFERENCES ClassRoom(classRoomNumber) ON DELETE CASCADE ON UPDATE CASCADE
);

#Tabela per te dhenat e administratoreve.
CREATE TABLE Administrator
(
	administratorID VARCHAR(20),
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY(administratorID));

INSERT INTO Administrator VALUES 
('1','admin','admin@gmail.com','admin'),
('2','bardhi','bardhi','bardhi');


INSERT INTO Subjects VALUES
('1000', 'Gjuhe Shqipe'),
('1001', 'Gjuhe Angleze'),
('1002', 'Gjuhe Gjermane'),
('1003', 'Art Muzikor'),
('1004', 'Art Figurativ'),
('1005', 'Matematike'),
('1006', 'Biologji'),
('1007', 'Fizike'),
('1008', 'Kimi'),
('1009', 'Gjeografi'),
('1010', 'Histori'),
('1011', 'Edukate Fizike'),
('1012', 'TIK'),
('1013', 'Kultura dhe Shoqeria'),
('1014', 'Ekologji');


INSERT INTO ClassRoom VALUES
('101'),
('102'),
('103'),
('104'),
('105'),
('106');


INSERT INTO City VALUES
('2000', 'Prishitne', 'Kosove', '10000'),
('2001', 'Kline', 'Kosove', '32000'),
('2002', 'Drenas', 'Kosove', '11000'),
('2003', 'Istog', 'Kosove', '12000'),
('2004', 'Gjakove', 'Kosove', '50000');


INSERT INTO gradeDescription VALUES
('5', 'Shkelqyeshem'),
('4', 'Shume mire'),
('3', 'Mire'),
('2', 'Mjaftueshem'),
('1', 'dobet');

DROP VIEW finalPeriodMark;

CREATE VIEW finalPeriodMark AS 
SELECT studentID, subjectID, SUM(finalPeriodMark) / 3 AS 'finalPeriodMark'
FROM Grades 
GROUP BY studentID;

select * from finalPeriodMark;