CREATE SCHEMA ole AUTHORIZATION dbo;

CREATE TABLE ole.EmpUser (
    EmployeeID INT PRIMARY KEY,
    FirstName NVARCHAR(10),
    LastName NVARCHAR(10),
    UserName NVARCHAR(20),
    Email NVARCHAR(50),
    Phone NVARCHAR(10),
    DeptCode char(3),
    Store varchar(3),
    UserRole varchar(5),
    EntDate datetime DEFAULT getdate(),
);

drop table ole.EmpUser

SELECT * from dbo.UserMaster um

SELECT MAX(LEN(Address)) AS MaxLength,Address
FROM MASTER m group by Address order by MaxLength desc;

select * from dbo.MASTER m where Bs_Code in (SELECT Bs_Code  from dbo.BSMST b where head like '%Deb%')

SELECT Bs_Code  from dbo.BSMST b where head like '%Deb%'

CREATE TABLE ole.Buyer (
    BsId varchar(7) PRIMARY KEY NOT NULL,
    BsName varchar(60),  -- Adjust the length as needed
    Addr varchar(200),     -- Adjust the length as needed
    City varchar(20),
    PIN varchar(MAX),      -- Adjust the length as needed
    Country varchar(20),  -- Adjust the length as needed
    BsCode varchar(4),   -- Adjust the length as needed
    Mobile_ext varchar(3),
    Mobile varchar(20),   -- Adjust the length as needed
    Email varchar(50),    -- Adjust the length as needed
    PAN varchar(MAX),      -- Adjust the length as needed
    EntDate datetime,
);

select * from dbo.OrderRequest or2 where S_No='0006077'


