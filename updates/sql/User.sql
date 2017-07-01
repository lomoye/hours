CREATE TABLE user(
id bigint(20) NOT NULL AUTO_INCREMENT,
nick varchar(128) NOT NULL,
mobile varchar(128) NOT NULL,
password varchar(128) NOT NULL,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;