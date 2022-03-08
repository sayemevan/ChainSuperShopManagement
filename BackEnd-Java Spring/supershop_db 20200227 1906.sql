-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema supershop_management
--

CREATE DATABASE IF NOT EXISTS supershop_management;
USE supershop_management;

--
-- Definition of table `allincexp`
--

DROP TABLE IF EXISTS `allincexp`;
CREATE TABLE `allincexp` (
  `incexpid` int(10) unsigned NOT NULL auto_increment,
  `bsaleid` int(10) unsigned NOT NULL,
  `bexpid` int(10) unsigned NOT NULL,
  `incamount` double NOT NULL,
  `expamount` double NOT NULL,
  `odate` date NOT NULL,
  PRIMARY KEY  (`incexpid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allincexp`
--

/*!40000 ALTER TABLE `allincexp` DISABLE KEYS */;
/*!40000 ALTER TABLE `allincexp` ENABLE KEYS */;


--
-- Definition of table `branchexpense`
--

DROP TABLE IF EXISTS `branchexpense`;
CREATE TABLE `branchexpense` (
  `bexpid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `expdesc` varchar(45) NOT NULL,
  `expamount` double NOT NULL,
  PRIMARY KEY  (`bexpid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchexpense`
--

/*!40000 ALTER TABLE `branchexpense` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchexpense` ENABLE KEYS */;


--
-- Definition of table `branchinfo`
--

DROP TABLE IF EXISTS `branchinfo`;
CREATE TABLE `branchinfo` (
  `branchid` int(10) unsigned NOT NULL auto_increment,
  `blocation` varchar(45) NOT NULL,
  `bcontact` varchar(45) NOT NULL,
  `bemail` varchar(45) NOT NULL,
  `bdesc` varchar(45) NOT NULL,
  PRIMARY KEY  (`branchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchinfo`
--

/*!40000 ALTER TABLE `branchinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchinfo` ENABLE KEYS */;


--
-- Definition of table `branchsale`
--

DROP TABLE IF EXISTS `branchsale`;
CREATE TABLE `branchsale` (
  `bsaleid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `saledate` date NOT NULL,
  `totalamount` double NOT NULL,
  `staffid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`bsaleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchsale`
--

/*!40000 ALTER TABLE `branchsale` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchsale` ENABLE KEYS */;


--
-- Definition of table `branchsaledetail`
--

DROP TABLE IF EXISTS `branchsaledetail`;
CREATE TABLE `branchsaledetail` (
  `bsaledetid` int(10) unsigned NOT NULL auto_increment,
  `bsaleid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `saleqty` int(10) unsigned NOT NULL,
  `salerate` double NOT NULL,
  PRIMARY KEY  (`bsaledetid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchsaledetail`
--

/*!40000 ALTER TABLE `branchsaledetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchsaledetail` ENABLE KEYS */;


--
-- Definition of table `branchstock`
--

DROP TABLE IF EXISTS `branchstock`;
CREATE TABLE `branchstock` (
  `bstockid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `bstockqty` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`bstockid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchstock`
--

/*!40000 ALTER TABLE `branchstock` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchstock` ENABLE KEYS */;


--
-- Definition of table `issuedetails`
--

DROP TABLE IF EXISTS `issuedetails`;
CREATE TABLE `issuedetails` (
  `issuedetid` int(10) unsigned NOT NULL auto_increment,
  `issueid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `issueqty` int(10) unsigned NOT NULL,
  `spricerate` double NOT NULL,
  PRIMARY KEY  (`issuedetid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuedetails`
--

/*!40000 ALTER TABLE `issuedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `issuedetails` ENABLE KEYS */;


--
-- Definition of table `issueproduct`
--

DROP TABLE IF EXISTS `issueproduct`;
CREATE TABLE `issueproduct` (
  `issueid` int(10) unsigned NOT NULL auto_increment,
  `issuedate` date NOT NULL,
  `branchid` int(10) unsigned NOT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY  (`issueid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issueproduct`
--

/*!40000 ALTER TABLE `issueproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `issueproduct` ENABLE KEYS */;


--
-- Definition of table `mainstock`
--

DROP TABLE IF EXISTS `mainstock`;
CREATE TABLE `mainstock` (
  `mstockid` int(10) unsigned NOT NULL auto_increment,
  `pid` int(10) unsigned NOT NULL,
  `stockqty` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`mstockid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mainstock`
--

/*!40000 ALTER TABLE `mainstock` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainstock` ENABLE KEYS */;


--
-- Definition of table `pcategory`
--

DROP TABLE IF EXISTS `pcategory`;
CREATE TABLE `pcategory` (
  `catid` int(10) unsigned NOT NULL auto_increment,
  `catname` varchar(45) NOT NULL,
  `catdesc` varchar(45) NOT NULL,
  PRIMARY KEY  (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pcategory`
--

/*!40000 ALTER TABLE `pcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcategory` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `catid` int(10) unsigned NOT NULL,
  `pname` varchar(45) NOT NULL,
  `pdesc` varchar(45) NOT NULL,
  `pimgname` varchar(45) NOT NULL,
  `manufacturer` varchar(45) NOT NULL,
  `supplier` varchar(45) NOT NULL,
  `reorderqty` int(10) unsigned NOT NULL,
  `supplyqty` int(10) unsigned NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purid` int(10) unsigned NOT NULL auto_increment,
  `purdate` date NOT NULL,
  `totalamount` double NOT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY  (`purid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


--
-- Definition of table `purchasedetails`
--

DROP TABLE IF EXISTS `purchasedetails`;
CREATE TABLE `purchasedetails` (
  `purdetid` int(10) unsigned NOT NULL auto_increment,
  `purid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `purqty` int(10) unsigned NOT NULL,
  `purdate` date NOT NULL,
  PRIMARY KEY  (`purdetid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchasedetails`
--

/*!40000 ALTER TABLE `purchasedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchasedetails` ENABLE KEYS */;


--
-- Definition of table `receivedetail`
--

DROP TABLE IF EXISTS `receivedetail`;
CREATE TABLE `receivedetail` (
  `recdetid` int(10) unsigned NOT NULL auto_increment,
  `recid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `recqty` int(10) unsigned NOT NULL,
  `spricerate` double NOT NULL,
  PRIMARY KEY  (`recdetid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receivedetail`
--

/*!40000 ALTER TABLE `receivedetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `receivedetail` ENABLE KEYS */;


--
-- Definition of table `receiveproduct`
--

DROP TABLE IF EXISTS `receiveproduct`;
CREATE TABLE `receiveproduct` (
  `recid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `recdate` date NOT NULL,
  `issueid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`recid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receiveproduct`
--

/*!40000 ALTER TABLE `receiveproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `receiveproduct` ENABLE KEYS */;


--
-- Definition of table `staffdetail`
--

DROP TABLE IF EXISTS `staffdetail`;
CREATE TABLE `staffdetail` (
  `staffid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `semail` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `jdate` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY  (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffdetail`
--

/*!40000 ALTER TABLE `staffdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `staffdetail` ENABLE KEYS */;


--
-- Definition of table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `emailid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `udob` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `emailid` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `rolename` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

--
-- Create schema supershop
--

CREATE DATABASE IF NOT EXISTS supershop;
USE supershop;

--
-- Definition of table `allincexp`
--

DROP TABLE IF EXISTS `allincexp`;
CREATE TABLE `allincexp` (
  `incexpid` int(10) unsigned NOT NULL auto_increment,
  `bsaleid` int(10) unsigned NOT NULL,
  `bexpid` int(10) unsigned NOT NULL,
  `incamount` double NOT NULL,
  `expamount` double NOT NULL,
  `odate` date NOT NULL,
  PRIMARY KEY  (`incexpid`),
  KEY `FK_allincexp_bsaleid` (`bsaleid`),
  KEY `FK_allincexp_bexpid` (`bexpid`),
  CONSTRAINT `FK_allincexp_bsaleid` FOREIGN KEY (`bsaleid`) REFERENCES `branchsale` (`bsaleid`),
  CONSTRAINT `FK_allincexp_bexpid` FOREIGN KEY (`bexpid`) REFERENCES `branchexpense` (`bexpid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allincexp`
--

/*!40000 ALTER TABLE `allincexp` DISABLE KEYS */;
/*!40000 ALTER TABLE `allincexp` ENABLE KEYS */;


--
-- Definition of table `branchexpense`
--

DROP TABLE IF EXISTS `branchexpense`;
CREATE TABLE `branchexpense` (
  `bexpid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `expdesc` varchar(45) NOT NULL,
  `expamount` double NOT NULL,
  PRIMARY KEY  (`bexpid`),
  KEY `FK_branchexpense_branchid` (`branchid`),
  CONSTRAINT `FK_branchexpense_branchid` FOREIGN KEY (`branchid`) REFERENCES `branchinfo` (`branchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchexpense`
--

/*!40000 ALTER TABLE `branchexpense` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchexpense` ENABLE KEYS */;


--
-- Definition of table `branchinfo`
--

DROP TABLE IF EXISTS `branchinfo`;
CREATE TABLE `branchinfo` (
  `branchid` int(10) unsigned NOT NULL auto_increment,
  `blocation` varchar(45) NOT NULL,
  `bcontact` varchar(45) NOT NULL,
  `bemail` varchar(45) NOT NULL,
  `bdesc` varchar(45) NOT NULL,
  PRIMARY KEY  (`branchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchinfo`
--

/*!40000 ALTER TABLE `branchinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchinfo` ENABLE KEYS */;


--
-- Definition of table `branchsale`
--

DROP TABLE IF EXISTS `branchsale`;
CREATE TABLE `branchsale` (
  `bsaleid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `saledate` date NOT NULL,
  `totalamount` double NOT NULL,
  `staffid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`bsaleid`),
  KEY `FK_branchsale_branchid` (`branchid`),
  KEY `FK_branchsale_staffid` (`staffid`),
  CONSTRAINT `FK_branchsale_staffid` FOREIGN KEY (`staffid`) REFERENCES `staffdetail` (`staffid`),
  CONSTRAINT `FK_branchsale_branchid` FOREIGN KEY (`branchid`) REFERENCES `branchinfo` (`branchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchsale`
--

/*!40000 ALTER TABLE `branchsale` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchsale` ENABLE KEYS */;


--
-- Definition of table `branchsaledetail`
--

DROP TABLE IF EXISTS `branchsaledetail`;
CREATE TABLE `branchsaledetail` (
  `bsaledetid` int(10) unsigned NOT NULL auto_increment,
  `bsaleid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `saleqty` int(10) unsigned NOT NULL,
  `salerate` double NOT NULL,
  PRIMARY KEY  (`bsaledetid`),
  KEY `FK_branchsaledetail_bsaleid` (`bsaleid`),
  KEY `FK_branchsaledetail_pid` (`pid`),
  CONSTRAINT `FK_branchsaledetail_bsaleid` FOREIGN KEY (`bsaleid`) REFERENCES `branchsale` (`bsaleid`),
  CONSTRAINT `FK_branchsaledetail_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchsaledetail`
--

/*!40000 ALTER TABLE `branchsaledetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchsaledetail` ENABLE KEYS */;


--
-- Definition of table `branchstock`
--

DROP TABLE IF EXISTS `branchstock`;
CREATE TABLE `branchstock` (
  `bstockid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `bstockqty` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`bstockid`),
  KEY `FK_branchstock_branchid` (`branchid`),
  KEY `FK_branchstock_pid` (`pid`),
  CONSTRAINT `FK_branchstock_branchid` FOREIGN KEY (`branchid`) REFERENCES `branchinfo` (`branchid`),
  CONSTRAINT `FK_branchstock_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchstock`
--

/*!40000 ALTER TABLE `branchstock` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchstock` ENABLE KEYS */;


--
-- Definition of table `issuedetails`
--

DROP TABLE IF EXISTS `issuedetails`;
CREATE TABLE `issuedetails` (
  `issuedetid` int(10) unsigned NOT NULL auto_increment,
  `issueid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `issueqty` int(10) unsigned NOT NULL,
  `spricerate` double NOT NULL,
  PRIMARY KEY  (`issuedetid`),
  KEY `FK_issuedetails_issueid` (`issueid`),
  KEY `FK_issuedetails_pid` (`pid`),
  CONSTRAINT `FK_issuedetails_issueid` FOREIGN KEY (`issueid`) REFERENCES `issueproduct` (`issueid`),
  CONSTRAINT `FK_issuedetails_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuedetails`
--

/*!40000 ALTER TABLE `issuedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `issuedetails` ENABLE KEYS */;


--
-- Definition of table `issueproduct`
--

DROP TABLE IF EXISTS `issueproduct`;
CREATE TABLE `issueproduct` (
  `issueid` int(10) unsigned NOT NULL auto_increment,
  `issuedate` date NOT NULL,
  `branchid` int(10) unsigned NOT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY  (`issueid`),
  KEY `FK_issueproduct_branchid` (`branchid`),
  KEY `FK_issueproduct_emailid` (`emailid`),
  CONSTRAINT `FK_issueproduct_branchid` FOREIGN KEY (`branchid`) REFERENCES `branchinfo` (`branchid`),
  CONSTRAINT `FK_issueproduct_emailid` FOREIGN KEY (`emailid`) REFERENCES `user_info` (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issueproduct`
--

/*!40000 ALTER TABLE `issueproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `issueproduct` ENABLE KEYS */;


--
-- Definition of table `mainstock`
--

DROP TABLE IF EXISTS `mainstock`;
CREATE TABLE `mainstock` (
  `mstockid` int(10) unsigned NOT NULL auto_increment,
  `pid` int(10) unsigned NOT NULL,
  `stockqty` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`mstockid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mainstock`
--

/*!40000 ALTER TABLE `mainstock` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainstock` ENABLE KEYS */;


--
-- Definition of table `pcategory`
--

DROP TABLE IF EXISTS `pcategory`;
CREATE TABLE `pcategory` (
  `catid` int(10) unsigned NOT NULL auto_increment,
  `catname` varchar(45) NOT NULL,
  `catdesc` varchar(45) NOT NULL,
  PRIMARY KEY  (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pcategory`
--

/*!40000 ALTER TABLE `pcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcategory` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `catid` int(10) unsigned NOT NULL,
  `pname` varchar(45) NOT NULL,
  `pdesc` varchar(45) NOT NULL,
  `pimgname` varchar(45) NOT NULL,
  `manufacturer` varchar(45) NOT NULL,
  `supplier` varchar(45) NOT NULL,
  `reorderqty` int(10) unsigned NOT NULL,
  `supplyqty` int(10) unsigned NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY  (`pid`),
  KEY `FK_product_catid` (`catid`),
  CONSTRAINT `FK_product_catid` FOREIGN KEY (`catid`) REFERENCES `pcategory` (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purid` int(10) unsigned NOT NULL auto_increment,
  `purdate` date NOT NULL,
  `totalamount` double NOT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY  (`purid`),
  KEY `FK_purchase_emailid` (`emailid`),
  CONSTRAINT `FK_purchase_emailid` FOREIGN KEY (`emailid`) REFERENCES `user_info` (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


--
-- Definition of table `purchasedetails`
--

DROP TABLE IF EXISTS `purchasedetails`;
CREATE TABLE `purchasedetails` (
  `purdetid` int(10) unsigned NOT NULL auto_increment,
  `purid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `purqty` int(10) unsigned NOT NULL,
  `purdate` date NOT NULL,
  PRIMARY KEY  (`purdetid`),
  KEY `FK_purchasedetails_purid` (`purid`),
  KEY `FK_purchasedetails_pid` (`pid`),
  CONSTRAINT `FK_purchasedetails_purid` FOREIGN KEY (`purid`) REFERENCES `purchase` (`purid`),
  CONSTRAINT `FK_purchasedetails_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchasedetails`
--

/*!40000 ALTER TABLE `purchasedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchasedetails` ENABLE KEYS */;


--
-- Definition of table `receivedetail`
--

DROP TABLE IF EXISTS `receivedetail`;
CREATE TABLE `receivedetail` (
  `recdetid` int(10) unsigned NOT NULL auto_increment,
  `recid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `recqty` int(10) unsigned NOT NULL,
  `spricerate` double NOT NULL,
  PRIMARY KEY  (`recdetid`),
  KEY `FK_receivedetail_recid` (`recid`),
  KEY `FK_receivedetail_pid` (`pid`),
  CONSTRAINT `FK_receivedetail_recid` FOREIGN KEY (`recid`) REFERENCES `receiveproduct` (`recid`),
  CONSTRAINT `FK_receivedetail_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receivedetail`
--

/*!40000 ALTER TABLE `receivedetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `receivedetail` ENABLE KEYS */;


--
-- Definition of table `receiveproduct`
--

DROP TABLE IF EXISTS `receiveproduct`;
CREATE TABLE `receiveproduct` (
  `recid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `recdate` date NOT NULL,
  `issueid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`recid`),
  KEY `FK_receiveproduct_issueid` (`issueid`),
  KEY `FK_receiveproduct_branchid` (`branchid`),
  CONSTRAINT `FK_receiveproduct_branchid` FOREIGN KEY (`branchid`) REFERENCES `branchinfo` (`branchid`),
  CONSTRAINT `FK_receiveproduct_issueid` FOREIGN KEY (`issueid`) REFERENCES `issueproduct` (`issueid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receiveproduct`
--

/*!40000 ALTER TABLE `receiveproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `receiveproduct` ENABLE KEYS */;


--
-- Definition of table `staffdetail`
--

DROP TABLE IF EXISTS `staffdetail`;
CREATE TABLE `staffdetail` (
  `staffid` int(10) unsigned NOT NULL auto_increment,
  `branchid` int(10) unsigned NOT NULL,
  `semail` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `jdate` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY  (`staffid`),
  KEY `FK_staffdetail_branchid` (`branchid`),
  CONSTRAINT `FK_staffdetail_branchid` FOREIGN KEY (`branchid`) REFERENCES `branchinfo` (`branchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffdetail`
--

/*!40000 ALTER TABLE `staffdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `staffdetail` ENABLE KEYS */;


--
-- Definition of table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `emailid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `udob` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `emailid` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `rolename` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
