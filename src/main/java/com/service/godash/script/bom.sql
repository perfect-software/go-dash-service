select * from ole.Item

create table ole.SR_BOM(
bom_id int identity(1,1) not null,
sample_id int FOREIGN KEY REFERENCES ole.SampleRequest(sample_id),
article_id int FOREIGN KEY REFERENCES ole.Article(article_id),
item_id int FOREIGN KEY REFERENCES ole.Item(item_id),
inv_id int FOREIGN KEY REFERENCES ole.ItemInvent(inv_id),
used_in varchar(50),
pair varchar(50),
bom_qty decimal(18,2),
req_qty decimal(18,2),
entDate datetime DEFAULT getdate()
);

CREATE TABLE ItemInvent(
    inv_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    item_id int FOREIGN KEY REFERENCES ole.Item(item_id),
    quantity int,
    rate decimal(18,2), -- Assuming a decimal data type for the rate
    entDate datetime DEFAULT getdate()
);