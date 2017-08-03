DROP TABLE IF EXISTS credit_account_log;
CREATE TABLE credit_account_log(
id bigint(20) NOT NULL AUTO_INCREMENT,
user_id bigint(20) NOT NULL,
`day` datetime NOT NULL,
`type` varchar(128) NOT NULL,
memo varchar(128) NOT NULL,
content varchar(128) NOT NULL,
before_credit bigint(20) NOT NULL,
after_credit bigint(20) NOT NULL,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;