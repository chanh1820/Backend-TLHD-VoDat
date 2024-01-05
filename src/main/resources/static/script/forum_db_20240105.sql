/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 8.2.0 : Database - forum_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`forum_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `forum_db`;

/*Table structure for table `post_comment_tbl` */

DROP TABLE IF EXISTS `post_comment_tbl`;

CREATE TABLE `post_comment_tbl` (
  `post_comment_id` int unsigned NOT NULL AUTO_INCREMENT,
  `post_id` int unsigned DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `display_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `comment_content` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`post_comment_id`),
  KEY `fk_post_comment_tbl_post_tbl_idx` (`post_id`),
  CONSTRAINT `fk_post_comment_tbl_post_tbl` FOREIGN KEY (`post_id`) REFERENCES `post_tbl` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post_comment_tbl` */

insert  into `post_comment_tbl`(`post_comment_id`,`post_id`,`user_name`,`display_name`,`comment_content`,`create_date`,`delete_flag`) values 
(1,1,'minhchanh','Minh Chánh','Chào','2024-01-04 08:53:27','\0');

/*Table structure for table `post_interaction_tbl` */

DROP TABLE IF EXISTS `post_interaction_tbl`;

CREATE TABLE `post_interaction_tbl` (
  `post_interaction_id` int unsigned NOT NULL AUTO_INCREMENT,
  `post_id` int unsigned DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`post_interaction_id`),
  KEY `fk_post_interaction_tbl_post_tbl_idx` (`post_id`),
  CONSTRAINT `fk_post_interaction_tbl_post_tbl` FOREIGN KEY (`post_id`) REFERENCES `post_tbl` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post_interaction_tbl` */

insert  into `post_interaction_tbl`(`post_interaction_id`,`post_id`,`type`,`user_name`,`create_date`) values 
(1,1,'1','minhchanh','2024-01-04 08:52:24.000000');

/*Table structure for table `post_tbl` */

DROP TABLE IF EXISTS `post_tbl`;

CREATE TABLE `post_tbl` (
  `post_id` int unsigned NOT NULL AUTO_INCREMENT,
  `topic_code` varchar(255) DEFAULT NULL,
  `user_id` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `post_title` varchar(255) DEFAULT NULL,
  `post_content` varchar(20000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post_tbl` */

insert  into `post_tbl`(`post_id`,`topic_code`,`user_id`,`post_title`,`post_content`,`author`,`create_date`,`update_date`,`delete_flag`) values 
(1,'TP01','minhchanh','Chào','XIn chào tôi tên là chánh','Minh Chánh','2024-01-04 08:49:07','2024-01-04 08:49:05','\0'),
(4,'TP02','minhchanh','Chào','XIn chào tôi tên là chánh','Minh Chánh','2024-01-04 08:49:07','2024-01-04 08:49:05','\0'),
(5,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(6,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(7,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(8,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(9,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(10,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(11,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(12,'sdf','sdf','sdf','dsfsd','df','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(13,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(14,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(15,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(16,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(17,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(18,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(19,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(20,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(21,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:34:06','2024-01-05 08:34:06','\0'),
(22,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:45:39','2024-01-05 08:45:39','\0'),
(23,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:49:33','2024-01-05 08:49:33','\0'),
(24,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:49:34','2024-01-05 08:49:34','\0'),
(25,'TP01','minhchanh','Một ngày đẹp trời','Hôm nay là một ngày đẹp trời có nắng và gió','Minh Chánh','2024-01-05 08:50:41','2024-01-05 08:50:41','\0');

/*Table structure for table `topic_tbl` */

DROP TABLE IF EXISTS `topic_tbl`;

CREATE TABLE `topic_tbl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `topic_code` varchar(10) NOT NULL,
  `topic_name` varchar(225) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_flag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `topic_code_UNIQUE` (`topic_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `topic_tbl` */

insert  into `topic_tbl`(`id`,`topic_code`,`topic_name`,`create_date`,`delete_flag`) values 
(1,'TP01','Khẩn cấp','2024-01-02 17:51:04','\0'),
(2,'TP02','Tâm sự','2024-01-02 17:53:04','\0'),
(3,'sad','aadas','2024-01-05 08:32:39','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
