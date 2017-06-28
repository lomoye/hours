CREATE TABLE item_param_value(
id bigint(20) NOT NULL AUTO_INCREMENT,
item_param_id bigint(20),
item_id bigint(20),
value varchar(128),
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;