-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.29 - MySQL Community Server - GPL
-- SO del servidor:              Linux
-- HeidiSQL Versión:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para metrobusMX
DROP DATABASE IF EXISTS `metrobusMX`;
CREATE DATABASE IF NOT EXISTS `metrobusMX` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `metrobusMX`;

-- Volcando estructura para tabla metrobusMX.c_estatus
DROP TABLE IF EXISTS `c_estatus`;
CREATE TABLE IF NOT EXISTS `c_estatus` (
  `id_estatus` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_estatus`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Volcando datos para la tabla metrobusMX.c_estatus: ~2 rows (aproximadamente)
INSERT INTO `c_estatus` (`id_estatus`, `descripcion`) VALUES
	(1, 'Activo'),
	(2, 'Inactivo');

-- Volcando estructura para tabla metrobusMX.fetchdata_alcaldias
DROP TABLE IF EXISTS `fetchdata_alcaldias`;
CREATE TABLE IF NOT EXISTS `fetchdata_alcaldias` (
  `id_fetch` int NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime DEFAULT NULL,
  `estatus_proceso` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_fetch`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Volcando datos para la tabla metrobusMX.fetchdata_alcaldias: ~2 rows (aproximadamente)

-- Volcando estructura para tabla metrobusMX.fetchdata_unidades_mb
DROP TABLE IF EXISTS `fetchdata_unidades_mb`;
CREATE TABLE IF NOT EXISTS `fetchdata_unidades_mb` (
  `id_fetch` int NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime DEFAULT NULL,
  `estatus_proceso` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_fetch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Volcando datos para la tabla metrobusMX.fetchdata_unidades_mb: ~0 rows (aproximadamente)

-- Volcando estructura para tabla metrobusMX.hibernate_sequence
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Volcando datos para la tabla metrobusMX.hibernate_sequence: ~0 rows (aproximadamente)
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(0);

-- Volcando estructura para tabla metrobusMX.t_registro_alcaldia
DROP TABLE IF EXISTS `t_registro_alcaldia`;
CREATE TABLE IF NOT EXISTS `t_registro_alcaldia` (
  `id_alcaldia` int NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `nomgeo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cve_mun` int DEFAULT NULL,
  `cve_ent` int DEFAULT NULL,
  `cvegeo` int DEFAULT NULL,
  `geo_point_2d` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `geo_shape` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `municipio` int DEFAULT NULL,
  `id_fetch_alcaldia` int DEFAULT NULL,
  `estatus` int DEFAULT '1',
  `_id` bigint NOT NULL,
  PRIMARY KEY (`id_alcaldia`) USING BTREE,
  KEY `FK1_estatus` (`estatus`),
  CONSTRAINT `FK1_estatus` FOREIGN KEY (`estatus`) REFERENCES `c_estatus` (`id_estatus`) ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Volcando datos para la tabla metrobusMX.t_registro_alcaldia: ~0 rows (aproximadamente)

-- Volcando estructura para tabla metrobusMX.t_registro_mb
DROP TABLE IF EXISTS `t_registro_mb`;
CREATE TABLE IF NOT EXISTS `t_registro_mb` (
  `id_unidad` int NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `vehicle_label` int DEFAULT NULL,
  `vehicle_current_status` int DEFAULT NULL,
  `position_latitude` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `position_longitude` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `geographic_point` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `position_speed` int DEFAULT NULL,
  `position_odometer` int DEFAULT NULL,
  `trip_schedule_relationship` int DEFAULT NULL,
  `trip_id` int DEFAULT NULL,
  `trip_start_date` int DEFAULT NULL,
  `trip_route_id` int DEFAULT NULL,
  `id_fetch_mb` int DEFAULT NULL,
  `estatus` int DEFAULT '1',
  `_id` bigint NOT NULL,
  PRIMARY KEY (`id_unidad`) USING BTREE,
  KEY `estatus` (`estatus`),
  CONSTRAINT `FK1estatus` FOREIGN KEY (`estatus`) REFERENCES `c_estatus` (`id_estatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Volcando datos para la tabla metrobusMX.t_registro_mb: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;


-- Creando usuarios
DROP USER IF EXISTS 'usersavedata'@'%';
CREATE USER 'usersavedata'@'%' IDENTIFIED BY '123456789A';
GRANT USAGE ON *.* TO 'usersavedata'@'%';
GRANT ALL PRIVILEGES ON `metrobusMX`.* TO 'usersavedata'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

DROP USER IF EXISTS 'userconsulta'@'%';
CREATE USER 'userconsulta'@'%' IDENTIFIED BY '123456789A';
GRANT USAGE ON *.* TO 'userconsulta'@'%';
GRANT SELECT ON `metrobusMX`.* TO 'userconsulta'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
