/*
Navicat MySQL Data Transfer

Source Server         : fbmeeting
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : fuxin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-11 12:22:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for meeting_user
-- ----------------------------
DROP TABLE IF EXISTS `meeting_user`;
CREATE TABLE `meeting_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `confId` varchar(255) DEFAULT NULL COMMENT '会议id',
  `userId` varchar(255) DEFAULT NULL COMMENT 'userId',
  `nature` int(1) NOT NULL COMMENT '人员性质，1主持人，2参会者',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
