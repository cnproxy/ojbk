DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  name varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
BEGIN;
INSERT INTO roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles VALUES (2, 'ROLE_USER');
COMMIT;

DROP TABLE IF EXISTS services;
CREATE TABLE services (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  service_name varchar(20) NOT NULL,
  service_type varchar(20) NOT NULL,
  price int(10) NOT NULL,
  enabled bit(1) NOT NULL,
  creation_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 STATS_PERSISTENT=0 COMMENT='Item info';


BEGIN;
INSERT INTO services VALUES (1, 'TCP', 'Shadowsocks', 70, b'1', '2018-06-13 11:45:52', '2018-07-11 10:07:54');
INSERT INTO services VALUES (2, 'KCP', 'Shadowsocks', 150, b'1', '2018-06-13 11:45:52', '2018-07-11 10:07:55');
INSERT INTO services VALUES (3, 'TCP', 'Vmess', 70, b'1', '2018-06-13 11:45:52', '2018-07-11 10:07:56');
INSERT INTO services VALUES (4, 'KCP', 'Vmess', 150, b'1', '2018-06-13 11:45:52', '2018-07-11 10:07:57');
COMMIT;


DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  user_id bigint(11) NOT NULL,
  role_id bigint(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (user_id,role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


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
  expired bit(1) NOT NULL,
  descript varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 STATS_PERSISTENT=0 COMMENT='User & Item';



DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  email varchar(20) NOT NULL,
  password varchar(100) NOT NULL,
  enabled bit(1) NOT NULL,
  creation_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  invite_by bigint(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 STATS_PERSISTENT=0 COMMENT='User info';


DROP TABLE IF EXISTS invitation_codes;
CREATE TABLE invitation_codes (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  code varchar(64) DEFAULT NULL,
  user_id bigint(11) NOT NULL,
  used bit(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 STATS_PERSISTENT=0 COMMENT='Invitation Code Info';