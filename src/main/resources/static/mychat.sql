-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mychat
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_comment`
--

DROP TABLE IF EXISTS `tb_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `moments_id` varchar(45) NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `userId` varchar(45) NOT NULL,
  `time` varchar(50) NOT NULL,
  `userName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comment`
--

LOCK TABLES `tb_comment` WRITE;
/*!40000 ALTER TABLE `tb_comment` DISABLE KEYS */;
INSERT INTO `tb_comment` VALUES (3,'5','哈哈哈','18829591066','1512620968539','胖哥哥飘过'),(4,'6','huhuhuh','18829591066','1512622030383','胖哥哥飘过'),(5,'5','ttttt','13689105271','1512629894752','包蛋'),(6,'5','rrrrrr','13689105271','1512631486274','包蛋'),(7,'6','ddddd','13689105271','1512631504377','包蛋'),(8,'5','fffff','13689105271','1512631945305','包蛋'),(9,'7','fffff','13689105271','1512631960445','包蛋'),(10,'8','fff','13689105271','1512632504388','包蛋'),(11,'9','eeeee','13689105271','1512632836669','包蛋'),(12,'10','ffffff','13689105271','1512632897178','包蛋'),(13,'10','樱花皇后','18829591066','1512632916034','胖哥哥飘过');
/*!40000 ALTER TABLE `tb_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_friends_manage`
--

DROP TABLE IF EXISTS `tb_friends_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_friends_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `friend_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_friends_manage`
--

LOCK TABLES `tb_friends_manage` WRITE;
/*!40000 ALTER TABLE `tb_friends_manage` DISABLE KEYS */;
INSERT INTO `tb_friends_manage` VALUES (1,1000,1001),(2,1000,1002),(3,1000,1003),(4,1001,1000),(5,1001,1002),(6,1002,1000),(7,1002,1001),(8,1003,1000);
/*!40000 ALTER TABLE `tb_friends_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_moments`
--

DROP TABLE IF EXISTS `tb_moments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_moments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `text_content` varchar(200) DEFAULT NULL,
  `image_content` varchar(200) DEFAULT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_moments`
--

LOCK TABLES `tb_moments` WRITE;
/*!40000 ALTER TABLE `tb_moments` DISABLE KEYS */;
INSERT INTO `tb_moments` VALUES (5,'18829591066','sdads','http://i4.bvimg.com/602708/03fd775d388e79f1t.jpg;http://i4.bvimg.com/602708/07adb8c25c6786ddt.jpg;http://i4.bvimg.com/602708/4b6c291b04015e15t.jpg','1512557494513'),(6,'18829591066','sdasdasdad','http://i4.bvimg.com/602708/cda5327b8a17b898t.jpg;http://i4.bvimg.com/602708/2ec33ce66d59fc6ct.jpg;http://i4.bvimg.com/602708/acb2d0ae35208ee7t.jpg','1512557792877'),(7,'18829591066','哈哈哈','http://i4.bvimg.com/602708/34d0870110c18316t.jpg;http://i4.bvimg.com/602708/0c860d7a5000ee33t.jpg;http://i4.bvimg.com/602708/3edd61e9823a0445t.jpg','1512559490038'),(8,'13689105271','hjuhihiuhuhuihuihuhk','http://i4.bvimg.com/602708/03fd775d388e79f1t.jpg;http://i4.bvimg.com/602708/4b6c291b04015e15t.jpg;http://i4.bvimg.com/602708/eb4a02a1047cafd5t.jpg','1512559522302'),(9,'18829591066','好好好','http://i4.bvimg.com/602708/0c860d7a5000ee33t.jpg;http://i4.bvimg.com/602708/fd9d4d68b3e795e7t.jpg;http://i4.bvimg.com/602708/5b94af2a72a3e8c4t.jpg','1512632820342'),(10,'18829591066','解决解决','http://i4.bvimg.com/602708/3edd61e9823a0445t.jpg;http://i4.bvimg.com/602708/8e4e938e13f6f3e9t.jpg;http://i4.bvimg.com/602708/34d0870110c18316t.jpg','1512632882737');
/*!40000 ALTER TABLE `tb_moments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `headUrl` varchar(100) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `signature` varchar(100) DEFAULT NULL,
  `sex` int(2) NOT NULL,
  `location` varchar(100) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `type` int(2) NOT NULL,
  `backgroundUrl` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `telephone_UNIQUE` (`telephone`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1000,'1234567','http://i4.bvimg.com/602708/f617fca393454d74t.jpg','18829591066','胖哥哥飘过','一直被模仿，从未被超越!',0,'安徽 铜陵','1997-03-06',1,'http://i4.bvimg.com/602708/674870a953ed9565t.jpg'),(1001,'123456','image/head_face1.jpg','18829225021','金碗','哈哈哈',1,'陕西 延安','1997-06-07',1,'image/background_default.jpg'),(1002,'123456','image/head_face2.jpg','18829224913','栩七','嘿嘿嘿',1,'陕西 渭南','1995-08-07',1,'image/background_default.jpg'),(1003,'123456','image/head_face3.jpg','18829598059','胡撸娃','哦哦哦',1,'陕西 渭南','1995-10-11',1,'image/background_default.jpg'),(1004,'123456','image/head_face4.jpg','18829527029','胖子','哼哼哼',1,'陕西 延安','1997-09-08',1,'image/background_default.jpg'),(1005,'123456','image/head_face5.jpg','18829491377','DP','擦擦擦',1,'陕西 渭南','1997-07-06',1,'image/background1.jpg'),(1006,'123456','image/head_face6.jpg','13689105271','包蛋','我想睡觉！',1,'陕西西安','1997-08-07',1,'image/background2.jpg'),(1007,'123456','image/head_face7.jpg','15191076876','肌肉老爷爷','李时珍滴皮！',1,'陕西 西安','1997-05-07',1,'image/background3.jpg'),(1008,'123456','image/head_face8.jpg','18829522663','鲨鱼辣椒','服务器开一下！',1,'广西 玉林','1997-05-04',1,'image/background4.jpg');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-07 20:34:34
