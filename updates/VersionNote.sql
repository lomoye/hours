CREATE TABLE version_note(
id bigint(20) NOT NULL AUTO_INCREMENT,
content varchar(128) NOT NULL,
`day` datetime NOT NULL,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;