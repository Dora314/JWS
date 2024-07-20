-- Tạo cơ sở dữ liệu
CREATE DATABASE JewelryStoreManagement;

-- Sử dụng cơ sở dữ liệu
USE JewelryStoreManagement;

-- Tạo bảng Loại Sản phẩm (Product Type)
CREATE TABLE ProductCategory (
    CategoryID INT PRIMARY KEY AUTO_INCREMENT,
    CategoryName VARCHAR(255) NOT NULL
);

-- Tạo bảng Sản phẩm (Product)
CREATE TABLE Product (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(255) NOT NULL,
    CategoryID INT,
    Weight DECIMAL(10,2) NOT NULL,
    Material VARCHAR(255) NOT NULL,
    MakingFee DECIMAL(10,2) NOT NULL,
    GemstonePrice DECIMAL(10,2) DEFAULT 0,
    CostPrice DECIMAL(10,2) NOT NULL,
    MarkupRatio DECIMAL(5,2) NOT NULL,
    Image VARCHAR(255),
    Status TINYINT DEFAULT 1,
    FOREIGN KEY (CategoryID) REFERENCES ProductCategory(CategoryID)
);

-- Tạo bảng Khách hàng (Customer)
CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(255) NOT NULL,
    Phone VARCHAR(20),
    Address VARCHAR(255),
    Email VARCHAR(255),
    LoyaltyPoint INT DEFAULT 0
);

-- Tạo bảng Quầy hàng (Stall)
CREATE TABLE Stall (
    StallID INT PRIMARY KEY AUTO_INCREMENT,
    StallName VARCHAR(255) NOT NULL,
    Location VARCHAR(255)
);

-- Tạo bảng Nhân viên (Employee)
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    EmployeeName VARCHAR(255) NOT NULL,
    Phone VARCHAR(20),
    Address VARCHAR(255),
    Position VARCHAR(255) NOT NULL,
    Salary DECIMAL(10,2) NOT NULL,
    StallID INT,
    FOREIGN KEY (StallID) REFERENCES Stall(StallID)
);

-- Tạo bảng Hóa đơn bán hàng (Sales Invoice)
CREATE TABLE SalesInvoice (
    SalesInvoiceID INT PRIMARY KEY AUTO_INCREMENT,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    CustomerID INT,
    EmployeeID INT,
    StallID INT,
    TotalAmount DECIMAL(10,2) NOT NULL,
    Discount DECIMAL(10,2) DEFAULT 0,
    PaymentMethod VARCHAR(255) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
    FOREIGN KEY (StallID) REFERENCES Stall(StallID)
);

-- Tạo bảng Chi tiết hóa đơn bán hàng (Sales Invoice Detail)
CREATE TABLE SalesInvoiceDetail (
    SalesInvoiceID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (SalesInvoiceID, ProductID),
    FOREIGN KEY (SalesInvoiceID) REFERENCES SalesInvoice(SalesInvoiceID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

-- Tạo bảng Hóa đơn mua lại (Buyback Invoice)
CREATE TABLE BuybackInvoice (
    BuybackInvoiceID INT PRIMARY KEY AUTO_INCREMENT,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    CustomerID INT,
    EmployeeID INT,
    StallID INT,
    TotalAmount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
    FOREIGN KEY (StallID) REFERENCES Stall(StallID)
);

-- Tạo bảng Chi tiết hóa đơn mua lại (Buyback Invoice Detail)
CREATE TABLE BuybackInvoiceDetail (
    BuybackInvoiceID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (BuybackInvoiceID, ProductID),
    FOREIGN KEY (BuybackInvoiceID) REFERENCES BuybackInvoice(BuybackInvoiceID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

-- Tạo bảng Khuyến mãi (Promotion)
CREATE TABLE Promotion (
    PromotionID INT PRIMARY KEY AUTO_INCREMENT,
    PromotionName VARCHAR(255) NOT NULL,
    PromotionType VARCHAR(255) NOT NULL,
    ConditionPromotion VARCHAR(255),
    Value DECIMAL(10,2) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL
);

-- Tạo bảng Chính sách ưu đãi (Customer Policy)
CREATE TABLE CustomerPolicy (
    PolicyID INT PRIMARY KEY AUTO_INCREMENT,
    PolicyName VARCHAR(255) NOT NULL,
    CustomerType VARCHAR(255) NOT NULL,
    DiscountRate DECIMAL(5,2) NOT NULL
);

-- Tạo bảng Bảng giá vàng (Gold Price)
CREATE TABLE GoldPrice (
    UpdateDate DATE PRIMARY KEY,
    GoldPrice DECIMAL(10,2) NOT NULL
);

-- Tạo bảng Chính sách đổi trả (Return Policy)
CREATE TABLE ReturnPolicy (
    ReturnPolicyID INT PRIMARY KEY AUTO_INCREMENT,
    ConditionReturn TEXT NOT NULL,
    Duration INT NOT NULL
);

-- Tạo bảng Tồn kho (Inventory)
CREATE TABLE Inventory (
    StallID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    PRIMARY KEY (StallID, ProductID),
    FOREIGN KEY (StallID) REFERENCES Stall(StallID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);