CREATE SCHEMA ole AUTHORIZATION dbo;

CREATE TABLE ole.SampleRequest (
    sample_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	season varchar(10) NOT NULL,
	sr_no  varchar(12) NOT NULL,
	bs_id int NOT NULL,
	sample_ref varchar(30),
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
	order_date date,
	username varchar(10),
    entDate datetime DEFAULT getdate(),
);

DELETE FROM ole.SampleRequest;

DBCC CHECKIDENT('ole.SampleRequest', RESEED, 0);

ALTER TABLE ole.SampleRequest
ALTER COLUMN article_no INT;

select * from ole.SampleRequest

CREATE TABLE ole.Supplier (
    supplier_id INT IDENTITY(1,1) PRIMARY KEY,
    Code VARCHAR(10),
    supplier_name VARCHAR(60),
    billing_addr VARCHAR(300),
    delivery_addr VARCHAR(300),
    city VARCHAR(50),
    pincode VARCHAR(50),
    country VARCHAR(20),
    currency VARCHAR(5),
    contact_person VARCHAR(50),
    mobile_ext VARCHAR(3),
    mobile VARCHAR(50),
    phone VARCHAR(50),
    email VARCHAR(200),
    username VARCHAR(20),
    entDate datetime DEFAULT getdate(),
);

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

select * from ole. --where bs_name like '%Axil%'

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
ORDER BY Name Asc;

drop table ole.BankAccount

select * from ole.BankAccount

ALTER TABLE ole.BankAccount
ADD businessInd varchar(20);

CREATE TABLE ole.BankAccount (
    id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	business_id int,
	bankName varchar(100),
	bankBranch varchar(100),
	bankAccountNo varchar(100),
	bankIFSC varchar(100),
	bankAccountType varchar(100),
	bankCity varchar(100),
	bankAddress varchar(100),
	bankSwiftCode varchar(100),
	);

drop table ole.bsAccount

select * from ole.Item

-- Step 1: Delete all rows
DELETE FROM ole.SR_BOM

-- Step 2: Reset the primary key
DBCC CHECKIDENT('ole.SR_BOM', RESEED, 0);

select * from ole.Item

CREATE TABLE ole.Item (
    item_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	item_grp varchar(7),
	item_sub_grp varchar(7),
	animal varchar(10),
	season varchar(10),
	characteristics varchar(100),
	texture varchar(50),
	substance varchar(50),
	tanning varchar(50),
	origin varchar(50),
	tannery varchar(50),
	color varchar(50),
	uniquecode varchar(50),
	skintype varchar(50),
	size varchar(50),
	itemname varchar (200),
	username varchar (10),
	entDate datetime DEFAULT getdate(),
	);

	CREATE TABLE ole.Article (
        article_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    	article_nm varchar (50),
    	animal varchar(10),
    	color varchar(50),
    	gender varchar(5),
    	sole_type varchar(50),
    	toe_shape varchar(50),
    	category varchar(50),
    	platform_type varchar(50),
    	platform_no varchar(50),
    	heel_type varchar(50),
    	heel_no varchar(50),
    	heel_height varchar(50),
    	last_no varchar(50),
    	lining_material varchar(50),
    	socks_material varchar(50),
    	comment varchar(255),
    	username varchar (10),
    	entDate datetime DEFAULT getdate(),
    	);

	CREATE TABLE ole.ItemGrp (
    id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	item_grp varchar(7),
	item_sub_grp varchar(7),
	item_grp_nm varchar (50),
	item_sub_grp_nm varchar (50),
	username varchar(10),
	entDate datetime DEFAULT getdate(),
	);

	INSERT INTO GPL.ole.ItemGrp(item_grp,item_sub_grp,item_grp_nm,item_sub_grp_nm,username,entDate)
	SELECT Item_Group_Code,Item_SubGroup_Code,Item_Group_Name,Item_SubGroup_Name,null,EntDate from GPLTEST.dbo.ItemGroupMst Order By Item_Group_Code,Item_SubGroup_Code

	select * from ole.ItemGrp

	CREATE TABLE ole.ItemInvent(
    inv_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    item_id int FOREIGN KEY REFERENCES ole.Item(item_id),
    quantity int,
    rate decimal(18,2), -- Assuming a decimal data type for the rate
    entDate datetime DEFAULT getdate()
);

