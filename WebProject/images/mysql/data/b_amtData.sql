--
-- * Document           : amtData.sql
-- * Created on         : Oct 20, 2016
-- * Author             : J. Ayoub & M-H. Aghamahdi
-- * Object			    : This file inserts data into the database tables.
-- * Remarks            : N/A
-- * Information Source : N/A
--

USE amtDB;

INSERT INTO users (username, password, email, firstName, familyName) 
VALUES
('jean.ayoub', 'jeanayoub', 'jean.ayoub@amt.ch', 'Jean', 'Ayoub'),
('hossein.aghamahdi', 'hosseinaghamahdi', 'hossein.aghamahdi@amt.ch', 'Hossein', 'Aghamahdi'),
('kawasaki.ninja', 'kawasakininja', null, null, null),
('yamaha.r6', 'yamahar6', null, 'unknown', null);