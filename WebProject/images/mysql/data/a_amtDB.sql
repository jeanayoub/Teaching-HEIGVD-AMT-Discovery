--
-- * Document           : amtDB.sql
-- * Created on         : Oct 20, 2016
-- * Author             : J. Ayoub & M-H. Aghamahdi
-- * Object			    : This file creates the database tables.
-- * Remarks            : N/A
-- * Information Source : N/A
--

DROP SCHEMA IF EXISTS amtDB;
CREATE SCHEMA amtDB;
USE amtDB;


-- The users table --
CREATE TABLE users (
username   VARCHAR(50) NOT NULL,
password   VARCHAR(50) NOT NULL,
email      VARCHAR(50) DEFAULT NULL,
firstName  VARCHAR(50) DEFAULT NULL, 
familyName VARCHAR(50) DEFAULT NULL, 
PRIMARY KEY (username)
);