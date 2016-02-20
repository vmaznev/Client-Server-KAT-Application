CREATE DATABASE	KAT;
USE KAT;

CREATE TABLE Automobile(
	RegNum INT NOT NULL AUTO_INCREMENT,
	Make VARCHAR(30),
	Model VARCHAR(30),
	Type VARCHAR(30),
	Color VARCHAR(20),
	PRIMARY KEY(RegNum)
	);

CREATE TABLE Owners(
	OwnerID INT,
	FName VARCHAR(30),
	LName VARCHAR(30),
	Country VARCHAR(30),
	Address VARCHAR(100),
	RegNum INT,
	PRIMARY KEY(OwnerID),
	FOREIGN KEY(RegNum) REFERENCES Automobile(RegNum)
	);

CREATE TABLE Violations(
	ViolationID INT,
	Type VARCHAR(50),
	OwnerID INT,
	PRIMARY KEY(ViolationID),
	FOREIGN KEY(OwnerID) REFERENCES Owners(OwnerID)
	);

CREATE TABLE Fines(
	FineID INT,
	Type VARCHAR(50),
	ViolationID INT,
	PRIMARY KEY(FineID),
	FOREIGN KEY(ViolationID) REFERENCES Violations(ViolationID)
	);

INSERT INTO Automobile(Make, Model, Type, Color) VALUES
('Alfa Romeo', '166', '166 Serie 1', 'Brown'),
('Mercedes-Benz', '190 W201', '190 2.3-16 W201 Serie 1', 'Silver'),
('Suzuki', 'Cara (PG)', 'Cara Couple (PG)', 'Green'),
('Volvo', '780', '780', 'Black');

INSERT INTO Owners(OwnerID, FName, LName, Country, Address, RegNum) VALUES
('1', 'Harry', 'Potter', 'USA', 'CA', '3'),
('2', 'Lynda', 'Fox', 'USA', 'NY', '2'),
('3', 'Johnny', 'Depp', 'Bulgaria', 'SF', '4');

INSERT INTO Violations(ViolationID, Type, OwnerID) VALUES
('1', 'Speeding', '1'),
('2', 'Improper Passing', '1'),
('3', 'Reckless Driving', '3');

INSERT INTO Fines(FineID, Type, ViolationID) VALUES
('1', '700 Dollars', '1'),
('2', '900 Dollars', '2'),
('3', '500 Leva', '3');