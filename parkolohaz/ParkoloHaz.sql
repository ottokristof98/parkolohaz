-- --------------------------------------------------------
-- Host:                         localhost
-- Szerver verzió:               5.7.33 - MySQL Community Server (GPL)
-- Szerver OS:                   Win64
-- HeidiSQL Verzió:              10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Adatbázis struktúra mentése a parkolohaz.
CREATE DATABASE IF NOT EXISTS `parkolohaz` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `parkolohaz`;

-- Struktúra mentése tábla parkolohaz. felhasznalo
CREATE TABLE IF NOT EXISTS `felhasznalo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nev` varchar(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `jelszo` varchar(100) NOT NULL DEFAULT '0',
  `lakcim` varchar(250) DEFAULT NULL,
  `szuletes` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Tábla adatainak mentése parkolohaz.felhasznalo: ~0 rows (hozzávetőleg)
/*!40000 ALTER TABLE `felhasznalo` DISABLE KEYS */;
INSERT INTO `felhasznalo` (`id`, `nev`, `email`, `jelszo`, `lakcim`, `szuletes`) VALUES
	(1, 'Lajos Gusztáv', 'lajos.guszi@miertne.hu', 'almasretes12', '1231 Tápióbütyke Kakas utca 5', '1920-11-30');
/*!40000 ALTER TABLE `felhasznalo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
