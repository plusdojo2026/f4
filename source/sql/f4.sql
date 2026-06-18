CREATE DATABASE f4;

SHOW DATABASES;

USE f4;

CREATE TABLE users(
user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(32) NOT NULL,
qr_code VARCHAR(200)
);

INSERT INTO users VALUES(
NULL,
'papa',
'password',
'url'
);

SELECT * FROM users;

CREATE TABLE characters(
character_id INT PRIMARY KEY,
character_name VARCHAR(100),
character_main_img VARCHAR(200)
);

INSERT INTO characters VALUES(
1,
'ぺたんこ',
'petanko.png'
);

SELECT * FROM characters;

CREATE TABLE characters_subs(
character_id INT,
character_sub_id INT,
character_sub_name VARCHAR(100),
character_sub_img VARCHAR(200),
PRIMARY KEY(character_id,character_sub_id)
);

INSERT INTO characters_subs VALUES(
1,
1,
'ぺたんこ笑顔',
'petanko_smile.png'
);

SELECT * FROM characters_subs;

CREATE TABLE daily_records(
user_id INT,
character_id INT,
body INT,
mind INT,
create_date DATE,
default_screenshot VARCHAR(200),
edit_screenshot VARCHAR(200),
PRIMARY KEY(user_id,create_date)
);

INSERT INTO daily_records VALUES(
1,
1,
80,
30,
'2026-06-17',
'default.png',
'edit.png'
);

SELECT * FROM daily_records;

CREATE TABLE items(
item_id INT PRIMARY KEY,
item_name VARCHAR(100),
item_img VARCHAR(200)
);

INSERT INTO items VALUES(
1,
'ビール',
'item.png'
);

SELECT * FROM items;