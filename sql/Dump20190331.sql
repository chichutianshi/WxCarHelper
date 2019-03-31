-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cargg
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sequence` varchar(45) DEFAULT NULL,
  `img_url` text,
  `uesid` varchar(45) DEFAULT NULL,
  `variety` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_tab`
--

DROP TABLE IF EXISTS `shop_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shop_tab` (
  `id` varchar(45) NOT NULL,
  `sequence` int(11) DEFAULT NULL COMMENT '排序',
  `is_lb` varchar(45) DEFAULT NULL,
  `is_hot` varchar(45) DEFAULT NULL,
  `shopname` varchar(45) DEFAULT NULL,
  `subscript` varchar(45) DEFAULT NULL,
  `headimg_url` varchar(145) DEFAULT NULL,
  `pdesc` text,
  `createtime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_tab`
--

LOCK TABLES `shop_tab` WRITE;
/*!40000 ALTER TABLE `shop_tab` DISABLE KEYS */;
INSERT INTO `shop_tab` VALUES ('16ccbced-3a90-4da5-b7fe-03826a320738',3,'2','2','好评2','111好评','1c33f6c4-245d-4c01-8809-fbbeb2a7ef8e-0-saturn_solar.jpg_220x220.jpg','','星期二 2019-02-12  01:25:56'),('d5e0c9ae-1da5-4e47-b615-53102c32579f',2,'1','1','热门测试3','热门下标2','66e78d4c-bd42-4403-9f7f-8d99103ebeb101_small.jpg','11111111111','星期二 2019-02-12  01:25:56'),('d8ba278b-c1c7-4ca2-864d-fe8f9f040b88',2,'2','2','好评1','222好评','5db2e0a3-c9de-4edf-95dd-96b7a826fc201.jpg','','星期二 2019-02-12  01:25:56'),('f270793f-215b-4ce3-a4fc-9676ed8c2b12',3,'1','2','好评2','222好评','9dee3e5f-2eb1-4892-9280-8a53c052173c1-item_pic.jpg_220x220.jpg','','星期二 2019-02-12  01:25:56');
/*!40000 ALTER TABLE `shop_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tempip`
--

DROP TABLE IF EXISTS `tempip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tempip` (
  `ip` varchar(45) NOT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tempip`
--

LOCK TABLES `tempip` WRITE;
/*!40000 ALTER TABLE `tempip` DISABLE KEYS */;
INSERT INTO `tempip` VALUES ('0:0:0:0:0:0:0:1',3);
/*!40000 ALTER TABLE `tempip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `token` (
  `token` varchar(60) NOT NULL,
  `userid` varchar(45) DEFAULT NULL,
  `createtime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES ('19fcb64d790ebb30dd653f13f385cc85c','19022721137711',' 2019-02-27  19:37:31'),('1d24af95091037a9a59b1690a2953c3bd','19012290158475',' 2019-03-17  18:53:58'),('31ca80bc85df78639de7ef84e73ea0704','admin',' 2019-03-16  23:32:33');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `idcard` varchar(45) DEFAULT NULL,
  `power` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('19012290158475','295758739@qq.com','123','coco','13943094911',NULL,NULL,'1'),('19022606884219','697452916','123456','coco','18834562474',NULL,NULL,'1'),('19022667197955','aksjdkasdj','asddas','nice','123123',NULL,NULL,'1'),('19022690555104','1239','1234','coco1','18834562477',NULL,NULL,'1'),('19022721137711','1234','1234','1234','1234',NULL,NULL,'1'),('19031619765501','123124214','asd','coco1','18834562479',NULL,NULL,'1'),('admin','admin','admin','超管','admin',NULL,NULL,'3');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-31 22:32:27
