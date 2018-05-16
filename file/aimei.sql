/*
Navicat MySQL Data Transfer

Source Server         : mecg本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : aimei

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-16 19:22:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `evaluationId` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '评价Id',
  `replyId` bigint(50) NOT NULL COMMENT '回复ID',
  `merberId` bigint(50) NOT NULL COMMENT '会员id',
  `content` text COMMENT '评论内容',
  `time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`evaluationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` bigint(50) NOT NULL AUTO_INCREMENT,
  `stockId` bigint(50) DEFAULT NULL,
  `goodsTypeId` bigint(50) DEFAULT NULL,
  `goodsName` varchar(50) DEFAULT NULL,
  `goodsComment` varchar(50) DEFAULT NULL,
  `price` decimal(50,0) DEFAULT NULL,
  `purchaseDate` datetime DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=1526464143082 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1526463667776', null, null, '百事可乐', '罐装330ml', '3', null);
INSERT INTO `goods` VALUES ('1526464143081', null, null, '可口可乐', '罐装330ml', '3', '2018-05-16 00:00:00');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `goodsTypeId` bigint(50) NOT NULL AUTO_INCREMENT,
  `hotSaleId` bigint(50) DEFAULT NULL,
  `goodsTypeName` varchar(255) DEFAULT NULL,
  `typeComment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goodsTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstype
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` bigint(50) NOT NULL AUTO_INCREMENT,
  `managerName` varchar(50) DEFAULT NULL,
  `managerPwd` varchar(50) DEFAULT NULL,
  `managerRName` varchar(50) DEFAULT NULL,
  `managerEmail` varchar(50) DEFAULT NULL,
  `managerPhone` varchar(50) DEFAULT NULL,
  `managerDate` date DEFAULT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `memberId` bigint(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `realName` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '小芹', '123456', '芹菜', 'female', '13959895649', null, null, null);
INSERT INTO `member` VALUES ('2', '张老师', '123456', '磊磊', 'male', '12632546987', 'cdxy_zl@163.com', '四川成都', '2018-05-16 00:00:00');
INSERT INTO `member` VALUES ('3', '器材', '123456', '小芹菜', 'female', '13959895649', null, null, null);
INSERT INTO `member` VALUES ('4', '芹小仙女儿', '123456', '七仙女', 'male', '54210', 'qinxiannv@164.com', '织女星0', null);
INSERT INTO `member` VALUES ('5', '芹小仙女儿', '123456', '七仙女', 'male', '54210', 'qinxiannv@164.com', '织女星0', null);
INSERT INTO `member` VALUES ('6', '芹小仙女儿', '123456', '七仙女', 'male', '54210', 'qinxiannv@164.com', '织女星0', null);
INSERT INTO `member` VALUES ('7', '芹小仙女儿', '123456', '七仙女', 'male', '54210', 'qinxiannv@164.com', '织女星0', null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `orderGenDate` datetime DEFAULT NULL COMMENT '订单日期',
  `memberName` varchar(50) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `address` varchar(50) DEFAULT NULL COMMENT '用户地址',
  `email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `status` int(1) DEFAULT '0' COMMENT '订单状态：0-已下单，1-已完成，2-已取消',
  `memberId` bigint(20) DEFAULT NULL COMMENT '会员ID',
  `price` double(10,2) DEFAULT NULL COMMENT '订单金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1526469392785 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsId` bigint(20) DEFAULT NULL COMMENT '商品Id',
  `orderId` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `number` int(20) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsId` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `number` bigint(20) DEFAULT NULL COMMENT '商品数量',
  `memberId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `stockId` bigint(50) NOT NULL AUTO_INCREMENT,
  `goodsId` bigint(50) NOT NULL,
  `memberId` bigint(50) DEFAULT NULL,
  `numbers` bigint(50) DEFAULT NULL,
  `purchaseTimes` datetime DEFAULT NULL,
  `wetherPurchase` bigint(50) DEFAULT NULL,
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('3', '1526463667776', null, '50', '2018-05-16 00:00:00', '1');
INSERT INTO `stock` VALUES ('7', '1526464143081', null, '-2', '2018-05-16 00:00:00', '0');
