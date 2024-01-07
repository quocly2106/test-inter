CREATE TABLE users
(
    username VARCHAR(50) PRIMARY KEY ,
    password VARCHAR(500) NOT NULL ,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities(
    id SERIAL PRIMARY KEY ,
    username varchar(50) NOT NULL ,
    authority varchar(50) NOT NULL ,
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE
);

CREATE TABLE customer(
    id SERIAL PRIMARY KEY ,
    username varchar(50) NOT NULL ,
    password varchar(500) NOT NULL ,
    role varchar(50) not null
);

INSERT INTO customer (id,username,password,role) 
VALUES (1,'quocv1','quoc123','admin')
