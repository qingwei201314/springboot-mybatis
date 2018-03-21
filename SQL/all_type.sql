/*
Navicat MySQL Data Transfer

Source Server         : 开发_192.168.11.55
Source Server Version : 50173
Source Host           : 192.168.11.55:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-21 20:03:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for all_type
-- ----------------------------
DROP TABLE IF EXISTS `all_type`;
CREATE TABLE `all_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tinyint_s` tinyint(4) NOT NULL,
  `smallint_s` smallint(6) NOT NULL,
  `mediumint_s` mediumint(9) NOT NULL,
  `int_s` int(11) NOT NULL,
  `integer_s` int(11) NOT NULL,
  `bigint_s` bigint(20) NOT NULL,
  `bit_s` bit(1) NOT NULL,
  `real_s` double(255,0) NOT NULL,
  `double_s` double NOT NULL,
  `float_s` float NOT NULL,
  `decimal_s` decimal(10,0) NOT NULL,
  `numeric_s` decimal(10,0) NOT NULL,
  `char_s` char(255) NOT NULL,
  `varchar_s` varchar(255) NOT NULL,
  `date_s` date NOT NULL,
  `time_s` time NOT NULL,
  `year_s` year(4) NOT NULL,
  `timestamp_s` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `datetime` datetime NOT NULL,
  `tinyblob_s` tinyblob NOT NULL,
  `blob_s` blob NOT NULL,
  `mediumblob_s` mediumblob NOT NULL,
  `longblob_s` longblob NOT NULL,
  `tinytext_s` tinytext NOT NULL,
  `text_s` text NOT NULL,
  `mediumtext_s` mediumtext NOT NULL,
  `longtext_s` longtext NOT NULL,
  `enum_s` enum('three','two','one') CHARACTER SET utf8 NOT NULL,
  `set_s` set('d','c','b','a') CHARACTER SET utf8 NOT NULL DEFAULT '',
  `binary_s` binary(255) NOT NULL,
  `varbinary_s` varbinary(255) NOT NULL,
  `point` point NOT NULL,
  `linestring` linestring NOT NULL,
  `polygon` polygon NOT NULL,
  `geometry` geometry NOT NULL,
  `multipoint` multipoint NOT NULL,
  `multilinestring` multilinestring NOT NULL,
  `multipolygon` multipolygon NOT NULL,
  `geometrycollection` geometrycollection NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
