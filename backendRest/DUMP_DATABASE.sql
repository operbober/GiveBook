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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Пушкин','Александр','Сергеевич'),(2,'Хрюшкин','Александр','Сергеевич'),(45,'Толстой','Лев','Николаевич'),(46,'Чехов','Антон','Павлович'),(55,'Лукьяненко','Сергей','Васильевич'),(56,'Достоевский','Федор','Михайлович'),(70,'Бак','Джон',''),(71,'Кинг','Стивен','');
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
  `work_id` int(11) DEFAULT NULL,
  `language_id` int(11) DEFAULT NULL,
  `book_type_id` int(11) DEFAULT NULL,
  `book_condition_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `work_id` (`work_id`) USING BTREE,
  KEY `book_type_id` (`book_type_id`) USING BTREE,
  KEY `language_id` (`language_id`) USING BTREE,
  KEY `condition_id` (`book_condition_id`) USING BTREE,
  CONSTRAINT `book_fk4` FOREIGN KEY (`book_condition_id`) REFERENCES `book_condition` (`id`),
  CONSTRAINT `book_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `book_fk2` FOREIGN KEY (`book_type_id`) REFERENCES `book_type` (`id`),
  CONSTRAINT `book_fk3` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,1,NULL,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_condition`
--

LOCK TABLES `book_condition` WRITE;
/*!40000 ALTER TABLE `book_condition` DISABLE KEYS */;
INSERT INTO `book_condition` VALUES (3,'Изношенная'),(1,'Новая'),(4,'Очень даже ничего'),(6,'Полвека на полке стояла'),(5,'Потрепанная'),(2,'Старая');
/*!40000 ALTER TABLE `book_condition` ENABLE KEYS */;
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
INSERT INTO `book_type` VALUES (5,'Газета'),(4,'Журнал'),(1,'Карманная'),(3,'Мягкая обложка'),(2,'Твердый переплет');
/*!40000 ALTER TABLE `book_type` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
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
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (1,1,1,1);
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
INSERT INTO `offer_type` VALUES (3,'Куплю'),(1,'Отдам'),(2,'Поменяю'),(5,'Сожгу'),(4,'Хочу');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin@mail.com',NULL),(12,'user','user','user@mail.com',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_fk2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1),(2);
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_title`
--

DROP TABLE IF EXISTS `work_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `work_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `work_id` (`work_id`) USING BTREE,
  CONSTRAINT `work_title_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_title`
--

LOCK TABLES `work_title` WRITE;
/*!40000 ALTER TABLE `work_title` DISABLE KEYS */;
INSERT INTO `work_title` VALUES (1,'Евгений Онегин',1),(2,'Evgen Oneg',1),(3,'Хрюшина библия',2);
/*!40000 ALTER TABLE `work_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `works_authors`
--

DROP TABLE IF EXISTS `works_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `works_authors` (
  `work_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  KEY `work_id` (`work_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `work_author_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `work_author_fk2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works_authors`
--

LOCK TABLES `works_authors` WRITE;
/*!40000 ALTER TABLE `works_authors` DISABLE KEYS */;
INSERT INTO `works_authors` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `works_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `works_genres`
--

DROP TABLE IF EXISTS `works_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `works_genres` (
  `work_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  KEY `work_id` (`work_id`) USING BTREE,
  KEY `genre_id` (`genre_id`) USING BTREE,
  CONSTRAINT `work_genre_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `work_genre_fk2` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works_genres`
--

LOCK TABLES `works_genres` WRITE;
/*!40000 ALTER TABLE `works_genres` DISABLE KEYS */;
/*!40000 ALTER TABLE `works_genres` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-04 20:14:44
