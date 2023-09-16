CREATE TABLE IF NOT EXISTS stamm_product (
    id serial PRIMARY KEY,
    name varchar(32) NOT NULL, 
    stamm_brand_id INT NOT NULL,
    food_type varchar(16) NOT NULL, 	
    created timestamp NOT NULL DEFAULT current_timestamp,
    CONSTRAINT fk_brand
      FOREIGN KEY(stamm_brand_id) 
	  REFERENCES stamm_brand(id)    
);

CREATE TABLE IF NOT EXISTS stamm_product_taste (
    id serial PRIMARY KEY,
    name varchar(32) NOT NULL, 
    stamm_product_id INT NOT NULL,    
    created timestamp NOT NULL DEFAULT current_timestamp,
    CONSTRAINT fk_product
      FOREIGN KEY(stamm_product_id) 
	  REFERENCES stamm_product(id)    
);