-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.7.19 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table springboot.device: ~3 rows (approximately)
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` (`id`, `name`, `power_usage`, `category`, `environment`) VALUES
	(1, NULL, NULL, NULL, NULL),
	(10, 'Alarm', '100W', 'Alarm', NULL);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;

-- Dumping data for table springboot.house: 4 rows
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` (`id`, `city`, `flats`, `floors`, `heating_type`, `house_number`, `insulation_type`, `property_type`, `square_meters`, `street`, `years_of_build`, `device_id`) VALUES
	(27, 'Siauliai', '', '', '', '32', 'sssss', '', '35', 'pilies', '1999', '1'),
	(44, 'Plunge', 'g', '5', 'Central heating', '45', 'asdasd', 'Residential', 'asdasd', 'Vytauto g.', '1975', '1'),
	(43, 'Kaunas', '2', '5', 'Central heating', '45', 'Concrete block insulation', 'Residential', '27', 'Pilies', '1975', '1'),
	(45, 'Kaunas', '', '', '', '', '', '', '', '', '', '1');
/*!40000 ALTER TABLE `house` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
