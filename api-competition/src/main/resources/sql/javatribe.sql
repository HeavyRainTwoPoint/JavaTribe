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

 Date: 15/01/2021 18:48:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_competition_introduction
-- ----------------------------
DROP TABLE IF EXISTS `t_competition_introduction`;
CREATE TABLE `t_competition_introduction`
(
    `competition_id`   bigint(0) AUTO_INCREMENT  NOT NULL COMMENT '比赛id',
    `competition_name` varchar(60) NULL DEFAULT NULL COMMENT '比赛名字',
    `show_content`     varchar(3000) COMMENT '展示内容',
    `delete_status`    tinyint(1)  NULL DEFAULT NULL COMMENT '逻辑删除 0表示没有删除，1表示删除',
    `gmt_create`       datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `gmt_modified`     datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `sign_up`          int(0)      NULL DEFAULT NULL COMMENT '是否可以通过官网进行报名。0表示不可以，1表示可以',
    PRIMARY KEY (`competition_id`) USING BTREE
);

-- ----------------------------
-- Table structure for t_register_team
-- ----------------------------
DROP TABLE IF EXISTS `t_register_team`;
CREATE TABLE `t_register_team`
(
    `register_id`            bigint(0)   NOT NULL  AUTO_INCREMENT,
    `competition_id`         bigint(0)   NULL DEFAULT NULL,
    `team_name`              varchar(60)  NULL DEFAULT NULL COMMENT '队伍名字',
    `team_leader_name`       varchar(60)   NULL DEFAULT NULL COMMENT '队长电话',
    `team_leader_student_id` varchar(60)      NULL DEFAULT NULL COMMENT '队长id',
    `team_leader_wechat`     varchar(60)      NULL DEFAULT NULL COMMENT '队长微信',
    `team_leader_college`    varchar(60)      NULL DEFAULT NULL COMMENT '队长学院',
    `team_user_list`         varchar(180)    NULL DEFAULT NULL COMMENT '队长的成员列表',
    `delete_status`          int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '逻辑删除。0表示为未删除 1表示删除',
    `register_time`          datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '报名时间',
    PRIMARY KEY (`register_id`) USING BTREE,
    INDEX                    `FK_Reference_3`(`competition_id`) USING BTREE,
    CONSTRAINT `FK_Reference_3` FOREIGN KEY (`competition_id`) REFERENCES `t_competition_introduction` (`competition_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
;
-- ----------------------------
-- Table structure for t_style_show
-- ----------------------------
DROP TABLE IF EXISTS `t_style_show`;
CREATE TABLE `t_style_show`
(
    `competition_id`  bigint(0)   NOT NULL COMMENT '比赛id，外键这个队伍是哪个比赛的',
    `show_id`         bigint(0)   NOT NULL auto_increment COMMENT '展示id，主键',
    `gmt_create`      datetime(0) NULL DEFAULT NULL,
    `gmt_modified`    datetime(0) NULL DEFAULT NULL,
    `show_status`     tinyint(1)  NULL DEFAULT NULL COMMENT '如果是1表示展示前端，为0就是往期数据，不展示',
    `delete_status`   tinyint(1)  NULL DEFAULT NULL COMMENT '逻辑删除 0表示没有删除，1表示删除',
    `show_order`      int(0)      NULL DEFAULT NULL COMMENT '展示的顺序，从小到大展示',
    `imgs`            varchar(3000)  NOT NULL COMMENT '图片列表',
    `project_name`    varchar(60)  NOT NULL,
    `team_name`       varchar(80)   NOT NULL COMMENT '队伍名字',
    `team_members`    varchar(180)   NOT NULL COMMENT '队伍成员[使用逗号拼接]',
    `team_begin_time` datetime(0) NOT NULL COMMENT '队伍开始时间',
    `team_end_time`   datetime(0) NOT NULL COMMENT '队伍结束时间',
    `the_year`        varchar(60)   NOT NULL COMMENT '第几届',
    PRIMARY KEY (`show_id`) USING BTREE,
    INDEX             `FK_Reference_1`(`competition_id`) USING BTREE,
    CONSTRAINT `FK_Reference_1` FOREIGN KEY (`competition_id`) REFERENCES `t_competition_introduction` (`competition_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
;
-- ----------------------------
-- Table structure for t_winner_team
-- ----------------------------
DROP TABLE IF EXISTS `t_winner_team`;
CREATE TABLE `t_winner_team`
(
    `team_id`         bigint(0) auto_increment primary key   ,
    `team_name`       varchar(60)   NULL DEFAULT NULL COMMENT '队伍名字',
    `team_user_list`  varchar(180)    NULL DEFAULT NULL COMMENT '队伍成员列表',
    `gmt_create`      datetime(0) NULL DEFAULT NULL,
    `gmt_modified`    datetime(0) NULL DEFAULT NULL,
    `the_year`        varchar(60)  NULL DEFAULT NULL COMMENT '第几届',
    `team_begin_time` datetime(0) NULL DEFAULT NULL COMMENT '队伍开始时间',
    `team_end_time`   datetime(0) NULL DEFAULT NULL COMMENT '队伍结束时间',
    `delete_status`   tinyint(1)  NULL DEFAULT NULL COMMENT '逻辑删除',
    `competition_id`  bigint(0)   NULL DEFAULT NULL COMMENT '比赛ID',
    `team_order`      int(0)      NULL DEFAULT NULL COMMENT '表示几等奖【从1开始】',
    INDEX             `FK_Reference_2`(`competition_id`) USING BTREE,
    CONSTRAINT `FK_Reference_2` FOREIGN KEY (`competition_id`) REFERENCES `t_competition_introduction` (`competition_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)  ;

SET FOREIGN_KEY_CHECKS = 1;
