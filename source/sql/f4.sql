CREATE DATABASE f4;

SHOW DATABASES;

USE f4;

CREATE TABLE users(
user_id VARCHAR(100) PRIMARY KEY,
password VARCHAR(32) NOT NULL,
qr_code VARCHAR(200)
);

INSERT INTO users VALUES(
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

INSERT INTO characters(character_id,character_name,character_main_img) VALUES
(1,'ぺったん','images/pettan.png'),
(2,'ぐったり','images/guttari.png'),
(3,'ひきこもり','images/hikikomori.png'),
(4,'うすうす','images/usuusu.png'),
(5,'もやもや','images/moyamoya.png'),
(6,'ふわふわ','images/fuwafuwa.png'),
(7,'まあまあ','images/maamaa.png'),
(8,'いいかも','images/iikamo.png'),
(9,'うきうき','images/ukiuki.png'),
(10,'るんるん','images/runnrunn.png'),
(11,'わくわく','images/wakuwaku.png'),
(12,'きらきら','images/kirakira.png'),
(13,'そわそわ','images/sowasowa.png'),
(14,'ざわざわ','images/zawazawa.png'),
(15,'おもい','images/omoi.png'),
(16,'いらいら','images/iraira.png'),
(17,'ぐるぐる','images/guruguru.png'),

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
user_id VARCHAR(100),
character_id INT,
body INT,
mind INT,
create_date DATE,
default_screenshot VARCHAR(200),
edit_screenshot VARCHAR(200),
PRIMARY KEY(user_id,create_date)
);

INSERT INTO daily_records VALUES(
'papa',
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