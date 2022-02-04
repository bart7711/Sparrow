DELETE FROM post where id > 0;
DELETE FROM user;

INSERT INTO user (username,description,email,password) values ('bart','I love Social democracy','bart00q@gmail','password123');
INSERT INTO user (username,description,email,password) values ('test','I love Monarchy','test@gmail','password1234');

INSERT INTO post (id,create_date_time,text,user_username) values (1,'2030-12-31 01:15:00','Test','bart');
INSERT INTO post (id,create_date_time,text,user_username) values (2,'2023-12-31 01:15:00','Test1','bart');
INSERT INTO post (id,create_date_time,text,user_username) values (3,'2024-12-31 01:15:00','Test2','test');
