CREATE DATABASE  IF NOT EXISTS `bc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bc`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: bc
-- ------------------------------------------------------
-- Server version	5.5.30

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Пушкин','Александр','Сергеевич'),(2,'Хрюшкин','Александр','Сергеевич'),(45,'Толстой','Лев','Николаевич'),(46,'Чехов','Антон','Павлович'),(55,'Лукьяненко','Сергей','Васильевич'),(56,'Достоевский','Федор','Михайлович'),(70,'Бак','Джон',''),(71,'Кинг','Стивен',''),(76,'Грибоедов','Александр','Сергеевич'),(77,'Брэдберри','Рэй',NULL),(78,'Оруэлл','Джордж',NULL),(85,'Паланик','Чак',NULL),(86,'Кинг','Стивен',NULL),(87,'Киз','Дэниел',NULL),(94,'Купер','Джеймс','Фенимор'),(95,'Лермонтов','Михаил','Юрьевич'),(96,'Ожогов',NULL,NULL),(103,'Автор1',NULL,NULL),(104,'Автор2',NULL,NULL),(105,'Автор3',NULL,NULL),(106,'Глуховский','Дмитрий','Алексеевич'),(107,'Уайльд','Оскар',NULL),(108,'Хаксли','Олдос','Леонард'),(109,'Милн','Алан',NULL),(110,'Голдинг','Уильям','Джералд');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `language_id` int(11) DEFAULT NULL,
  `book_type_id` int(11) DEFAULT NULL,
  `book_condition_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `book_type_id` (`book_type_id`) USING BTREE,
  KEY `language_id` (`language_id`) USING BTREE,
  KEY `condition_id` (`book_condition_id`) USING BTREE,
  CONSTRAINT `book_fk2` FOREIGN KEY (`book_type_id`) REFERENCES `book_type` (`id`),
  CONSTRAINT `book_fk3` FOREIGN KEY (`language_id`) REFERENCES `book_language` (`id`),
  CONSTRAINT `book_fk4` FOREIGN KEY (`book_condition_id`) REFERENCES `book_condition` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,1,2,7),(2,1,2,7),(3,NULL,3,NULL),(4,NULL,NULL,NULL),(5,1,1,1),(6,NULL,NULL,NULL),(7,1,2,7),(8,1,1,3),(9,NULL,NULL,NULL),(10,NULL,NULL,NULL),(11,NULL,5,3),(12,1,3,5),(13,1,2,7),(14,1,3,7),(15,1,3,7);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_condition`
--

DROP TABLE IF EXISTS `book_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_condition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_condition`
--

