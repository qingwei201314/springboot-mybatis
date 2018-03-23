/*
Navicat MySQL Data Transfer

Source Server         : 开发_192.168.11.55
Source Server Version : 50173
Source Host           : 192.168.11.55:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-23 10:54:03
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
  `char_s` char(255) CHARACTER SET latin1 NOT NULL,
  `varchar_s` varchar(255) CHARACTER SET latin1 NOT NULL,
  `date_s` date NOT NULL,
  `time_s` time NOT NULL,
  `year_s` year(4) NOT NULL,
  `timestamp_s` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `datetime` datetime NOT NULL,
  `tinyblob_s` tinyblob NOT NULL,
  `blob_s` blob NOT NULL,
  `mediumblob_s` mediumblob NOT NULL,
  `longblob_s` longblob NOT NULL,
  `tinytext_s` tinytext CHARACTER SET latin1 NOT NULL,
  `text_s` text CHARACTER SET latin1 NOT NULL,
  `mediumtext_s` mediumtext CHARACTER SET latin1 NOT NULL,
  `longtext_s` longtext CHARACTER SET latin1 NOT NULL,
  `enum_s` enum('three','two','one') NOT NULL,
  `set_s` set('d','c','b','a') NOT NULL DEFAULT '',
  `binary_s` binary(255) NOT NULL,
  `varbinary_s` varbinary(255) NOT NULL,
  `point` point DEFAULT NULL,
  `linestring` linestring DEFAULT NULL,
  `polygon` polygon DEFAULT NULL,
  `geometry` geometry DEFAULT NULL,
  `multipoint` multipoint DEFAULT NULL,
  `multilinestring` multilinestring DEFAULT NULL,
  `multipolygon` multipolygon DEFAULT NULL,
  `geometrycollection` geometrycollection DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_type
-- ----------------------------
INSERT INTO `all_type` VALUES ('11', '2', '2', '3', '4', '5', '6', '', '7', '8.08', '9.09', '10', '11', 'char_s', 'varchar_s', '2017-12-12', '15:27:32', '2018', '2018-03-23 10:45:22', '2018-03-23 10:43:02', 0x74696E79626C6F62, 0x626C6F625F73, 0x6D656469756D626C6F62, 0x6C6F6E67626C6F62, 'tinytext', 'text_s', 'mediumtext', 'longtext', 'one', 'c,b,a', 0x62696E617279000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 0x76617262696E617279, null, null, null, null, null, null, null, null);
