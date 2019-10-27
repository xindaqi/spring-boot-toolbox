/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-02-11 06:29:41
*/

-- CREATE DATABASE `shop` DEFAULT CHARACTER SET utf8;

USE `shop`;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ausertable`
-- ----------------------------
DROP TABLE IF EXISTS `ausertable`;
CREATE TABLE `ausertable` (
  `aname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`aname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ausertable
-- ----------------------------
INSERT INTO ausertable VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for `busertable`
-- ----------------------------
DROP TABLE IF EXISTS `busertable`;
CREATE TABLE `busertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bemail` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `bpwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of busertable
-- ----------------------------

-- ----------------------------
-- Table structure for `carttable`
-- ----------------------------
DROP TABLE IF EXISTS `carttable`;
CREATE TABLE `carttable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`busertable_id`),
  KEY `gno` (`goodstable_id`),
  CONSTRAINT `bid` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`),
  CONSTRAINT `gno` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of carttable
-- ----------------------------

-- ----------------------------
-- Table structure for `focustable`
-- ----------------------------
DROP TABLE IF EXISTS `focustable`;
CREATE TABLE `focustable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodstable_id` int(11) NOT NULL,
  `busertable_id` int(11) NOT NULL,
  `focustime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gno1` (`goodstable_id`),
  KEY `bid1` (`busertable_id`),
  CONSTRAINT `bid1` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`),
  CONSTRAINT `gno1` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of focustable
-- ----------------------------

-- ----------------------------
-- Table structure for `goodstable`
-- ----------------------------
DROP TABLE IF EXISTS `goodstable`;
CREATE TABLE `goodstable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goprice` double DEFAULT NULL,
  `grprice` double DEFAULT NULL,
  `gstore` int(11) DEFAULT NULL,
  `gpicture` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodstype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeid` (`goodstype_id`),
  CONSTRAINT `typeid` FOREIGN KEY (`goodstype_id`) REFERENCES `goodstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goodstable
-- ----------------------------

-- ----------------------------
-- Table structure for `goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goodstype
-- ----------------------------

-- ----------------------------
-- Table structure for `noticetable`
-- ----------------------------
DROP TABLE IF EXISTS `noticetable`;
CREATE TABLE `noticetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ncontent` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ntime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of noticetable
-- ----------------------------

-- ----------------------------
-- Table structure for `orderbasetable`
-- ----------------------------
DROP TABLE IF EXISTS `orderbasetable`;
CREATE TABLE `orderbasetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `status` tinyint(4) NOT NULL,
  `orderdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid2` (`busertable_id`),
  CONSTRAINT `bid2` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orderbasetable
-- ----------------------------

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderbasetable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `odsn` (`orderbasetable_id`),
  KEY `gno3` (`goodstable_id`),
  CONSTRAINT `odsn` FOREIGN KEY (`orderbasetable_id`) REFERENCES `orderbasetable` (`id`),
  CONSTRAINT `gno3` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- DROP TABLE IF EXISTS `alarm_computer_room`;
-- CREATE TABLE `alarm_computer_room` (
--     `id` int NOT NULL AUTO_INCREMENT,
--     `Summary` varchar(100) NULL,
--     `Alarm_sys` varchar(100) NULL,
--     `Alarm_des` varchar(100) NULL,
--     `Alarm_id` varchar(100) NULL,
--     `Alarm_level` varchar(100) NULL,
--     `Alarm_begin` varchar(100) NULL,
--     `Alarm_end` varchar(100) NULL,
--     `Alarm_source` varchar(100) NULL,
--     `Alarm_projectCode` varchar(100) NULL,
--     `Alarm_projectName` varchar(100) NULL,
--     `Alarm_areaName` varchar(100) NULL,
--     `Alarm_deviceName` varchar(100) NULL,
--     `Alarm_pointName` varchar(100) NULL,
--     `Alarm_deviceID` varchar(100) NULL,
--     `Alarm_pointID` int(20) NULL,
--     `Alarm_pointValue` varchar(100) NULL,
--     `Alarm_condition` varchar(300) NULL,
--     PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- INSERT INTO alarm_computer_room VALUES (1, "异常通知","给排水","温度过高","1_1003_63","一般",
--                                         "2019-09-25 16:55:09","2019-10-24 09:11:10","[普罗理想国]","ZZ0201","普罗理想国西苑",
--                                         "设备机房","环境温湿度","湿度","1_313_63",3,
--                                         "37.18%","点值大于70...")