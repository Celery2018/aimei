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
-- Table structure for conference
-- ----------------------------
DROP TABLE IF EXISTS `conference`;
CREATE TABLE `conference` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会议ID',
  `protocolHostStartUrl` varchar(2000) DEFAULT NULL COMMENT '协议启会地址',
  `hostStartUrl` varchar(2000) DEFAULT NULL COMMENT ' 主持人启会地址',
  `confStatus` smallint(6) DEFAULT NULL COMMENT '会议状态:0,预约成功 、2,正在召开、3,已结束会议、9,已',
  `confPassword` varchar(50) DEFAULT NULL COMMENT '会议密码',
  `optionJbh` tinyint(4) DEFAULT NULL COMMENT '是否允许参会人先于主持人入会，0 否 1 是',
  `startTime` datetime DEFAULT NULL COMMENT '会议开会时间',
  `actualTime` datetime DEFAULT NULL COMMENT '会议实际开启时间',
  `optionVideoParticipants` tinyint(4) DEFAULT NULL COMMENT '会议与会人视频选项设置，0 关闭视频 1 开启视频',
  `confId` int(11) DEFAULT NULL COMMENT '会畅会议ID',
  `duration` int(11) DEFAULT NULL COMMENT '会议时长',
  `protocolJoinUrl` varchar(2000) DEFAULT NULL COMMENT '协议入会地址',
  `userId` varchar(255) DEFAULT NULL COMMENT '创建会议用户id',
  `userName` varchar(255) DEFAULT NULL,
  `confName` varchar(255) DEFAULT NULL COMMENT '会议名称',
  `confParties` int(11) DEFAULT NULL COMMENT '会议方数',
  `joinUrl` varchar(2000) DEFAULT NULL COMMENT '入会地址',
  `confDelFlag` tinyint(4) DEFAULT NULL COMMENT '会议删除状态 0,无效数据、1,正常使用、2,已删除',
  `optionVideoHost` tinyint(4) DEFAULT NULL COMMENT '会议主持人视频选项设置，0 关闭视频 1 开启视频',
  `confNumber` varchar(20) DEFAULT NULL COMMENT '会议号码',
  `roomId` int(11) DEFAULT NULL COMMENT '会议室ID',
  `timeZone` varchar(255) DEFAULT NULL COMMENT '时区',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `rcIps` varchar(255) DEFAULT NULL COMMENT '硬件入会地址',
  `h323pwd` varchar(255) DEFAULT NULL COMMENT '硬件入会密码',
  `isPush` int(11) DEFAULT NULL COMMENT '是否已推送消息',
  PRIMARY KEY (`ID`),
   KEY `confId` (`confId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of conference
-- ----------------------------
