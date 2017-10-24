/*
Navicat MySQL Data Transfer

Source Server         : PETER-MYSQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : fuxin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-02 18:09:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` varchar(255) DEFAULT NULL COMMENT '用户ID',
  `userName` varchar(255) DEFAULT NULL COMMENT ' 用户名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱地址',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `tel` varchar(20) DEFAULT NULL COMMENT '用户电话',
  `depart` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `engName` varchar(2000) DEFAULT NULL COMMENT '英文名',
  `reserved2` varchar(2000) DEFAULT NULL COMMENT '预留位2',
  `reserved3` varchar(2000) DEFAULT NULL COMMENT '预留位3',
  PRIMARY KEY (`ID`),
   KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
