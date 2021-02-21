/*
 Navicat Premium Data Transfer

 Source Server         : 3310
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3310
 Source Schema         : ttsx

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 21/02/2021 12:57:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `aId` int(255) NOT NULL AUTO_INCREMENT,
  `uId` int(255) NOT NULL,
  `aConsignee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `aAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `aPC` int(255) NULL DEFAULT NULL,
  `aPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (1, 1, '隔壁老王', '武汉商学院\r\n                    ', 430000, '17766346824');
INSERT INTO `tb_address` VALUES (2, 2, '哈哈', '武汉商学院', 432600, '17798256634');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`  (
  `gId` int(255) NOT NULL AUTO_INCREMENT,
  `gBrief` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gPrice` double(255, 2) NULL DEFAULT NULL,
  `gCompany` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gStock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gImage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`gId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES (1, '越南直采 精选大果】果肉更足，享受饱满的甜蜜诱惑！红果富含花青素，天然抗氧化营养库！泰国金枕榴莲火爆促销中，点我直达，萨瓦迪卡。', 33.90, '1.94kg', '10', '57ab290aN34f76b37.jpg', '新鲜水果', '越南进口红心火龙果 3个装 大果 单果约450~500g');
INSERT INTO `tb_goods` VALUES (2, '寻天果蔬 泰国山竹水果 京东生鲜 5A级 热带水果', 98.00, '2.5kg', '15', '5b4871e6N072f0d74.jpg', '新鲜水果', '寻天果蔬 泰国山竹水果 5个装 单果约450~500g');
INSERT INTO `tb_goods` VALUES (3, '中科农业 水果礼盒 水果提货券 礼券 238型 水果提货卡券', 238.00, '3.0kg', '20', '5b18c158N35a55d7a.jpg', '新鲜水果', '中科农业 水果礼盒 5个装 单果约300~350g');
INSERT INTO `tb_goods` VALUES (4, '阳澄联合 阳澄湖大闸蟹礼券1988型公4.0两 母3.0两', 199.00, '0.5kg', '20', '5b2c5716N1a1c07b1.jpg', '海鲜水产', '阳澄联合 阳澄湖大闸蟹 1988型公4.0两 母3.0两');
INSERT INTO `tb_goods` VALUES (5, 'Ocean Gala 冷冻阿拉斯加黄金鲽鱼', 35.90, '0.5kg', '60', '5addb366Nb137c891.jpg', '海鲜水产', '冷冻阿拉斯加黄金鲽鱼 1kg 2-3条');
INSERT INTO `tb_goods` VALUES (6, '原装进口熟冻新西兰全壳青口贝', 138.00, '0.3kg', '80', '57c4e212N9e09772f.jpg', '海鲜水产', '新西兰全壳青口贝');
INSERT INTO `tb_goods` VALUES (7, '领券199减100【周黑鸭_锁鲜】卤鸭脖', 118.00, '0.32kg', '50', '5ac2ee43N56cf06b0.jpg', '猪牛羊肉', '领券199减100【周黑鸭_锁鲜】卤鸭脖320g鸭锁骨240');
INSERT INTO `tb_goods` VALUES (8, '如意三宝 10片/1540g 澳洲进口原切牛排套餐', 265.00, '1.54kg', '30', '59ba49beNfa4afb17.jpg', '猪牛羊肉', '如意三宝 10片/1540g 澳洲进口原切牛排套餐 菲力4片');
INSERT INTO `tb_goods` VALUES (9, '恒都 羔羊排 1.2kg/袋 烧烤食材', 59.90, '1.2kg', '30', '57e3aea6N5d8f4459.jpg', '猪牛羊肉', '恒都 羔羊排 1.2kg/袋 烧烤食材');
INSERT INTO `tb_goods` VALUES (10, '边大哥 散养鲜鹅蛋', 109.00, '0.2kg', '100', '5927942eN14545b4d.jpg', '禽类蛋品', '边大哥 散养鲜鹅蛋 12枚');
INSERT INTO `tb_goods` VALUES (11, '>春朝 新鲜鸽子蛋', 57.00, '0.2kg', '120', '590c63b4N63036e65.jpg', '禽类蛋品', '春朝 新鲜鸽子蛋 10枚');
INSERT INTO `tb_goods` VALUES (12, '高邮神邮牌咸鸭蛋', 39.99, '0.5kg', '60', '57481b77Nbed0cff5.jpg', '禽类蛋品', '高邮神邮牌咸鸭蛋（熟65g*20只）真空');
INSERT INTO `tb_goods` VALUES (13, '蔡家洼 北京密云茴香菜 饺子馅新鲜蔬菜', 11.20, '1.0kg', '70', '5a389d24N39ad0079.jpg', '新鲜蔬菜', '蔡家洼 北京密云茴香菜 饺子馅新鲜蔬菜 500g');
INSERT INTO `tb_goods` VALUES (14, '有机汇 有机蔬菜套餐 3口之家 新鲜蔬菜', 67.00, '3kg', '80', '594c8c8fN707ca024.jpg', '新鲜蔬菜', '有机汇 有机蔬菜套餐 3口之家 新鲜蔬菜 宅配 月度 6斤*');
INSERT INTO `tb_goods` VALUES (15, '富爸爸 韩国风味泡菜 切件瓶装白菜泡菜', 19.90, '0.5kg', '30', '57a9a823N2c38934e.jpg', '新鲜蔬菜', '富爸爸 韩国风味泡菜 切件瓶装白菜泡菜 单瓶约450~500g');

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop`  (
  `uId` int(255) NULL DEFAULT NULL,
  `gId` int(255) NULL DEFAULT NULL,
  `num` int(255) NULL DEFAULT NULL,
  `sId` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
INSERT INTO `tb_shop` VALUES (1, 1, 3, 1);
INSERT INTO `tb_shop` VALUES (1, 4, 3, 2);
INSERT INTO `tb_shop` VALUES (2, 4, 1, 11);
INSERT INTO `tb_shop` VALUES (2, 2, 1, 12);
INSERT INTO `tb_shop` VALUES (3, 1, 1, 13);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'user', '123', '1432721789@qq.com');
INSERT INTO `tb_user` VALUES (2, 'admin', '123', '133@163.com');
INSERT INTO `tb_user` VALUES (3, 'aaa', '111', 'aaa@sian.com');

-- ----------------------------
-- Procedure structure for pro_fenye
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_fenye`;
delimiter ;;
CREATE PROCEDURE `pro_fenye`(tableName VARCHAR(20),
	columns text,
	whereStr text,
	orderStr VARCHAR(50),
	pageSize int,
	currentPage int,
	out totalSize int,
	out totalPage int)
BEGIN
	-- 步骤1：求总记录数
	-- 'select count(*) into @totalSize from tableName where 1=1 IFNULL(whereStr,null)
	SET @sql = CONCAT('select count(*) into @totalSize from ',tableName,
							' where 1=1 ',IFNULL(whereStr,''));
	PREPARE count_sql from @sql; -- 准备执行
	EXECUTE count_sql;  -- 执行
	DEALLOCATE PREPARE count_sql;   -- 解除执行

	-- 步骤2：计算总页数
	SET totalSize=@totalSize;
	SET totalPage=CEIL(totalSize/pageSize);

	-- 步骤3：先判断用户输入的页数(currentPage)是否规范
	IF(currentPage<1)THEN SET currentPage=1;
	ELSEIF(currentPage>totalPage)THEN SET currentPage=totalPage;
	END IF;

	-- 步骤4：拼接分页sql
	SET @fenyeSql = CONCAT('select ',columns,' from ',tableName,
									' where 1=1 ',IFNULL(whereStr,' '),' ', IFNULL(orderStr,' '),
									' limit ',pageSize*(currentPage-1),',',pageSize);
	PREPARE fenye_sql from @fenyeSql; -- 准备执行
	EXECUTE fenye_sql;  -- 执行
	DEALLOCATE PREPARE fenye_sql;   -- 解除执行
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
