CREATE TABLE ole.Item (
    item_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	item_grp varchar(5),
	item_sub_grp varchar(5),
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

	---------------------

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


