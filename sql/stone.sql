/*
Navicat MySQL Data Transfer

Source Server         : 39.97.181.183-二哥2
Source Server Version : 50562
Source Host           : 39.97.181.183:3306
Source Database       : stone

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-03-11 11:37:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for basic_config
-- ----------------------------
DROP TABLE IF EXISTS `basic_config`;
CREATE TABLE `basic_config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IS_JUMP` varchar(2) DEFAULT NULL COMMENT '是否跳过开场动画页面',
  `NUWA_TIP` varchar(4000) DEFAULT NULL COMMENT '女娲开场白',
  `LOTTO_NUM` int(11) DEFAULT NULL COMMENT '抽奖次数',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basic_config
-- ----------------------------
INSERT INTO `basic_config` VALUES ('1', '0', '冒险家，你终于来了，你看到的是我在人间残留的影像，既然能来到这，说明你就是天选之子，神石已经被分割成了几部分，将他们全部集齐后就能知晓其中隐藏的秘密，每块神石碎片都留有线索，那么请开始吧。', '2', '2020-02-29 13:24:27');

-- ----------------------------
-- Table structure for lotto
-- ----------------------------
DROP TABLE IF EXISTS `lotto`;
CREATE TABLE `lotto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOTTO_PRIZE` varchar(512) DEFAULT NULL COMMENT '奖品名称',
  `IMG_URL` varchar(512) DEFAULT NULL COMMENT '生成图片存放地址',
  `STATUS` varchar(512) DEFAULT NULL COMMENT '是否中奖 0 否 1 是',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lotto
-- ----------------------------
INSERT INTO `lotto` VALUES ('1', 'SKG按摩仪', '/www/server/tomcat/webapps/ROOT/upload/SKG按摩仪.png', '0', '2020-03-06 15:06:12');
INSERT INTO `lotto` VALUES ('2', 'Tissot机械表', '/www/server/tomcat/webapps/ROOT/upload/Tissot机械表.png', '0', '2020-03-06 15:40:44');

-- ----------------------------
-- Table structure for stone
-- ----------------------------
DROP TABLE IF EXISTS `stone`;
CREATE TABLE `stone` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STONE_NO` varchar(64) DEFAULT NULL COMMENT '神石碎片编号',
  `TIP_INFO` varchar(4000) DEFAULT NULL COMMENT '触碰神石碎片提示的信息',
  `CIPHER_TEXT` varchar(512) DEFAULT NULL COMMENT '密文',
  `IS_DECODE` varchar(2) DEFAULT NULL COMMENT '是否被破译',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stone
-- ----------------------------
INSERT INTO `stone` VALUES ('1', '1', '你每天都能看到他的笑，但是它的背后却藏着不为人知的秘密', '我爱你', '0', '2020-02-29 13:48:26');
INSERT INTO `stone` VALUES ('2', '2', '我们的爱，没有永恒，却是永远。', 'forever', '0', '2020-02-29 13:49:13');
INSERT INTO `stone` VALUES ('3', '3', '你笑起来真好看，像春天的花一样', 'smile', '0', '2020-02-29 13:50:06');
INSERT INTO `stone` VALUES ('4', '4', '你的名字，我的心事', 'rain', '0', '2020-02-29 13:50:26');
