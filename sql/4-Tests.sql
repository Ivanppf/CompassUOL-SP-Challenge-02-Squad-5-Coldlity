-- ETAPA 4: Testando Constraints etc
-- ETAPA 4.1: Tabela Customers
-- ETAPA 4.1.1: chk_name_length
INSERT INTO Customers (name, cpf, email, active)
VALUES ('J', '123.456.789-00', 'joao@example.com', true);

-- ETAPA 4.1.2: chk_cpf_length
INSERT INTO Customers (name, cpf, email, active)
VALUES ('João da Silva', '123', 'joao@example.com', true);

-- ETAPA 4.1.3: CPF unique
INSERT INTO Customers (name, cpf, email, active)
VALUES ('Maria Souza', '123.456.789-00', 'maria@example.com', true);

-- ETAPA 4.1.4: Email unique
INSERT INTO Customers (name, cpf, email, active)
VALUES ('Carlos Pereira', '987.654.321-00', 'joao@gmail.com', true);



-- ETAPA 4.2: Tabela Products
-- ETAPA 4.2.1: chk_name_length
INSERT INTO Products (name, price, description)
VALUES ('A', 19.99, 'Description of Product A');

-- ETAPA 4.2.2: chk_description_length
INSERT INTO Products (name, price, description)
VALUES ('Product B', 29.99, 'A');

-- ETAPA 4.2.3: Price NULL
INSERT INTO Products (name, price, description)
VALUES ('Product C', NULL, 'Description of Product C');

-- ETAPA 4.2.4: Description NULL
INSERT INTO Products (name, price, description)
VALUES ('Product D', 39.99, NULL);



-- ETAPA 4.3: Tabela Orders
-- ETAPA 4.3.1: status inválido
INSERT INTO Orders (customerId, orderDate, status)
VALUES (1, '2023-06-01', 'INVALID_STATUS');

-- ETAPA 4.3.2: customerId NULL
INSERT INTO Orders (customerId, orderDate, status)
VALUES (NULL, '2023-06-01', 'CREATED');

-- ETAPA 4.3.3: orderDate inválido
INSERT INTO Orders (customerId, orderDate, status)
VALUES (1, NULL, 'CREATED');

-- ETAPA 4.3.4: customerId inválido
INSERT INTO Orders (customerId, orderDate, status)
VALUES (9999, '2023-06-01', 'CREATED');



-- ETAPA 4.4: Tabela Orders
-- ETAPA 4.4.1: paymentMethod inválido
INSERT INTO Payments (paymentMethod, paymentDate, orderId)
VALUES ('INVALID_METHOD', '2023-06-01', 1);

-- ETAPA 4.4.2: paymentMethod NULL
INSERT INTO Payments (paymentMethod, paymentDate, orderId)
VALUES (NULL, '2023-06-01', 1);

-- ETAPA 4.4.3: paymentDate NULL
INSERT INTO Payments (paymentMethod, paymentDate, orderId)
VALUES ('CREDIT_CARD', NULL, 1);

-- ETAPA 4.4.4: orderId inválido
INSERT INTO Payments (paymentMethod, paymentDate, orderId)
VALUES ('CREDIT_CARD', '2023-06-01', 9999);
