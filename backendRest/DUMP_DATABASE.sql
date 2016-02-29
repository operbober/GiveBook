# SQL Manager for MySQL 5.5.3.46192
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : bc


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `bc`;

CREATE DATABASE `bc`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `bc`;

#
# ????????? ??? ??????? `author`: 
#

CREATE TABLE `author` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `person_id` INTEGER(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `person_id` (`person_id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `book`: 
#

CREATE TABLE `book` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `work_id` INTEGER(11) DEFAULT NULL,
  `book_type` INTEGER(11) DEFAULT NULL,
  `language` INTEGER(11) DEFAULT NULL,
  `condition` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `book_type`: 
#

CREATE TABLE `book_type` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `city`: 
#

CREATE TABLE `city` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `condition`: 
#

CREATE TABLE `condition` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `genre`: 
#

CREATE TABLE `genre` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `language`: 
#

CREATE TABLE `language` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `offer`: 
#

CREATE TABLE `offer` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `user_id` INTEGER(11) NOT NULL,
  `book_id` INTEGER(11) NOT NULL,
  `offer_type_id` INTEGER(11) NOT NULL,
  `city_id` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `offer_type`: 
#

CREATE TABLE `offer_type` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `person`: 
#

CREATE TABLE `person` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `first_name` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `midle_name` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `city_id` INTEGER(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `role`: 
#

CREATE TABLE `role` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `user`: 
#

CREATE TABLE `user` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) COLLATE latin1_swedish_ci NOT NULL,
  `password` VARCHAR(100) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `login` (`login`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=3 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `work`: 
#

CREATE TABLE `work` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# ????????? ??? ??????? `work_title`: 
#

CREATE TABLE `work_title` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  `work_id` INTEGER(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
;

#
# Data for the `user` table  (LIMIT 0,500)
#

INSERT INTO `user` (`id`, `login`, `password`) VALUES
  (1,'user','user'),
  (2,'user1','user1');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;