--Database--
Create DATABASE usecaseDB;
use usecaseDB;

--Tables--
CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY IDENTITY(1,1),
    Name VARCHAR(255)
);

CREATE TABLE Products (
    ProductID INT PRIMARY KEY IDENTITY(1,1),
    Name VARCHAR(255),
    Description TEXT,
    Price DECIMAL(10, 2),
    CategoryID INT,
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY IDENTITY(1,1),
    Name VARCHAR(255),
    Email VARCHAR(255),
    Address VARCHAR(255)
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT,
    OrderDate DATETIME,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


CREATE TABLE Cart (
    CartID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);



--Constraints
ALTER TABLE CUSTOMER ADD CONSTRAINT chk_email CHECK(Email LIKE '%@%.%')

--Keys, Referential Integrity and CASCADE--
CREATE TABLE CartItems (
    CartItemID INT PRIMARY KEY IDENTITY(1,1),
    CartID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (CartID) REFERENCES Cart(CartID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE OrderItems (
    OrderItemID INT PRIMARY KEY IDENTITY(1,1),
    OrderID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);


/*
FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) ON DELETE SET NULL
FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) ON DELETE SET DEFAULT
FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) ON DELETE NO ACTION
*/

--Indexing--
CREATE INDEX idx_customer_name ON Customers (Name);

--Triggers--

CREATE TABLE OrderHistory (
    OrderID INT,
    CustomerID INT,
    DeletedAt DATETIME DEFAULT GETDATE()
);


CREATE TRIGGER trg_AfterDelete ON Orders
AFTER DELETE
AS
BEGIN
    INSERT INTO OrderHistory (OrderID, CustomerID, DeletedAt)
    SELECT OrderID, CustomerID, GETDATE() FROM deleted;
END;