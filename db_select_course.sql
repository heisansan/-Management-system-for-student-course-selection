/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : db_select_course

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2021-12-21 02:34:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CNo` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(30) NOT NULL,
  `Ccredit` float(5,1) DEFAULT '0.0',
  PRIMARY KEY (`CNo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '离散数学', '4.0');
INSERT INTO `course` VALUES ('4', '大学英语', '4.0');
INSERT INTO `course` VALUES ('5', '数字逻辑', '3.0');
INSERT INTO `course` VALUES ('6', '计算机网络', '3.0');
INSERT INTO `course` VALUES ('7', '数据结构', '3.0');
INSERT INTO `course` VALUES ('11', '大学物理', '4.0');
INSERT INTO `course` VALUES ('14', 'JAVA', '3.0');
INSERT INTO `course` VALUES ('15', 'C语言', '2.0');
INSERT INTO `course` VALUES ('16', '数据库', '2.0');
INSERT INTO `course` VALUES ('18', '嵌入式系统', '3.0');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `SNo` int(11) NOT NULL,
  `CNo` int(11) NOT NULL,
  `classroom` varchar(11) DEFAULT '0.0',
  PRIMARY KEY (`SNo`,`CNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('1', '2', '1-111');
INSERT INTO `sc` VALUES ('1', '3', '1-120');
INSERT INTO `sc` VALUES ('1', '6', '2-501');
INSERT INTO `sc` VALUES ('1', '7', '3-302');
INSERT INTO `sc` VALUES ('1', '14', '中巴304');
INSERT INTO `sc` VALUES ('1924010919', '6', '2-501');
INSERT INTO `sc` VALUES ('1924010924', '1', '0');
INSERT INTO `sc` VALUES ('1924010924', '6', '2-501');
INSERT INTO `sc` VALUES ('1924010924', '7', '3-302');
INSERT INTO `sc` VALUES ('1924010924', '11', '0');
INSERT INTO `sc` VALUES ('1924111111', '1', '0');
INSERT INTO `sc` VALUES ('1924111111', '7', '3-302');
INSERT INTO `sc` VALUES ('1924111326', '14', '中巴304');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `SNo` int(11) NOT NULL AUTO_INCREMENT,
  `Sname` varchar(30) NOT NULL,
  `Spassword` varchar(30) NOT NULL,
  `Sclass` varchar(30) DEFAULT '',
  `Ssex` varchar(10) DEFAULT '',
  PRIMARY KEY (`SNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1924111327 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '测试', '0', '1', '女');
INSERT INTO `student` VALUES ('1924010919', '刘琪', '123456', '测试班级', '男');
INSERT INTO `student` VALUES ('1924010924', '于强', '456253', '测试班级', '男');
INSERT INTO `student` VALUES ('1924010926', '张三', '1', '测试班级', '男');
INSERT INTO `student` VALUES ('1924111111', '闫宇浩', '000000', '19科技1班', '男');
INSERT INTO `student` VALUES ('1924111326', '黑三', '662300', '19科技3班', '女');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `TNo` int(11) NOT NULL AUTO_INCREMENT,
  `Tname` varchar(30) DEFAULT NULL,
  `Tpassword` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TNo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '测试老师1', '0');
INSERT INTO `teacher` VALUES ('2', '西如恩', '00');
