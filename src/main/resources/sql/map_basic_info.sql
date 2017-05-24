/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50551
Source Host           : localhost:3306
Source Database       : movingcq

Target Server Type    : MYSQL
Target Server Version : 50551
File Encoding         : 65001

Date: 2017-02-23 10:28:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `map_basic_info`
-- ----------------------------
DROP TABLE IF EXISTS `map_basic_info`;
CREATE TABLE `map_basic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_uid` varchar(55) DEFAULT NULL COMMENT '商家uid，当uid为空时即为工厂地址',
  `car_id` int(5) DEFAULT '0' COMMENT '所绑定车id',
  `type` int(5) DEFAULT '0' COMMENT '起始点类型 0起点 1终点',
  `longitude` decimal(18,6) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(18,6) DEFAULT NULL COMMENT '纬度',
  `select_type` int(5) DEFAULT '0' COMMENT '起始点运动下拉选择条件 0最短距离 1最少时间  2避开高速',
  `order_num` int(5) DEFAULT '1' COMMENT '路线顺序 0即为工厂地址',
  `create_time` varchar(25) DEFAULT NULL,
  `update_time` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of map_basic_info
-- ----------------------------
INSERT INTO `map_basic_info` VALUES ('6', '', '-1', '0', '116.433823', '39.909467', '0', '0', '2017-02-21 10:43:27', '2017-02-23 10:24:45');
INSERT INTO `map_basic_info` VALUES ('7', '1cf98765-7b07-4480-8024-625fdbe5ebd0', '0', '0', '116.404046', '39.914632', '0', '0', '2017-02-21 13:58:19', '2017-02-23 10:26:44');
INSERT INTO `map_basic_info` VALUES ('8', '230c327d-f614-4e70-9e32-f44355bc6fa2', '5', '0', '116.325319', '39.965665', '0', '2', '2017-02-21 14:04:06', '2017-02-22 17:48:49');
INSERT INTO `map_basic_info` VALUES ('9', 'efeb8eef-0bb5-43d6-80a2-97b0e478bee6', '5', '0', '116.300957', '39.811924', '0', '1', '2017-02-21 14:08:26', '2017-02-22 17:48:49');
INSERT INTO `map_basic_info` VALUES ('10', '88d5ad5f-6e87-49f6-85cd-35cb27ad8145', '0', '0', '116.418168', '39.980097', '0', '0', '2017-02-21 14:10:55', '2017-02-23 10:26:44');
INSERT INTO `map_basic_info` VALUES ('11', '255f44ed-ac08-4b4d-90bb-a46fb35019f6', '5', '0', '116.367503', '40.147080', '0', '3', '2017-02-21 14:13:31', '2017-02-22 17:48:49');
INSERT INTO `map_basic_info` VALUES ('12', '5873bdba-727d-4aaf-8f9f-2916da63f871', '0', '0', '116.618310', '39.964006', '0', '0', '2017-02-21 14:15:46', '2017-02-23 10:26:44');
