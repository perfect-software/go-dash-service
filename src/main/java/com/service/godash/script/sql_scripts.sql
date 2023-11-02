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



CREATE TABLE ole.emp_user (
    emp_id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(20),
    userpass NVARCHAR(20),
	email NVARCHAR(50),
    phone NVARCHAR(10),
    deptCode char(3),
    store varchar(3),
    userrole varchar(5),
    entDate datetime DEFAULT getdate(),
);

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

drop table ole.Buyer

CREATE TABLE ole.Buyer (
    bs_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	Code varchar(10),
	bs_name varchar(60),
	bs_abbreviation varchar(5),
    billing_addr varchar(300),
	delivery_addr varchar(300),
    city varchar(50),
    pincode varchar(50),
    country varchar(20),
	currency varchar(5),
    bs_code varchar(4),
    contact_person varchar(50),
	mobile_ext varchar(3),
    mobile varchar(50),
	phone varchar(50),
    email varchar(200),
	username varchar(20),
    entDate datetime DEFAULT getdate(),
);

select * from dbo.OrderRequest or2 where S_No='0006077'

select * from GPLTEST.dbo.MASTER  where Bs_Code in (select Bs_Code from GPLTEST.dbo.BSMST where Head like '%Debtors%')

INSERT INTO GPL.ole.Buyer (
    Code,
	bs_name,
    bs_abbreviation,
    billing_addr,
    delivery_addr,
    city,
    pincode,
    country,
    currency,
    bs_code,
    contact_person,
    mobile_ext,
    mobile,
    phone,
    email,
    username,
    entDate
)
SELECT
	Code,
    Name,
    NULL,
    Address,
    Address,
    City,
    PIN,
    NULL,
    Currency,
    Bs_Code,
    Contact_Person,
    NULL,
    Mobile,
    Phone,
    E_mail,
    User_Name,
    EntDate
FROM GPLTEST.dbo.master
WHERE Bs_Code IN (SELECT Bs_Code FROM GPLTEST.dbo.BSMST WHERE Head LIKE '%Debtors%')
ORDER BY EntDate Desc;

select * from ole.Buyer where billing_addr='  '

UPDATE ole.Buyer
SET
    bs_name = NULLIF(bs_name, ''),
    bs_abbreviation = NULLIF(bs_abbreviation, ' '),
    billing_addr = NULLIF(billing_addr, ' '),
    delivery_addr = NULLIF(delivery_addr, ''),
    city = NULLIF(city, ''),
    pincode = NULLIF(pincode, ''),
    country = NULLIF(country, ''),
    currency = NULLIF(currency, ''),
    bs_code = NULLIF(bs_code, ''),
    contact_person = NULLIF(contact_person, ''),
    mobile_ext = NULLIF(mobile_ext, ''),
    mobile = NULLIF(mobile, ''),
    phone = NULLIF(phone, ''),
    email = NULLIF(email, ''),
    username = NULLIF(username, '');






