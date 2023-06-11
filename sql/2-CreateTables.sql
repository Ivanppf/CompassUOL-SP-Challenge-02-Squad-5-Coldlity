-- ETAPA 2: CREATE TABLES
-- ETAPA 2.1: CREATE TABLE Customers
CREATE TABLE Customers (
 	customerId 		SERIAL 			PRIMARY KEY,
	name 			VARCHAR(50) 	NOT NULL,
	cpf 			VARCHAR(14) 	UNIQUE NOT NULL,
	email 			VARCHAR(100) 	UNIQUE NOT NULL,
	active 			BOOLEAN			NOT NULL,

	CONSTRAINT chk_name_length CHECK (LENGTH(name) >= 3),
);



-- ETAPA 2.2: CREATE TABLE Products
CREATE TABLE Products (
 	productId 		SERIAL 			PRIMARY KEY,
	name 			VARCHAR(50) 	NOT NULL,
	price 			FLOAT 			NOT NULL,
	description 	VARCHAR(100) 	NOT NULL,			

	CONSTRAINT chk_name_length 			CHECK (LENGTH(name) >= 3),
  	CONSTRAINT chk_description_length 	CHECK (LENGTH(description) >= 3)
);



-- ETAPA 2.3: CREATE TABLE Orders
CREATE TYPE statusOptions AS ENUM ('CREATED', 'CONFIRMED');

CREATE TABLE Orders (
 	orderId 		SERIAL 			PRIMARY KEY,
	customerId 		INT	 			NOT NULL,
	orderDate 		DATE 			NOT NULL,
	status 			statusOptions	NOT NULL,			

	CONSTRAINT fk_customer FOREIGN KEY (customerId) REFERENCES Customers (customerId),
	CONSTRAINT chk_status CHECK (status IN ('CREATED', 'CONFIRMED'))
);



-- ETAPA 2.4: CREATE TABLE Payments
CREATE TYPE paymentsOptions AS ENUM ('CREDIT_CARD', 'DEBIT_CARD', 'TRANSFER', 'PIX', 'CASH');

CREATE TABLE Payments (
 	paymentId 		SERIAL 			PRIMARY KEY,
	paymentMethod 	paymentsOptions	NOT NULL,	
	paymentDate 	DATE 			NOT NULL,
	orderId			INT 			NOT NULL,
	
	CONSTRAINT fk_order FOREIGN KEY (orderId) REFERENCES Orders (orderId),
	CONSTRAINT chk_status CHECK (paymentMethod IN ('CREDIT_CARD', 'DEBIT_CARD', 'TRANSFER', 'PIX', 'CASH'))
);