ALTER TABLE ole.ItemInvent
ADD actual_stock decimal(18,2),unallocated_Stock decimal(18,2),inv_ind varchar(2);

ALTER TABLE ole.ItemInvent
DROP COLUMN quantity;

drop table ole.SR_BOM

create table ole.SR_BOM(
bom_id int identity(1,1) not null,
sample_id int FOREIGN KEY REFERENCES ole.SampleRequest(sample_id),
item_id int FOREIGN KEY REFERENCES ole.Item(item_id),
item_grp varchar(50),
item_sub_grp varchar(50),
used_in varchar(50),
pair varchar(50),
bom_qty decimal(18,2),
extra decimal(18,2),
stock_consumed_qty decimal(18,2),
req_qty decimal(18,2),
rate decimal(18,2),
unit varchar(10),
bom_type varchar (2),
bom_status varchar (2),
supplier_id int,
username varchar(10),
bomApprovedBy varchar(10),
entDate datetime DEFAULT getdate()
);

select * from ole.SR_BOM

create table ole.SampleType(
sampletype_id int identity(1,1),
type varchar(50)
);

select * from ole.SampleType

insert into GPL.ole.SampleType(type)
select Name from GPLTEST.dbo.TblSrType order by Name Asc

create table ole.ItemHead(
item_header_id int identity(1,1),
head varchar(50),
value varchar(50)
);

select * from ole.ItemHead

CREATE TABLE ole.Color (
    color_id INT IDENTITY(1,1) PRIMARY KEY,
    color VARCHAR(50) NOT NULL
);

INSERT INTO ole.Color (color)
VALUES
    ('Red'), ('Blue'), ('Green'), ('Yellow'), ('Purple'),
    ('Orange'), ('Pink'), ('Brown'), ('Black'), ('White'),
    ('Gray'), ('Cyan'), ('Magenta'), ('Lime'), ('Teal'),
    ('Indigo'), ('Violet'), ('Maroon'), ('Olive'), ('Navy'),
    ('Aquamarine'), ('Turquoise'), ('Silver'), ('Gold'), ('Coral'),
    ('Beige'), ('Khaki'), ('Lavender'), ('Plum'), ('Slate'),
    ('Sky Blue'), ('Forest Green'), ('Tan'), ('Salmon'), ('Sienna'),
    ('Periwinkle'), ('Tomato'), ('Chocolate'), ('Auburn'), ('Turmeric'),
    ('Saffron'), ('Emerald'), ('Ruby'), ('Pearl'), ('Amethyst'),
    ('Topaz'), ('Citrus'), ('Steel Blue'), ('Crimson'), ('Mauve'),
    ('Chartreuse'), ('Sapphire'), ('Cerulean'), ('Burgundy'), ('Tangerine'),
    ('Peach'), ('Cobalt'), ('Charcoal'), ('Azure'), ('Mustard'),
    ('Platinum'), ('Rose Gold'), ('Copper'), ('Mint Green'), ('Tiffany Blue'),
    ('Champagne'), ('Bronze'), ('Denim'), ('Rust'), ('Forest Brown'),
    ('Olive Drab'), ('Turquoise Blue'), ('Caramel'), ('Honey'), ('Graphite'),
    ('Melon'), ('Peachpuff'), ('Powder Blue'), ('Cornflower Blue'), ('Thistle'),
    ('Lavender Blush'), ('Slate Gray'), ('Honeydew'), ('Aqua'), ('Medium Orchid'),
    ('Medium Slate Blue'), ('Navajo White'), ('Pale Goldenrod'), ('Light Salmon'), ('Papaya Whip'),
    ('Lemon Chiffon'), ('Antique White'), ('Pale Turquoise'), ('Powder Blue'), ('Light Steel Blue');

-- Verify the data
SELECT * FROM ole.Color;

select * from ole.ItemHead;

use GPL

select * from ole.Supplier


select b.bs_name,a.article_nm from ole.SampleRequest s,ole.Buyer b,ole.Article a where s.bs_id=b.bs_id and s.article_no=a.article_id and sr_no='SR123456'
