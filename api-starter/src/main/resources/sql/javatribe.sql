/*
 Navicat Premium Data Transfer

 Source Server         : new_javatribe
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 106.52.5.184:3308
 Source Schema         : javatribe

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 28/03/2022 19:01:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enroll_direction
-- ----------------------------
DROP TABLE IF EXISTS `enroll_direction`;
CREATE TABLE `enroll_direction`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `direction_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方向图标',
  `direction_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方向名称',
  `direction_code` int(0) NULL DEFAULT NULL COMMENT '方向代号（1 前端 2 后端 3 设计 4算法 5产品 6安卓）',
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `delete_mark` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `enroll_direction_idx1`(`direction_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部落方向表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enroll_direction
-- ----------------------------
INSERT INTO `enroll_direction` VALUES (1, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151646088860.png', '前端组', 1, '2021-02-27 22:24:01', '2021-04-15 16:46:09', 0);
INSERT INTO `enroll_direction` VALUES (2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/2021041516462055.png', '后端组', 2, '2021-02-27 22:24:02', '2021-04-15 16:46:22', 0);
INSERT INTO `enroll_direction` VALUES (3, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151646366488.png', '设计组', 3, '2021-02-27 22:24:02', '2021-04-15 16:46:37', 0);
INSERT INTO `enroll_direction` VALUES (4, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151646488801.png', '算法组', 4, '2021-02-27 22:24:02', '2021-04-15 16:46:50', 0);
INSERT INTO `enroll_direction` VALUES (5, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151646599945.png', '产品组', 5, '2021-02-27 22:24:02', '2021-04-15 16:47:01', 0);
INSERT INTO `enroll_direction` VALUES (6, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151647155376.png', '安卓组', 6, '2021-02-27 22:24:02', '2021-04-15 16:47:16', 0);
INSERT INTO `enroll_direction` VALUES (43, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104021929166239.png', 'python组', 7, '2021-04-02 19:29:17', '2021-04-02 19:29:17', 1);

-- ----------------------------
-- Table structure for enroll_notice
-- ----------------------------
DROP TABLE IF EXISTS `enroll_notice`;
CREATE TABLE `enroll_notice`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `direction_code` int(0) NOT NULL DEFAULT 1 COMMENT '方向代号',
  `delete_mark` int(0) NOT NULL DEFAULT 0,
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '招新通知' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enroll_notice
-- ----------------------------
INSERT INTO `enroll_notice` VALUES (85, '2020招新', 'https://mp.weixin.qq.com/s/Fq8j6RoZf4eUkFyU7kWtuw', 1, 0, '2020-10-06 11:01:45', '2020-12-08 11:01:45');
INSERT INTO `enroll_notice` VALUES (86, '2021招新', 'https://mp.weixin.qq.com/s/5D65qYREKgca7aOnh7sniA', 1, 0, '2021-04-02 11:02:09', '2021-04-02 11:02:09');

-- ----------------------------
-- Table structure for enroll_test
-- ----------------------------
DROP TABLE IF EXISTS `enroll_test`;
CREATE TABLE `enroll_test`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考核名称（用户上传的文件的名称）',
  `direction_code` int(0) NOT NULL DEFAULT 1 COMMENT '方向代号（参照方向表）',
  `ownner_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提交人的姓名',
  `file_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '考核提交的文件url',
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `delete_mark` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考核提交上传表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enroll_test
-- ----------------------------
INSERT INTO `enroll_test` VALUES (85, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/2021041518051056_20软工-1班-小爪.rar', '2021-04-15 18:05:10', '2021-04-15 18:05:10', 0);
INSERT INTO `enroll_test` VALUES (86, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151808211626_20软工-1班-小爪.rar', '2021-04-15 18:08:21', '2021-04-15 18:08:21', 0);
INSERT INTO `enroll_test` VALUES (87, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151812499366_20软工-1班-小爪.rar', '2021-04-15 18:12:49', '2021-04-15 18:12:49', 0);
INSERT INTO `enroll_test` VALUES (88, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151818033860_20软工-1班-小爪.rar', '2021-04-15 18:18:04', '2021-04-15 18:18:04', 0);
INSERT INTO `enroll_test` VALUES (89, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151827244173_20软工-1班-小爪.rar', '2021-04-15 18:27:24', '2021-04-15 18:27:24', 0);
INSERT INTO `enroll_test` VALUES (90, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151828233173_20软工-1班-小爪.rar', '2021-04-15 18:28:23', '2021-04-15 18:28:23', 0);
INSERT INTO `enroll_test` VALUES (91, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151829322516_20软工-1班-小爪.rar', '2021-04-15 18:29:32', '2021-04-15 18:29:32', 0);
INSERT INTO `enroll_test` VALUES (92, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151829333579_20软工-1班-小爪.rar', '2021-04-15 18:29:33', '2021-04-15 18:29:33', 0);
INSERT INTO `enroll_test` VALUES (93, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/20210415183120588_20软工-1班-小爪.rar', '2021-04-15 18:31:20', '2021-04-15 18:31:20', 0);
INSERT INTO `enroll_test` VALUES (94, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161019366845_20软工-1班-小爪.rar', '2021-04-16 10:19:36', '2021-04-16 10:19:36', 0);
INSERT INTO `enroll_test` VALUES (95, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161025022040_20软工-1班-小爪.rar', '2021-04-16 10:25:02', '2021-04-16 10:25:02', 0);
INSERT INTO `enroll_test` VALUES (96, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161033066630_20软工-1班-小爪.rar', '2021-04-16 10:33:06', '2021-04-16 10:33:06', 0);
INSERT INTO `enroll_test` VALUES (97, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161038088997_20软工-1班-小爪.rar', '2021-04-16 10:38:09', '2021-04-16 10:38:09', 0);
INSERT INTO `enroll_test` VALUES (98, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161038599878_20软工-1班-小爪.rar', '2021-04-16 10:39:00', '2021-04-16 10:39:00', 0);
INSERT INTO `enroll_test` VALUES (99, '20软工-1班-小爪.rar', 1, '小爪.rar', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161040399932_20软工-1班-小爪.rar', '2021-04-16 10:40:40', '2021-04-16 10:40:40', 0);
INSERT INTO `enroll_test` VALUES (100, '20计科-1班-张三.zip', 1, '张三.zip', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104172024022783_20计科-1班-张三.zip', '2021-04-17 20:24:08', '2021-04-17 20:24:08', 0);
INSERT INTO `enroll_test` VALUES (101, '20计科-2班-冯远安.zip', 1, '冯远安.zip', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105260000433547_20计科-2班-冯远安.zip', '2021-05-26 00:01:29', '2021-05-26 00:01:29', 0);

-- ----------------------------
-- Table structure for file_manager
-- ----------------------------
DROP TABLE IF EXISTS `file_manager`;
CREATE TABLE `file_manager`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `file_name` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文件名',
  `conten_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件contenType',
  `file_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文件地址',
  `file_type` int(0) NULL DEFAULT 1 COMMENT '文件类型（1 图片， 2 压缩包）',
  `uploader` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传者',
  `download_count` int(0) NOT NULL DEFAULT 0 COMMENT '下载次数',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `delete_mark` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传下载表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_manager
-- ----------------------------
INSERT INTO `file_manager` VALUES (84, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151812499366_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-15 18:12:49', '2021-04-15 18:12:49', 0);
INSERT INTO `file_manager` VALUES (85, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151818033860_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-15 18:18:04', '2021-04-15 18:18:04', 0);
INSERT INTO `file_manager` VALUES (86, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151827244173_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-15 18:27:24', '2021-04-15 18:27:24', 0);
INSERT INTO `file_manager` VALUES (87, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151828233173_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-15 18:28:23', '2021-04-15 18:28:23', 0);
INSERT INTO `file_manager` VALUES (88, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151829322516_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-15 18:29:32', '2021-04-15 18:29:32', 0);
INSERT INTO `file_manager` VALUES (89, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104151829333579_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-15 18:29:33', '2021-04-15 18:29:33', 0);
INSERT INTO `file_manager` VALUES (90, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/20210415183120588_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-15 18:31:20', '2021-04-15 18:31:20', 0);
INSERT INTO `file_manager` VALUES (91, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161019366845_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-16 10:19:36', '2021-04-16 10:19:36', 0);
INSERT INTO `file_manager` VALUES (92, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161025022040_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-16 10:25:02', '2021-04-16 10:25:02', 0);
INSERT INTO `file_manager` VALUES (93, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161033066630_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-16 10:33:06', '2021-04-16 10:33:06', 0);
INSERT INTO `file_manager` VALUES (94, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161038088997_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-16 10:38:09', '2021-04-16 10:38:09', 0);
INSERT INTO `file_manager` VALUES (95, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161038599878_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-16 10:39:00', '2021-04-16 10:39:00', 0);
INSERT INTO `file_manager` VALUES (96, '20软工-1班-小爪.rar', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104161040399932_20软工-1班-小爪.rar', 2, '小爪.rar', 0, '2021-04-16 10:40:40', '2021-04-16 10:40:40', 0);
INSERT INTO `file_manager` VALUES (97, '20计科-1班-张三.zip', 'application/x-zip-compressed', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104172024022783_20计科-1班-张三.zip', 2, '张三.zip', 0, '2021-04-17 20:24:08', '2021-04-17 20:24:08', 0);
INSERT INTO `file_manager` VALUES (98, '2021爪哇部落后端第二次考核 .docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181153466766_2021爪哇部落后端第二次考核 .docx', 2, 'default', 0, '2021-04-18 11:53:49', '2021-04-18 11:53:49', 0);
INSERT INTO `file_manager` VALUES (99, '爪哇部落设计组第二次考核作业(3).docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181156055329_爪哇部落设计组第二次考核作业(3).docx', 2, 'default', 0, '2021-04-18 11:56:08', '2021-04-18 11:56:08', 0);
INSERT INTO `file_manager` VALUES (100, '2021爪哇部落后端第二次考核 .docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181156588165_2021爪哇部落后端第二次考核 .docx', 2, 'default', 0, '2021-04-18 11:57:01', '2021-04-18 11:57:01', 0);
INSERT INTO `file_manager` VALUES (101, '算法组第二次考核作业.docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181157377396_算法组第二次考核作业.docx', 2, 'default', 0, '2021-04-18 11:57:37', '2021-04-18 11:57:37', 0);
INSERT INTO `file_manager` VALUES (102, '产品组第二次考核(1).docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181158177748_产品组第二次考核(1).docx', 2, 'default', 0, '2021-04-18 11:58:18', '2021-04-18 11:58:18', 0);
INSERT INTO `file_manager` VALUES (103, '安卓第二轮考核.docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181158588183_安卓第二轮考核.docx', 2, 'default', 0, '2021-04-18 11:58:58', '2021-04-18 11:58:58', 0);
INSERT INTO `file_manager` VALUES (104, '前端第一次考核问题.docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/20210418120020500_前端第一次考核问题.docx', 2, 'default', 0, '2021-04-18 12:00:22', '2021-04-18 12:00:22', 0);
INSERT INTO `file_manager` VALUES (105, '2021爪哇部落后端第三次考核作业.docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105110805299404_2021爪哇部落后端第三次考核作业.docx', 2, 'default', 0, '2021-05-11 08:05:33', '2021-05-11 08:05:33', 0);
INSERT INTO `file_manager` VALUES (106, '2021爪哇部落设计组第三次考核作业.docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105110806044774_2021爪哇部落设计组第三次考核作业.docx', 2, 'default', 0, '2021-05-11 08:06:05', '2021-05-11 08:06:05', 0);
INSERT INTO `file_manager` VALUES (107, '2021爪哇部落产品组第三次考核.docx', 'application/octet-stream', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105110806444720_2021爪哇部落产品组第三次考核.docx', 2, 'default', 0, '2021-05-11 08:06:44', '2021-05-11 08:06:44', 0);
INSERT INTO `file_manager` VALUES (108, '互联网学院教师通讯录19.09.xls', 'application/vnd.ms-excel', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105111219088200_互联网学院教师通讯录19.09.xls', 2, 'default', 0, '2021-05-11 12:19:08', '2021-05-11 12:19:08', 0);
INSERT INTO `file_manager` VALUES (109, '互联网学院教师通讯录19.09.xls', 'application/vnd.ms-excel', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105111247366138_互联网学院教师通讯录19.09.xls', 2, 'default', 0, '2021-05-11 12:47:36', '2021-05-11 12:47:36', 0);
INSERT INTO `file_manager` VALUES (110, '爪哇部落前端第三次考核2021.05.09.zip', 'application/x-zip-compressed', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105111244499927_爪哇部落前端第三次考核2021.05.09.zip', 2, 'default', 0, '2021-05-11 12:51:46', '2021-05-11 12:51:46', 0);
INSERT INTO `file_manager` VALUES (111, '181549135-丘炳辉-统一建模语言课程设计.docx', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105111254155886_181549135-丘炳辉-统一建模语言课程设计.docx', 2, 'default', 0, '2021-05-11 12:54:56', '2021-05-11 12:54:56', 0);
INSERT INTO `file_manager` VALUES (112, '20计科-2班-冯远安.zip', 'application/x-zip-compressed', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105260000433547_20计科-2班-冯远安.zip', 2, '冯远安.zip', 0, '2021-05-26 00:01:29', '2021-05-26 00:01:29', 0);

-- ----------------------------
-- Table structure for number_of_sessions
-- ----------------------------
DROP TABLE IF EXISTS `number_of_sessions`;
CREATE TABLE `number_of_sessions`  (
  `year_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `the_year` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '表示第几届',
  `delete_status` tinyint(0) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除',
  `active_status` int(0) NULL DEFAULT NULL COMMENT '表示 在部落官网前端是否展示，0 不展示，1 就展示',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `year_start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `year_end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `competition_id` int(0) NOT NULL COMMENT '比赛 ID',
  PRIMARY KEY (`year_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of number_of_sessions
-- ----------------------------
INSERT INTO `number_of_sessions` VALUES (1, '第一届', 0, 1, '2021-03-29 15:37:51', '2021-03-29 15:37:51', '2015-01-17 00:00:00', '2015-04-18 00:00:00', 1);
INSERT INTO `number_of_sessions` VALUES (2, '第二届', 0, 1, '2021-03-29 15:38:07', '2021-03-29 15:38:07', '2016-01-17 00:00:00', '2016-04-18 00:00:00', 1);

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity`  (
  `act_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `act_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `act_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `act_imgURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片地址',
  `act_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '活动时间',
  `priority` int(0) UNSIGNED NOT NULL COMMENT '优先级',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(0) NOT NULL DEFAULT 0 COMMENT '逻辑删',
  PRIMARY KEY (`act_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES (1, '部落生活', '部落生活', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/123.jpg', '2021-03-07 01:10:00', 2, '2020-12-29 21:20:19', '2021-03-07 01:12:33', 0);
INSERT INTO `t_activity` VALUES (11, '部落小生活', '部落生活', '部落生活,部落生活', '2021-03-07 00:52:26', 3, '2021-03-07 01:08:14', '2021-03-07 01:08:14', 1);
INSERT INTO `t_activity` VALUES (12, '部落生活', '部落生活', 'http://47.114.124.157/test.jpg', '2021-03-07 00:52:26', 4, '2021-03-07 19:48:07', '2021-03-13 10:53:06', 1);
INSERT INTO `t_activity` VALUES (13, '部落', '部落生活', '部落生活图片,部落生活图片', '2021-03-18 11:43:28', 5, '2021-03-18 11:43:28', '2021-03-18 11:43:28', 1);
INSERT INTO `t_activity` VALUES (14, '部落1', '部落生活', '部落生活图片,部落生活图片', '2021-03-07 00:52:26', 6, '2021-03-18 11:46:47', '2021-03-18 11:46:47', 1);
INSERT INTO `t_activity` VALUES (15, '测试', 'content他', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104061043066324.jpg', '2021-04-06 10:43:07', 7, '2021-04-06 10:43:07', '2021-04-06 10:43:07', 1);
INSERT INTO `t_activity` VALUES (16, '部落聚餐', '大家一起恰饭~', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104131234199891.jpg', '2021-04-13 12:35:00', 8, '2021-04-13 12:35:00', '2021-04-13 12:35:00', 0);
INSERT INTO `t_activity` VALUES (17, '算法比赛', '部落的算法成员在一起打比赛', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104131238399919.jpg', '2021-04-13 12:38:44', 9, '2021-04-13 12:38:44', '2021-04-13 12:38:44', 0);
INSERT INTO `t_activity` VALUES (18, '爪哇部落成立了', '今天是部落成立的日子', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161337544682.jpg', '2021-04-16 13:37:55', 10, '2021-04-16 13:37:55', '2021-04-16 13:37:55', 0);
INSERT INTO `t_activity` VALUES (19, '部落壮大了', '加入的人越来越多', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161357311838.JPG', '2021-04-16 13:57:33', 11, '2021-04-16 13:57:33', '2021-04-16 13:57:33', 0);
INSERT INTO `t_activity` VALUES (20, '部落开会', '大家一起讨论学到的知识，其乐融融', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161358399519.JPG', '2021-04-16 13:58:40', 12, '2021-04-16 13:58:40', '2021-04-16 13:58:40', 0);
INSERT INTO `t_activity` VALUES (21, '项目讨论', '师兄师姐们讨论项目的内容和问题', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161359266621.jpg', '2021-04-16 13:59:28', 13, '2021-04-16 13:59:28', '2021-04-16 13:59:28', 0);

-- ----------------------------
-- Table structure for t_art_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_art_tag`;
CREATE TABLE `t_art_tag`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `art_id` int(0) NOT NULL COMMENT '文章id',
  `tag_id` int(0) NOT NULL COMMENT '标签id',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `delete_status` int(0) NULL DEFAULT 0 COMMENT '逻辑删，0表示可用，1表示删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_art_tag
-- ----------------------------
INSERT INTO `t_art_tag` VALUES (1, 1, 7, '2021-04-16 13:10:39', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (2, 1, 1, '2021-04-16 13:10:39', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (3, 2, 8, '2021-04-16 13:37:36', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (4, 2, 2, '2021-04-16 13:37:36', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (5, 3, 9, '2021-04-16 13:57:05', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (6, 3, 4, '2021-04-16 13:57:05', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (7, 4, 10, '2021-04-16 14:01:08', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (8, 4, 5, '2021-04-16 14:01:08', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (9, 5, 11, '2021-04-16 14:12:53', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (10, 5, 3, '2021-04-16 14:12:53', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (11, 6, 12, '2021-04-16 14:15:24', '2021-04-16 13:10:39', 0);
INSERT INTO `t_art_tag` VALUES (12, 6, 6, '2021-04-16 14:15:24', '2021-04-16 13:10:39', 0);

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `art_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章id，自增主键',
  `art_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `art_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章正文内容',
  `art_summary` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章摘要',
  `art_viewcount` int(0) NULL DEFAULT 0 COMMENT '阅读数量',
  `art_tag_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '文章的一级标签',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `delete_status` int(0) NULL DEFAULT 0 COMMENT '逻辑删，0表示可用，1表示禁用',
  `art_no` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  PRIMARY KEY (`art_id`, `art_no`) USING BTREE,
  INDEX `art_title`(`art_title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES (1, 'js获取当前代码行号', '<p><font color=\'red\' size=5>声明：前面是需求的来源和详解，想看最后效果的可以直接翻到最后面</font></p>\n<ul>\n<li><a href=\"#%E4%B8%BA%E4%BB%80%E4%B9%88%E4%BC%9A%E9%9C%80%E8%A6%81%E8%8E%B7%E5%8F%96%E4%BB%A3%E7%A0%81%E7%9A%84%E8%A1%8C%E5%8F%B7\">为什么会需要获取代码的行号？</a></li>\n<li><a href=\"#%E5%A6%82%E4%BD%95%E8%8E%B7%E5%8F%96%E4%BB%A3%E7%A0%81%E7%9A%84%E8%A1%8C%E5%8F%B7\">如何获取代码的行号？</a></li>\n<li><a href=\"#%E6%9C%80%E7%BB%88%E6%95%88%E6%9E%9C\">最终效果</a></li>\n</ul>\n<h5><a id=\"_6\"></a>为什么会需要获取代码的行号？</h5>\n<p>在我们开发项目的过程中，有些地方可能理论上是没有问题的，但是为了以防万一，还是加了一个判断用来预防。<br />\n例如：</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">2</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f1();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        <span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-string\">\'出bug了\'</span>);\n    }\n}\nf2();\n</code></div></pre>\n<p>上述代码中，f1函数在一些情况下会返回数字1一些情况下会返回或数字2(当然上面的代码就只是用一个随机数模拟一下这个情景)，f2函数知道f1函数只会返回1或者2，于是用if-else判断f1函数返回的是1还是2，并做一些处理，如果二者都不是，则打印一下出bug了，这样在调试的时候我们看到了控制台打印了’出bug了’之后就会知道这里出了问题。</p>\n<p>现在假设我们在后来某一次改bug或者加需求的时候改了一下f1函数：</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161303555841.png\" alt=\"1.png\" alt=\"1\" style=\"zoom:60%;\" /><br />\n现在f1函数的返回值就不止是1或2了，也就是f1函数被我们改的逻辑错了，但是我们并没有意识到，于是我们在调试的时候，偶然的发现控制台里打印了’出bug了’</p>\n<p>而且还贴心的的告诉了我们这个’出bug了’是哪行代码打印的，然后看了那行代码之后，我们就知道我们在之前某次的改动中把f1函数给改出bug了，于是我们就会去修复这个bug。</p>\n<p>但是上面这种情况是我们运气好看到了控制台打印了这个，如果我们调试的时候没在看控制台，而是在观察其它的东西（比如在看Network或者是页面中的变化啥的），这样的话我们可能就不能第一时间知道这个地方出bug了，而是好久之后才发现，这样就会降低我们调试的效率。</p>\n<p>所以我们为了能够第一时间知道哪里有bug，可以把<code>console.log</code>换成<code>alert</code>。</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f1();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'出bug了\'</span>);\n    }\n}\n</code></div></pre>\n<p>这样如果f1函数出现了问题的话，会直接在页面上弹一下，比较的显眼，就可以第一时间发现问题从而去解决问题。<br />\n<img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/20210416130420939.png\" alt=\"2.png\" style=\"zoom:42%;\"/></p>\n<p>这样我们就可以第一时间发现问题了，于是我们会去代码里找是哪行代码<code>alert</code>的这个，从而去修复这个bug<br />\n但是新的问题出现了，如果这种不确定的bug比较多的话</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f1();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'出bug了\'</span>);\n    }\n}\nf2();\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f3</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f4</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f3();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'出bug了\'</span>);\n    }\n}\nf4();\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f5</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f6</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f5();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'出bug了\'</span>);\n    }\n}\nf6();\n</code></div></pre>\n<p>这样当页面<code>alert</code>出bug了之后我们就不知道到底是哪里的代码<code>alert</code>的了<br />\n于是我们可能这样做</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f1();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第12行代码处出bug了\'</span>);\n    }\n}\nf2();\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f3</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f4</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f3();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第27行代码处出bug了\'</span>);\n    }\n}\nf4();\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f5</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f6</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f5();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第42行代码处出bug了\'</span>);\n    }\n}\nf6();\n</code></div></pre>\n<p>这样再<code>alert</code>的时候我们就知道是哪行<code>alert</code>的了<br />\n不过这样还是有一个问题，如果我们在这写代码上面的代码做了一些修改的话</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f1();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第12行代码处出bug了\'</span>);\n    }\n}\nf2();\n<span class=\"hljs-comment\">// 这里加了一点代码 --------------</span>\n<span class=\"hljs-keyword\">let</span> a = <span class=\"hljs-number\">1</span>;\n<span class=\"hljs-comment\">// ----------------</span>\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f3</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f4</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f3();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第27行代码处出bug了\'</span>);\n    }\n}\nf4();\n<span class=\"hljs-comment\">// 这里加了亿点代码 --------------</span>\n<span class=\"hljs-keyword\">let</span> sum = <span class=\"hljs-number\">0</span>;\n<span class=\"hljs-keyword\">for</span> (<span class=\"hljs-keyword\">let</span> i = <span class=\"hljs-number\">1</span>; i &lt;= <span class=\"hljs-number\">100</span>; i++) {\n    sum += i;\n}\n<span class=\"hljs-built_in\">console</span>.log(sum);\n<span class=\"hljs-keyword\">const</span> html = <span class=\"hljs-built_in\">document</span>.documentElement;\n<span class=\"hljs-keyword\">const</span> body = html.children[<span class=\"hljs-number\">1</span>];\nbody.style.backgroundColor = <span class=\"hljs-string\">\'pink\'</span>;\n<span class=\"hljs-keyword\">let</span> div = <span class=\"hljs-built_in\">document</span>.createElement(<span class=\"hljs-string\">\'div\'</span>);\ndiv.innerText = <span class=\"hljs-string\">\'hello bug\'</span>;\nbody.appendChild(div);\n<span class=\"hljs-comment\">// ----------------</span>\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f5</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f6</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f5();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第42行代码处出bug了\'</span>);\n    }\n}\nf6();\n</code></div></pre>\n<p>这些<code>alert</code>语句所在的行数就会发生改变，如果改动的不多的话还好，最后也会在附近<br />\n<img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161304544808.png\" alt=\"3.png\" style=\"zoom:42%;\"/><br />\n但是改动比较多的话就不太好找了，这样就不利于我们去找bug<br />\n<img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161305166911.png\" alt=\"4.png\" style=\"zoom:42%;\"/><br />\n既然这样，那么为了防止<code>alert</code>窜行，我们可以在程序里先获取一下当前alert代码所在的行号，然后再alert出来<br />\n于是我去在网上搜了一波，但是也没搜到js能获取行号的内置函数<br />\n既然没有自带的，那我们就自己写一个吧哈哈哈</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">getRow</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-comment\">// 当前行数</span>\n}\n</code></div></pre>\n<p>假设我们如果写好了一个这样功能的函数，那么之前的代码就可以改成这样，就可以解决我们的问题了：</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f1();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第1\'</span> + getRow() + <span class=\"hljs-string\">\'行代码处出bug了\'</span>);\n    }\n}\nf2();\n<span class=\"hljs-comment\">// 这里加了一点代码 --------------</span>\n<span class=\"hljs-keyword\">let</span> a = <span class=\"hljs-number\">1</span>;\n<span class=\"hljs-comment\">// ----------------</span>\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f3</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f4</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f3();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第\'</span> + getRow() + <span class=\"hljs-string\">\'行代码处出bug了\'</span>);\n    }\n}\nf4();\n<span class=\"hljs-comment\">// 这里加了亿点代码 --------------</span>\n<span class=\"hljs-keyword\">let</span> sum = <span class=\"hljs-number\">0</span>;\n<span class=\"hljs-keyword\">for</span> (<span class=\"hljs-keyword\">let</span> i = <span class=\"hljs-number\">1</span>; i &lt;= <span class=\"hljs-number\">100</span>; i++) {\n    sum += i;\n}\n<span class=\"hljs-built_in\">console</span>.log(sum);\n<span class=\"hljs-keyword\">const</span> html = <span class=\"hljs-built_in\">document</span>.documentElement;\n<span class=\"hljs-keyword\">const</span> body = html.children[<span class=\"hljs-number\">1</span>];\nbody.style.backgroundColor = <span class=\"hljs-string\">\'pink\'</span>;\n<span class=\"hljs-keyword\">let</span> div = <span class=\"hljs-built_in\">document</span>.createElement(<span class=\"hljs-string\">\'div\'</span>);\ndiv.innerText = <span class=\"hljs-string\">\'hello bug\'</span>;\nbody.appendChild(div);\n<span class=\"hljs-comment\">// ----------------</span>\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f5</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f6</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> x = f5();\n    <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {\n        <span class=\"hljs-comment\">// 如果是1，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {\n        <span class=\"hljs-comment\">// 如果是2，则进行一些操作</span>\n    } <span class=\"hljs-keyword\">else</span> {\n        <span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span>\n        alert(<span class=\"hljs-string\">\'第\'</span> + getRow() + <span class=\"hljs-string\">\'行代码处出bug了\'</span>);\n    }\n}\nf6();\n</code></div></pre>\n<p>那么本文的核心来了，要如何获取行号呢</p>\n<h5><a id=\"_315\"></a>如何获取代码的行号？</h5>\n<p>首先，先来回忆一下，我们都在什么地方见到过代码行号<br />\n首先，上文中提到的<code>console.log()</code>在将内容打印到控制台的时候，在右侧会显示是哪行打印的，这里就出现了一个行号，但是<code>console.log()</code>这个东西它的内部比较高深，目前已咱这个水平也研究不明白<br />\n那么就需要再想想哪里还出现过行号</p>\n<p>还记不记得，每次当代码报错的时候，都会显示是哪行代码报的错，这里也出现了行号！</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">throw</span> <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>(<span class=\"hljs-string\">\'错误原因\'</span>);\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161305388562.png\" alt=\"5.png\" style=\"zoom:42%;\"/><br />\n既然这个异常对象里面有报错的代码的行数，那我们就好好研究一下这个<code>Error</code>吧</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>(<span class=\"hljs-string\">\'错误原因\'</span>));\n</code></div></pre>\n<p>如果我们直接将这个异常对象打印出来的话，是这样的<br />\n<img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161306222323.png\" alt=\"6.png\" style=\"zoom:42%;\"/><br />\n既然这样，我们就可以分割一下字符串，从而获取到这个行号1，记得要先转化成字符串，这里我是通过冒号分割的</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-built_in\">console</span>.log((<span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>(<span class=\"hljs-string\">\'错误原因\'</span>) + <span class=\"hljs-string\">\'\'</span>).split(<span class=\"hljs-string\">\':\'</span>));\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161306433533.png\" alt=\"7.png\" style=\"zoom:42%;\"/><br />\nemmm看样子好像不太行，异常对象转化成字符串之后和在<code>console.log</code>里打印的东西不太一样，可能是以为内部有什么转换机制吧，不太清楚<br />\n那么……就要另寻他路<br />\n我们先用浏览器看看异常对象里都有啥吧<br />\n<img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161307322980.png\" alt=\"8.png\"  style=\"zoom:42%;\"/><br />\nemmm根据观察<br />\n首先<code>constructor</code>是构造函数，应该没啥用<br />\n然后<code>message</code>应该是异常的信息，就是我们new的时候传进去的那个<br />\n<code>name</code>应该是这个异常的类型的名字，也用处不大<br />\n<code>toString()</code>就不用说了，刚刚上面转化成字符串的时候内部调用的就是这个函数<br />\n那么就剩一个<code>stack</code>了<br />\n那么我们看看这是啥</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>().stack);\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>().stack);\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161307499536.png\" alt=\"9.png\" style=\"zoom:42%;\"/><br />\n很好，这里面有行号，而且它还是个字符串，这不就正是我们需要的东西吗<br />\n那么我们就来利用一下它</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">let</span> e = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>();\n<span class=\"hljs-built_in\">console</span>.log(e.stack);\n<span class=\"hljs-built_in\">console</span>.log(e.stack.split(<span class=\"hljs-string\">\':\'</span>));\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161308022070.png\" alt=\"10.png\" style=\"zoom:42%;\"/><br />\n那么数组里索引为3的元素就是我们要的行号1了<br />\n把它取出来</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">let</span> e = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>();\n<span class=\"hljs-comment\">// console.log(e.stack);</span>\n<span class=\"hljs-built_in\">console</span>.log(e.stack.split(<span class=\"hljs-string\">\':\'</span>)[<span class=\"hljs-number\">3</span>]);\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161308133680.png\" alt=\"11.png\" style=\"zoom:42%;\"/><br />\n那么我们只要在<code>getRow</code>函数中返回这个就可以了</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">getRow</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> e = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>();\n    <span class=\"hljs-comment\">// console.log(e.stack);</span>\n    <span class=\"hljs-keyword\">return</span> e.stack.split(<span class=\"hljs-string\">\':\'</span>)[<span class=\"hljs-number\">3</span>];\n}\n<span class=\"hljs-built_in\">console</span>.log(getRow());\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/20210416130830415.png\" alt=\"12.png\" style=\"zoom:42%;\"/><br />\n好像不太对，我们需要的应该是调用<code>getRow</code>函数的那一行的行号也就是6，但是返回的是创建异常对象的行号2<br />\n不难发现，异常对象中还会记录函数的调用的行号<br />\n那么我们再做个实验</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">getRow</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> e = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>();\n    <span class=\"hljs-built_in\">console</span>.log(e.stack);\n    <span class=\"hljs-built_in\">console</span>.log(e.stack.split(<span class=\"hljs-string\">\':\'</span>));\n    <span class=\"hljs-comment\">// return e.stack.split(\':\')[3];</span>\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-built_in\">console</span>.log(getRow());\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{\n    f1();\n}\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f3</span>(<span class=\"hljs-params\"></span>) </span>{\n    f2();\n}\nf3();\nf2();\n<span class=\"hljs-built_in\">console</span>.log(getRow());\n</code></div></pre>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161308411190.png\" alt=\"13.png\" style=\"zoom:42%;\"/><br />\n异常对象会把层层调用的函数的行号都记录下来，我们需要的是调用<code>getRow</code>函数的行号，也就是第二层的调用，也就是分割后的数组的索引为7的那个元素</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">getRow</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">let</span> e = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>();\n    <span class=\"hljs-keyword\">return</span> e.stack.split(<span class=\"hljs-string\">\':\'</span>)[<span class=\"hljs-number\">7</span>];\n}\n<p><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{<br />\n<span class=\"hljs-built_in\">console</span>.log(getRow());<br />\n}<br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{<br />\nf1();<br />\n}<br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f3</span>(<span class=\"hljs-params\"></span>) </span>{<br />\nf2();<br />\n}<br />\nf3();</p>\n<p><span class=\"hljs-built_in\">console</span>.log(getRow());<br />\n</code></div></pre></p>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161308544644.png\" alt=\"14.png\" style=\"zoom:42%;\"/><br />\n现在我们的<code>getRow</code>函数就可以成功且准确的获取到代码的行号了！！！</p>\n<p>考虑到以后或许可能还会用需要用这个行号计算（虽然这个几乎不可能，应该不会用需要用行号计算的需求吧，我觉得我这个获取行号的需求已经挺奇葩的了哈哈哈），所以返回的时候也可以转化成数值型</p>\n<h5><a id=\"_449\"></a>最终效果</h5>\n<p>那么最终的效果就是这样啦：</p>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-comment\">/**\n * 函数功能：获取代码行号\n * \n * @returns 返回函数调用处的代码行号\n * @author 60rzvvbj\n */</span>\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">getRow</span>(<span class=\"hljs-params\"></span>) </span>{\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Error</span>().stack.split(<span class=\"hljs-string\">\':\'</span>)[<span class=\"hljs-number\">7</span>]);\n}\n<p><span class=\"hljs-comment\">// 用之前的代码测试一下</span><br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>) </span>{<br />\n<span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);<br />\n}<br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f2</span>(<span class=\"hljs-params\"></span>) </span>{<br />\n<span class=\"hljs-keyword\">let</span> x = f1();<br />\n<span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {<br />\n<span class=\"hljs-comment\">// 如果是1，则进行一些操作</span><br />\n} <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {<br />\n<span class=\"hljs-comment\">// 如果是2，则进行一些操作</span><br />\n} <span class=\"hljs-keyword\">else</span> {<br />\n<span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span><br />\nalert(<span class=\"hljs-string\">‘第’</span> + getRow() + <span class=\"hljs-string\">‘行代码处出bug了’</span>);<br />\n}<br />\n}<br />\nf2();<br />\n<span class=\"hljs-comment\">// 这里加了一点代码 --------------</span><br />\n<span class=\"hljs-keyword\">let</span> a = <span class=\"hljs-number\">1</span>;<br />\n<span class=\"hljs-comment\">// ----------------</span><br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f3</span>(<span class=\"hljs-params\"></span>) </span>{<br />\n<span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);<br />\n}<br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f4</span>(<span class=\"hljs-params\"></span>) </span>{<br />\n<span class=\"hljs-keyword\">let</span> x = f3();<br />\n<span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {<br />\n<span class=\"hljs-comment\">// 如果是1，则进行一些操作</span><br />\n} <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {<br />\n<span class=\"hljs-comment\">// 如果是2，则进行一些操作</span><br />\n} <span class=\"hljs-keyword\">else</span> {<br />\n<span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span><br />\nalert(<span class=\"hljs-string\">‘第’</span> + getRow() + <span class=\"hljs-string\">‘行代码处出bug了’</span>);<br />\n}<br />\n}<br />\nf4();<br />\n<span class=\"hljs-comment\">// 这里加了亿点代码 --------------</span><br />\n<span class=\"hljs-keyword\">let</span> sum = <span class=\"hljs-number\">0</span>;<br />\n<span class=\"hljs-keyword\">for</span> (<span class=\"hljs-keyword\">let</span> i = <span class=\"hljs-number\">1</span>; i &lt;= <span class=\"hljs-number\">100</span>; i++) {<br />\nsum += i;<br />\n}<br />\n<span class=\"hljs-built_in\">console</span>.log(sum);<br />\n<span class=\"hljs-keyword\">const</span> html = <span class=\"hljs-built_in\">document</span>.documentElement;<br />\n<span class=\"hljs-keyword\">const</span> body = html.children[<span class=\"hljs-number\">1</span>];<br />\nbody.style.backgroundColor = <span class=\"hljs-string\">‘pink’</span>;<br />\n<span class=\"hljs-keyword\">let</span> div = <span class=\"hljs-built_in\">document</span>.createElement(<span class=\"hljs-string\">‘div’</span>);<br />\ndiv.innerText = <span class=\"hljs-string\">‘hello bug’</span>;<br />\nbody.appendChild(div);<br />\n<span class=\"hljs-comment\">// ----------------</span><br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f5</span>(<span class=\"hljs-params\"></span>) </span>{<br />\n<span class=\"hljs-keyword\">return</span> <span class=\"hljs-built_in\">parseInt</span>(<span class=\"hljs-built_in\">Math</span>.random() * <span class=\"hljs-number\">3</span> + <span class=\"hljs-number\">1</span>);<br />\n}<br />\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f6</span>(<span class=\"hljs-params\"></span>) </span>{<br />\n<span class=\"hljs-keyword\">let</span> x = f5();<br />\n<span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">1</span>) {<br />\n<span class=\"hljs-comment\">// 如果是1，则进行一些操作</span><br />\n} <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (x == <span class=\"hljs-number\">2</span>) {<br />\n<span class=\"hljs-comment\">// 如果是2，则进行一些操作</span><br />\n} <span class=\"hljs-keyword\">else</span> {<br />\n<span class=\"hljs-comment\">// 如果既不是1也不是2，则说明f1函数的逻辑出现了错误</span><br />\nalert(<span class=\"hljs-string\">‘第’</span> + getRow() + <span class=\"hljs-string\">‘行代码处出bug了’</span>);<br />\n}<br />\n}<br />\nf6();<br />\n</code></div></pre></p>\n<p>运行结果：<br />\n<img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161309111905.png\" alt=\"15.png\" style=\"zoom:42%;\"/><br />\n很好，完全正确！！！</p>\n', '在写代码的时候如何能够确定当前输入位置呢？', 0, '前端', '2021-04-16 13:10:39', '2021-04-16 13:22:01', 0, '34495460');
INSERT INTO `t_article` VALUES (2, 'Tomcat配置HTTPS协议的请求', '<h1><a id=\"TomcatHTTPS_0\"></a>Tomcat配置HTTPS协议的请求</h1>\n<h4><a id=\"1_2\"></a>1、背景</h4>\n<p>​		tomcat原本默认请求方式就是http的，但是由于刚好手上在做一个项目，前后端分离的，把前端挂在了腾讯的静态网站托管上面去了，后端是直接挂在了服务器的tomcat上；</p>\n<p>​		项目技术：ssm（其实无关项目的事情，全部都是在tomcat上面的配置）</p>\n<h4><a id=\"2_8\"></a>2、问题描述：</h4>\n<p>​		根据上述的情景，需要将服务器的tomcat请求转为https的，不然的话，访问网页的时候就会出现一个情形：<strong>Mix…</strong>（我忘记了~打开浏览器的控制台就可以看到了），好像是什么混合内容的，直白点就是https请求方式的页面不能有使用http协议的后端请求；</p>\n<h4><a id=\"3_12\"></a>3、至于获取域名、下载证书、自制证书等等的前期准备工作，这些百度都有一大堆了，我就不复述了；</h4>\n<h4><a id=\"4tomcat_14\"></a>4、正片开始：配置tomcat；</h4>\n<p>​	1) 将tomcat的配置文件 <strong>server.xml</strong> 中关于https的相关配置的注释解开</p>\n<pre><div class=\"hljs\"><code class=\"lang-xml\"><span class=\"hljs-comment\">&lt;!-- Define an SSL/TLS HTTP/1.1 Connector on port 8443\n         This connector uses the NIO implementation. The default\n         SSLImplementation will depend on the presence of the APR/native\n         library and the useOpenSSL attribute of the\n         AprLifecycleListener.\n         Either JSSE or OpenSSL style configuration may be used regardless of\n         the SSLImplementation selected. JSSE style configuration is used below.\n    --&gt;</span>\n    \n<span class=\"hljs-comment\">&lt;!-- port的值是配置好之后https的访问端口,可以在http协议配置处通过重定向方式转为https --&gt;</span>\n    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">Connector</span> <span class=\"hljs-attr\">port</span>=<span class=\"hljs-string\">\"8443\"</span> <span class=\"hljs-attr\">protocol</span>=<span class=\"hljs-string\">\"org.apache.coyote.http11.Http11NioProtocol\"</span>\n               <span class=\"hljs-attr\">maxThreads</span>=<span class=\"hljs-string\">\"150\"</span> <span class=\"hljs-attr\">SSLEnabled</span>=<span class=\"hljs-string\">\"true\"</span>&gt;</span>\n        <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">SSLHostConfig</span>&gt;</span>\n		<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">Certificate</span> <span class=\"hljs-attr\">certificateKeystoreFile</span>=<span class=\"hljs-string\">\"conf/localhost-rsa.jks\"</span>\n			<span class=\"hljs-attr\">certificateKeystorePassword</span>=<span class=\"hljs-string\">\"30i799x41r\"</span>\n                         <span class=\"hljs-attr\">type</span>=<span class=\"hljs-string\">\"RSA\"</span> /&gt;</span>\n        <span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">SSLHostConfig</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">Connector</span>&gt;</span>\n\n<span class=\"hljs-comment\">&lt;!-- 这里是可加可不加, 影响不大 --&gt;</span>\n<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">Connctor</span> <span class=\"hljs-attr\">port</span>=<span class=\"hljs-string\">\"8009\"</span> <span class=\"hljs-attr\">enableLookups</span>=<span class=\"hljs-string\">\"false\"</span> <span class=\"hljs-attr\">protocol</span>=<span class=\"hljs-string\">\"AJP/1.3\"</span> <span class=\"hljs-attr\">redirectPort</span>=<span class=\"hljs-string\">\"8443\"</span> <span class=\"hljs-attr\">maxHttpHeaderSize</span>=<span class=\"hljs-string\">\"8192\"</span> /&gt;</span>\n</code></div></pre>\n<p>​		<strong>值得注意的时候，这里其实保持原本的就行了，甚至都不用添加什么新的项；</strong></p>\n<p>​		证书的类型不同就使用不同的配置方式，我的是jks类型的，详细请看上面最后一行注释 ： <code>the SSLImplementation selected. JSSE style configuration is used below.</code>；</p>\n<p>​		证书放置的位置，我这里是与server.xml位于同一目录下，其他位置就使用绝对路径吧；</p>\n<p>​		**注意点：**在网上有很多老帖，两三年前的，会教你将  <font color = \'red\'><strong>protocol</strong></font> 值设置为   <font color=\'red\'><strong>HTTP/1.1</strong></font>  。千万不要这样做，不然的话，你的tomcat会直接崩掉，再也启动不起来那种，如果你不是很熟悉这个原因的话，可能你得再花很多时间去处理这个新问题。如果是直接在服务器上的tomcat倒是问题不大，如果是用docker挂载的容器，直接删掉重建吧。</p>\n<p>​	2）在<strong>web.xml</strong>配置文件中配置相关信息（直接滚轮滑动到最下面，写在**&lt;/web-app&gt;**标签之前：</p>\n<pre><div class=\"hljs\"><code class=\"lang-xml\"><span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">login-config</span>&gt;</span>\n	    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">auth-method</span>&gt;</span>CLIENT-CERT<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">auth-method</span>&gt;</span>\n	    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">realm-name</span>&gt;</span>Client Cert Users-only Area<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">realm-name</span>&gt;</span>\n    <span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">login-config</span>&gt;</span>\n    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">security-constraint</span>&gt;</span>\n	    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">web-resource-collection</span>&gt;</span>\n		    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">web-resource-name</span>&gt;</span>SSL<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">web-resource-name</span>&gt;</span>\n		    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">url-pattern</span>&gt;</span>/*<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">url-pattern</span>&gt;</span>\n	    <span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">web-resource-collection</span>&gt;</span>\n	    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">user-data-constraint</span>&gt;</span>\n		    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">transport-guarantee</span>&gt;</span>CONFIDENTIAL<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">transport-guarantee</span>&gt;</span>\n	    <span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">user-data-constraint</span>&gt;</span>\n    <span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">security-constraint</span>&gt;</span>\n</code></div></pre>\n<p>​	这里提一下我自己遇到的小问题：</p>\n<p>​	<code>&lt;auth-method&gt;CLIENT-CERT&lt;/auth-method&gt;</code></p>\n<p>​	<strong>此处是横杠，而不是下划线，敲错了会导致配置失败不生效；</strong></p>\n<p>​	<code>&lt;realm-name&gt;Client Cert Users-only Area&lt;/realm-name&gt;</code></p>\n<p>​	<strong>此处是Users-only，有一个s以及是横杠，敲错了也是会导致配置不生效；</strong></p>\n<p>​	以上两处都不是什么大问题，就是一些细节，错了就可能又浪费多一点时间；基本上按照上面配置好，就可以将http请求转为https方式的了；</p>\n<p>**PS：**如果配置完之后还是发现不太行，那就一步步排除问题，</p>\n<p>​		首先确保整个项目是正常的，在http请求方式是能够正常访问的；</p>\n<p>​		接着如果是被浏览器的访问策略拦截了，就百度，因为每种问题都有不同的原因；</p>\n<p>​		如果出现tomcat那种404的话，就可以确定问题是你上面的配置问题，可以通过查看tomcat的启动日志，应该能够找到问题的所在。</p>\n', 'http转https那点事儿~', 0, '后端', '2021-04-16 13:37:36', '2021-04-16 13:37:36', 0, '40706178');
INSERT INTO `t_article` VALUES (3, '产品的真相', '<p>人人都是产品经理！</p>\n', '点进去看过就知道了', 0, '产品', '2021-04-16 13:57:05', '2021-04-16 13:57:05', 0, '33720112');
INSERT INTO `t_article` VALUES (4, 'Java实现计网循环冗余检验算法', '<h2><a id=\"_0\"></a>目录</h2>\n<ul>\n<li><a href=\"#%E7%9B%AE%E5%BD%95\">目录</a></li>\n<li><a href=\"#%E7%9B%B8%E5%85%B3%E7%9F%A5%E8%AF%86%E7%82%B9\">相关知识点</a>\n<ul>\n<li><a href=\"#%E5%9C%A8%E6%95%B0%E6%8D%AE%E9%93%BE%E8%B7%AF%E5%B1%82%E4%BC%A0%E9%80%81%E7%9A%84%E5%B8%A7%E4%B8%AD%E5%B9%BF%E6%B3%9B%E4%BD%BF%E7%94%A8%E4%BA%86%E5%BE%AA%E7%8E%AF%E5%86%97%E4%BD%99%E6%A3%80%E9%AA%8C-crc-%E7%9A%84%E6%A3%80%E9%94%99%E6%8A%80%E6%9C%AF\">在数据链路层传送的帧中，广泛使用了循环冗余检验 CRC 的检错技术。</a></li>\n<li><a href=\"#%E5%BE%AA%E7%8E%AF%E5%86%97%E4%BD%99%E6%A3%80%E9%AA%8C%E7%9A%84%E5%8E%9F%E7%90%86\">循环冗余检验的原理</a></li>\n<li><a href=\"#%E5%86%97%E4%BD%99%E7%A0%81%E7%9A%84%E8%AE%A1%E7%AE%97\">冗余码的计算</a></li>\n<li><a href=\"#%E6%8E%A5%E6%94%B6%E7%AB%AF%E5%AF%B9%E6%94%B6%E5%88%B0%E7%9A%84%E6%AF%8F%E4%B8%80%E5%B8%A7%E8%BF%9B%E8%A1%8C-crc-%E6%A3%80%E9%AA%8C\">接收端对收到的每一帧进行 CRC 检验</a></li>\n<li><a href=\"#%E5%86%97%E4%BD%99%E7%A0%81%E7%9A%84%E8%AE%A1%E7%AE%97%E4%B8%BE%E4%BE%8B\">冗余码的计算举例</a></li>\n<li><a href=\"#%E6%A8%A12%E9%99%A4%E6%B3%95%E6%AD%A5%E9%AA%A4\">模2除法步骤</a></li>\n</ul>\n</li>\n<li><a href=\"#%E4%BB%A3%E7%A0%81%E5%AE%9E%E7%8E%B0\">代码实现</a></li>\n</ul>\n<h2><a id=\"_12\"></a>相关知识点</h2>\n<h4><a id=\"_CRC__14\"></a>在数据链路层传送的帧中，广泛使用了循环冗余检验 CRC 的检错技术。</h4>\n<h4><a id=\"_16\"></a>循环冗余检验的原理</h4>\n<ul>\n<li>在发送端，先把数据划分为组。假定每组 k 个比特。</li>\n<li>在每组 M 后面再添加供差错检测用的 n 位冗余码，然后一起发送出去。</li>\n</ul>\n<h4><a id=\"_21\"></a>冗余码的计算</h4>\n<ul>\n<li>用二进制的模 2 运算进行 2n 乘 M 的运算，这相当于在 M 后面添加 n 个 0。</li>\n<li>得到的 (k + n) 位的数除以事先选定好的长度为 (n + 1) 位的除数 P，得出商是 Q 而余数是 R，余数 R 比除数 P 少 1 位，即 R 是 n 位。</li>\n<li>将余数 R 作为冗余码拼接在数据 M 后面，一起发送出去。</li>\n</ul>\n<h4><a id=\"_CRC__27\"></a>接收端对收到的每一帧进行 CRC 检验</h4>\n<ul>\n<li>(1) 若得出的余数 R = 0，则判定这个帧没有差错，就接受 (accept)。</li>\n<li>(2) 若余数 R ≠ 0，则判定这个帧有差错，就丢弃。</li>\n<li>但这种检测方法并不能确定究竟是哪一个或哪几个比特出现了差错。</li>\n<li>只要经过严格的挑选，并使用位数足够多的除数 P，那么出现检测不到的差错的概率就很小很小。</li>\n</ul>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/20210416135850871.png\" alt=\"1.png\" style=\"zoom:42%\"/></p>\n<h4><a id=\"_36\"></a>冗余码的计算举例</h4>\n<ul>\n<li>现在 k = 6, M = 101001。</li>\n<li>设 n = 3, 除数 P = 1101，</li>\n<li>被除数是 2nM = 101001000。</li>\n<li>模 2 运算的结果是：商 Q = 110101，余数 R = 001。</li>\n<li>把余数 R 作为冗余码添加在数据 M 的后面发送出去。发送的数据是：2nM + R，即：101001001，共 (k + n) 位。</li>\n</ul>\n<h4><a id=\"2_44\"></a>模2除法步骤</h4>\n<ul>\n<li>用除数对被除数最高几位做模2减，没有借位；</li>\n<li>除数右移一位，若余数最高位为1，商为1，并对余数做模2减。若余数最高位为0，商为0，除数继续右移一位；</li>\n<li>一直做到余数的位数小于除数时，该余数就是最终余数。</li>\n</ul>\n<p><img src=\"https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161359433615.png\" alt=\"2.png\" style=\"zoom:42%\"/></p>\n<h2><a id=\"_52\"></a>代码实现</h2>\n<pre><code class=\"lang-\">\npackage computernetwork;\n\n// 循环冗余检验 Cyclic Redundancy Check (CRC)\npublic class CRC {\n\n    private int[] generatingCode; // 生成码\n\n    // 设置生成码\n    public void setGeneratingCode(String str) {\n        generatingCode = stringToArray(str);\n    }\n\n    // 获取帧检验序列\n    public String getFCS(String message) {\n        for (int i = 0; i &lt; generatingCode.length - 1; i++) {\n            message += &quot;0&quot;;\n        }\n        return getRemainder(stringToArray(message));\n    }\n\n    // 判断接受码是否产生跳变\n    public boolean judge(String res) {\n        return Integer.parseInt(getRemainder(stringToArray(res))) == 0;\n    }\n\n    // 将01字符串转换为数组\n    private int[] stringToArray(String str) {\n        char[] chars = str.toCharArray();\n        int[] res = new int[chars.length];\n        for (int i = 0; i &lt; chars.length; i++) {\n            res[i] = chars[i] - \'0\';\n        }\n        return res;\n    }\n\n    // 求余数\n    private String getRemainder(int[] code) {\n        int len = code.length - generatingCode.length + 1;\n        for (int i = 0; i &lt; len; i++) {\n            if (code[i] != 0) {\n                for (int j = 0; j &lt; generatingCode.length; j++) {\n                    code[i + j] ^= generatingCode[j];\n                }\n            }\n        }\n        StringBuilder res = new StringBuilder();\n        for (int i = len; i &lt; code.length; i++) {\n            res.append(code[i]);\n        }\n        return res.toString();\n    }\n}\n\nclass TestCRC {\n    public static void main(String[] args) {\n        CRC crc = new CRC();\n        crc.setGeneratingCode(&quot;10011&quot;);\n        System.out.println(crc.getFCS(&quot;1101011011&quot;)); // 1110\n        System.out.println(crc.judge(&quot;11010110111110&quot;)); // true\n        System.out.println(crc.judge(&quot;11010110111011&quot;)); // false\n    }\n}</code></pre>\n', '无聊写着试试看', 0, '算法', '2021-04-16 14:01:08', '2021-04-16 14:01:08', 0, '50624693');
INSERT INTO `t_article` VALUES (5, '设计制胜秘诀？', '<p>你这里少了1px！</p>\n', '直呼内行！？', 0, '设计', '2021-04-16 14:12:53', '2021-04-16 14:16:07', 0, '69256535');
INSERT INTO `t_article` VALUES (6, '安卓修炼口诀', '<p>安卓从入门到入…(开放式结局）</p>\n', '芜湖！', 0, '安卓', '2021-04-16 14:15:24', '2021-04-16 14:15:24', 0, '02915126');

-- ----------------------------
-- Table structure for t_awarded
-- ----------------------------
DROP TABLE IF EXISTS `t_awarded`;
CREATE TABLE `t_awarded`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` tinyint(0) NULL DEFAULT NULL COMMENT '获奖类型：1、软设；2、蓝桥杯',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_competition_introduction
-- ----------------------------
DROP TABLE IF EXISTS `t_competition_introduction`;
CREATE TABLE `t_competition_introduction`  (
  `competition_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '比赛id',
  `competition_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '比赛名字',
  `show_content` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示内容',
  `delete_status` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除 0表示没有删除，1表示删除',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `sign_up` int(0) NULL DEFAULT 1 COMMENT '是否可以通过官网进行报名。0表示不可以，1表示可以',
  PRIMARY KEY (`competition_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_competition_introduction
-- ----------------------------
INSERT INTO `t_competition_introduction` VALUES (1, '软件设计大赛', '“软设”全名软件设计大赛，由互联网金融与信息工程学院爪哇部落主办，属于校级比赛，鼓励跨院组队参与。大赛旨在激发大学生的创造力和实践能力，坚持“博采众长，共同进步”的宗旨。软件设计大赛目的是为了促进互联网院更好的学习风气，提高同学们的编程素质，体验一次团体开发软件程序的经历。提高自己的阅历以及简历的含金量。\n参加软设队伍仅限广东金融学院的大二与大三的学生，队伍人数可在1人到4人之间，各个专业方向的人才可自行组合，比赛一般涉及计算机前端、计算机后端、UI设计、产品运维、市场营销调查等等。软件类型可以包括游戏类、商城类、信息展示类、服务预约类、餐饮外卖类、同城社区类、社区团购类等等，所做的软件程序目的在于服务好大学生校园生活或者解决生活难题。\n软设比赛分为初赛和决赛两个阶段，初赛时间为十月中旬，决赛时间为十一月中旬（具体时间请看具体通知）；初赛评委为爪哇部落以及互联网院优秀师兄师姐评审，决赛评委为互联网院老师以及优秀毕业师兄师姐担任评委；初赛将选出十支队伍进入决赛，进入决赛的队伍将视评审分数高低分出一等奖一名，二等奖两名，三等奖三名，优秀奖若干名，颁发奖章证明以及参赛纪念品。\n决赛后评取一等奖一名，二等奖两名，三等奖三名，优秀奖若干名。综测分：第一名加五分，第二名加三分，第三名加二分，优秀奖以及参与者都加一分；创新学分：一等奖0.5分，二等奖0.3分，三等奖0.2分。\n软设比赛可以作为大学生创新创业大赛的磨刀石，锻炼团队合作能力，无论比赛结果好坏，比赛中学习到的知识和团队之间的情谊，才是最后对自己两个月努力的回报。', 0, '2021-01-05 19:55:46', '2021-04-16 16:47:39', 1);
INSERT INTO `t_competition_introduction` VALUES (2, 'ACM', '国际大学生程序设计竞赛（英文全称：International Collegiate Programming Contest（简称ICPC））是由国际计算机协会（ACM）主办的，一项旨在展示大学生创新能力、团队精神和在压力下编写程序、分析和解决问题能力的年度竞赛。经过近40年的发展，ACM国际大学生程序设计竞赛已经发展成为全球最具影响力的大学生程序设计竞赛。赛事目前由方正集团赞助。', 0, '2021-01-05 19:56:37', '2021-04-16 15:36:45', 1);
INSERT INTO `t_competition_introduction` VALUES (3, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-02-01 00:02:25', '2021-03-23 19:11:48', 1);
INSERT INTO `t_competition_introduction` VALUES (8, '蓝桥杯', '蓝桥杯全国软件和信息技术专业人才大赛是由工业和信息化部人才交流中心举办的全国性IT学科赛事。共有北京大学、清华大学、上海交通大学等全国1200余所高校参赛，累计参赛人数超过40万人。', 0, '2021-02-01 00:07:47', '2021-04-16 15:37:19', 1);
INSERT INTO `t_competition_introduction` VALUES (16, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-07 14:57:37', '2021-03-23 19:11:49', 1);
INSERT INTO `t_competition_introduction` VALUES (17, '天天杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-07 14:58:26', '2021-03-25 15:16:00', 1);
INSERT INTO `t_competition_introduction` VALUES (18, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-07 15:31:43', '2021-03-23 19:11:50', 1);
INSERT INTO `t_competition_introduction` VALUES (22, '牛客杯', '目前牛客网竞赛平台的比赛大多为ACM赛制比赛。OI赛制为新增赛制，该类型的比赛在将来也会不断增多。在牛客平台，不管是ACM还是OI赛制都是从标准输入流读取', 0, '2021-03-07 20:36:32', '2021-04-16 15:39:02', 1);
INSERT INTO `t_competition_introduction` VALUES (23, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-08 22:33:31', '2021-03-23 19:12:22', 0);
INSERT INTO `t_competition_introduction` VALUES (24, '蓝桥杯22', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-10 20:20:25', '2021-03-23 19:12:01', 0);
INSERT INTO `t_competition_introduction` VALUES (25, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-10 20:25:56', '2021-03-23 19:12:00', 0);
INSERT INTO `t_competition_introduction` VALUES (26, 'leetcode杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-10 20:29:27', '2021-04-15 15:59:17', 0);
INSERT INTO `t_competition_introduction` VALUES (27, '蓝桥杯33', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-10 20:34:58', '2021-03-23 19:11:56', 0);
INSERT INTO `t_competition_introduction` VALUES (28, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-10 20:40:53', '2021-03-23 19:12:27', 0);
INSERT INTO `t_competition_introduction` VALUES (29, '洛谷杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-11 14:50:40', '2021-03-25 15:16:03', 0);
INSERT INTO `t_competition_introduction` VALUES (30, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-20 09:12:10', '2021-03-23 19:12:07', 0);
INSERT INTO `t_competition_introduction` VALUES (31, '蓝桥杯', '蓝桥杯啦啦   &lt;script&gt;alert()&lt;/script&gt;', 1, '2021-03-20 09:16:10', '2021-03-23 19:12:05', 0);
INSERT INTO `t_competition_introduction` VALUES (32, '不是v', '让国人个', 1, '2021-03-23 19:08:31', '2021-03-23 19:12:03', NULL);
INSERT INTO `t_competition_introduction` VALUES (33, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-25 18:02:46', '2021-03-31 10:35:19', 0);
INSERT INTO `t_competition_introduction` VALUES (34, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:24:23', '2021-03-31 10:35:22', 0);
INSERT INTO `t_competition_introduction` VALUES (35, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:25:39', '2021-03-31 10:35:16', 0);
INSERT INTO `t_competition_introduction` VALUES (36, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:26:06', '2021-03-31 10:35:17', 0);
INSERT INTO `t_competition_introduction` VALUES (37, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:27:14', '2021-03-31 10:35:13', 0);
INSERT INTO `t_competition_introduction` VALUES (38, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:27:55', '2021-03-31 10:35:14', 0);
INSERT INTO `t_competition_introduction` VALUES (39, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:28:33', '2021-03-31 10:35:11', 0);
INSERT INTO `t_competition_introduction` VALUES (40, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:29:15', '2021-03-31 10:35:10', 0);
INSERT INTO `t_competition_introduction` VALUES (41, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:29:53', '2021-03-31 10:35:20', 0);
INSERT INTO `t_competition_introduction` VALUES (42, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:30:23', '2021-03-31 10:35:08', 0);
INSERT INTO `t_competition_introduction` VALUES (43, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-03-30 18:30:54', '2021-03-31 10:35:07', 0);
INSERT INTO `t_competition_introduction` VALUES (44, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-04-07 10:40:58', '2021-04-13 12:23:40', 0);
INSERT INTO `t_competition_introduction` VALUES (45, '软件设计大赛', '&ldquo;软设&rdquo;全名软件设计大赛，由互联网金融与信息工程学院爪哇部落主办，属于校级比赛，鼓励跨院组队参与。大赛旨在激发大学生的创造力和实践能力，坚持&ldquo;博采众长，共同进步&rdquo;的宗旨。软件设计大赛目的是为了促进互联网院更好的学习风气，提高同学们的编程素质，体验一次团体开发软件程序的经历。提高自己的阅历以及简历的含金量。\n参加软设队伍仅限广东金融学院的大二与大三的学生，队伍人数可在1人到4人之间，各个专业方向的人才可自行组合，比赛一般设计计算机前端、计算机后端、UI设计、产品运维、市场营销调查等等。软件类型可以包括游戏类、商城类、信息展示类、服务预约类、餐饮外卖类、同城社区类、社区团购类等等，所做的软件程序目的在于服务好大学生校园生活或者解决生活难题。\n软设比赛分为初赛和决赛两个阶段，初赛时间为十月中旬，决赛时间为十一月中旬（具体时间请看具体通知）；初赛评委为爪哇部落以及互联网元优秀师兄师姐评审，决赛评委为互联网院老师以及优秀毕业师兄师姐担任评委；初赛将选出十支队伍进入决赛，进入决赛的队伍将视评审分数高低分出一等奖一名，二等奖两名，三等奖三名，优秀奖若干名，颁发奖章证明以及参赛纪念品。\n决赛后评取一等奖一名，二等奖两名，三等奖三名，优秀奖若干名。综测分：第一名加五分，第二名加三分，第三名加二分，优秀奖以及参与者都加一分；创新学分：一等奖0.5分，二等奖0.3分，三等奖0.2分。\n软设比赛可以作为大学生创新创业大赛的磨刀石，锻炼团队合作能力，无论比赛结果好坏，比赛中学习到的知识和团队之间的情谊，才是最后对自己两个月努力的回报。', 1, '2021-04-13 12:19:58', '2021-04-13 12:23:37', 1);
INSERT INTO `t_competition_introduction` VALUES (46, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-04-15 10:27:37', '2021-04-15 15:59:21', 0);
INSERT INTO `t_competition_introduction` VALUES (47, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-04-15 10:41:50', '2021-04-15 15:59:19', 0);
INSERT INTO `t_competition_introduction` VALUES (48, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-04-16 15:01:00', '2021-04-16 15:37:23', 0);
INSERT INTO `t_competition_introduction` VALUES (49, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-04-16 15:02:04', '2021-04-16 15:36:05', 0);
INSERT INTO `t_competition_introduction` VALUES (50, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-04-16 15:03:41', '2021-04-16 15:36:07', 0);
INSERT INTO `t_competition_introduction` VALUES (51, '蓝桥杯', '蓝桥杯啦啦', 1, '2021-04-16 15:05:03', '2021-04-16 15:36:09', 0);

-- ----------------------------
-- Table structure for t_competition_years
-- ----------------------------
DROP TABLE IF EXISTS `t_competition_years`;
CREATE TABLE `t_competition_years`  (
  `year_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `the_year` int(0) NULL DEFAULT NULL COMMENT '表示第几届',
  `delete_status` tinyint(0) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除',
  `active_status` int(0) NULL DEFAULT NULL COMMENT '表示 在部落官网前端是否展示，0 不展示，1 就展示',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `year_start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `year_end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `competition_id` int(0) NOT NULL COMMENT '比赛 ID',
  `show_order` int(0) NULL DEFAULT 0 COMMENT '展示顺序',
  PRIMARY KEY (`year_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_competition_years
-- ----------------------------
INSERT INTO `t_competition_years` VALUES (1, 1, 1, 1, '2021-04-16 14:36:37', '2021-04-16 14:36:37', '2021-04-14 00:00:00', '2021-04-15 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (2, 2, 1, 0, '2021-04-16 15:40:44', '2021-04-16 15:40:44', '2021-03-25 10:16:53', '2021-03-25 10:16:50', 2, 0);
INSERT INTO `t_competition_years` VALUES (4, 1, 0, 0, '2021-03-25 18:23:36', '2021-03-25 18:23:36', '2021-03-25 18:23:11', '2021-03-25 18:23:13', 3, 0);
INSERT INTO `t_competition_years` VALUES (5, 1, 1, 0, '2021-04-16 15:40:42', '2021-04-16 15:40:42', '2021-03-25 10:16:43', '2021-03-25 10:16:47', 2, 0);
INSERT INTO `t_competition_years` VALUES (7, 3, 1, 0, '2021-04-16 15:40:45', '2021-04-16 15:40:45', '2021-03-25 10:16:56', '2021-03-25 10:16:58', 2, 0);
INSERT INTO `t_competition_years` VALUES (8, 4, 0, 0, '2021-03-25 18:17:16', '2021-03-25 18:17:16', '2021-03-25 10:17:00', '2021-03-25 10:17:04', 18, 0);
INSERT INTO `t_competition_years` VALUES (9, 5, 0, 1, '2021-04-16 14:43:01', '2021-04-16 14:43:01', '2016-12-10 00:00:00', '2016-12-28 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (10, 8, 0, 1, '2021-04-16 14:45:36', '2021-04-16 14:45:36', '2019-11-03 00:00:00', '2019-11-24 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (11, 6, 0, 1, '2021-04-16 14:43:54', '2021-04-16 14:43:54', '2017-11-18 00:00:00', '2017-12-09 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (12, 20, 1, 1, '2021-04-01 15:58:41', '2021-04-01 15:58:41', NULL, NULL, 1, 0);
INSERT INTO `t_competition_years` VALUES (13, 21, 1, 1, '2021-04-01 15:58:37', '2021-04-01 15:58:37', NULL, NULL, 1, 0);
INSERT INTO `t_competition_years` VALUES (14, 11, 1, 1, '2021-04-01 16:14:53', '2021-04-01 16:14:53', '2021-04-05 00:00:00', '2021-04-16 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (15, 12, 1, 1, '2021-04-01 15:58:39', '2021-04-01 15:58:39', NULL, NULL, 1, 0);
INSERT INTO `t_competition_years` VALUES (16, 3, 1, 1, '2021-04-16 14:41:36', '2021-04-16 14:41:36', '2021-04-05 00:00:00', '2021-04-16 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (17, 666666, 0, 0, '2021-04-01 10:37:42', '2021-04-01 10:37:42', '2021-04-01 10:37:42', '2021-04-01 10:37:42', 489999, 0);
INSERT INTO `t_competition_years` VALUES (18, 666666, 0, 0, '2021-04-01 10:37:42', '2021-04-01 10:37:42', '2021-04-01 00:00:00', '2021-04-07 00:00:00', 4899999, 0);
INSERT INTO `t_competition_years` VALUES (19, 666666, 0, 0, '2021-04-01 10:37:42', '2021-04-01 10:37:42', '2021-04-01 00:00:00', '2021-04-07 00:00:00', 4899999, 0);
INSERT INTO `t_competition_years` VALUES (20, 666666, 0, NULL, '2021-04-01 10:37:42', '2021-04-01 10:37:42', '2021-04-01 00:00:00', '2021-04-01 00:00:00', 4899999, 0);
INSERT INTO `t_competition_years` VALUES (21, 666666, 0, NULL, '2021-04-01 10:37:42', '2021-04-01 10:37:42', '2021-04-01 00:00:00', '2021-04-01 00:00:00', 4899999, 0);
INSERT INTO `t_competition_years` VALUES (22, 10, 1, NULL, '2021-04-16 14:36:40', '2021-04-16 14:36:40', '2021-04-05 00:00:00', '2021-04-07 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (24, 14, 1, 1, '2021-04-16 14:36:43', '2021-04-16 14:36:43', NULL, NULL, 1, 0);
INSERT INTO `t_competition_years` VALUES (25, 9, 0, NULL, NULL, NULL, '2020-11-01 00:00:00', '2020-11-21 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (26, 4, 0, NULL, '2021-04-16 14:46:30', '2021-04-16 14:46:30', '2015-12-03 00:00:00', '2015-12-25 00:00:00', 1, 0);
INSERT INTO `t_competition_years` VALUES (27, 7, 0, NULL, '2021-04-16 14:44:52', '2021-04-16 14:44:52', '2018-11-17 00:00:00', '2017-12-09 00:00:00', 1, 0);

-- ----------------------------
-- Table structure for t_cooperation
-- ----------------------------
DROP TABLE IF EXISTS `t_cooperation`;
CREATE TABLE `t_cooperation`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻标题',
  `photo` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片链接',
  `items` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交流事项',
  `content` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `type` tinyint(1) NOT NULL COMMENT '合作类型,0表示对内交流,1表示对外交流',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_by` int(0) NOT NULL COMMENT '创建人id',
  `update_by` int(0) NOT NULL COMMENT '更新人id',
  `delete_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除,0表示未删除,1表示删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 991 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cooperation
-- ----------------------------
INSERT INTO `t_cooperation` VALUES (985, '18年内部交流会', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161426233631.jpg', '18年内部交流会', '18年内部交流会', 0, '2021-04-16 14:26:25', '2021-04-16 15:34:34', 1, 1, 0);
INSERT INTO `t_cooperation` VALUES (986, '18年内部交流会', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161533288924.jpg', '18年内部交流会', '18年内部交流会', 0, '2021-04-16 15:33:30', '2021-04-16 15:33:30', 1, 1, 0);
INSERT INTO `t_cooperation` VALUES (987, '17年内部交流会', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161534511623.JPG', '17年内部交流会', '17年内部交流会', 0, '2021-04-16 15:34:52', '2021-04-16 15:34:52', 1, 1, 0);
INSERT INTO `t_cooperation` VALUES (988, '16级对外交流', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161545422786.jpg', '16级对外交流', '16级对外交流', 1, '2021-04-16 15:45:46', '2021-04-16 15:45:46', 1, 1, 0);
INSERT INTO `t_cooperation` VALUES (989, '16级对外交流', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161545555560.jpg', '16级对外交流', '16级对外交流', 1, '2021-04-16 15:45:56', '2021-04-16 15:45:56', 1, 1, 0);
INSERT INTO `t_cooperation` VALUES (990, '16级对外交流', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161546044013.jpg', '16级对外交流', '16级对外交流', 1, '2021-04-16 15:46:04', '2021-04-16 15:46:04', 1, 1, 0);

-- ----------------------------
-- Table structure for t_direction
-- ----------------------------
DROP TABLE IF EXISTS `t_direction`;
CREATE TABLE `t_direction`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `direction_id` tinyint(1) NOT NULL COMMENT '方向id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '方向介绍',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '文章创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '文章删除时间',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '文章创建人id',
  `update_by` int(0) NULL DEFAULT NULL COMMENT '文章更新人id',
  `delete_status` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除,0表示可用,1表示删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `direction_id`(`direction_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_direction
-- ----------------------------
INSERT INTO `t_direction` VALUES (1, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_direction` VALUES (2, 2, NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_history
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `year` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `introduct` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介',
  `gmt_create` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_history
-- ----------------------------
INSERT INTO `t_history` VALUES (1, '2011', '由陈成腾、张晓凡、陈丽平、吴图等同学组织的爪哇部落正式建立，部落开始不断加强计科系的学术氛围，并得到陈国君教授，\r\n\r\n邹林达、李梅生、韩冬等老师的大力支持；', '2021-03-10 16:27:52', '2021-03-10 16:27:54');
INSERT INTO `t_history` VALUES (2, '2012', '由朱永森、周翊灿、李慧红，郑志渠等同学接任，建立起初步的规章制度，在加强学习的基础上，与学校合作开发了一系列具有实用价值的\r\n\r\n系统，包括教材科，人事处，招就处等；', '2021-03-10 16:33:35', '2021-03-10 16:33:43');
INSERT INTO `t_history` VALUES (3, '2013', '由杨柳明、谢钟洪、张枫枫、刘加宝等同学继任，对部落的规章制度进行进一步的完善并开始自主创新进行大型项目的开发，并于2013年10月推出校园首款社交应用', '2021-03-10 16:33:39', '2021-03-10 16:33:40');
INSERT INTO `t_history` VALUES (4, '2014', '由陈海晴、陈欣、萧敏芹、谭毛女等同学接任，部落的规章制度逐渐成熟，成员规模进一步扩大，管理井井有序，把前端设计组分开两个方\r\n\r\n向，部落继续扩张，此外鼓励部落人参加创新比赛，蓝桥杯。', '2021-03-10 16:33:27', '2021-03-10 16:33:31');
INSERT INTO `t_history` VALUES (5, '2015', '近几年来，在学校和教师们的支持和成员们的不断努力，爪哇部落进入了一个新的发展阶段。部落设置六大学习交流小组，举办第九届软件设计大赛，筹备算法方向的比赛。积极开展各项学习交流活动，努力成为我校互联网专业的中坚力量。', '2021-03-10 16:35:24', '2021-03-10 16:35:24');
INSERT INTO `t_history` VALUES (6, '-1', '爪哇部落(javatribe2),2011年6月，由广东金融学院2009级计科系充满热血的师兄师姐创立诞生，现已成为一支极具互联网专业性质的团队。\r\n\r\n爪哇部落立志于向广金学子提供具有浓厚学术氛围的专业平台，我们秉承着海纳百川的态度，以“博采众长，共同进步”为宗旨，积极热情\r\n\r\n地展开各种全校性的学习交流活动，努力成为我校互联网专业的中坚力量。\r\n\r\n       部落设有六大学习交流组，包括前端组、后端组、产品组、设计组、算法组、安卓组。方向分设明确，六大组别不断交流学习，形成了较为\r\n\r\n完备的互联网学习体系。\r\n\r\n       部落现有在校与历届校友200余人，我们称之为“爪哇青年”，爪哇青年们以部落为自豪，部落同时也因爪哇青年们骄傲。', '2021-03-10 16:37:20', '2021-03-10 16:37:13');
INSERT INTO `t_history` VALUES (7, '1', '在爪哇部落成立十周年之际，第十届的成员们一起合作开发了部落自己的官网。', NULL, '2021-06-16 11:05:43');

-- ----------------------------
-- Table structure for t_management
-- ----------------------------
DROP TABLE IF EXISTS `t_management`;
CREATE TABLE `t_management`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `position` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部落职位',
  `sessions` int(0) UNSIGNED NOT NULL COMMENT '届数',
  `is_leader` tinyint(0) NULL DEFAULT 0 COMMENT '是否是队长',
  `work_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任职时间',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_management
-- ----------------------------
INSERT INTO `t_management` VALUES (1, '胡曦', '队长', 10, 1, '2020.06 -2021.06 ', '2020-12-28 21:52:04', '2021-04-15 19:05:37');
INSERT INTO `t_management` VALUES (7, '邓宇良', 'Web开发后端组组长', 9, 0, '2021 年 02 月2022 年 02 月', '2021-03-10 14:56:10', '2021-03-15 16:56:00');
INSERT INTO `t_management` VALUES (8, '邱泽明', '队长', 9, 1, '2019.06 -2020.06 ', '2021-03-10 15:14:26', '2021-04-15 19:05:44');
INSERT INTO `t_management` VALUES (9, '陈成腾', '队长', 1, 1, '2011.06 -2012.06 ', '2021-03-10 15:22:19', '2021-04-15 19:06:37');
INSERT INTO `t_management` VALUES (10, '朱永森', '队长', 2, 1, '2012.06 -2013.06 ', '2021-03-10 16:08:36', '2021-04-15 19:06:30');
INSERT INTO `t_management` VALUES (27, '曹志鑫', '队长', 7, 1, '2017.06 -2018.06 ', '2021-04-07 10:55:50', '2021-04-15 19:05:55');
INSERT INTO `t_management` VALUES (28, '梁永辉', 'Web开发组组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:19:39', '2021-04-15 10:19:39');
INSERT INTO `t_management` VALUES (29, '邓宇良', 'Web开发组后端组组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:20:22', '2021-04-15 10:20:22');
INSERT INTO `t_management` VALUES (30, '叶领然', 'Web开发后端副组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:21:05', '2021-04-15 10:21:05');
INSERT INTO `t_management` VALUES (31, '刘家旻', 'Web开发前端组组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:21:35', '2021-04-15 10:21:35');
INSERT INTO `t_management` VALUES (32, '林城武', '安卓组组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:21:58', '2021-04-15 10:21:58');
INSERT INTO `t_management` VALUES (33, '洪凯莹', '设计组组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:22:33', '2021-04-15 10:22:33');
INSERT INTO `t_management` VALUES (34, '程晓仪', '设计组副组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:23:07', '2021-04-15 10:23:07');
INSERT INTO `t_management` VALUES (35, '谢羽欣', '产品组组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:23:41', '2021-04-15 10:23:41');
INSERT INTO `t_management` VALUES (36, '吴茂平', '算法组组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:24:01', '2021-04-15 10:24:01');
INSERT INTO `t_management` VALUES (37, '江宏鑫', '算法组副组长', 10, 0, '2020 年 06 月-2021 年 06 月', '2021-04-15 10:24:22', '2021-04-15 10:24:22');
INSERT INTO `t_management` VALUES (38, '杨柳明', '队长', 3, 1, '2013.06 -2014.06 ', '2021-04-15 14:50:14', '2021-04-15 19:06:19');
INSERT INTO `t_management` VALUES (39, '陈海晴', '队长', 4, 1, '2014.06 -2015.06 ', '2021-04-15 14:50:40', '2021-04-15 19:06:12');
INSERT INTO `t_management` VALUES (40, '陈广镇', '队长', 5, 1, '2015.06 -2016.06 ', '2021-04-15 14:51:09', '2021-04-15 19:06:07');
INSERT INTO `t_management` VALUES (41, '丁永辉', '队长', 6, 1, '2016.06 -2017.06 ', '2021-04-15 14:51:26', '2021-04-15 19:06:00');
INSERT INTO `t_management` VALUES (42, '曾祥鑫', '队长', 8, 1, '2018.06 -2019.06 ', '2021-04-15 14:52:07', '2021-04-15 19:05:50');
INSERT INTO `t_management` VALUES (43, '陈雅楠', '队长', 11, 1, '2021.06-2022.06', '2021-06-16 10:49:11', '2021-06-16 10:49:11');
INSERT INTO `t_management` VALUES (44, '于学礼', '副队长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:53:43', '2021-06-16 10:53:43');
INSERT INTO `t_management` VALUES (45, '冯远安', 'Web开发前端组组长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:54:39', '2021-06-16 10:54:45');
INSERT INTO `t_management` VALUES (46, '王腾坤', 'Web开发后端组组长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:55:16', '2021-06-16 10:55:16');
INSERT INTO `t_management` VALUES (47, '陈洁琳', '设计组组长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:56:05', '2021-06-16 10:56:05');
INSERT INTO `t_management` VALUES (48, '黄嗣海', '产品组组长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:56:33', '2021-06-16 10:56:33');
INSERT INTO `t_management` VALUES (49, '陈明耀', '安卓组组长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:57:01', '2021-06-16 10:57:01');
INSERT INTO `t_management` VALUES (50, '蔡昊彤', '算法组组长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:57:27', '2021-06-16 10:57:27');
INSERT INTO `t_management` VALUES (51, '曹子杰', '算法组副组长', 11, 0, '2021 年 06 月-2022 年 06 月', '2021-06-16 10:57:51', '2021-06-16 10:57:51');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻标题',
  `photo` varchar(2560) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻图片',
  `url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻推文链接',
  `priority` tinyint(1) NOT NULL DEFAULT 0 COMMENT '优先级,0表示正常排序,1表示优先级高',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_by` int(0) NOT NULL COMMENT '创建人id',
  `update_by` int(0) NOT NULL COMMENT '更新人id',
  `delete_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志位,0表示未删除,1表示已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 919 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES (908, '软件设计大赛结果', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151656555780.png', 'https://mp.weixin.qq.com/s/lqhTCztz4sZpjfnZGdoNtQ', 0, '2021-04-15 16:56:57', '2021-04-15 17:08:24', 1, 1, 1);
INSERT INTO `t_news` VALUES (909, '嗨！这里有一个神秘组织', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', 'https://mp.weixin.qq.com/s/kBSG64VVMu2lwbW8YrZz5w', 1, '2021-04-15 17:05:26', '2021-04-15 17:05:26', 1, 1, 0);
INSERT INTO `t_news` VALUES (910, '爪哇部落第二次交流会', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151711311420.png', 'https://mp.weixin.qq.com/s/Q_lmv3fF3phzp9bNbMZc_A', 0, '2021-04-15 17:06:03', '2021-06-16 10:47:39', 1, 1, 0);
INSERT INTO `t_news` VALUES (911, '爪哇部落第一次交流会', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151706499475.png', 'https://mp.weixin.qq.com/s/5D65qYREKgca7aOnh7sniA', 0, '2021-04-15 17:06:51', '2021-04-15 17:06:51', 1, 1, 0);
INSERT INTO `t_news` VALUES (912, '蓝桥杯宣讲会 & 爪哇部落算法组招新', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151707577324.png', 'https://mp.weixin.qq.com/s/Krzn_YaWBppDOIwBPt7EpA', 0, '2021-04-15 17:08:12', '2021-04-15 17:08:12', 1, 1, 0);
INSERT INTO `t_news` VALUES (913, '软件设计大赛|决赛结果', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151709022081.png', 'https://mp.weixin.qq.com/s/lqhTCztz4sZpjfnZGdoNtQ', 0, '2021-04-15 17:09:05', '2021-04-15 17:09:05', 1, 1, 0);
INSERT INTO `t_news` VALUES (914, '软件设计大赛 || 决赛预告', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151712366749.png', 'https://mp.weixin.qq.com/s/2jiA-KuULaMQtbfmt4ltLQ', 0, '2021-04-15 17:12:38', '2021-04-15 17:12:38', 1, 1, 0);
INSERT INTO `t_news` VALUES (915, '爪哇部落第十一届换届大会暨沙龙分享会', 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202106161046566386.png', 'https://mp.weixin.qq.com/s?__biz=MzA4OTg3MTI4NA==&mid=2654430214&idx=1&sn=695a36e677c9d85c48b5c3f86362a859&chksm=8bd782ddbca00bcbe02c57a0334fb32f3b1ed7ef5abc78642d817c5f94ae414e55d2068aea1d&scene=132#wechat_redirect', 1, '2021-06-16 10:46:59', '2021-06-16 10:47:45', 1, 1, 0);
INSERT INTO `t_news` VALUES (916, '爪哇部落第十届软件大赛', 'https://s3.bmp.ovh/imgs/2021/12/37ccecb1ed895405.jpg', 'https://mp.weixin.qq.com/s/igOKrXfhfW5rZfYqmTnCOg', 0, '2021-12-12 22:57:08', '2021-12-12 22:57:08', 1, 1, 0);
INSERT INTO `t_news` VALUES (917, 'ACM-ICPC区域赛奖牌？拿来吧你！', 'https://s3.bmp.ovh/imgs/2021/12/a8148e0be5bf587b.jpg', 'https://mp.weixin.qq.com/s/xLdvLOg7ZShmdU055dpwxQ', 0, '2021-12-12 23:05:23', '2021-12-12 23:05:23', 1, 1, 0);
INSERT INTO `t_news` VALUES (918, '爪哇部落第一次交流分享会', 'https://s3.bmp.ovh/imgs/2021/12/1d6ffa0141470509.png', 'https://mp.weixin.qq.com/s/2HvCE6XzqX_D04LwZ2Nj1Q', 0, '2021-12-12 23:09:39', '2021-12-12 23:09:39', 1, 1, 0);

-- ----------------------------
-- Table structure for t_office
-- ----------------------------
DROP TABLE IF EXISTS `t_office`;
CREATE TABLE `t_office`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `employment` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就职单位',
  `position` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `career` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业方向',
  `sessions` int(0) NULL DEFAULT NULL COMMENT '届数',
  `gmt_create` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_office
-- ----------------------------
INSERT INTO `t_office` VALUES (6, '爪小哇', '爪哇部落', '吉祥物', '咱们爪哇部落呀，山清水秀，人杰地灵', 2020, '2021-04-16 15:09:28', '2021-04-16 15:14:08');
INSERT INTO `t_office` VALUES (7, '爪大哇', '爪哇部落', '现任背锅侠', '背锅呀，我熟~', 2019, '2021-04-16 15:12:37', '2021-04-16 15:13:25');

-- ----------------------------
-- Table structure for t_postgraduate
-- ----------------------------
DROP TABLE IF EXISTS `t_postgraduate`;
CREATE TABLE `t_postgraduate`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `school` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校',
  `profession` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `sessions` int(0) NULL DEFAULT NULL COMMENT '届数',
  `gmt_create` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_register_team
-- ----------------------------
DROP TABLE IF EXISTS `t_register_team`;
CREATE TABLE `t_register_team`  (
  `register_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `competition_id` bigint(0) NULL DEFAULT NULL,
  `team_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队伍名字',
  `team_leader_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队长名字',
  `team_leader_phone` varchar(180) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队长电话',
  `team_leader_student_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队长id',
  `team_leader_wechat` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队长微信',
  `team_leader_college` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队长学院',
  `team_user_list` varchar(180) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队长的成员列表',
  `delete_status` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '逻辑删除。0表示为未删除 1表示删除',
  `register_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '报名时间',
  `team_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '队员id',
  PRIMARY KEY (`register_id`) USING BTREE,
  INDEX `FK_Reference_3`(`competition_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_register_team
-- ----------------------------
INSERT INTO `t_register_team` VALUES (6, 1, '胜利队1', '我是', '15521474202', NULL, '1111', '赛道和', '我是第一个,我是第二个', 0, '2021-03-15 16:57:25', '2,3');
INSERT INTO `t_register_team` VALUES (7, 1, '胜利队2', '我是1', '15819162433', '181549221', NULL, NULL, '', 0, '2021-03-05 09:46:59', NULL);
INSERT INTO `t_register_team` VALUES (9, 1, '意识', '无敌', '15819162433', '111225', 'ssss', NULL, '', 0, '2021-03-05 11:46:35', NULL);
INSERT INTO `t_register_team` VALUES (10, 1, '我是', '我不是', '15819162433', '222222222222', 'sssssss', 'sssssssss', '', 0, '2021-03-07 17:05:36', NULL);
INSERT INTO `t_register_team` VALUES (11, 1, '你猜', '你猜', 'ssss', 'ssssss', 'ssssssssss', 'nicai1', '第一个,第二个', 0, '2021-03-15 16:57:28', '3,4');
INSERT INTO `t_register_team` VALUES (12, 1, 'nissss', 'ssss', 'ssss', 'ssss', 'ssss', 'sss', 'sssss,sssss', 0, '2021-03-15 16:57:30', '4,5');
INSERT INTO `t_register_team` VALUES (13, 17, '测试1什么都对', '队长姓名', '13234567890', '1323456789', '13234567890', '互金', '1,1,1', 0, '2021-03-20 09:29:57', '1,1,1');
INSERT INTO `t_register_team` VALUES (14, 1, '队伍名称', '这是队长名称', '15816412458', '154212', 'weixin1', 'college', 'xingming1,xingming2', 0, '2022-03-15 17:17:04', 'xingming1,xingm');
INSERT INTO `t_register_team` VALUES (16, 1, '队伍名称2', '你1猜', '15816412458', NULL, '互连', 'weixin1', 'ssss,小红', 0, '2021-03-20 10:09:09', '181549112,181549113');
INSERT INTO `t_register_team` VALUES (17, 1, '队伍名称3', '量钧彭1', '15816412458', '181549119', 'weixin1', '互联', '梁钧彭,张小红', 0, '2021-03-23 10:50:24', '181549112,181549113');
INSERT INTO `t_register_team` VALUES (18, 1, '队伍2', '梁钧彭', '13650730056', '181549119', 'chat', '护理学院', '茂平', 0, '2021-03-23 10:53:57', '181549140');
INSERT INTO `t_register_team` VALUES (20, 1, '刚问完', '滚滚滚', '15521455210', '181549135', 'fwefwef', NULL, '1213', 0, '2021-03-29 14:26:04', '181549136');
INSERT INTO `t_register_team` VALUES (33, 1, '11', '22', '15521455210', '181549101', '25', '55', '55', 0, '2021-04-02 10:29:13', '181549135');
INSERT INTO `t_register_team` VALUES (34, 1, '22', '33', '13631881051', '181549122', '66', '77', '99', 0, '2021-04-02 16:44:03', '181549135');
INSERT INTO `t_register_team` VALUES (35, 1, '相对队', '黄竣波', '13650730056', '181549120', '13650730056', '互金', '丘炳', 0, '2021-04-15 19:38:01', '181549130');
INSERT INTO `t_register_team` VALUES (36, 1, '的', '阿萨德', '13719518116', '181549149', '13719518116', '互联网金融', '是的', 0, '2021-04-16 10:21:03', '181549144');
INSERT INTO `t_register_team` VALUES (37, 1, '6516', '阿萨德想', '13719518117', '181549143', '13719518116', '互联网金融', '捱三顶五', 0, '2021-04-16 10:24:50', '181594144');

-- ----------------------------
-- Table structure for t_softwareDesign
-- ----------------------------
DROP TABLE IF EXISTS `t_softwareDesign`;
CREATE TABLE `t_softwareDesign`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` tinyint(0) NULL DEFAULT NULL COMMENT '获奖类型id',
  `teamName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队伍名称',
  `playerName` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '队员姓名',
  `rank` int(0) NULL DEFAULT NULL COMMENT '排名',
  `sessions` int(0) NULL DEFAULT NULL COMMENT '届数',
  `gmt_create` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_style_show
-- ----------------------------
DROP TABLE IF EXISTS `t_style_show`;
CREATE TABLE `t_style_show`  (
  `competition_id` bigint(0) NOT NULL COMMENT '比赛id，外键这个队伍是哪个比赛的',
  `show_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '展示id，主键',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `show_status` tinyint(1) NULL DEFAULT NULL COMMENT '如果是1表示展示前端，为0就是往期数据，不展示',
  `delete_status` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除 0表示没有删除，1表示删除',
  `show_order` int(0) NULL DEFAULT 0 COMMENT '展示的顺序，从小到大展示',
  `imgs` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片列表',
  `project_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `team_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队伍名字',
  `team_members` varchar(180) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队伍成员[使用逗号拼接]',
  `team_begin_time` datetime(0) NULL DEFAULT NULL COMMENT '队伍开始时间',
  `team_end_time` datetime(0) NULL DEFAULT NULL COMMENT '队伍结束时间',
  `the_year` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第几届',
  `year_id` int(0) NULL DEFAULT NULL COMMENT '第几届 -- >  the number of sessions 表',
  `team_master_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队伍的队长名字 【补充字段，暂时没用】',
  PRIMARY KEY (`show_id`) USING BTREE,
  INDEX `FK_Reference_1`(`competition_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 218 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_style_show
-- ----------------------------
INSERT INTO `t_style_show` VALUES (3, 1, '2021-02-01 00:14:16', '2021-02-01 00:14:16', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎_项目', '哈哈队伍', '林东,李某', '2021-02-01 00:14:15', '2021-02-01 00:14:15', '4', 3, NULL);
INSERT INTO `t_style_show` VALUES (3, 2, '2021-03-13 10:53:48', NULL, 1, 0, 1, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', 'A比赛APP', 'A队伍', '李某,吴某', '2021-03-13 10:52:46', '2021-03-13 10:52:51', '15', 3, NULL);
INSERT INTO `t_style_show` VALUES (3, 3, '2021-03-20 09:12:10', '2021-03-20 09:12:10', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-20 09:12:10', '2021-03-20 09:12:10', '8', 3, NULL);
INSERT INTO `t_style_show` VALUES (3, 4, '2021-03-20 09:16:10', '2021-03-20 09:16:10', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-20 09:16:10', '2021-03-20 09:16:10', '8', 3, NULL);
INSERT INTO `t_style_show` VALUES (2, 46, '2021-03-23 20:22:19', '2021-03-23 20:22:19', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:19', '2021-03-23 20:22:19', '2', 4, NULL);
INSERT INTO `t_style_show` VALUES (3, 47, '2021-03-23 20:22:19', '2021-03-23 20:22:19', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:19', '2021-03-23 20:22:19', '3', 4, NULL);
INSERT INTO `t_style_show` VALUES (4, 48, '2021-03-23 20:22:20', '2021-03-23 20:22:20', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:20', '2021-03-23 20:22:20', '4', 4, NULL);
INSERT INTO `t_style_show` VALUES (5, 49, '2021-03-23 20:22:20', '2021-03-23 20:22:20', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:20', '2021-03-23 20:22:20', '5', 4, NULL);
INSERT INTO `t_style_show` VALUES (6, 50, '2021-03-23 20:22:20', '2021-03-23 20:22:20', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:20', '2021-03-23 20:22:20', '6', 3, NULL);
INSERT INTO `t_style_show` VALUES (7, 51, '2021-03-23 20:22:21', '2021-03-23 20:22:21', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:20', '2021-03-23 20:22:20', '7', 3, NULL);
INSERT INTO `t_style_show` VALUES (1, 52, NULL, NULL, NULL, NULL, NULL, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', '1,2,3', NULL, NULL, NULL, 3, NULL);
INSERT INTO `t_style_show` VALUES (2, 53, '2021-03-23 20:22:21', '2021-03-23 20:22:21', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:21', '2021-03-23 20:22:21', '2', 3, NULL);
INSERT INTO `t_style_show` VALUES (3, 54, '2021-03-23 20:22:21', '2021-03-23 20:22:21', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:21', '2021-03-23 20:22:21', '3', 3, NULL);
INSERT INTO `t_style_show` VALUES (4, 55, '2021-03-23 20:22:22', '2021-03-23 20:22:22', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:22', '2021-03-23 20:22:22', '4', 3, NULL);
INSERT INTO `t_style_show` VALUES (5, 56, '2021-03-23 20:22:22', '2021-03-23 20:22:22', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:22', '2021-03-23 20:22:22', '5', 3, NULL);
INSERT INTO `t_style_show` VALUES (6, 57, '2021-03-23 20:22:22', '2021-03-23 20:22:22', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:22', '2021-03-23 20:22:22', '6', 3, NULL);
INSERT INTO `t_style_show` VALUES (7, 58, '2021-03-23 20:22:22', '2021-03-23 20:22:22', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:22', '2021-03-23 20:22:22', '7', 7, NULL);
INSERT INTO `t_style_show` VALUES (1, 59, NULL, NULL, NULL, NULL, NULL, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', '1,2,3', NULL, NULL, NULL, 7, NULL);
INSERT INTO `t_style_show` VALUES (2, 60, '2021-03-23 20:22:23', '2021-03-23 20:22:23', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:23', '2021-03-23 20:22:23', '2', 7, NULL);
INSERT INTO `t_style_show` VALUES (3, 61, '2021-03-23 20:22:23', '2021-03-23 20:22:23', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:23', '2021-03-23 20:22:23', '3', 7, NULL);
INSERT INTO `t_style_show` VALUES (4, 62, '2021-03-23 20:22:24', '2021-03-23 20:22:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:23', '2021-03-23 20:22:23', '4', 7, NULL);
INSERT INTO `t_style_show` VALUES (5, 63, '2021-03-23 20:22:24', '2021-03-23 20:22:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:24', '2021-03-23 20:22:24', '5', 7, NULL);
INSERT INTO `t_style_show` VALUES (6, 64, '2021-03-23 20:22:24', '2021-03-23 20:22:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:24', '2021-03-23 20:22:24', '6', 7, NULL);
INSERT INTO `t_style_show` VALUES (7, 65, '2021-03-23 20:22:24', '2021-03-23 20:22:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:24', '2021-03-23 20:22:24', '7', 7, NULL);
INSERT INTO `t_style_show` VALUES (1, 66, NULL, NULL, NULL, NULL, NULL, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', '1,2,3', NULL, NULL, NULL, 7, NULL);
INSERT INTO `t_style_show` VALUES (2, 67, '2021-03-23 20:22:25', '2021-03-23 20:22:25', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:25', '2021-03-23 20:22:25', '2', 7, NULL);
INSERT INTO `t_style_show` VALUES (3, 68, '2021-03-23 20:22:25', '2021-03-23 20:22:25', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:25', '2021-03-23 20:22:25', '3', 7, NULL);
INSERT INTO `t_style_show` VALUES (4, 69, '2021-03-23 20:22:25', '2021-03-23 20:22:25', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:25', '2021-03-23 20:22:25', '4', 5, NULL);
INSERT INTO `t_style_show` VALUES (5, 70, '2021-03-23 20:22:26', '2021-03-23 20:22:26', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:26', '2021-03-23 20:22:26', '5', 5, NULL);
INSERT INTO `t_style_show` VALUES (6, 71, '2021-03-23 20:22:26', '2021-03-23 20:22:26', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:26', '2021-03-23 20:22:26', '6', 5, NULL);
INSERT INTO `t_style_show` VALUES (7, 72, '2021-03-23 20:22:26', '2021-03-23 20:22:26', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:26', '2021-03-23 20:22:26', '7', 5, NULL);
INSERT INTO `t_style_show` VALUES (1, 73, NULL, NULL, NULL, NULL, NULL, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', '1,2,3', NULL, NULL, NULL, 9, NULL);
INSERT INTO `t_style_show` VALUES (2, 74, '2021-03-23 20:22:27', '2021-03-23 20:22:27', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:27', '2021-03-23 20:22:27', '2', 5, NULL);
INSERT INTO `t_style_show` VALUES (3, 75, '2021-03-23 20:22:27', '2021-03-23 20:22:27', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:27', '2021-03-23 20:22:27', '3', 5, NULL);
INSERT INTO `t_style_show` VALUES (4, 76, '2021-03-23 20:22:27', '2021-03-23 20:22:27', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:27', '2021-03-23 20:22:27', '4', 5, NULL);
INSERT INTO `t_style_show` VALUES (5, 77, '2021-03-23 20:22:28', '2021-03-23 20:22:28', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:28', '2021-03-23 20:22:28', '5', 5, NULL);
INSERT INTO `t_style_show` VALUES (6, 78, '2021-03-23 20:22:28', '2021-03-23 20:22:28', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:28', '2021-03-23 20:22:28', '6', 5, NULL);
INSERT INTO `t_style_show` VALUES (7, 79, '2021-03-23 20:22:28', '2021-03-23 20:22:28', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-23 20:22:28', '2021-03-23 20:22:28', '7', 5, NULL);
INSERT INTO `t_style_show` VALUES (1, 80, NULL, NULL, NULL, NULL, NULL, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎1', '哈哈队伍1', '1,2,3', NULL, NULL, NULL, 9, NULL);
INSERT INTO `t_style_show` VALUES (2, 81, '2021-03-23 20:23:37', '2021-03-23 20:23:37', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎2', '哈哈队伍2', NULL, '2021-03-23 20:23:37', '2021-03-23 20:23:37', '2', 5, NULL);
INSERT INTO `t_style_show` VALUES (3, 82, '2021-03-23 20:23:37', '2021-03-23 20:23:37', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎3', '哈哈队伍3', NULL, '2021-03-23 20:23:37', '2021-03-23 20:23:37', '3', 6, NULL);
INSERT INTO `t_style_show` VALUES (4, 83, '2021-03-23 20:23:37', '2021-03-23 20:23:37', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎4', '哈哈队伍4', NULL, '2021-03-23 20:23:37', '2021-03-23 20:23:37', '4', 6, NULL);
INSERT INTO `t_style_show` VALUES (5, 84, '2021-03-23 20:23:38', '2021-03-23 20:23:38', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎5', '哈哈队伍5', NULL, '2021-03-23 20:23:37', '2021-03-23 20:23:37', '5', 6, NULL);
INSERT INTO `t_style_show` VALUES (6, 85, '2021-03-23 20:23:38', '2021-03-23 20:23:38', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎6', '哈哈队伍6', NULL, '2021-03-23 20:23:38', '2021-03-23 20:23:38', '6', 6, NULL);
INSERT INTO `t_style_show` VALUES (7, 86, '2021-03-23 20:23:38', '2021-03-23 20:23:38', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎7', '哈哈队伍7', NULL, '2021-03-23 20:23:38', '2021-03-23 20:23:38', '7', 6, NULL);
INSERT INTO `t_style_show` VALUES (1, 87, NULL, NULL, NULL, NULL, NULL, NULL, '搜索引擎1', '哈哈队伍1', '888', NULL, NULL, NULL, 11, NULL);
INSERT INTO `t_style_show` VALUES (2, 88, '2021-03-23 20:23:39', '2021-03-23 20:23:39', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎2', '哈哈队伍2', NULL, '2021-03-23 20:23:39', '2021-03-23 20:23:39', '2', 6, NULL);
INSERT INTO `t_style_show` VALUES (3, 89, '2021-03-23 20:23:39', '2021-03-23 20:23:39', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎3', '哈哈队伍3', NULL, '2021-03-23 20:23:39', '2021-03-23 20:23:39', '3', 6, NULL);
INSERT INTO `t_style_show` VALUES (4, 90, '2021-03-23 20:23:39', '2021-03-23 20:23:39', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎4', '哈哈队伍4', NULL, '2021-03-23 20:23:39', '2021-03-23 20:23:39', '4', 6, NULL);
INSERT INTO `t_style_show` VALUES (5, 91, '2021-03-23 20:23:39', '2021-03-23 20:23:39', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎5', '哈哈队伍5', NULL, '2021-03-23 20:23:39', '2021-03-23 20:23:39', '5', 6, NULL);
INSERT INTO `t_style_show` VALUES (6, 92, '2021-03-23 20:23:40', '2021-03-23 20:23:40', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎6', '哈哈队伍6', NULL, '2021-03-23 20:23:40', '2021-03-23 20:23:40', '6', 6, NULL);
INSERT INTO `t_style_show` VALUES (7, 93, '2021-03-23 20:23:40', '2021-03-23 20:23:40', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎7', '哈哈队伍7', NULL, '2021-03-23 20:23:40', '2021-03-23 20:23:40', '7', 6, NULL);
INSERT INTO `t_style_show` VALUES (1, 94, NULL, NULL, NULL, NULL, NULL, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎1', '哈哈队伍1', '1', NULL, NULL, NULL, 10, NULL);
INSERT INTO `t_style_show` VALUES (2, 95, '2021-03-23 20:23:41', '2021-03-23 20:23:41', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎2', '哈哈队伍2', NULL, '2021-03-23 20:23:41', '2021-03-23 20:23:41', '2', 8, NULL);
INSERT INTO `t_style_show` VALUES (3, 96, '2021-03-23 20:23:41', '2021-03-23 20:23:41', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎3', '哈哈队伍3', NULL, '2021-03-23 20:23:41', '2021-03-23 20:23:41', '3', 8, NULL);
INSERT INTO `t_style_show` VALUES (4, 97, '2021-03-23 20:23:41', '2021-03-23 20:23:41', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎4', '哈哈队伍4', NULL, '2021-03-23 20:23:41', '2021-03-23 20:23:41', '4', 8, NULL);
INSERT INTO `t_style_show` VALUES (5, 98, '2021-03-23 20:23:41', '2021-03-23 20:23:41', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎5', '哈哈队伍5', NULL, '2021-03-23 20:23:41', '2021-03-23 20:23:41', '5', 8, NULL);
INSERT INTO `t_style_show` VALUES (6, 99, '2021-03-23 20:23:42', '2021-03-23 20:23:42', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎6', '哈哈队伍6', NULL, '2021-03-23 20:23:42', '2021-03-23 20:23:42', '6', 8, NULL);
INSERT INTO `t_style_show` VALUES (7, 100, '2021-03-23 20:23:42', '2021-03-23 20:23:42', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎7', '哈哈队伍7', NULL, '2021-03-23 20:23:42', '2021-03-23 20:23:42', '7', 8, NULL);
INSERT INTO `t_style_show` VALUES (1, 101, '2021-03-23 20:23:42', '2021-03-23 20:23:42', 1, 1, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎1', '哈哈队伍1', '1,2,3', '2021-03-23 20:23:42', '2021-03-23 20:23:42', '1', 10, NULL);
INSERT INTO `t_style_show` VALUES (2, 102, '2021-03-23 20:23:43', '2021-03-23 20:23:43', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎2', '哈哈队伍2', NULL, '2021-03-23 20:23:42', '2021-03-23 20:23:42', '2', 8, NULL);
INSERT INTO `t_style_show` VALUES (3, 103, '2021-03-23 20:23:43', '2021-03-23 20:23:43', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎3', '哈哈队伍3', NULL, '2021-03-23 20:23:43', '2021-03-23 20:23:43', '3', 8, NULL);
INSERT INTO `t_style_show` VALUES (4, 104, '2021-03-23 20:23:43', '2021-03-23 20:23:43', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎4', '哈哈队伍4', NULL, '2021-03-23 20:23:43', '2021-03-23 20:23:43', '4', 8, NULL);
INSERT INTO `t_style_show` VALUES (5, 105, '2021-03-23 20:23:43', '2021-03-23 20:23:43', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎5', '哈哈队伍5', NULL, '2021-03-23 20:23:43', '2021-03-23 20:23:43', '5', 8, NULL);
INSERT INTO `t_style_show` VALUES (6, 106, '2021-03-23 20:23:44', '2021-03-23 20:23:44', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎6', '哈哈队伍6', NULL, '2021-03-23 20:23:44', '2021-03-23 20:23:44', '6', 8, NULL);
INSERT INTO `t_style_show` VALUES (7, 107, '2021-03-23 20:23:44', '2021-03-23 20:23:44', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎7', '哈哈队伍7', NULL, '2021-03-23 20:23:44', '2021-03-23 20:23:44', '7', 9, NULL);
INSERT INTO `t_style_show` VALUES (1, 108, '2021-03-23 20:23:44', '2021-03-23 20:23:44', 1, 1, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎1', '哈哈队伍1', NULL, '2021-03-23 20:23:44', '2021-03-23 20:23:44', '1', 9, NULL);
INSERT INTO `t_style_show` VALUES (2, 109, '2021-03-23 20:23:44', '2021-03-23 20:23:44', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎2', '哈哈队伍2', NULL, '2021-03-23 20:23:44', '2021-03-23 20:23:44', '2', 9, NULL);
INSERT INTO `t_style_show` VALUES (3, 110, '2021-03-23 20:23:45', '2021-03-23 20:23:45', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎3', '哈哈队伍3', NULL, '2021-03-23 20:23:45', '2021-03-23 20:23:45', '3', 9, NULL);
INSERT INTO `t_style_show` VALUES (4, 111, '2021-03-23 20:23:45', '2021-03-23 20:23:45', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎4', '哈哈队伍4', NULL, '2021-03-23 20:23:45', '2021-03-23 20:23:45', '4', 9, NULL);
INSERT INTO `t_style_show` VALUES (5, 112, '2021-03-23 20:23:45', '2021-03-23 20:23:45', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎5', '哈哈队伍5', NULL, '2021-03-23 20:23:45', '2021-03-23 20:23:45', '5', 9, NULL);
INSERT INTO `t_style_show` VALUES (6, 113, '2021-03-23 20:23:46', '2021-03-23 20:23:46', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎6', '哈哈队伍6', NULL, '2021-03-23 20:23:46', '2021-03-23 20:23:46', '6', 9, NULL);
INSERT INTO `t_style_show` VALUES (7, 114, '2021-03-23 20:23:46', '2021-03-23 20:23:46', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎7', '哈哈队伍7', NULL, '2021-03-23 20:23:46', '2021-03-23 20:23:46', '7', 9, NULL);
INSERT INTO `t_style_show` VALUES (1, 115, '2021-03-25 18:02:47', '2021-03-25 18:02:47', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎2队伍', '铠甲2队', '222,333', '2021-03-25 18:02:47', '2021-03-25 18:02:47', NULL, 1, NULL);
INSERT INTO `t_style_show` VALUES (1, 116, '2021-03-25 18:02:47', '2021-03-25 18:02:47', 1, 1, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-25 18:02:47', '2021-03-25 18:02:47', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 117, '2021-03-25 18:02:47', '2021-03-25 18:02:47', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-25 18:02:47', '2021-03-25 18:02:47', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 118, '2021-03-25 18:02:48', '2021-03-25 18:02:48', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-25 18:02:48', '2021-03-25 18:02:48', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 119, '2021-03-25 18:02:48', '2021-03-25 18:02:48', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-25 18:02:48', '2021-03-25 18:02:48', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 120, '2021-03-25 19:10:47', '2021-03-25 19:10:47', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '12', '111', '1,2,3', NULL, NULL, '1', NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 121, '2021-03-25 19:48:40', '2021-03-25 19:48:40', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '测试', '测试队伍', '1,2,3', NULL, NULL, NULL, 1, NULL);
INSERT INTO `t_style_show` VALUES (1, 122, '2021-03-25 20:05:36', '2021-03-25 20:05:36', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '全国大学生问卷趣答队', '蒙文', '555', NULL, NULL, NULL, 12, NULL);
INSERT INTO `t_style_show` VALUES (1, 123, '2021-03-25 20:06:06', '2021-03-25 20:06:06', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '888', '8888', '4444444', NULL, NULL, NULL, 13, NULL);
INSERT INTO `t_style_show` VALUES (1, 124, '2021-03-25 20:08:45', '2021-03-25 20:08:45', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', 'VRVR额', '付费无法', '222', NULL, NULL, NULL, 24, NULL);
INSERT INTO `t_style_show` VALUES (1, 125, '2021-03-25 20:15:28', '2021-03-25 20:15:28', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '测试', '555', '33，222', NULL, NULL, NULL, 15, NULL);
INSERT INTO `t_style_show` VALUES (1, 126, '2021-03-25 20:16:26', '2021-03-25 20:16:26', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '分隔', '分隔', '11,22', NULL, NULL, NULL, 16, NULL);
INSERT INTO `t_style_show` VALUES (1, 127, '2021-03-30 18:24:24', '2021-03-30 18:24:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:24:24', '2021-03-30 18:24:24', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 128, '2021-03-30 18:24:24', '2021-03-30 18:24:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:24:24', '2021-03-30 18:24:24', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 129, '2021-03-30 18:24:24', '2021-03-30 18:24:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:24:24', '2021-03-30 18:24:24', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 130, '2021-03-30 18:24:25', '2021-03-30 18:24:25', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:24:25', '2021-03-30 18:24:25', NULL, 1, NULL);
INSERT INTO `t_style_show` VALUES (1, 131, '2021-03-30 18:24:25', '2021-03-30 18:24:25', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:24:25', '2021-03-30 18:24:25', NULL, 1, NULL);
INSERT INTO `t_style_show` VALUES (1, 132, '2021-03-30 18:25:39', '2021-03-30 18:25:39', 1, 0, 2, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104151705033375.png', '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:25:39', '2021-03-30 18:25:39', NULL, 1, NULL);
INSERT INTO `t_style_show` VALUES (1, 133, '2021-03-30 18:25:39', '2021-03-30 18:25:39', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:25:39', '2021-03-30 18:25:39', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 134, '2021-03-30 18:25:40', '2021-03-30 18:25:40', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:25:40', '2021-03-30 18:25:40', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 135, '2021-03-30 18:25:40', '2021-03-30 18:25:40', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:25:40', '2021-03-30 18:25:40', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 136, '2021-03-30 18:25:40', '2021-03-30 18:25:40', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:25:40', '2021-03-30 18:25:40', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 137, '2021-03-30 18:26:07', '2021-03-30 18:26:07', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:26:07', '2021-03-30 18:26:07', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 138, '2021-03-30 18:26:07', '2021-03-30 18:26:07', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:26:07', '2021-03-30 18:26:07', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 139, '2021-03-30 18:26:07', '2021-03-30 18:26:07', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:26:07', '2021-03-30 18:26:07', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 140, '2021-03-30 18:26:08', '2021-03-30 18:26:08', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:26:07', '2021-03-30 18:26:07', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 141, '2021-03-30 18:26:08', '2021-03-30 18:26:08', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:26:08', '2021-03-30 18:26:08', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 142, '2021-03-30 18:27:14', '2021-03-30 18:27:14', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:14', '2021-03-30 18:27:14', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 143, '2021-03-30 18:27:15', '2021-03-30 18:27:15', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:15', '2021-03-30 18:27:15', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 144, '2021-03-30 18:27:15', '2021-03-30 18:27:15', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:15', '2021-03-30 18:27:15', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 145, '2021-03-30 18:27:15', '2021-03-30 18:27:15', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:15', '2021-03-30 18:27:15', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 146, '2021-03-30 18:27:15', '2021-03-30 18:27:15', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:15', '2021-03-30 18:27:15', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 147, '2021-03-30 18:27:56', '2021-03-30 18:27:56', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:56', '2021-03-30 18:27:56', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 148, '2021-03-30 18:27:56', '2021-03-30 18:27:56', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:56', '2021-03-30 18:27:56', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 149, '2021-03-30 18:27:56', '2021-03-30 18:27:56', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:56', '2021-03-30 18:27:56', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 150, '2021-03-30 18:27:57', '2021-03-30 18:27:57', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:57', '2021-03-30 18:27:57', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 151, '2021-03-30 18:27:57', '2021-03-30 18:27:57', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:27:57', '2021-03-30 18:27:57', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 152, '2021-03-30 18:28:34', '2021-03-30 18:28:34', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:28:34', '2021-03-30 18:28:34', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 153, '2021-03-30 18:28:34', '2021-03-30 18:28:34', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:28:34', '2021-03-30 18:28:34', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 154, '2021-03-30 18:28:34', '2021-03-30 18:28:34', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:28:34', '2021-03-30 18:28:34', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 155, '2021-03-30 18:28:35', '2021-03-30 18:28:35', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:28:35', '2021-03-30 18:28:35', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 156, '2021-03-30 18:28:35', '2021-03-30 18:28:35', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:28:35', '2021-03-30 18:28:35', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 157, '2021-03-30 18:29:15', '2021-03-30 18:29:15', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:15', '2021-03-30 18:29:15', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 158, '2021-03-30 18:29:15', '2021-03-30 18:29:15', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:15', '2021-03-30 18:29:15', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 159, '2021-03-30 18:29:16', '2021-03-30 18:29:16', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:15', '2021-03-30 18:29:15', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 160, '2021-03-30 18:29:16', '2021-03-30 18:29:16', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:16', '2021-03-30 18:29:16', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 161, '2021-03-30 18:29:16', '2021-03-30 18:29:16', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:16', '2021-03-30 18:29:16', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 162, '2021-03-30 18:29:53', '2021-03-30 18:29:53', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:53', '2021-03-30 18:29:53', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 163, '2021-03-30 18:29:53', '2021-03-30 18:29:53', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:53', '2021-03-30 18:29:53', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 164, '2021-03-30 18:29:53', '2021-03-30 18:29:53', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:53', '2021-03-30 18:29:53', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 165, '2021-03-30 18:29:54', '2021-03-30 18:29:54', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:54', '2021-03-30 18:29:54', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 166, '2021-03-30 18:29:54', '2021-03-30 18:29:54', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:29:54', '2021-03-30 18:29:54', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 167, '2021-03-30 18:30:23', '2021-03-30 18:30:23', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:23', '2021-03-30 18:30:23', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 168, '2021-03-30 18:30:23', '2021-03-30 18:30:23', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:23', '2021-03-30 18:30:23', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 169, '2021-03-30 18:30:24', '2021-03-30 18:30:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:24', '2021-03-30 18:30:24', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 170, '2021-03-30 18:30:24', '2021-03-30 18:30:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:24', '2021-03-30 18:30:24', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 171, '2021-03-30 18:30:24', '2021-03-30 18:30:24', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:24', '2021-03-30 18:30:24', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 172, '2021-03-30 18:30:54', '2021-03-30 18:30:54', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:54', '2021-03-30 18:30:54', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 173, '2021-03-30 18:30:55', '2021-03-30 18:30:55', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:55', '2021-03-30 18:30:55', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 174, '2021-03-30 18:30:55', '2021-03-30 18:30:55', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:55', '2021-03-30 18:30:55', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 175, '2021-03-30 18:30:55', '2021-03-30 18:30:55', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:55', '2021-03-30 18:30:55', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 176, '2021-03-30 18:30:55', '2021-03-30 18:30:55', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-03-30 18:30:55', '2021-03-30 18:30:55', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 177, '2021-04-07 10:40:58', '2021-04-07 10:40:58', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-07 10:40:58', '2021-04-07 10:40:58', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 178, '2021-04-07 10:40:59', '2021-04-07 10:40:59', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-07 10:40:59', '2021-04-07 10:40:59', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 179, '2021-04-07 10:40:59', '2021-04-07 10:40:59', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-07 10:40:59', '2021-04-07 10:40:59', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 180, '2021-04-07 10:41:00', '2021-04-07 10:41:00', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-07 10:41:00', '2021-04-07 10:41:00', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 181, '2021-04-07 10:41:00', '2021-04-07 10:41:00', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-07 10:41:00', '2021-04-07 10:41:00', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 182, '2021-04-15 10:27:38', '2021-04-15 10:27:38', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:27:38', '2021-04-15 10:27:38', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 183, '2021-04-15 10:27:38', '2021-04-15 10:27:38', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:27:38', '2021-04-15 10:27:38', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 184, '2021-04-15 10:27:39', '2021-04-15 10:27:39', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:27:39', '2021-04-15 10:27:39', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 185, '2021-04-15 10:27:39', '2021-04-15 10:27:39', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:27:39', '2021-04-15 10:27:39', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 186, '2021-04-15 10:27:39', '2021-04-15 10:27:39', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:27:39', '2021-04-15 10:27:39', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 187, '2021-04-15 10:41:50', '2021-04-15 10:41:50', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:41:50', '2021-04-15 10:41:50', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 188, '2021-04-15 10:41:50', '2021-04-15 10:41:50', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:41:50', '2021-04-15 10:41:50', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 189, '2021-04-15 10:41:51', '2021-04-15 10:41:51', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:41:51', '2021-04-15 10:41:51', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 190, '2021-04-15 10:41:51', '2021-04-15 10:41:51', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:41:51', '2021-04-15 10:41:51', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 191, '2021-04-15 10:41:51', '2021-04-15 10:41:51', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-15 10:41:51', '2021-04-15 10:41:51', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 192, '2021-04-16 14:35:13', '2021-04-16 14:35:13', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161435111934.JPG', '合照', '合照', '合照', NULL, NULL, NULL, 9, NULL);
INSERT INTO `t_style_show` VALUES (1, 193, '2021-04-16 14:38:45', '2021-04-16 14:38:45', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161438444399.JPG', '合照', '合照', '合照', NULL, NULL, NULL, 26, NULL);
INSERT INTO `t_style_show` VALUES (1, 194, '2021-04-16 14:39:04', '2021-04-16 14:39:04', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161439011846.JPG', '合照', '合照', '合照', NULL, NULL, NULL, 11, NULL);
INSERT INTO `t_style_show` VALUES (1, 195, '2021-04-16 14:40:18', '2021-04-16 14:40:18', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161440166109.JPG', '合照', '合照', '合照', NULL, NULL, NULL, 27, NULL);
INSERT INTO `t_style_show` VALUES (1, 196, '2021-04-16 14:40:42', '2021-04-16 14:40:42', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/20210416144040365.JPG', '合照', '合照', '合照', NULL, NULL, NULL, 10, NULL);
INSERT INTO `t_style_show` VALUES (1, 197, '2021-04-16 14:40:57', '2021-04-16 14:40:57', 1, 0, 0, 'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/article/202104161440555715.JPG', '合照', '合照', '合照', NULL, NULL, NULL, 25, NULL);
INSERT INTO `t_style_show` VALUES (1, 198, '2021-04-16 15:01:00', '2021-04-16 15:01:00', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:01:00', '2021-04-16 15:01:00', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 199, '2021-04-16 15:01:01', '2021-04-16 15:01:01', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:01:01', '2021-04-16 15:01:01', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 200, '2021-04-16 15:01:01', '2021-04-16 15:01:01', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:01:01', '2021-04-16 15:01:01', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 201, '2021-04-16 15:01:01', '2021-04-16 15:01:01', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:01:01', '2021-04-16 15:01:01', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 202, '2021-04-16 15:01:02', '2021-04-16 15:01:02', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:01:02', '2021-04-16 15:01:02', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 203, '2021-04-16 15:02:04', '2021-04-16 15:02:04', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:02:04', '2021-04-16 15:02:04', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 204, '2021-04-16 15:02:05', '2021-04-16 15:02:05', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:02:05', '2021-04-16 15:02:05', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 205, '2021-04-16 15:02:05', '2021-04-16 15:02:05', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:02:05', '2021-04-16 15:02:05', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 206, '2021-04-16 15:02:06', '2021-04-16 15:02:06', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:02:06', '2021-04-16 15:02:06', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 207, '2021-04-16 15:02:06', '2021-04-16 15:02:06', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:02:06', '2021-04-16 15:02:06', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 208, '2021-04-16 15:03:41', '2021-04-16 15:03:41', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:03:41', '2021-04-16 15:03:41', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 209, '2021-04-16 15:03:42', '2021-04-16 15:03:42', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:03:42', '2021-04-16 15:03:42', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 210, '2021-04-16 15:03:43', '2021-04-16 15:03:43', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:03:43', '2021-04-16 15:03:43', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 211, '2021-04-16 15:03:43', '2021-04-16 15:03:43', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:03:43', '2021-04-16 15:03:43', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 212, '2021-04-16 15:03:44', '2021-04-16 15:03:44', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:03:44', '2021-04-16 15:03:44', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 213, '2021-04-16 15:05:03', '2021-04-16 15:05:03', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:05:03', '2021-04-16 15:05:03', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 214, '2021-04-16 15:05:03', '2021-04-16 15:05:03', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:05:03', '2021-04-16 15:05:03', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 215, '2021-04-16 15:05:04', '2021-04-16 15:05:04', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:05:04', '2021-04-16 15:05:04', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 216, '2021-04-16 15:05:04', '2021-04-16 15:05:04', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:05:04', '2021-04-16 15:05:04', NULL, NULL, NULL);
INSERT INTO `t_style_show` VALUES (1, 217, '2021-04-16 15:05:05', '2021-04-16 15:05:05', 1, 0, 2, NULL, '搜索引擎 &lt;script&gt;alert(&#39;ssss&#39;)&lt;/script&gt;', '哈哈队伍', NULL, '2021-04-16 15:05:05', '2021-04-16 15:05:05', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `tag_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '标签id，自增主键',
  `tag_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `tag_parent` int(0) NOT NULL COMMENT '所属父标签的id',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `delete_status` int(0) NULL DEFAULT 0 COMMENT '逻辑删，0表示可用，1表示禁用',
  PRIMARY KEY (`tag_id`) USING BTREE,
  INDEX `tag_name`(`tag_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, '前端', 0, '2021-04-16 08:06:44', '2021-04-16 08:06:44', 0);
INSERT INTO `t_tag` VALUES (2, '后端', 0, '2021-04-16 08:07:31', '2021-04-16 08:07:31', 0);
INSERT INTO `t_tag` VALUES (3, '设计', 0, '2021-04-16 08:07:46', '2021-04-16 08:07:46', 0);
INSERT INTO `t_tag` VALUES (4, '产品', 0, '2021-04-16 08:07:56', '2021-04-16 08:07:56', 0);
INSERT INTO `t_tag` VALUES (5, '算法', 0, '2021-04-16 08:08:06', '2021-04-16 08:08:06', 0);
INSERT INTO `t_tag` VALUES (6, '安卓', 0, '2021-04-16 08:08:17', '2021-04-16 08:08:17', 0);
INSERT INTO `t_tag` VALUES (7, 'js', 1, '2021-04-16 13:10:34', '2021-04-16 13:10:34', 0);
INSERT INTO `t_tag` VALUES (8, 'tomcat', 2, '2021-04-16 13:37:34', '2021-04-16 13:37:34', 0);
INSERT INTO `t_tag` VALUES (9, '随笔', 4, '2021-04-16 13:56:01', '2021-04-16 13:56:01', 0);
INSERT INTO `t_tag` VALUES (10, 'Java', 5, '2021-04-16 14:01:04', '2021-04-16 14:01:04', 0);
INSERT INTO `t_tag` VALUES (11, 'px', 3, '2021-04-16 14:12:39', '2021-04-16 14:12:39', 0);
INSERT INTO `t_tag` VALUES (12, '随想', 6, '2021-04-16 14:15:22', '2021-04-16 14:15:22', 0);
INSERT INTO `t_tag` VALUES (13, 'test', 1, '2021-09-01 14:41:51', '2021-09-01 14:41:51', 0);

-- ----------------------------
-- Table structure for t_winner_team
-- ----------------------------
DROP TABLE IF EXISTS `t_winner_team`;
CREATE TABLE `t_winner_team`  (
  `prize_id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '唯一键',
  `team_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队伍名字',
  `team_user_list` varchar(180) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队伍成员列表',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `the_year` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第几届',
  `team_begin_time` datetime(0) NULL DEFAULT NULL COMMENT '队伍开始时间',
  `team_end_time` datetime(0) NULL DEFAULT NULL COMMENT '队伍结束时间',
  `delete_status` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `competition_id` bigint(0) NULL DEFAULT NULL COMMENT '比赛ID',
  `team_order_num` int(0) NULL DEFAULT NULL COMMENT '表示几等奖【由数字开始，即1，主要用于排序】',
  `team_order_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表示几等奖【由文本开始，即一等奖，主要用于展示】',
  PRIMARY KEY (`prize_id`) USING BTREE,
  INDEX `FK_Reference_2`(`competition_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_winner_team
-- ----------------------------
INSERT INTO `t_winner_team` VALUES (00000000000000000001, '第一个队伍', '队员1，队员2，队员4', '2021-01-05 20:00:04', '2021-01-13 20:00:09', '1', '2020-01-01 20:00:19', '2021-01-17 20:00:34', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000002, '第二个队伍', '队员1，队员2，队员3', '2021-01-05 20:02:22', '2021-01-17 20:02:39', '1', '2020-01-17 20:03:01', '2020-01-17 20:03:07', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000003, '第三个队伍', '队员1，队员2，队员3', '2021-01-17 20:04:12', '2021-01-17 20:04:15', '1', '2020-01-01 20:04:22', '2020-01-17 20:04:34', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000004, '第四个队伍', '队员1，队员2，队员3', '2021-01-17 20:05:16', '2021-01-17 20:05:21', '1', '2020-01-17 20:05:29', '2020-01-17 20:05:35', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000005, '第五个队伍', '队员1，队员2，队员3', '2021-01-17 20:34:02', '2021-01-17 20:34:11', '2', '2021-12-01 20:35:10', '2021-12-17 20:35:19', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000006, '第六个队伍', '队员1，队员2，队员3', '2021-01-17 20:35:52', '2021-01-17 20:35:54', '2', '2021-12-17 20:36:01', '2021-12-17 20:36:08', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000013, '第一个队伍', '1,2,3', '2021-04-02 15:40:12', '2021-04-02 15:40:12', '1', '2021-04-14 00:00:00', '2021-04-15 00:00:00', 0, 1, 2, '二等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000014, '测试', '1,2,3', '2021-04-02 15:59:45', '2021-04-02 15:59:45', '22', '2021-04-05 00:00:00', '2021-04-07 00:00:00', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000015, '测试', '2,3,5,4', '2021-04-02 16:02:05', '2021-04-02 16:02:05', '10', '2021-04-05 00:00:00', '2021-04-22 00:00:00', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000016, '测试', '1,2,3', '2021-04-02 16:04:24', '2021-04-02 16:04:24', '11', '2021-04-19 00:00:00', '2021-04-23 00:00:00', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000017, '测试', '5,6,8', '2021-04-02 16:07:36', '2021-04-02 16:07:36', '7', '2021-03-25 10:16:56', '2021-03-25 10:16:58', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000018, '测试', '我,可,以', '2021-04-02 16:09:07', '2021-04-02 16:09:07', '8', '2021-03-25 10:17:00', '2021-03-25 10:17:04', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000019, '测试', '1,2,3', '2021-04-02 16:16:33', '2021-04-02 16:16:33', '7', '2021-03-25 10:16:56', '2021-03-25 10:16:58', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000020, '测试', '1,2,3', '2021-04-02 16:17:36', '2021-04-02 16:17:36', '7', '2021-03-25 10:16:56', '2021-03-25 10:16:58', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000022, '第三个队伍', '1,2,3,5,6', '2021-04-02 21:00:43', '2021-04-02 21:00:43', '2', '2021-03-25 10:16:53', '2021-03-25 10:16:50', 0, 1, 3, '三等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000023, '测试', '1,2,3', '2021-04-02 21:05:48', '2021-04-02 21:05:48', '8', '2021-03-25 10:17:00', '2021-03-25 10:17:04', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000024, '测试', '1,2,3', '2021-04-02 21:06:15', '2021-04-02 21:06:15', '8', '2021-03-25 10:17:00', '2021-03-25 10:17:04', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000027, '测试', '1,2,3', '2021-04-03 10:42:53', '2021-04-03 10:42:53', '16', '2021-04-05 00:00:00', '2021-04-16 00:00:00', 0, 1, 1, '一等奖');
INSERT INTO `t_winner_team` VALUES (00000000000000000028, '测试', '2,3,5', '2021-04-03 10:46:19', '2021-04-03 10:46:19', '16', '2021-04-05 00:00:00', '2021-04-16 00:00:00', 0, 1, 2, '二等奖');

-- ----------------------------
-- Table structure for test_notice
-- ----------------------------
DROP TABLE IF EXISTS `test_notice`;
CREATE TABLE `test_notice`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考核名称',
  `test_direction` int(0) NULL DEFAULT 1 COMMENT '考核方向（1 前端 2 后端 3 设计 4算法 5产品 6安卓）',
  `notice_file` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '考核文件url（多个用,分割）',
  `delete_mark` int(0) NOT NULL DEFAULT 0,
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考核通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_notice
-- ----------------------------
INSERT INTO `test_notice` VALUES (114, '2021爪哇部落前端组第二轮考核', 1, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/20210418120020500_前端第一次考核问题.docx\']', 0, '2021-04-15 11:16:33', '2021-04-18 12:00:24');
INSERT INTO `test_notice` VALUES (115, '2021爪哇部落设计组第二轮考核', 3, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181156055329_爪哇部落设计组第二次考核作业(3).docx\']', 0, '2021-04-18 11:56:15', '2021-04-18 11:56:15');
INSERT INTO `test_notice` VALUES (116, '2021爪哇部落后端组第二轮考核', 2, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181156588165_2021爪哇部落后端第二次考核 .docx\']', 0, '2021-04-18 11:57:03', '2021-04-18 11:57:03');
INSERT INTO `test_notice` VALUES (117, '2021爪哇部落算法组第二轮考核', 4, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181157377396_算法组第二次考核作业.docx\']', 0, '2021-04-18 11:57:40', '2021-04-18 11:57:40');
INSERT INTO `test_notice` VALUES (118, '2021爪哇部落产品组第二轮考核', 5, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181158177748_产品组第二次考核(1).docx\']', 0, '2021-04-18 11:58:22', '2021-04-18 11:58:22');
INSERT INTO `test_notice` VALUES (119, '2021爪哇部落安卓组第二轮考核', 6, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202104181158588183_安卓第二轮考核.docx\']', 0, '2021-04-18 11:58:59', '2021-04-18 11:58:59');
INSERT INTO `test_notice` VALUES (120, '2021爪哇部落后端组第三轮考核', 2, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105110805299404_2021爪哇部落后端第三次考核作业.docx\']', 0, '2021-05-11 08:05:36', '2021-05-11 08:05:36');
INSERT INTO `test_notice` VALUES (121, '2021爪哇部落设计组第三轮考核', 3, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105110806044774_2021爪哇部落设计组第三次考核作业.docx\']', 0, '2021-05-11 08:06:07', '2021-05-11 08:06:07');
INSERT INTO `test_notice` VALUES (122, '2021爪哇部落产品组第三轮考核', 5, '[\'https://javatribe2.oss-cn-guangzhou.aliyuncs.com/zip/202105110806444720_2021爪哇部落产品组第三次考核.docx\']', 0, '2021-05-11 08:06:47', '2021-05-11 08:06:47');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_type` int(0) NULL DEFAULT 1 COMMENT '1用户 2管理员,3超级管理员',
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `delete_mark` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '181549126', '梁永辉', 'U2lzdGVyMTk5NzExMjQ=', 3, '2021-03-30 16:24:51', '2021-03-30 16:24:51', 0);
INSERT INTO `user` VALUES (2, '181549135', '丘炳辉', 'cWJoMTIzMC4w', 3, '2021-04-10 22:00:42', '2021-04-10 22:00:42', 0);
INSERT INTO `user` VALUES (3, '181549422', '胡曦', 'aHV4aTkxMzg=', 3, '2021-04-10 22:19:21', '2021-04-10 22:19:21', 0);
INSERT INTO `user` VALUES (4, '181549128', '林城武', NULL, 3, '2021-04-14 20:01:40', '2021-04-14 20:01:40', 0);
INSERT INTO `user` VALUES (5, '181549140', '吴茂平', NULL, 3, '2021-04-14 20:10:38', '2021-04-14 20:10:38', 0);
INSERT INTO `user` VALUES (6, '181543343', '吴泽鹏', 'MTYxNDM5Mjgwamts', 1, '2021-04-15 10:28:26', '2021-04-15 10:28:26', 0);
INSERT INTO `user` VALUES (7, '181543120', '邓宇良', NULL, 3, '2021-04-15 14:33:52', '2021-04-15 14:33:52', 0);
INSERT INTO `user` VALUES (8, '181549149', '钟嘉伟', 'MTIzNDU2Nzg5cQ==', 1, '2021-04-15 16:07:13', '2021-04-15 16:07:13', 0);
INSERT INTO `user` VALUES (9, '181549119', '黄竣波', 'MjAxOGZlbmRvdQ==', 1, '2021-04-15 18:30:29', '2021-04-15 18:30:29', 0);
INSERT INTO `user` VALUES (10, '181543404', '刘家旻', 'NTIwMTMxNGxqbQ==', 1, '2021-04-16 10:31:24', '2021-04-16 10:31:24', 0);
INSERT INTO `user` VALUES (11, '181543245', '吴奕涛', 'd2Vpbmllcmh1by4xLg==', 1, '2021-04-16 11:03:22', '2021-04-16 11:03:22', 0);
INSERT INTO `user` VALUES (12, '171543303', '黄海丽', 'MDc2OTI2YWI=', 1, '2021-04-16 11:04:54', '2021-04-16 11:04:54', 0);
INSERT INTO `user` VALUES (13, '191543110', '蔡昊彤', 'MjQ2ODE1OWNodA==', 1, '2021-04-16 11:07:26', '2021-04-16 11:07:26', 0);
INSERT INTO `user` VALUES (14, '191541227', '吴彦臻', 'cXExMjM0NTY=', 1, '2021-04-16 11:11:19', '2021-04-16 11:11:19', 0);
INSERT INTO `user` VALUES (15, '181543223', '江宏鑫', 'd2VuamluZzEyMy4=', 1, '2021-04-16 11:15:16', '2021-04-16 11:15:16', 0);
INSERT INTO `user` VALUES (16, '191543430', '王维', 'NzY3NTBqd3c=', 1, '2021-04-16 11:20:09', '2021-04-16 11:20:09', 0);
INSERT INTO `user` VALUES (17, '181543226', '李禧源', 'eHk4ODQwNDc=', 1, '2021-04-16 11:50:54', '2021-04-16 11:50:54', 0);
INSERT INTO `user` VALUES (18, '171543106', '梁雅群', 'ZmViYnkxMjM=', 1, '2021-04-16 12:05:31', '2021-04-16 12:05:31', 0);
INSERT INTO `user` VALUES (19, '171543117', '陈兆东', 'Y3pkNzY5Mzk0', 1, '2021-04-16 16:26:37', '2021-04-16 16:26:37', 0);
INSERT INTO `user` VALUES (20, '161543305', '张云倩', 'cXVlZW44ODY5MjA=', 1, '2021-04-16 16:26:51', '2021-04-16 16:26:51', 0);
INSERT INTO `user` VALUES (21, '161543446', '余捷', 'dWZvMTAxMjAz', 1, '2021-04-16 16:27:16', '2021-04-16 16:27:16', 0);
INSERT INTO `user` VALUES (22, '171543409', '朱小霞', 'enh4MzAxNTU4NzQ=', 1, '2021-04-16 16:28:13', '2021-04-16 16:28:13', 0);
INSERT INTO `user` VALUES (23, '171543113', '陈彬', 'Y2gxNTAxNjk1Mzk3', 1, '2021-04-16 16:54:58', '2021-04-16 16:54:58', 0);
INSERT INTO `user` VALUES (24, '191543214', '冯远安', 'eXlhMDYzNTE0', 1, '2021-04-16 18:07:37', '2021-04-16 18:07:37', 0);
INSERT INTO `user` VALUES (25, '191543201', '陈雅楠', 'ODUyMTM2NmN5bg==', 3, '2021-04-17 12:20:49', '2021-04-17 12:20:49', 0);
INSERT INTO `user` VALUES (26, '181549120', '黄彦锟', 'YW51bnlrNzc=', 1, '2021-06-15 15:16:41', '2021-06-15 15:16:41', 0);
INSERT INTO `user` VALUES (27, '191549139', '王腾坤', 'amFja2hhb3podTA1', 1, '2021-07-14 12:19:25', '2021-07-14 12:19:25', 0);
INSERT INTO `user` VALUES (28, '181549424', '黄卓涛', 'R2R1Zi43NDQ1ODgyNjM=', 1, '2021-09-01 14:40:30', '2021-09-01 14:40:30', 0);

SET FOREIGN_KEY_CHECKS = 1;
