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

 Date: 20/01/2021 21:14:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `art_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id，自增主键',
  `art_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `art_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章正文内容',
  `art_summary` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章摘要',
  `art_viewcount` int(11) NULL DEFAULT 0 COMMENT '阅读数量',
  `art_tag_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '文章的一级标签',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` timestamp(0) NOT NULL COMMENT '最近一次修改时间',
  `delete_status` int(11) NULL DEFAULT 0 COMMENT '逻辑删，0表示可用，1表示禁用',
  `art_no` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  PRIMARY KEY (`art_id`, `art_no`) USING BTREE,
  INDEX `art_title`(`art_title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
