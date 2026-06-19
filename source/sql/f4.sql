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
(1,'ふわふわ','images/fuwafuwa.png'),
(2,'ぐるぐる','images/guruguru.png'),
(3,'ぐったり','images/guttari.png'),
(4,'ひきこもり','images/hikikomori.png'),
(5,'いいかも','images/iikamo.png'),
(6,'いらいら','images/iraira.png'),
(7,'きらきら','images/kirakira.png'),
(8,'まあまあ','images/maamaa.png'),
(9,'もやもや','images/moyamoya.png'),
(10,'おもい','images/omoi.png'),
(11,'ぺったん','images/pettan.png'),
(12,'るんるん','images/runnrunn.png'),
(13,'そわそわ','images/sowasowa.png'),
(14,'うきうき','images/ukiuki.png'),
(15,'うすうす','images/usuusu.png'),
(16,'わくわく','images/wakuwaku.png'),
(17,'ざわざわ','images/zawazawa.png');


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