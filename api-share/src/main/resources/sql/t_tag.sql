/*
 Navicat Premium Data Transfer

 Source Server         : javatribe
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 47.92.200.8:3306
 Source Schema         : javatribe

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 20/01/2021 21:14:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签id，自增主键',
  `tag_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `tag_parent` int(11) NOT NULL COMMENT '所属父标签的id',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` timestamp(0) NOT NULL COMMENT '最近一次修改时间',
  `delete_status` int(11) NULL DEFAULT 0 COMMENT '逻辑删，0表示可用，1表示禁用',
  PRIMARY KEY (`tag_id`) USING BTREE,
  INDEX `tag_name`(`tag_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
