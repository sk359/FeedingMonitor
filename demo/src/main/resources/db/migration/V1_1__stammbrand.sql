CREATE TABLE IF NOT EXISTS stamm_brand (
    id serial PRIMARY KEY,
    name varchar(32) NOT NULL,    
    created timestamp NOT NULL DEFAULT current_timestamp    
);