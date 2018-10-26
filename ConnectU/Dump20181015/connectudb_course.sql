-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: connectudb
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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course` (
  `course_id` varchar(45) NOT NULL,
  `prerequisite_course_id` varchar(45) DEFAULT NULL,
  `course_name` varchar(100) NOT NULL,
  `semester_one_flag` tinyint(4) DEFAULT NULL,
  `semester_two_flag` tinyint(4) DEFAULT NULL,
  `semester_three_flag` tinyint(4) DEFAULT NULL,
  `uoc` int(11) NOT NULL,
  `link` varchar(45) DEFAULT NULL,
  `prerequisite_courses` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `course_id_UNIQUE` (`course_id`),
  KEY `course_ibfk_1` (`prerequisite_course_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`prerequisite_course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('ACCT1501',NULL,'Accounting and Financial Management 1A',1,1,1,6,NULL,NULL),('ACCT1511','ACCT1501','Accounting and Financial Mgt 1B',1,1,1,6,NULL,NULL),('ACCT2507','ACCT1511','Introduction to Accounting Research',0,0,1,6,NULL,NULL),('ACCT2522','ACCT1501','Management Accounting 1',1,1,0,6,NULL,NULL),('ACCT2542','ACCT1501','Corporate Financial Reporting and Analysis',0,1,0,6,NULL,NULL),('ACCT3563','ACCT2542','Issues in Financial Reporting and Analysis',1,0,1,6,NULL,NULL),('ACCT3583','ACCT2522','Management Accounting 2',1,0,1,6,NULL,NULL),('ACCT3601','ACCT2542','Global Financial Reporting and Analysis',0,0,1,6,NULL,NULL),('ACCT3708','ACCT2542','Auditing and Assurance Services',1,1,0,6,NULL,NULL),('ARTS1090',NULL,'Media, Culture and Everyday Life',1,0,0,6,NULL,NULL),('ARTS1450',NULL,'Introductory Chinese',1,0,0,6,NULL,NULL),('COMM1000',NULL,'Creating Social Change',1,1,1,6,NULL,NULL),('ECON1101',NULL,'Microeconomics 1',1,1,1,6,NULL,NULL),('ECON1102',NULL,'Maroeconomics',1,1,1,6,NULL,NULL),('ECON1203',NULL,'Business and Economic Statistics',1,1,1,6,NULL,NULL),('FINS1613',NULL,'Business Finance',1,1,1,6,NULL,NULL),('INFS1602',NULL,'Digital Transformation',1,1,0,6,NULL,NULL),('INFS1603',NULL,'Introduction to Business Databases',1,0,1,6,NULL,NULL),('INFS1609',NULL,'Fundamentals of Business Programming',1,0,1,6,NULL,NULL),('INFS2603','INFS1602','Business Analysis',0,0,1,6,NULL,NULL),('INFS2605','INFS1609','Intermediate Business Programming',1,0,1,6,NULL,'INFS1603, INFS1609'),('INFS2608','INFS1602','Database Management',1,0,1,6,NULL,NULL),('INFS2621','INFS1602','Enterprise Systems',0,1,0,6,NULL,NULL),('INFS2631','INFS1602','Innovation and Technology Management',1,0,0,6,NULL,NULL),('INFS3020',NULL,'International Information Systems and Technology Practicum',0,1,0,6,NULL,NULL),('INFS3603','INFS1602','Introduction to Business Analytics',1,1,0,6,NULL,NULL),('INFS3604','INFS2603','Business Process Management',0,0,1,6,NULL,NULL),('INFS3605','INFS3634','Information Systems Innovation and Transformation',1,1,0,6,NULL,NULL),('INFS3617','INFS1602','Networking and Cyber Security',1,0,0,6,NULL,NULL),('INFS3632','INFS1602','Service and Quality Management',0,1,0,6,NULL,NULL),('INFS3634','INFS2605','Mobile Applications Development',1,0,1,6,NULL,'INFS2605, INFS2608'),('INFS3830','INFS3603','Social Media and Analytics',1,0,0,6,NULL,NULL),('INFS3873','INFS3603','Business Analytics Methods',0,0,1,6,NULL,NULL),('MARK1012',NULL,'Marketing Fundamentals',1,1,1,6,NULL,NULL),('MATH1041',NULL,'Statistics for Life and Social Science',0,1,0,6,NULL,NULL),('MDIA1002',NULL,'Media and Communication Contexts',1,0,0,6,NULL,NULL),('MGMT1001',NULL,'Managing Organisations and People',1,1,1,6,NULL,NULL),('PHYS1160',NULL,'Introduction to Astronomy',1,1,1,6,NULL,NULL),('TABL1710',NULL,'Business and the Law',1,1,1,6,NULL,NULL),('TABL2741','TABL1710','Business Entity',0,1,1,6,NULL,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-15  0:47:59
