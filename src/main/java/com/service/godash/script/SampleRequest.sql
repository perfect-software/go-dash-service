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
	username varchar(10),
    entDate datetime DEFAULT getdate(),
);

Insert into ole.SampleRequest (bs_id, sample_ref, sample_type, article_no, buyer_article, season, size, quantity, pair, upperColor, liningColor,
last, insole, solelable, socks, heel, pattern, buyer_ref, in_upper_leather, in_lining, in_socks, in_quantity, comments, delivery_date,
prod_ex_date, username) values (1, 1, 'PP', 'PP-001', 'PP-001', 'SS-2017', '39', '1', '1', 'Black', 'Black',
'L-1', 'L-1', 'L-1', 'L-1', 'L-1', 'L-1', 'PP-001', 'L-1', 'L-1', 'L-1', 'L-1', 'L-1', '2017-01-01', '2017-01-01', 'admin')

select * from ole.SampleRequest
