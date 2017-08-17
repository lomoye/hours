CREATE TABLE item_goal(
id bigint(20) NOT NULL AUTO_INCREMENT,
user_id bigint(20),
start_time datetime,
end_time datetime,
credit_rate bigint(20),
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;