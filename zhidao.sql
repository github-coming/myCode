-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: zhidao
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `collection` (
  `collection_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `question_id` int(11) NOT NULL COMMENT '问题id',
  `user_id` int(11) NOT NULL COMMENT '收藏者id',
  PRIMARY KEY (`collection_id`),
  KEY `collection_user_user_id_fk` (`user_id`),
  KEY `collection_user_question_question_id_fk` (`question_id`),
  CONSTRAINT `collection_user_question_question_id_fk` FOREIGN KEY (`question_id`) REFERENCES `user_question` (`question_id`),
  CONSTRAINT `collection_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (1,1,1),(2,1,666),(3,1,666),(4,1,789),(5,8,789),(6,8,666),(7,1,10086);
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id，主键',
  `comment_content` text COMMENT '评论内容',
  `comment_time` text NOT NULL COMMENT '评论时间',
  `question_id` int(11) DEFAULT NULL COMMENT '被评论问题id，外键',
  `user_id` int(11) DEFAULT NULL COMMENT '问题对应用户id，外键',
  PRIMARY KEY (`comment_id`),
  KEY `comment_user_user_id_fk` (`user_id`),
  KEY `comment_user_question_question_id_fk` (`question_id`),
  CONSTRAINT `comment_user_question_question_id_fk` FOREIGN KEY (`question_id`) REFERENCES `user_question` (`question_id`),
  CONSTRAINT `comment_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'哈哈哈','2020-07-05 17:08:39',1,1),(3,'1111','2020-07-09 17:29:41',1,666),(4,'2222','2020-07-09 17:30:37',1,666),(5,'hhah','2020-07-09 19:35:40',7,666),(6,'qqqqqqq','2020-07-09 20:38:16',1,789),(7,'asdfasf','2020-07-09 20:39:46',8,789),(8,'dasgadgagd','2020-07-09 20:40:25',8,666),(9,'应该等于2吧？','2020-07-10 08:12:30',9,10086);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fans`
--

DROP TABLE IF EXISTS `fans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id，外键',
  `idol_id` int(11) DEFAULT NULL COMMENT '关注id，外键',
  PRIMARY KEY (`id`),
  KEY `fans_user_user_id_fk` (`user_id`),
  KEY `fans_user_user_id_fk_2` (`idol_id`),
  CONSTRAINT `fans_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fans_user_user_id_fk_2` FOREIGN KEY (`idol_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fans`
--

LOCK TABLES `fans` WRITE;
/*!40000 ALTER TABLE `fans` DISABLE KEYS */;
INSERT INTO `fans` VALUES (1,1,13),(2,1,14),(3,666,1),(4,1,111),(6,789,1),(7,666,789),(8,10086,1),(9,13,10086);
/*!40000 ALTER TABLE `fans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id、主键',
  `user_name` text NOT NULL COMMENT '用户名',
  `user_password` text NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10087 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'张三','123456'),(13,'李四','1234'),(14,'王五','1234'),(111,'1111','1111'),(222,'222','222'),(333,'333','333'),(666,'asdf','777'),(789,'fff','aaa'),(10086,'qwer','1111');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_question`
--

DROP TABLE IF EXISTS `user_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id，主键',
  `question_title` text COMMENT '问题标题',
  `question_time` text NOT NULL COMMENT '发表时间',
  `user_id` int(11) DEFAULT NULL COMMENT '发表用户id，外键',
  `comments` int(11) DEFAULT NULL COMMENT '评论数',
  `question_content` text NOT NULL COMMENT '发表内容',
  PRIMARY KEY (`question_id`),
  KEY `user_question_user_user_id_fk` (`user_id`),
  CONSTRAINT `user_question_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_question`
--

LOCK TABLES `user_question` WRITE;
/*!40000 ALTER TABLE `user_question` DISABLE KEYS */;
INSERT INTO `user_question` VALUES (1,'高考必胜','2020-07-05 16:05:23',1,5,'你好'),(2,'高考加油','2020-07-05 16:42:06',1,0,'你好'),(4,'2222','2020-07-07 16:05:10',111,0,'22222222222'),(5,'333','2020-07-07 16:14:13',222,0,'333333'),(7,'这是标题0001','2020-07-09 15:50:01',666,1,'这是内容0001'),(8,'sadfasfasa','2020-07-09 20:39:05',789,2,'bafsfhasfhshh'),(9,'1+1=?','2020-07-10 08:10:20',10086,1,'1+1到底等于几？');
/*!40000 ALTER TABLE `user_question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-10  9:11:19
