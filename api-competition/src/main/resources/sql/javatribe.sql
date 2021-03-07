/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : javatribe

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 06/03/2021 16:20:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for number_of_sessions
-- ----------------------------
DROP TABLE IF EXISTS `number_of_sessions`;
CREATE TABLE `number_of_sessions`  (
  `year_id` int(0) NOT NULL AUTO_INCREMENT,
  `the_year` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`year_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of number_of_sessions
-- ----------------------------
INSERT INTO `number_of_sessions` VALUES (1, '第一届');
INSERT INTO `number_of_sessions` VALUES (2, '第二届');

-- ----------------------------
-- Table structure for t_competition_introduction
-- ----------------------------
DROP TABLE IF EXISTS `t_competition_introduction`;
CREATE TABLE `t_competition_introduction`  (
  `competition_id` bigint(0) NOT NULL COMMENT '比赛id',
  `competition_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '比赛名字',
  `show_content` varchar(3000) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '展示内容',
  `delete_status` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除 0表示没有删除，1表示删除',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `sign_up` int(0) NULL DEFAULT NULL COMMENT '是否可以通过官网进行报名。0表示不可以，1表示可以',
  PRIMARY KEY (`competition_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_competition_introduction
-- ----------------------------
INSERT INTO `t_competition_introduction` VALUES (1, '蓝桥杯', '这是蓝桥杯', 0, '2021-01-05 19:55:46', '2021-01-06 19:55:50', 0);
INSERT INTO `t_competition_introduction` VALUES (2, '官网杯', '这是官网杯', 0, '2021-01-05 19:56:37', '2021-01-20 19:56:42', 1);

-- ----------------------------
-- Table structure for t_register_team
-- ----------------------------
DROP TABLE IF EXISTS `t_register_team`;
CREATE TABLE `t_register_team`  (
  `register_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `competition_id` bigint(0) NULL DEFAULT NULL,
  `team_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队伍名字',
  `team_leader_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队长名字',
  `team_leader_phone` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队长电话',
  `team_leader_student_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队长id',
  `team_leader_wechat` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队长微信',
  `team_leader_college` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队长学院',
  `team_user_list` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队长的成员列表',
  `delete_status` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '逻辑删除。0表示为未删除 1表示删除',
  `register_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '报名时间',
  PRIMARY KEY (`register_id`) USING BTREE,
  INDEX `FK_Reference_3`(`competition_id`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`competition_id`) REFERENCES `t_competition_introduction` (`competition_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_register_team
-- ----------------------------

-- ----------------------------
-- Table structure for t_style_show
-- ----------------------------
DROP TABLE IF EXISTS `t_style_show`;
CREATE TABLE `t_style_show`  (
  `competition_id` bigint(0) NOT NULL COMMENT '比赛id，外键这个队伍是哪个比赛的',
  `show_id` bigint(0) NOT NULL COMMENT '展示id，主键',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `show_status` tinyint(1) NULL DEFAULT NULL COMMENT '如果是1表示展示前端，为0就是往期数据，不展示',
  `delete_status` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除 0表示没有删除，1表示删除',
  `show_order` int(0) NULL DEFAULT NULL COMMENT '展示的顺序，从小到大展示',
  `imgs` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片列表',
  `project_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `team_name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '队伍名字',
  `team_members` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '队伍成员[使用逗号拼接]',
  `team_begin_time` datetime(0) NOT NULL COMMENT '队伍开始时间',
  `team_end_time` datetime(0) NOT NULL COMMENT '队伍结束时间',
  `the_year` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第几届',
  PRIMARY KEY (`show_id`) USING BTREE,
  INDEX `FK_Reference_1`(`competition_id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`competition_id`) REFERENCES `t_competition_introduction` (`competition_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'ͼƬ?б???ֱ?Ӷ???ƴ?' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_style_show
-- ----------------------------

-- ----------------------------
-- Table structure for t_winner_team
-- ----------------------------
DROP TABLE IF EXISTS `t_winner_team`;
CREATE TABLE `t_winner_team`  (
  `team_id` bigint(0) NULL DEFAULT NULL,
  `team_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队伍名字',
  `team_user_list` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '队伍成员列表',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `the_year` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第几届',
  `team_begin_time` datetime(0) NULL DEFAULT NULL COMMENT '队伍开始时间',
  `team_end_time` datetime(0) NULL DEFAULT NULL COMMENT '队伍结束时间',
  `delete_status` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `competition_id` bigint(0) NULL DEFAULT NULL COMMENT '比赛ID',
  `team_order_num` int(0) NULL DEFAULT NULL COMMENT '表示几等奖【由数字开始，即1，主要用于排序】',
  `team_order_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示几等奖【由文本开始，即一等奖，主要用于展示】',
  INDEX `FK_Reference_2`(`competition_id`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`competition_id`) REFERENCES `t_competition_introduction` (`competition_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_winner_team
-- ----------------------------
INSERT INTO `t_winner_team` VALUES (1, '第一个队伍', '队员1，队员2，队员3', '2021-01-05 20:00:04', '2021-01-13 20:00:09', '1', '2020-01-01 20:00:19', '2021-01-17 20:00:34', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (2, '第二个队伍', '队员1，队员2，队员3', '2021-01-05 20:02:22', '2021-01-17 20:02:39', '1', '2020-01-17 20:03:01', '2020-01-17 20:03:07', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (3, '第三个队伍', '队员1，队员2，队员3', '2021-01-17 20:04:12', '2021-01-17 20:04:15', '1', '2020-01-01 20:04:22', '2020-01-17 20:04:34', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (4, '第四个队伍', '队员1，队员2，队员3', '2021-01-17 20:05:16', '2021-01-17 20:05:21', '1', '2020-01-17 20:05:29', '2020-01-17 20:05:35', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (5, '第五个队伍', '队员1，队员2，队员3', '2021-01-17 20:34:02', '2021-01-17 20:34:11', '2', '2021-12-01 20:35:10', '2021-12-17 20:35:19', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (6, '第六个队伍', '队员1，队员2，队员3', '2021-01-17 20:35:52', '2021-01-17 20:35:54', '2', '2021-12-17 20:36:01', '2021-12-17 20:36:08', 0, 1, 2, '二等奖');

SET FOREIGN_KEY_CHECKS = 1;
