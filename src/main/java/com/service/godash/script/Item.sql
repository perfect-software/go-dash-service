drop table ole.item

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

	----------------------------
	drop table ole.ItemGrp

	CREATE TABLE ole.ItemGrp (
    item_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	item_grp varchar(7),
	item_sub_grp varchar(7),
	item_grp_nm varchar (50),
	item_sub_grp_nm varchar (50),
	username varchar(10),
	entDate datetime DEFAULT getdate(),
	);

	INSERT INTO GPL.ole.ItemGrp(item_grp,item_sub_grp,item_grp_nm,item_sub_grp_nm,username,entDate)
	SELECT Item_Group_Code,Item_SubGroup_Code,Item_Group_Name,Item_SubGroup_Name,User_Name,EntDate from GPLTEST.dbo.ItemGroupMst Order By Item_Group_Code,Item_SubGroup_Code

	select * from ole.ItemGrp