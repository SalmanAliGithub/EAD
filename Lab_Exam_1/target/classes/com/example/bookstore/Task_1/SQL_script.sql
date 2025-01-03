-- First let's Create the database named 'BookstoreDB'
CREATE DATABASE IF NOT EXISTS BookstoreDB;

-- Second let's use the DB and after that add the tables
USE BookstoreDB;

-- I will use the follwing Command to create a table called 'Books'
CREATE TABLE IF NOT EXISTS Books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);


