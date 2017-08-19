CREATE TABLE item_goal(
id bigint(20) NOT NULL AUTO_INCREMENT,
user_id bigint(20) NOT NULL,
item_id bigint(20) NOT NULL,
item_param_id BIGINT(20) NOT NULL,
start_time datetime NOT NULL,
end_time datetime NOT NULL,
goal_num varchar(128) NOT NULL,
credit_rate bigint(20) NOT NULL,
status varchar(128) NOT NULL,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;