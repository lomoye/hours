DROP TABLE IF EXISTS item;

CREATE TABLE item(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(128) NOT NULL,
  `desc` varchar(128),
  create_time datetime NOT NULL,
  modify_time datetime NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;