/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.27 : Database - courses
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`courses` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `courses`;

/*Table structure for table `courses` */

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `cid` char(10) NOT NULL,
  `cname` char(10) DEFAULT NULL,
  `cplace` char(10) DEFAULT NULL,
  `ccredit` float DEFAULT NULL,
  `cteacher` char(10) DEFAULT NULL,
  `ctime` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `courses` */

insert  into `courses`(`cid`,`cname`,`cplace`,`ccredit`,`cteacher`,`ctime`) values ('1111','数据库','主楼',1,'王瑞红','12'),('2222','单片机','主楼',2,'黄喜云','11'),('3333','java','科厦',3,'高辉','10'),('4444','操作系统','科厦',4,'游海晖','9');

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `sId` char(10) NOT NULL,
  `sName` char(20) DEFAULT NULL,
  `sAge` int(11) DEFAULT NULL,
  `sSex` char(10) DEFAULT NULL,
  `sDept` char(10) DEFAULT NULL,
  `sPassword` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `students` */

insert  into `students`(`sId`,`sName`,`sAge`,`sSex`,`sDept`,`sPassword`) values ('13','孙',21,'男','数学系','12'),('14','周',22,'女','外语系','12'),('15','赵',23,'女','计科系','12'),('12','王',19,'男','计科系','12');

/*Table structure for table `syllabus` */

DROP TABLE IF EXISTS `syllabus`;

CREATE TABLE `syllabus` (
  `cid` char(10) NOT NULL,
  `sid` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `syllabus` */

insert  into `syllabus`(`cid`,`sid`) values ('1111','11'),('121','11'),('2222','11'),('1111','12'),('2222','12');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` char(10) NOT NULL,
  `tName` char(10) DEFAULT NULL,
  `tPassword` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`tid`,`tName`,`tPassword`) values ('1','11','11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
