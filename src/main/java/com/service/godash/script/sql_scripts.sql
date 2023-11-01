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

CREATE TABLE ole.SampleRequest (
    sample_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	bs_id int,
	sample_ref int,
	sample_type varchar(10),
	article_no varchar(50),
	buyer_article varchar(50),
	season varchar(10),
	size varchar(5),
	quantity varchar(5),
	pair varchar(5),
	upperColor varchar(20),
	liningColor varchar(20),
	last varchar(20),
	insole varchar(20),
	solelable varchar(20),
	socks varchar(20),
	heel varchar(20),
	pattern varchar(20),
	buyer_ref  varchar(50),
	in_upper_leather varchar(50),
	in_lining varchar(50),
	in_socks varchar(50),
	in_quantity varchar(50),
	comments varchar(200),
	delivery_date datetime,
	prod_ex_date datetime,
    entDate datetime DEFAULT getdate(),
);

-----------------------------------------

select * from ole.SampleRequest

delete from ole.SampleRequest

drop table ole.SampleRequest

CREATE TABLE ole.SampleRequest (
    sample_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	season varchar(10) NOT NULL,
	sr_no  AS season + RIGHT('00000000' + CAST(sample_id AS VARCHAR(8)), 8) PERSISTED,
	bs_id int NOT NULL,
	sample_ref int,
	sample_type varchar(10),
	article_no varchar(50),
	buyer_article varchar(50),
	size varchar(5),
	quantity varchar(5),
	pair varchar(5),
	upperColor varchar(20),
	liningColor varchar(20),
	last varchar(20),
	insole varchar(20),
	solelable varchar(20),
	socks varchar(20),
	heel varchar(20),
	pattern varchar(20),
	buyer_ref  varchar(50),
	in_upper_leather varchar(50),
	in_lining varchar(50),
	in_socks varchar(50),
	in_quantity varchar(50),
	comments varchar(200),
	delivery_date date,
	prod_ex_date date,
	username varchar(10),
    entDate datetime DEFAULT getdate(),
);





