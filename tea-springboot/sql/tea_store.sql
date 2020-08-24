-- MySQL dump 10.13  Distrib 8.0.11, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: tea_store_demo
-- ------------------------------------------------------
-- Server version	8.0.11

 SET NAMES utf8mb4 ;

--
-- Table structure for table `buyer_address`
--

DROP TABLE IF EXISTS `buyer_address`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `buyer_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `area_code` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址编码',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='收货地址表';

--
-- Dumping data for table `buyer_address`
--

--
-- Table structure for table `order_master`
--

DROP TABLE IF EXISTS `order_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_master` (
  `order_id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `buyer_name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `tea_id` int(11) DEFAULT NULL COMMENT '商品编号',
  `tea_name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名称',
  `tea_quantity` int(11) DEFAULT NULL COMMENT '商品数量',
  `tea_icon` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品小图',
  `specs_id` int(11) DEFAULT NULL COMMENT '规格编号',
  `specs_name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规格名称',
  `specs_price` decimal(8,2) DEFAULT NULL COMMENT '规格单价',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';

--
-- Dumping data for table `order_master`
--

--
-- Table structure for table `tea_category`
--

DROP TABLE IF EXISTS `tea_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tea_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='类目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea_category`
--

LOCK TABLES `tea_category` WRITE;
/*!40000 ALTER TABLE `tea_category` DISABLE KEYS */;
INSERT INTO `tea_category` VALUES (1,'绿茶',1,'2020-04-01 10:39:43','2020-04-01 12:35:54'),(2,'红茶',2,'2020-04-01 10:39:43','2020-04-01 12:35:54'),(3,'花茶',3,'2020-04-01 10:39:43','2020-04-01 12:35:54');
/*!40000 ALTER TABLE `tea_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tea_info`
--

DROP TABLE IF EXISTS `tea_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tea_info` (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `tea_price` decimal(8,2) NOT NULL COMMENT '商品单价',
  `tea_description` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `tea_stock` int(11) NOT NULL COMMENT '库存',
  `tea_icon` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tea_tag` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea_info`
--

LOCK TABLES `tea_info` WRITE;
/*!40000 ALTER TABLE `tea_info` DISABLE KEYS */;
INSERT INTO `tea_info` VALUES (1,'绿茶1',100.00,'绿茶',2,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'2020-04-01 10:03:08','2020-04-10 09:20:41','好喝&苦'),(2,'红茶1',200.00,'红茶',100,'../static/8f0bd0d0-a11e-4185-927e-04b54ff4a1bd.jpg',2,'2020-04-01 10:03:08','2020-04-01 14:30:42','红&好喝'),(3,'花茶1',300.00,'花茶',100,'../static/fd7fee3c-a35c-477b-b007-9fda6e9c589a.jpg',3,'2020-04-01 10:14:54','2020-04-01 14:30:42','香'),(4,'绿茶2',100.00,'绿茶',2,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'2020-04-01 10:03:08','2020-04-10 09:20:41','好喝&苦'),(5,'红茶2',200.00,'红茶',100,'../static/8f0bd0d0-a11e-4185-927e-04b54ff4a1bd.jpg',2,'2020-04-01 10:03:08','2020-04-01 14:30:42','红&好喝'),(6,'花茶2',300.00,'花茶',100,'../static/fd7fee3c-a35c-477b-b007-9fda6e9c589a.jpg',3,'2020-04-01 10:14:54','2020-04-01 14:30:42','香'),(7,'绿茶3',100.00,'绿茶',2,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'2020-04-01 10:03:08','2020-04-10 09:20:41','好喝&苦'),(8,'红茶3',200.00,'红茶',100,'../static/8f0bd0d0-a11e-4185-927e-04b54ff4a1bd.jpg',2,'2020-04-01 10:03:08','2020-04-01 14:30:42','红&好喝'),(9,'花茶3',300.00,'花茶',100,'../static/fd7fee3c-a35c-477b-b007-9fda6e9c589a.jpg',3,'2020-04-01 10:14:54','2020-04-01 14:30:42','香');
/*!40000 ALTER TABLE `tea_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_specs`
--

DROP TABLE IF EXISTS `tea_specs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tea_specs` (
  `specs_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `specs_name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `specs_stock` int(11) NOT NULL COMMENT '库存',
  `specs_price` decimal(8,2) NOT NULL COMMENT '单价',
  `specs_icon` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
  `specs_preview` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '预览图',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`specs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品规格表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea_specs`
--

LOCK TABLES `tea_specs` WRITE;
/*!40000 ALTER TABLE `tea_specs` DISABLE KEYS */;
INSERT INTO `tea_specs` VALUES (1,'1','1斤装',0,100.00,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','2020-04-10 09:20:36','2020-04-01 14:16:36'),(2,'1','2斤装',2,200.00,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','2020-04-07 10:06:22','2020-04-01 14:16:36');
/*!40000 ALTER TABLE `tea_specs` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2020-04-10 18:17:07
