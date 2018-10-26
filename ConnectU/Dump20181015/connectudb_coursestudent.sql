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
-- Table structure for table `coursestudent`
--

DROP TABLE IF EXISTS `coursestudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coursestudent` (
  `course_student_id` varchar(100) NOT NULL,
  `course_id` varchar(45) NOT NULL,
  `student_id` varchar(45) NOT NULL,
  PRIMARY KEY (`course_student_id`),
  KEY `course_id` (`course_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `coursestudent_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `coursestudent_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursestudent`
--

LOCK TABLES `coursestudent` WRITE;
/*!40000 ALTER TABLE `coursestudent` DISABLE KEYS */;
INSERT INTO `coursestudent` VALUES ('1','INFS1602','1234'),('10','INFS2608','1234'),('11','INFS2621','1234'),('12','INFS3634','1234'),('13','PHYS1160','1234'),('14','ARTS1090','1234'),('15','MDIA1002','1234'),('16','ARTS1450','1234'),('17','INFS1602','2345'),('18','INFS1603','2345'),('19','INFS1609','2345'),('2','INFS1603','1234'),('20','INFS2621','2345'),('21','INFS2603','2345'),('22','INFS2608','2345'),('23','INFS2605','2345'),('24','INFS3634','2345'),('3','INFS1609','1234'),('4','ACCT1501','1234'),('5','INFS2603','1234'),('6','MGMT1001','1234'),('7','ECON1203','1234'),('8','ECON1101','1234'),('9','INFS2605','1234');
/*!40000 ALTER TABLE `coursestudent` ENABLE KEYS */;
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
