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

CREATE TABLE ole.ItemInvent(
    inv_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    item_id int FOREIGN KEY REFERENCES ole.Item(item_id),
    quantity int,
    rate decimal(18,2), -- Assuming a decimal data type for the rate
    entDate datetime DEFAULT getdate()
);

    INSERT INTO ItemInvent(item_id, quantity, rate) VALUES(1, 10, 100.00);

    -- Assuming you want to remove the [old_column] and add a new column [new_column] to the table [YourTable]

    -- Step 1: Remove the old column
    ALTER TABLE [YourTable]
    DROP COLUMN [old_column];

    -- Step 2: Add the new column
    ALTER TABLE [YourTable]
    ADD [new_column] [data_type] NULL; -- Replace [data_type] with the appropriate data type for your new column
