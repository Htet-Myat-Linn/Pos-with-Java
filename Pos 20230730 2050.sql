-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema pos
--

CREATE DATABASE IF NOT EXISTS pos;
USE pos;

--
-- Definition of table `brand`
--

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brandid` varchar(10) NOT NULL,
  `brandname` varchar(30) NOT NULL,
  PRIMARY KEY  (`brandid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `brand`
--

/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`brandid`,`brandname`) VALUES 
 ('BR-0000001','LG'),
 ('BR-0000002','SONY'),
 ('BR-0000003','ZTE'),
 ('BR-0000004','Google'),
 ('BR-0000005','Samsung'),
 ('BR-0000006','Hisense'),
 ('BR-0000007','HTC Hero'),
 ('BR-0000008','UBIQUAM'),
 ('BR-0000009','i Phone'),
 ('BR-0000010','Black Berry'),
 ('BR-0000011','lenovo'),
 ('BR-0000012','apple'),
 ('BR-0000013','fsdt');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerid` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phoneno` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY  (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customerid`,`name`,`address`,`phoneno`,`email`) VALUES 
 ('CU-0000026','','gu','09099999','dSJD@gmail.com'),
 ('CU_0000001','Chan Myae','Japan','013456789','cm@gmail.com'),
 ('CU_0000002','Zwe Min Htike','Yangon','0949213847','zmt@gmail.com'),
 ('CU_0000003','Moe That Zun','Mawbi','0145623','mtz@gmail.com'),
 ('CU_0000004','Kyaw Si Thu','Yangon','012458','kst@gmail.com'),
 ('CU_0000005','Aung Set Paing','Yangon','01610452','asp@gmail.com'),
 ('CU_0000006','Sap Yan Naing','Innlay','014789562','syn@gmail.com'),
 ('CU_0000008','Cho Lay','Yangon','01452897','cl@gmail.com'),
 ('CU_0000009','Nan Daiwi','Shan','0124578','nd@gmail.com'),
 ('CU_0000010','Nan Khin','pinya','0546123','nk@gmail.com'),
 ('CU_0000011','Naw Yin Mawe','Kayin','0312458','ym@gmail.com'),
 ('CU_0000012','Khun Myo Yan Kim','pinlaung','014562','myk@gmail.com'),
 ('CU_0000013','Khun Ye Cho Cho Paing','Pinya','03124587','ccp@gmail.com'),
 ('CU_0000014','May Than Nu','Mon','0456231','mtn@gmail.com'),
 ('CU_0000015','Naing Myo Aung','Yangon','0973146182','nmy@gmail.com');
INSERT INTO `customer` (`customerid`,`name`,`address`,`phoneno`,`email`) VALUES 
 ('CU_0000016','Chit Eindary Myint Myat','Yangon','014562','emm@gmail.com'),
 ('CU_0000017','Nan Sandar','Shan State','05478945','ns@gmail.com'),
 ('CU_0000018','Nyein Nyein','Yangon','0124578','nn@gmail.com'),
 ('CU_0000019','Nandar','Pyay','014785','nd@gmail.com'),
 ('CU_0000020','sjka','djsdk','0921122','sdjkdj12@gmail.com'),
 ('CU_0000021','difjfdh','fdjfk','92337238','djfhfjhf11@gmail.com'),
 ('CU_0000022','jfjjdsfhdj','jvfj','3478344837','djfhfdhk637@gmail.com'),
 ('CU_0000023','eirrurookf','gfjgfjf','0933447843','fjdvjd12@gmail.com'),
 ('CU_0000024','fjffjfdlk','cjvvjkcv','0948394','sjhdjf12@gmail.com'),
 ('CU_0000025','djfjdfh','jdsdj','293833','djdfj12@gamil.com'),
 ('CU_0000026','Htet','fkfgj','09776565','vjvj@gmail.com'),
 ('CU_0000027','Htetdfjfj','jkjf','093743476','jdghj@gmail.com'),
 ('CU_0000028','Htet','fjfjfj','098766555','fnjkd@gamil.com'),
 ('CU_0000029',' heett','fjdf','09776656','njfd@gmail.com'),
 ('CU_0000030',' dhjfhdfhj',' djfhj','0977666','chdjf@gmail.com');
INSERT INTO `customer` (`customerid`,`name`,`address`,`phoneno`,`email`) VALUES 
 ('CU_0000031','fjdj','jdfh','097766','cbdhhj@gmail.com'),
 ('CU_0000032',' dffhjdjJF','dbf','09876655','dfh@gmail.com'),
 ('CU_0000033',' jdfhdhj','jdfjdj','0987777','cjh@gmail.com'),
 ('CU_0000034',' drffdfd','fff','09877','hhvfg@gmail.com'),
 ('CU_0000035',' djkfd','jfd','0978765','vjv@gmail.com'),
 ('CU_0000036',' Htert','fjdjf','0987666','ffg@gmail.com'),
 ('CU_0000037',' dfdff','djff','0977666','dfjf@gmail.com'),
 ('CU_0000038',' djkfjkdk','dkf','09766555','jdf@gmail.com'),
 ('CU_0000039',' jdffj','jkfg','09776655','vvjJK@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `itemdetail`
--

DROP TABLE IF EXISTS `itemdetail`;
CREATE TABLE `itemdetail` (
  `itemid` varchar(10) NOT NULL,
  `merid` varchar(10) NOT NULL,
  `itemname` varchar(45) NOT NULL,
  `curSaleprice` bigint(20) unsigned NOT NULL default '0',
  `remark` varchar(45) NOT NULL,
  `totalQty` bigint(20) unsigned NOT NULL default '0',
  PRIMARY KEY  (`itemid`),
  KEY `FK_itemdetail_1` (`merid`),
  CONSTRAINT `FK_itemdetail_1` FOREIGN KEY (`merid`) REFERENCES `merchandise` (`merid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemdetail`
--

/*!40000 ALTER TABLE `itemdetail` DISABLE KEYS */;
INSERT INTO `itemdetail` (`itemid`,`merid`,`itemname`,`curSaleprice`,`remark`,`totalQty`) VALUES 
 ('IT_0000001','ME-0000001','NOKIA N96',3300,'Music Phone',10),
 ('IT_0000002','ME-0000001','Vivo',11000,'Good',102),
 ('IT_0000003','ME-0000001','hifj',0,'fjdi',0),
 ('IT_0000004','ME-0000001','rrffd',0,'ddf',0);
/*!40000 ALTER TABLE `itemdetail` ENABLE KEYS */;


--
-- Definition of table `merchandise`
--

DROP TABLE IF EXISTS `merchandise`;
CREATE TABLE `merchandise` (
  `merid` varchar(10) NOT NULL,
  `brandid` varchar(10) NOT NULL,
  `Typeid` varchar(10) NOT NULL,
  PRIMARY KEY  (`merid`),
  KEY `FK_Merchandise_1` (`brandid`),
  KEY `FK_Merchandise_2` (`Typeid`),
  CONSTRAINT `FK_Merchandise_1` FOREIGN KEY (`brandid`) REFERENCES `brand` (`brandid`),
  CONSTRAINT `FK_Merchandise_2` FOREIGN KEY (`Typeid`) REFERENCES `type` (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `merchandise`
--

/*!40000 ALTER TABLE `merchandise` DISABLE KEYS */;
INSERT INTO `merchandise` (`merid`,`brandid`,`Typeid`) VALUES 
 ('ME-0000001','BR-0000001','TP-0000003');
/*!40000 ALTER TABLE `merchandise` ENABLE KEYS */;


--
-- Definition of table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `orderid` varchar(10) NOT NULL,
  `itemid` varchar(10) NOT NULL,
  `deposit` bigint(20) unsigned NOT NULL,
  `orderQty` int(10) unsigned NOT NULL,
  `price` bigint(20) unsigned NOT NULL,
  `remark` int(10) unsigned NOT NULL default '0',
  KEY `FK_orderdetail_2` (`orderid`),
  CONSTRAINT `FK_orderdetail_1` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `FK_orderdetail_2` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderdetail`
--

/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` (`orderid`,`itemid`,`deposit`,`orderQty`,`price`,`remark`) VALUES 
 ('OR_0000001','IT_0000001',27500,1,55000,1);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;


--
-- Definition of table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` varchar(10) NOT NULL,
  `customerid` varchar(10) NOT NULL,
  `orderdate` date NOT NULL,
  PRIMARY KEY  (`orderid`),
  KEY `FK_orders_1` (`customerid`),
  CONSTRAINT `FK_orders_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`orderid`,`customerid`,`orderdate`) VALUES 
 ('OR_0000001','CU_0000001','2012-02-09');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


--
-- Definition of table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purchaseid` varchar(10) NOT NULL,
  `supplierid` varchar(10) NOT NULL,
  `purchasedate` date NOT NULL,
  PRIMARY KEY  (`purchaseid`),
  KEY `FK_purchase_1` (`supplierid`),
  CONSTRAINT `FK_purchase_1` FOREIGN KEY (`supplierid`) REFERENCES `supplier` (`supplierid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`purchaseid`,`supplierid`,`purchasedate`) VALUES 
 ('P-00000001','SU_0000003','2012-02-09'),
 ('P-00000002','SU_0000001','2012-01-17'),
 ('P-00000003','SU_0000002','2012-01-17'),
 ('P-00000004','SU_0000002','2012-01-17'),
 ('P-00000005','SU_0000003','2012-01-17'),
 ('P-00000006','SU_0000002','2012-01-17'),
 ('P-00000007','SU_0000003','2023-03-28'),
 ('P-00000008','SU_0000002','2023-07-24');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


--
-- Definition of table `purchasedetail`
--

DROP TABLE IF EXISTS `purchasedetail`;
CREATE TABLE `purchasedetail` (
  `purchaseid` varchar(10) NOT NULL,
  `purchaseprice` bigint(20) unsigned NOT NULL,
  `purchasequantity` int(10) unsigned NOT NULL,
  `itemid` varchar(10) NOT NULL,
  KEY `FK_purchasedetail_1` (`purchaseid`),
  KEY `FK_purchasedetail_2` (`itemid`),
  CONSTRAINT `FK_purchasedetail_1` FOREIGN KEY (`purchaseid`) REFERENCES `purchase` (`purchaseid`),
  CONSTRAINT `FK_purchasedetail_2` FOREIGN KEY (`itemid`) REFERENCES `itemdetail` (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchasedetail`
--

/*!40000 ALTER TABLE `purchasedetail` DISABLE KEYS */;
INSERT INTO `purchasedetail` (`purchaseid`,`purchaseprice`,`purchasequantity`,`itemid`) VALUES 
 ('P-00000001',50000,5,'IT_0000001'),
 ('P-00000004',100,10,'IT_0000001'),
 ('P-00000005',1000,10,'IT_0000001'),
 ('P-00000006',100,10,'IT_0000001'),
 ('P-00000007',3000,3,'IT_0000001'),
 ('P-00000007',5000,5,'IT_0000002'),
 ('P-00000008',10000,100,'IT_0000002');
/*!40000 ALTER TABLE `purchasedetail` ENABLE KEYS */;


--
-- Definition of table `sale`
--

DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `Saleid` varchar(10) NOT NULL,
  `customerid` varchar(10) NOT NULL,
  `saledate` date NOT NULL,
  PRIMARY KEY  (`Saleid`),
  KEY `FK_Sale_1` (`customerid`),
  CONSTRAINT `FK_Sale_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` (`Saleid`,`customerid`,`saledate`) VALUES 
 ('S-00000001','CU_0000001','2012-02-09'),
 ('S-00000002','CU_0000004','2023-03-28'),
 ('S-00000003','CU_0000004','2023-03-28'),
 ('S-00000004','CU_0000005','2023-03-28'),
 ('S-00000005','CU_0000005','2023-03-28'),
 ('S-00000006','CU_0000003','2023-03-28'),
 ('S-00000007','CU_0000002','2023-03-28'),
 ('S-00000008','CU_0000004','2023-03-29'),
 ('S-00000009','CU_0000005','2023-03-29'),
 ('S-00000010','CU_0000004','2023-03-29'),
 ('S-00000011','CU_0000002','2023-04-30'),
 ('S-00000012','CU_0000001','2023-05-05'),
 ('S-00000013','CU_0000001','2023-07-23');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;


--
-- Definition of table `saledetail`
--

DROP TABLE IF EXISTS `saledetail`;
CREATE TABLE `saledetail` (
  `saleid` varchar(10) NOT NULL,
  `saleprice` bigint(20) unsigned NOT NULL,
  `salequantity` int(10) unsigned NOT NULL,
  `itemid` varchar(10) NOT NULL,
  KEY `FK_saledetail_1` (`saleid`),
  KEY `FK_saledetail_2` (`itemid`),
  CONSTRAINT `FK_saledetail_1` FOREIGN KEY (`saleid`) REFERENCES `sale` (`Saleid`),
  CONSTRAINT `FK_saledetail_2` FOREIGN KEY (`itemid`) REFERENCES `itemdetail` (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saledetail`
--

/*!40000 ALTER TABLE `saledetail` DISABLE KEYS */;
INSERT INTO `saledetail` (`saleid`,`saleprice`,`salequantity`,`itemid`) VALUES 
 ('S-00000001',55000,1,'IT_0000001'),
 ('S-00000002',3300,20,'IT_0000001'),
 ('S-00000003',5500,1,'IT_0000002'),
 ('S-00000004',3300,20,'IT_0000001'),
 ('S-00000005',5500,1,'IT_0000002'),
 ('S-00000006',5500,1,'IT_0000002'),
 ('S-00000007',3300,1,'IT_0000001'),
 ('S-00000008',3300,3,'IT_0000001'),
 ('S-00000008',3300,2,'IT_0000001'),
 ('S-00000009',3300,2,'IT_0000001'),
 ('S-00000010',3300,3,'IT_0000001'),
 ('S-00000011',3300,1,'IT_0000001'),
 ('S-00000012',3300,12,'IT_0000001'),
 ('S-00000013',3300,1,'IT_0000001');
/*!40000 ALTER TABLE `saledetail` ENABLE KEYS */;


--
-- Definition of table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplierid` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phoneno` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY  (`supplierid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`supplierid`,`name`,`address`,`phoneno`,`email`) VALUES 
 ('SU-0000008',' Sga  gada','Yangon Township','09876655443','sga@gmail.com'),
 ('SU_0000001','Htet Htet Win','Yangon','0124578','hhw@gmail.com'),
 ('SU_0000002','Hnin Wai Oo','Yangon','014578','hwo@gmail.com'),
 ('SU_0000003','Nan Thinzar','pinya','0245789','tz@gmail.com'),
 ('SU_0000004','Sai Thiha','shan','0214578','th@gamil.com'),
 ('SU_0000005','Khun Tun Phyu','Pinlaung','0145789','tp@gmail.com'),
 ('SU_0000006','U Khun Tun','Shan','0546789','kt@gmail.com'),
 ('SU_0000007','Thiri Aung','Kyimyindie','014789','ta@gmail.com');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


--
-- Definition of table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeid` varchar(10) NOT NULL,
  `typename` varchar(20) NOT NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type`
--

/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`typeid`,`typename`) VALUES 
 ('TP-0000001','CDMA450'),
 ('TP-0000002','CDMA 800'),
 ('TP-0000003','GSM'),
 ('TP-0000004','IPHONE'),
 ('TP-0000005','SMART PHONE'),
 ('TP-0000006',' Notebooks');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
