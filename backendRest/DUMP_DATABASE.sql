﻿# SQL Manager 2010 for MySQL 4.5.0.9
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : bc


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `bc`;

CREATE DATABASE `bc`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `bc`;

#
# Structure for the `author` table : 
#

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

#
# Structure for the `book_condition` table : 
#

CREATE TABLE `book_condition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Structure for the `book_language` table : 
#

CREATE TABLE `book_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for the `book_type` table : 
#

CREATE TABLE `book_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Structure for the `work` table : 
#

CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Structure for the `book` table : 
#

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
  CONSTRAINT `book_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `book_fk2` FOREIGN KEY (`book_type_id`) REFERENCES `book_type` (`id`),
  CONSTRAINT `book_fk3` FOREIGN KEY (`language_id`) REFERENCES `book_language` (`id`),
  CONSTRAINT `book_fk4` FOREIGN KEY (`book_condition_id`) REFERENCES `book_condition` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Structure for the `book_work` table : 
#

CREATE TABLE `book_work` (
  `book_id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `books_works` table : 
#

CREATE TABLE `books_works` (
  `book_id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL,
  KEY `work_id` (`work_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `works_books_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`) ON DELETE CASCADE,
  CONSTRAINT `works_books_fk2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

#
# Structure for the `city` table : 
#

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for the `condition` table : 
#

CREATE TABLE `condition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `genre` table : 
#

CREATE TABLE `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Structure for the `offer_type` table : 
#

CREATE TABLE `offer_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Structure for the `person` table : 
#

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

#
# Structure for the `user` table : 
#

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

#
# Structure for the `offer` table : 
#

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Structure for the `role` table : 
#

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for the `user_role` table : 
#

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `work_title` table : 
#

CREATE TABLE `work_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `work_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `work_id` (`work_id`) USING BTREE,
  CONSTRAINT `work_title_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Structure for the `works_authors` table : 
#

CREATE TABLE `works_authors` (
  `work_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  KEY `work_id` (`work_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `work_author_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `work_author_fk2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

#
# Structure for the `works_genres` table : 
#

CREATE TABLE `works_genres` (
  `work_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  KEY `work_id` (`work_id`) USING BTREE,
  KEY `genre_id` (`genre_id`) USING BTREE,
  CONSTRAINT `work_genre_fk1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `work_genre_fk2` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `author` table  (LIMIT 0,500)
#

INSERT INTO `author` (`id`, `last_name`, `first_name`, `middle_name`) VALUES 
  (1,'Пушкин','Александр','Сергеевич'),
  (2,'Хрюшкин','Александр','Сергеевич'),
  (45,'Толстой','Лев','Николаевич'),
  (46,'Чехов','Антон','Павлович'),
  (55,'Лукьяненко','Сергей','Васильевич'),
  (56,'Достоевский','Федор','Михайлович'),
  (70,'Бак','Джон',''),
  (71,'Кинг','Стивен',''),
  (72,'asd',NULL,NULL),
  (73,'zxc',NULL,NULL),
  (74,'qwe',NULL,NULL);
COMMIT;

#
# Data for the `work` table  (LIMIT 0,500)
#

INSERT INTO `work` (`id`, `name`) VALUES 
  (1,'Евгений Онегин'),
  (2,'Хрюшина Библия'),
  (3,'qwe'),
  (4,'qwe'),
  (5,'qwe'),
  (6,'123'),
  (7,'z'),
  (8,'123'),
  (9,'qwe');
COMMIT;

#
# Data for the `book_type` table  (LIMIT 0,500)
#

INSERT INTO `book_type` (`id`, `name`) VALUES 
  (1,'Карманная'),
  (2,'Твердый переплет'),
  (3,'Мягкая обложка'),
  (4,'Журнал'),
  (5,'Газета');
COMMIT;

#
# Data for the `book_language` table  (LIMIT 0,500)
#

INSERT INTO `book_language` (`id`, `name`) VALUES 
  (1,'Русский'),
  (2,'Нерусский');
COMMIT;

#
# Data for the `book_condition` table  (LIMIT 0,500)
#

INSERT INTO `book_condition` (`id`, `name`) VALUES 
  (1,'Новая'),
  (2,'Старая'),
  (3,'Изношенная'),
  (4,'Очень даже ничего'),
  (5,'Потрепанная'),
  (6,'Полвека на полке стояла');
COMMIT;

#
# Data for the `book` table  (LIMIT 0,500)
#

INSERT INTO `book` (`id`, `work_id`, `language_id`, `book_type_id`, `book_condition_id`) VALUES 
  (1,1,NULL,NULL,1),
  (2,NULL,NULL,NULL,NULL),
  (3,NULL,NULL,NULL,NULL),
  (4,NULL,2,5,3),
  (5,NULL,2,5,3),
  (6,NULL,2,NULL,2);
COMMIT;

#
# Data for the `book_work` table  (LIMIT 0,500)
#

INSERT INTO `book_work` (`book_id`, `work_id`) VALUES 
  (2,3),
  (2,4),
  (3,5),
  (4,6),
  (4,7),
  (5,3),
  (5,7),
  (5,8),
  (6,9);
COMMIT;

#
# Data for the `books_works` table  (LIMIT 0,500)
#

INSERT INTO `books_works` (`book_id`, `work_id`) VALUES 
  (25,43),
  (25,44),
  (26,45),
  (27,46),
  (28,46);
COMMIT;

#
# Data for the `city` table  (LIMIT 0,500)
#

INSERT INTO `city` (`id`, `name`) VALUES 
  (1,'Minsk');
COMMIT;

#
# Data for the `genre` table  (LIMIT 0,500)
#

INSERT INTO `genre` (`id`, `name`) VALUES 
  (1,'Классика'),
  (2,'Фантастика'),
  (3,'Научная фантастика'),
  (4,'Фэнтези'),
  (6,'Публицистика'),
  (7,'Журнал');
COMMIT;

#
# Data for the `person` table  (LIMIT 0,500)
#

INSERT INTO `person` (`id`, `last_name`, `first_name`, `middle_name`, `city_id`) VALUES 
  (1,'lara','lara','lara',1);
COMMIT;

#
# Data for the `user` table  (LIMIT 0,500)
#

INSERT INTO `user` (`id`, `login`, `password`, `email`, `person_id`) VALUES 
  (1,'admin','admin','admin@mail.com',NULL),
  (12,'user','user','user@mail.com',1);
COMMIT;

#
# Data for the `offer_type` table  (LIMIT 0,500)
#

INSERT INTO `offer_type` (`id`, `name`) VALUES 
  (1,'Отдам'),
  (2,'Поменяю'),
  (3,'Куплю'),
  (4,'Хочу'),
  (5,'Сожгу');
COMMIT;

#
# Data for the `offer` table  (LIMIT 0,500)
#

INSERT INTO `offer` (`id`, `user_id`, `book_id`, `offer_type_id`) VALUES 
  (1,1,1,5),
  (2,1,1,3),
  (3,1,2,1),
  (4,1,3,1),
  (5,1,4,1),
  (6,1,5,1),
  (7,1,6,1);
COMMIT;

#
# Data for the `role` table  (LIMIT 0,500)
#

INSERT INTO `role` (`id`, `name`) VALUES 
  (1,'ROLE_ADMIN'),
  (2,'ROLE_USER');
COMMIT;

#
# Data for the `user_role` table  (LIMIT 0,500)
#

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES 
  (1,1);
COMMIT;

#
# Data for the `work_title` table  (LIMIT 0,500)
#

INSERT INTO `work_title` (`id`, `name`, `work_id`) VALUES 
  (1,'Евгений Онегин',1),
  (2,'Evgen Oneg',1),
  (3,'Хрюшина библия',2);
COMMIT;

#
# Data for the `works_authors` table  (LIMIT 0,500)
#

INSERT INTO `works_authors` (`work_id`, `author_id`) VALUES 
  (1,1),
  (2,2),
  (3,72),
  (5,73),
  (7,74);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;