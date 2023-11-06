select * from ole.bsAccount

	Drop table ole.buyerAccount

	CREATE TABLE ole.bsAccount (
    buyeraccount_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	bs_id int NOT NULL,
	bankName varchar(100),
	bankBranch varchar(100),
	bankAccountNo varchar(100),
	bankIFSC varchar(100),
	bankAccountType varchar(100),
	bankCity varchar(100),
	bankAddress varchar(100),
	bankSwiftCode varchar(100),
	);