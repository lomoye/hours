DROP TABLE IF EXISTS user_suggest;
CREATE TABLE user_suggest(
id bigint(20) NOT NULL AUTO_INCREMENT,
user_id bigint(20) NOT NULL,
user_nick varchar(128) NOT NULL,
title varchar(128) NOT NULL,
content varchar(2048) NOT NULL,
status varchar(128) NOT NULL,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;