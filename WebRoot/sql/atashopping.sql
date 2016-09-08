# SQL Manager 2005 for MySQL 3.7.7.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : atashopping


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES gbk */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `atashopping`;

CREATE DATABASE `atashopping`
    CHARACTER SET 'gbk'
    COLLATE 'gbk_chinese_ci';

USE `atashopping`;

#
# Structure for the `admin` table : 
#

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Structure for the `bank` table : 
#

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `username` varchar(20) character set gbk NOT NULL,
  `password` varchar(20) character set gbk NOT NULL,
  `money` double(15,3) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Structure for the `moneylog` table : 
#

DROP TABLE IF EXISTS `moneylog`;

CREATE TABLE `moneylog` (
  `logid` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `money` double(15,3) default NULL,
  `time` varchar(20) default NULL,
  PRIMARY KEY  (`logid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Structure for the `product` table : 
#

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` varchar(20) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `price` double(15,3) NOT NULL,
  `pcount` int(11) default NULL,
  `imgpath` varchar(20) default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Structure for the `user` table : 
#

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `tel` varchar(20) default NULL,
  `address` varchar(20) default NULL,
  `sex` varchar(20) default NULL,
  `age` int(11) default NULL,
  `money` double(15,3) default NULL,
  `regtime` varchar(20) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Structure for the `useraccount` table : 
#

DROP TABLE IF EXISTS `useraccount`;

CREATE TABLE `useraccount` (
  `username` varchar(20) NOT NULL,
  `money` double(15,3) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Structure for the `userform` table : 
#

DROP TABLE IF EXISTS `userform`;

CREATE TABLE `userform` (
  `fid` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `count` int(11) default NULL,
  `time` varchar(20) default NULL,
  PRIMARY KEY  (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;