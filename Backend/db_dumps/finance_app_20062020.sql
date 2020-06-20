-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: finance_app
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.16.04.1

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('item_00001','item name 1'),('item_00002','item name 2'),('item_00003','item name 3'),('item_00004','item name 4'),('item_00005','item name 5'),('item_00006','item name 6'),('item_00007','item name 7'),('item_00008','item name 8'),('item_00009','item name 9'),('item_00010','item name 10');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(30) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('pk id 1','username 1','pass 1'),('user_001','username 1','password 1'),('user_002','username 2','password 2'),('user_003','username 3','password 3'),('user_004','username 4','password 4'),('user_005','username 5','password 5'),('user_007_1','username','password');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_item_mapping`
--

DROP TABLE IF EXISTS `user_item_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_item_mapping` (
  `user_id` varchar(30) NOT NULL,
  `item_id` varchar(40) NOT NULL,
  `access_token` varchar(60) DEFAULT NULL,
  `request_id` varchar(30) DEFAULT NULL,
  `access_token_active_status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`item_id`),
  CONSTRAINT `user_item_mapping_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_item_mapping`
--

LOCK TABLES `user_item_mapping` WRITE;
/*!40000 ALTER TABLE `user_item_mapping` DISABLE KEYS */;
INSERT INTO `user_item_mapping` VALUES ('user_001','item_00001','access_token_1','request_id_1','1'),('user_001','item_00002','access_token_2','request_id_2','1'),('user_001','item_00003','access_token_3','request_id_3','1'),('user_001','item_00004','access_token_4','request_id_4','1'),('user_002','item_00005','access_token_5','request_id_5','1'),('user_002','item_00006','access_token_6','request_id_6','1'),('user_002','item_00007','access_token_7','request_id_7','1'),('user_003','item_00008','access_token_8','request_id_8','1'),('user_003','item_00009','access_token_9','request_id_9','1'),('user_004','item_00010','access_token_10','request_id_10','0'),('user_007_1','BXdERlJGrbf4EBL9Dy8JUZzqaMoGgQiw5BVQ9','access-sandbox-19a56c53-f1cb-42fe-b8b1-e14a5ad7080e','Yw49dyQ1sUf7bMb','ACTIVE'),('user_007_1','dBBlMXbjdRiMNnvnDmE4TQ8VgyXZB7CZxBKRo','access-sandbox-2391bf52-635d-43af-b514-f67d91d6ed55','Hb3TkuPu7MW5ijo','ACTIVE'),('user_007_1','J676NJxD1yire8gEQD9jib5myJo3LBtd83orn','access-sandbox-3c68580b-a09b-4ada-b20d-ca4e6dbe7d95','jpZE7QhONTaHlil','ACTIVE');
/*!40000 ALTER TABLE `user_item_mapping` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-20 15:16:52
