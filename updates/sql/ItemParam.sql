CREATE TABLE item_param(
id bigint(20) NOT NULL AUTO_INCREMENT,
item_id bigint(20),
type varchar(128),
unit varchar(128),
display_name varchar(128),
index int(20),
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;