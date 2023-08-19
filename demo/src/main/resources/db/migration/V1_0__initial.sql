CREATE TABLE IF NOT EXISTS feeding (

    id serial PRIMARY KEY,
    catname varchar(32) NOT NULL,
    brandName varchar(32) NOT NULL,
    productName varchar(32) NOT NULL,
    taste varchar(32) NOT NULL,
    eatenPercentage integer NOT NULL,
    type varchar(32) NOT NULL,
    created timestamp NOT NULL DEFAULT current_timestamp,
    feedingTime timestamp NOT NULL
);
