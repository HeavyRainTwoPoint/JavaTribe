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

 Date: 20/01/2021 21:14:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_art_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_art_tag`;
CREATE TABLE `t_art_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `art_id` int(11) NOT NULL COMMENT '文章id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` timestamp(0) NOT NULL COMMENT '最近一次修改时间',
  `delete_status` int(11) NULL DEFAULT 0 COMMENT '逻辑删，0表示可用，1表示删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