LOCK TABLES `book_condition` WRITE;
/*!40000 ALTER TABLE `book_condition` DISABLE KEYS */;
INSERT INTO `book_condition` VALUES (3,'Изношенная'),(1,'Новая'),(7,'Отличная'),(4,'Очень даже ничего'),(5,'Потрепанная'),(2,'Старая');
/*!40000 ALTER TABLE `book_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_language`
--

DROP TABLE IF EXISTS `book_language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_language`
--

LOCK TABLES `book_language` WRITE;
/*!40000 ALTER TABLE `book_language` DISABLE KEYS */;
INSERT INTO `book_language` VALUES (2,'Нерусский'),(1,'Русский');
/*!40000 ALTER TABLE `book_language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_type`
--

DROP TABLE IF EXISTS `book_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_type`
--

LOCK TABLES `book_type` WRITE;
/*!40000 ALTER TABLE `book_type` DISABLE KEYS */;
INSERT INTO `book_type` VALUES (5,'Газета'),(1,'Карманная'),(3,'Мягкая обложка'),(2,'Твердый переплет');
/*!40000 ALTER TABLE `book_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_work`
--

DROP TABLE IF EXISTS `book_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_work` (
  `book_id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`work_id`),
  KEY `book_id` (`book_id`),
  KEY `work_id` (`work_id`),
  CONSTRAINT `fk_work_book_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `fk_work_book_work_id` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_work`
--

LOCK TABLES `book_work` WRITE;
/*!40000 ALTER TABLE `book_work` DISABLE KEYS */;
INSERT INTO `book_work` VALUES (1,30),(2,31),(2,32),(3,33),(4,33),(4,34),(5,31),(6,35),(7,36),(8,37),(9,38),(10,39),(11,40),(12,41),(13,42),(14,43),(15,44);
/*!40000 ALTER TABLE `book_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Minsk');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (7,'Журнал'),(1,'Классика'),(3,'Научная фантастика'),(6,'Публицистика'),(2,'Фантастика'),(4,'Фэнтези');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `offer_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `book_id` (`book_id`) USING BTREE,
  KEY `offer_type_id` (`offer_type_id`) USING BTREE,
  CONSTRAINT `offer_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `offer_fk2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `offer_fk3` FOREIGN KEY (`offer_type_id`) REFERENCES `offer_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (1,1,1,1),(2,1,2,1),(3,1,3,1),(4,1,4,1),(5,1,5,1),(6,1,6,1),(7,12,7,1),(8,1,8,1),(9,1,9,1),(10,1,10,1),(11,1,11,1),(12,1,12,1),(13,13,13,1),(14,13,14,1),(15,13,15,1);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer_type`
--

DROP TABLE IF EXISTS `offer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer_type`
--

LOCK TABLES `offer_type` WRITE;
/*!40000 ALTER TABLE `offer_type` DISABLE KEYS */;
INSERT INTO `offer_type` VALUES (3,'Куплю'),(1,'Отдам'),(5,'Сожгу');
/*!40000 ALTER TABLE `offer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `first_name` varchar(40) DEFAULT NULL,
  `middle_name` varchar(40) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `city_id` (`city_id`),
  CONSTRAINT `person_fk1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'lara','lara','lara',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote`
--

DROP TABLE IF EXISTS `quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote` (
  `ID` int(11) NOT NULL,
  `QUOTE` varchar(250) NOT NULL,
  `AUTHOR` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote`
--

LOCK TABLES `quote` WRITE;
/*!40000 ALTER TABLE `quote` DISABLE KEYS */;
INSERT INTO `quote` VALUES (1,'Творец книги — автор, творец ее судьбы — общество.','Виктор Гюго'),(2,'Литература изъята из законов тления. Она одна не признает смерти.','Михаил Салтыков-Щедрин'),(3,'Нужно делать так, как нужно. А как не нужно, делать не нужно.','Винни Пух');
/*!40000 ALTER TABLE `quote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `login` (`login`) USING BTREE,
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `person_id` (`person_id`),
  CONSTRAINT `user_fk1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin@mail.com',NULL),(12,'user','user','user@mail.com',1),(13,'Masha','mama','masha_mazanik@mail.ru',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `fk_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1,'Евгений Онегин'),(2,'Хрюшина Библия'),(11,'Горе от ума'),(12,'451 по фаренгейту'),(13,'1984'),(14,'Ночной Дозор'),(17,'Дневной Дозор'),(18,'Осенние визиты'),(19,'Бойцовский клуб'),(20,'Линия грез'),(21,'Тело'),(22,'Библия'),(23,'Множественные умы Билли Миллигана'),(24,'Война и мир'),(26,'Следопыт'),(27,'Стихи'),(28,'Стихи'),(29,'Зверобой'),(30,'Словарь'),(31,'Стихи'),(32,'Стихи'),(33,'Книга'),(34,'Книга2'),(35,'Метро 2033'),(36,'Портрет Дориана Грея'),(37,'Дивный новый мир'),(38,'Винни Пух'),(39,'Новый дозор'),(40,'Осенние визиты'),(41,'Повелитель мух'),(42,'Цветы для Элджернона'),(43,'Множественные умы Билли Миллигана'),(44,'Проклятые');
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_author`
--

DROP TABLE IF EXISTS `work_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_author` (
  `work_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`work_id`,`author_id`),
  KEY `work_id` (`work_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `fk_work_athor_work_id` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `fk_work_author_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_author`
--

LOCK TABLES `work_author` WRITE;
/*!40000 ALTER TABLE `work_author` DISABLE KEYS */;
INSERT INTO `work_author` VALUES (1,1),(2,2),(11,76),(12,77),(13,78),(14,55),(17,55),(18,55),(19,85),(20,55),(21,86),(23,87),(24,45),(26,94),(29,94),(30,96),(31,1),(32,95),(33,103),(33,104),(34,104),(34,105),(35,106),(36,107),(37,108),(38,109),(39,55),(40,55),(41,110),(42,87),(43,87),(44,85);
/*!40000 ALTER TABLE `work_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_genre`
--

DROP TABLE IF EXISTS `work_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_genre` (
  `work_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  PRIMARY KEY (`work_id`,`genre_id`),
  KEY `work_id` (`work_id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `fk_work_genre_genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `fk_work_genre_work_id` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_genre`
--

LOCK TABLES `work_genre` WRITE;
/*!40000 ALTER TABLE `work_genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_genre` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-11  3:03:49
