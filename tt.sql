-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.14 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 isz 的数据库结构
CREATE DATABASE IF NOT EXISTS `isz` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `isz`;


-- 导出  表 isz.bloods 结构
CREATE TABLE IF NOT EXISTS `bloods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.bloods 的数据：~0 rows (大约)
DELETE FROM `bloods`;
/*!40000 ALTER TABLE `bloods` DISABLE KEYS */;
/*!40000 ALTER TABLE `bloods` ENABLE KEYS */;


-- 导出  表 isz.checkdigit 结构
CREATE TABLE IF NOT EXISTS `checkdigit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `d` int(11) NOT NULL,
  `m` varchar(255) DEFAULT NULL,
  `updatetime` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `checkdigit_d` (`d`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.checkdigit 的数据：~18 rows (大约)
DELETE FROM `checkdigit`;
/*!40000 ALTER TABLE `checkdigit` DISABLE KEYS */;
INSERT INTO `checkdigit` (`id`, `d`, `m`, `updatetime`) VALUES
	(1, 111111, '15000993473', 0),
	(2, 28332, NULL, 1486053977556),
	(3, 94690, NULL, 1486054053306),
	(4, 68087, NULL, 1486054108268),
	(5, 166672, NULL, 1486054220824),
	(6, 86083, '15000993473', 1486055260581),
	(7, 107935, '15000993473', 1486055329799),
	(8, 89924, '15000993473', 1486055422574),
	(9, 91476, '15000993473', 1486055537883),
	(10, 2211, '15000993473', 1486055724316),
	(11, 60831, '15000993473', 1486055751934),
	(12, 139184, '15000993473', 1486055963961),
	(13, 157688, '15000993473', 1486056053654),
	(14, 657, '15000993473', 1486056141363),
	(15, 145572, '15000993473', 1486056174030),
	(16, 34566, '15000993473', 1486056345019),
	(17, 135390, '15000993473', 1486056509764),
	(18, 1234, '15000993473', 1486057851579);
/*!40000 ALTER TABLE `checkdigit` ENABLE KEYS */;


-- 导出  表 isz.constellations 结构
CREATE TABLE IF NOT EXISTS `constellations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.constellations 的数据：~0 rows (大约)
DELETE FROM `constellations`;
/*!40000 ALTER TABLE `constellations` DISABLE KEYS */;
/*!40000 ALTER TABLE `constellations` ENABLE KEYS */;


-- 导出  表 isz.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `discount` double DEFAULT NULL,
  `goods_code` varchar(255) NOT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` double DEFAULT NULL,
  `goods_type` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1peseyc7orpt520u1177g1x2u` (`goods_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.goods 的数据：~0 rows (大约)
DELETE FROM `goods`;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


-- 导出  表 isz.goods_purchase 结构
CREATE TABLE IF NOT EXISTS `goods_purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_period` varchar(255) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `goods_code` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` double DEFAULT NULL,
  `goods_type` varchar(255) DEFAULT NULL,
  `purchase_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `purchase_men` varchar(255) DEFAULT NULL,
  `purchase_num` int(11) DEFAULT NULL,
  `purchase_price` double DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.goods_purchase 的数据：~0 rows (大约)
DELETE FROM `goods_purchase`;
/*!40000 ALTER TABLE `goods_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_purchase` ENABLE KEYS */;


-- 导出  表 isz.sales 结构
CREATE TABLE IF NOT EXISTS `sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `discount` double DEFAULT NULL,
  `goods_code` varchar(255) NOT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` double DEFAULT NULL,
  `goods_type` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pk1fbn7f01bgdnh9qb4k4aotd` (`goods_code`),
  KEY `FKu5lyewcf0mgbldqrf8rhmjf6` (`user_id`),
  CONSTRAINT `FKu5lyewcf0mgbldqrf8rhmjf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.sales 的数据：~0 rows (大约)
DELETE FROM `sales`;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;


-- 导出  表 isz.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL,
  `exp` bigint(20) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `mobile` bigint(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `os` int(11) NOT NULL,
  `point` int(11) DEFAULT NULL,
  `portrait` varchar(255) DEFAULT NULL,
  `pwd` varchar(30) NOT NULL,
  `school` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `wx_id` varchar(255) DEFAULT NULL,
  `cd` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_email` (`email`),
  KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user 的数据：~1 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `address`, `birthday`, `create_date`, `email`, `exp`, `gender`, `level`, `mobile`, `name`, `nickname`, `os`, `point`, `portrait`, `pwd`, `school`, `type`, `update_date`, `wx_id`, `cd`) VALUES
	(11, NULL, '2017-02-07', '2017-02-03 00:00:00', 'hanzhao7726562@163.com', NULL, 1, NULL, 15000993473, '帅哥', '刺客2', 0, NULL, NULL, '111111', '西贝', NULL, '2017-02-03 16:12:26', NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- 导出  表 isz.user_body 结构
CREATE TABLE IF NOT EXISTS `user_body` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_body 的数据：~0 rows (大约)
DELETE FROM `user_body`;
/*!40000 ALTER TABLE `user_body` DISABLE KEYS */;
INSERT INTO `user_body` (`id`, `body_name`) VALUES
	(1, '可乐瓶'),
	(2, '鸭梨'),
	(3, '标准'),
	(4, '草莓'),
	(5, '丝瓜'),
	(6, '苹果');
/*!40000 ALTER TABLE `user_body` ENABLE KEYS */;


-- 导出  表 isz.user_detail 结构
CREATE TABLE IF NOT EXISTS `user_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `body_id` bigint(20) DEFAULT NULL,
  `face_id` bigint(20) DEFAULT NULL,
  `frequency_id` bigint(20) DEFAULT NULL,
  `hair_id` bigint(20) DEFAULT NULL,
  `hierarchy_id` bigint(20) DEFAULT NULL,
  `inclination_id` bigint(20) DEFAULT NULL,
  `post_day_id` bigint(20) DEFAULT NULL,
  `skin_color_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `height` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `size_id` bigint(20) DEFAULT NULL,
  `blood_id` bigint(20) DEFAULT NULL,
  `constellation_id` bigint(20) DEFAULT NULL,
  `skincolor_id` bigint(20) DEFAULT NULL,
  `pricerange_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdpobsmms9p0tickf6c28tii3m` (`body_id`),
  KEY `FK4g5ksh7jwjasr6qkvm3olh3su` (`face_id`),
  KEY `FK8y0ra5grd8jalxk88rksy6n48` (`frequency_id`),
  KEY `FKe0c8xhil93k1tbd686d02okhg` (`hair_id`),
  KEY `FK8nplrjp66j2trgmvoj59u2det` (`hierarchy_id`),
  KEY `FK66e20psld19la3wiw8gk56pfi` (`inclination_id`),
  KEY `FKce9e72gtgifo3bdlanxw7m8k7` (`post_day_id`),
  KEY `FKcc4i4m61a5r3sghpgh2fj1lle` (`skin_color_id`),
  KEY `FKc2fr118twu8aratnm1qop1mn9` (`user_id`),
  KEY `FKimo1y2hvj8alpk5l96s26ntu8` (`size_id`),
  KEY `FK8t88qrrvy9t3bimxgq8hjwd49` (`blood_id`),
  KEY `FK9w0ymv970i8r7kny37d484ck3` (`constellation_id`),
  KEY `FKl4pul1wr0drscio5me6s5poj5` (`skincolor_id`),
  KEY `FKqed0c70hr4itqclrw8m0dynnk` (`pricerange_id`),
  CONSTRAINT `FKqed0c70hr4itqclrw8m0dynnk` FOREIGN KEY (`pricerange_id`) REFERENCES `user_pricerange` (`id`),
  CONSTRAINT `FK4g5ksh7jwjasr6qkvm3olh3su` FOREIGN KEY (`face_id`) REFERENCES `user_face` (`id`),
  CONSTRAINT `FK66e20psld19la3wiw8gk56pfi` FOREIGN KEY (`inclination_id`) REFERENCES `user_inclination` (`id`),
  CONSTRAINT `FK8nplrjp66j2trgmvoj59u2det` FOREIGN KEY (`hierarchy_id`) REFERENCES `user_hierarchy` (`id`),
  CONSTRAINT `FK8t88qrrvy9t3bimxgq8hjwd49` FOREIGN KEY (`blood_id`) REFERENCES `bloods` (`id`),
  CONSTRAINT `FK8y0ra5grd8jalxk88rksy6n48` FOREIGN KEY (`frequency_id`) REFERENCES `user_frequency` (`id`),
  CONSTRAINT `FK9w0ymv970i8r7kny37d484ck3` FOREIGN KEY (`constellation_id`) REFERENCES `constellations` (`id`),
  CONSTRAINT `FKc2fr118twu8aratnm1qop1mn9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKcc4i4m61a5r3sghpgh2fj1lle` FOREIGN KEY (`skin_color_id`) REFERENCES `user_skincolor` (`id`),
  CONSTRAINT `FKce9e72gtgifo3bdlanxw7m8k7` FOREIGN KEY (`post_day_id`) REFERENCES `user_postday` (`id`),
  CONSTRAINT `FKdpobsmms9p0tickf6c28tii3m` FOREIGN KEY (`body_id`) REFERENCES `user_body` (`id`),
  CONSTRAINT `FKe0c8xhil93k1tbd686d02okhg` FOREIGN KEY (`hair_id`) REFERENCES `user_hair` (`id`),
  CONSTRAINT `FKimo1y2hvj8alpk5l96s26ntu8` FOREIGN KEY (`size_id`) REFERENCES `user_size` (`id`),
  CONSTRAINT `FKl4pul1wr0drscio5me6s5poj5` FOREIGN KEY (`skincolor_id`) REFERENCES `user_skincolor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_detail 的数据：~1 rows (大约)
DELETE FROM `user_detail`;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` (`id`, `update_date`, `body_id`, `face_id`, `frequency_id`, `hair_id`, `hierarchy_id`, `inclination_id`, `post_day_id`, `skin_color_id`, `user_id`, `address`, `city`, `height`, `weight`, `size_id`, `blood_id`, `constellation_id`, `skincolor_id`, `pricerange_id`) VALUES
	(10, '2017-02-03 23:41:59', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11, '还没有写地址', NULL, 175, 0, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;


-- 导出  表 isz.user_face 结构
CREATE TABLE IF NOT EXISTS `user_face` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `face_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_face 的数据：~7 rows (大约)
DELETE FROM `user_face`;
/*!40000 ALTER TABLE `user_face` DISABLE KEYS */;
INSERT INTO `user_face` (`id`, `face_name`) VALUES
	(1, '圆形'),
	(2, '椭圆形'),
	(3, '长形'),
	(4, '标准'),
	(5, '心形'),
	(6, '梨形'),
	(7, '方形');
/*!40000 ALTER TABLE `user_face` ENABLE KEYS */;


-- 导出  表 isz.user_frequency 结构
CREATE TABLE IF NOT EXISTS `user_frequency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `frequency_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_frequency 的数据：~0 rows (大约)
DELETE FROM `user_frequency`;
/*!40000 ALTER TABLE `user_frequency` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_frequency` ENABLE KEYS */;


-- 导出  表 isz.user_hair 结构
CREATE TABLE IF NOT EXISTS `user_hair` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hair_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_hair 的数据：~0 rows (大约)
DELETE FROM `user_hair`;
/*!40000 ALTER TABLE `user_hair` DISABLE KEYS */;
INSERT INTO `user_hair` (`id`, `hair_name`) VALUES
	(1, '短直发'),
	(2, '短卷发'),
	(3, '波波头'),
	(4, '刘海短发'),
	(5, '刘海长发'),
	(6, '马尾辫'),
	(7, '丸子头'),
	(8, '长直头');
/*!40000 ALTER TABLE `user_hair` ENABLE KEYS */;


-- 导出  表 isz.user_hierarchy 结构
CREATE TABLE IF NOT EXISTS `user_hierarchy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hierarchy_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_hierarchy 的数据：~0 rows (大约)
DELETE FROM `user_hierarchy`;
/*!40000 ALTER TABLE `user_hierarchy` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_hierarchy` ENABLE KEYS */;


-- 导出  表 isz.user_inclination 结构
CREATE TABLE IF NOT EXISTS `user_inclination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `inclination_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_inclination 的数据：~0 rows (大约)
DELETE FROM `user_inclination`;
/*!40000 ALTER TABLE `user_inclination` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_inclination` ENABLE KEYS */;


-- 导出  表 isz.user_postday 结构
CREATE TABLE IF NOT EXISTS `user_postday` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `postday_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_postday 的数据：~0 rows (大约)
DELETE FROM `user_postday`;
/*!40000 ALTER TABLE `user_postday` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_postday` ENABLE KEYS */;


-- 导出  表 isz.user_pricerange 结构
CREATE TABLE IF NOT EXISTS `user_pricerange` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pricerange_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_pricerange 的数据：~0 rows (大约)
DELETE FROM `user_pricerange`;
/*!40000 ALTER TABLE `user_pricerange` DISABLE KEYS */;
INSERT INTO `user_pricerange` (`id`, `pricerange_name`) VALUES
	(1, '200元以内'),
	(2, '200~500元'),
	(3, '500~800元'),
	(4, '800~1200元'),
	(5, '1200~1500元'),
	(6, '1500~2000元'),
	(7, '2000元以上');
/*!40000 ALTER TABLE `user_pricerange` ENABLE KEYS */;


-- 导出  表 isz.user_size 结构
CREATE TABLE IF NOT EXISTS `user_size` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `size_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_size 的数据：~6 rows (大约)
DELETE FROM `user_size`;
/*!40000 ALTER TABLE `user_size` DISABLE KEYS */;
INSERT INTO `user_size` (`id`, `size_name`) VALUES
	(1, 'XS'),
	(2, 'S'),
	(3, 'M'),
	(4, 'L'),
	(5, 'XL'),
	(6, 'XXL');
/*!40000 ALTER TABLE `user_size` ENABLE KEYS */;


-- 导出  表 isz.user_skincolor 结构
CREATE TABLE IF NOT EXISTS `user_skincolor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skincolor_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  isz.user_skincolor 的数据：~7 rows (大约)
DELETE FROM `user_skincolor`;
/*!40000 ALTER TABLE `user_skincolor` DISABLE KEYS */;
INSERT INTO `user_skincolor` (`id`, `skincolor_name`) VALUES
	(1, '亮白'),
	(2, '粉白'),
	(3, '标准'),
	(4, '自然黄'),
	(5, '自然红'),
	(6, '小麦色'),
	(7, '古铜色');
/*!40000 ALTER TABLE `user_skincolor` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
