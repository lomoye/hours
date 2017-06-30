DROP TABLE IF EXISTS item_param;
CREATE TABLE item_param(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  item_id bigint(20) NOT NULL,
  `type` varchar(128) NOT NULL,
  unit varchar(128) NOT NULL,
  display_name varchar(128) NOT NULL,
  `index` int(20) NOT NULL,
  create_time datetime NOT NULL,
  modify_time datetime NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS item_param_value;
CREATE TABLE item_param_value(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  item_record_id bigint(20) NOT NULL,
  item_param_id bigint(20) NOT NULL,
  item_id bigint(20) NOT NULL,
  `value` varchar(128) NOT NULL,
  `day` datetime NOT NULL,
  create_time datetime NOT NULL,
  modify_time datetime NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS item_record;
CREATE TABLE item_record(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  item_id bigint(20) NOT NULL,
  `day` datetime NOT NULL,
  create_time datetime NOT NULL,
  modify_time datetime NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;