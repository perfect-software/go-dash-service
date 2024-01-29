CREATE TABLE ole.SampleRequest (
    sample_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	season varchar(10) NOT NULL,
	sr_no varchar(20) not null,
	bs_id int NOT NULL,
	sample_ref varchar(30),
	sample_type varchar(10) not null,
	article_no varchar(50) not null,
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
	fin_year varchar(5),
	username varchar(10),
    entDate datetime DEFAULT getdate(),
);


ALTER TABLE OLE.SampleRequest
DROP COLUMN sr_no;

ALTER TABLE OLE.SampleRequest
ADD sr_no varchar(20);

DELETE FROM ole.SampleRequest;

DBCC CHECKIDENT('ole.SampleRequest', RESEED, 0);

ALTER TABLE ole.SampleRequest
ALTER COLUMN article_no INT;

select * from ole.SampleRequest