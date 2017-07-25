DROP TABLE IF EXISTS article;
CREATE TABLE article(
id bigint(20) NOT NULL AUTO_INCREMENT,
title varchar(128) NOT NULL,
content TEXT NOT NULL,
author varchar(128) NOT NULL,
source varchar(128) NOT NULL,
picture varchar(128) NOT NULL,
`index` bigint(20) NOT NULL,
create_time datetime NOT NULL,
modify_time datetime NOT NULL,
PRIMARY KEY (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;