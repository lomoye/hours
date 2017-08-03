DROP TABLE IF EXISTS credit_account;
CREATE TABLE credit_account(
id bigint(20) NOT NULL AUTO_INCREMENT,
user_id bigint(20) NOT NULL,
credit bigint(20) NOT NULL,
history_credit bigint(20) NOT NULL,
`version` bigint(20) NOT NULL,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;