-- ETAPA 3: Inserindo alguns dados
-- ETAPA 3.1: Inserindo na tabela Customers
INSERT INTO Customers (name, cpf, email, active)
VALUES ('João', '123.456.789-00', 'joao@gmail.com', true);

INSERT INTO Customers (name, cpf, email, active)
VALUES ('Souza', '987.654.321-00', 'souza@gmail.com', true);



-- ETAPA 3.2: Inserindo na tabela Products
INSERT INTO Products (name, price, description)
VALUES ('Product A', 19.99, 'Description of Product A');

INSERT INTO Products (name, price, description)
VALUES ('Product B', 29.99, 'Description of Product B');



-- ETAPA 3.3: Inserindo na tabela Orders
INSERT INTO Orders (customerId, orderDate, status)
VALUES (1, '2023-06-01', 'CREATED');

INSERT INTO Orders (customerId, orderDate, status)
VALUES (2, '2023-06-02', 'CONFIRMED');



-- ETAPA 3.4: Inserindo na tabela Payments
INSERT INTO Payments (paymentMethod, paymentDate, orderId)
VALUES ('CREDIT_CARD', '2023-06-01', 1);

INSERT INTO Payments (paymentMethod, paymentDate, orderId)
VALUES ('TRANSFER', '2023-06-02', 2);
