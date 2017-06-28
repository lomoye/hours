CREATE TABLE item_record(
id bigint(20) NOT NULL AUTO_INCREMENT,
item_id bigint(20),
day datetime,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;