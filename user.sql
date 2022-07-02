/*
 Navicat Premium Data Transfer

 Source Server         : yuanh
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 02/07/2022 12:24:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand`  (
  `brandid` int(0) NOT NULL AUTO_INCREMENT,
  `brandname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `companyname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '企业名称',
  `ordered` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌介绍',
  `quantity` int(0) NULL DEFAULT NULL COMMENT '数量',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`brandid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand` VALUES (1, '三只松鼠', '三只松鼠股份有限公司', '零食', '\"\"好吃不上火\"\"', 200, 0);
INSERT INTO `tb_brand` VALUES (2, '肉肉大狂欢', '良品铺子 ', '零食', '\"良品铺子 肉肉大狂欢1770g零食大礼包16袋纯肉礼包节日送礼 鸭脖凤爪鸭舌多版本随机\"', 200, 1);
INSERT INTO `tb_brand` VALUES (3, '小米12 Ultra', '小米科技有限公司', '手机', '\"小米12 Ultra 骁龙8Gen1 2K 120Hz 5000万疾速影像 120W秒充 12GB+256GB黑色 5G手机\"', 232, 0);
INSERT INTO `tb_brand` VALUES (4, 'AOCG2490VX/BS', 'AOC', '显示器', ' AOC 23.8英寸 144Hz 1ms 广色域 HDR Mode 窄边框 低蓝光爱眼不闪屏 游戏电竞电脑显示器 G2490VX/BS', 111, 1);
INSERT INTO `tb_brand` VALUES (9, '华为mate40Pro5G', '华为技术有限公司', '手机', '华为mate40 Pro 5G手机 秘银色8G+256G【充电套装】 5G版全网通', 50, 1);
INSERT INTO `tb_brand` VALUES (10, '三星GalaxyS22Ultra', '三星（中国）投资有限公司', '手机', '\"三星 SAMSUNG Galaxy S22 Ultra 超视觉夜拍系统 超耐用精工设计 大屏S Pen书写 12GB+256GB 绯影红 5G手机\"', 121, 1);
INSERT INTO `tb_brand` VALUES (17, '华为MateBook', '华为技术有限公司', '电脑', '华为笔记本电脑MateBook 14 2022 12代酷睿版 i5 16G 512G 锐炬显卡/轻薄本/14英寸2K触控全面屏 深空灰', 400, 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'yuanh', '123');
INSERT INTO `tb_user` VALUES (40, 'gxc', '1234');
INSERT INTO `tb_user` VALUES (41, 'zzz', '1234');

SET FOREIGN_KEY_CHECKS = 1;
