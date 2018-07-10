DROP TABLE IF EXISTS services;
CREATE TABLE services (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  service_name varchar(20) NOT NULL,
  service_type varchar(20) NOT NULL,
  price int(10) NOT NULL,
  active enum('N','Y') NOT NULL DEFAULT 'Y',
  creation_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 STATS_PERSISTENT=0 COMMENT='Service info';

BEGIN;
INSERT INTO services VALUES (1, 'TCP', 'Shadowsocks', 70, 'Y', '2018-06-13 11:45:52', '2018-06-13 11:45:52');
INSERT INTO services VALUES (2, 'KCP', 'Shadowsocks', 150, 'Y', '2018-06-13 11:45:52', '2018-06-13 11:45:52');
INSERT INTO services VALUES (3, 'TCP', 'Vmess', 70, 'Y', '2018-06-13 11:45:52', '2018-06-13 11:45:52');
INSERT INTO services VALUES (4, 'KCP', 'Vmess', 150, 'Y', '2018-06-13 11:45:52', '2018-06-13 11:45:52');
COMMIT;

DROP TABLE IF EXISTS user_service;
CREATE TABLE user_service (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  user_id bigint(11) NOT NULL,
  service_id bigint(11) NOT NULL,
  vmess_uuid varchar(64) DEFAULT NULL,
  shadowsocks_port int(4) DEFAULT NULL,
  shadowsocks_pass varchar(32) DEFAULT NULL,
  begin_time date NOT NULL,
  expire_time date NOT NULL,
  expired enum('N','Y') NOT NULL DEFAULT 'N',
  descript varchar(20),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User & Service';


DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  qq varchar(20) NOT NULL,
  email varchar(20) NOT NULL,
  password varchar(32) NOT NULL,
  active enum('N','Y') NOT NULL DEFAULT 'Y',
  creation_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  invite_by bigint(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User info';
