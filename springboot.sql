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


-- Dumping database structure for springboot
CREATE DATABASE IF NOT EXISTS `springboot` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `springboot`;

-- Dumping structure for table springboot.component
CREATE TABLE IF NOT EXISTS `component` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.component: 5 rows
/*!40000 ALTER TABLE `component` DISABLE KEYS */;
INSERT INTO `component` (`id`, `name`) VALUES
	(1, 'house'),
	(14, 'Template'),
	(13, 'Computer'),
	(7, 'house'),
	(8, 'flat');
/*!40000 ALTER TABLE `component` ENABLE KEYS */;

-- Dumping structure for table springboot.component_properties
CREATE TABLE IF NOT EXISTS `component_properties` (
  `component_id` int(11) NOT NULL,
  `properties_id` int(11) NOT NULL,
  KEY `FKlpf8vglew3prujw5egebkbetp` (`properties_id`),
  KEY `FKs1pywahb3ewah7f3wvg2flyfg` (`component_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.component_properties: 5 rows
/*!40000 ALTER TABLE `component_properties` DISABLE KEYS */;
INSERT INTO `component_properties` (`component_id`, `properties_id`) VALUES
	(1, 1),
	(13, 6),
	(13, 7),
	(13, 8),
	(13, 10);
/*!40000 ALTER TABLE `component_properties` ENABLE KEYS */;

-- Dumping structure for table springboot.module
CREATE TABLE IF NOT EXISTS `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `component_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsrqenqtkgrpougfx43u87d24k` (`component_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.module: 2 rows
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` (`id`, `name`, `component_id`) VALUES
	(2, 'Computer', 13),
	(3, 'ComputerController', 13);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;

-- Dumping structure for table springboot.module_templates
CREATE TABLE IF NOT EXISTS `module_templates` (
  `module_id` int(11) NOT NULL,
  `templates_id` int(11) NOT NULL,
  UNIQUE KEY `UK_8n8nkeejmgjwvxfwq8cvf4fqj` (`templates_id`),
  KEY `FKjk393phxhmnk69nen42wy2jq6` (`module_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.module_templates: 1 rows
/*!40000 ALTER TABLE `module_templates` DISABLE KEYS */;
INSERT INTO `module_templates` (`module_id`, `templates_id`) VALUES
	(2, 2);
/*!40000 ALTER TABLE `module_templates` ENABLE KEYS */;

-- Dumping structure for table springboot.property
CREATE TABLE IF NOT EXISTS `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.property: 10 rows
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` (`id`, `name`, `type`) VALUES
	(1, 'name', 'String'),
	(12, 'componentTemplate', 'String'),
	(6, 'brand', 'String'),
	(7, 'processor', 'String'),
	(8, 'motherboard', 'String'),
	(11, 'Test', 'int'),
	(10, 'GPU', 'String'),
	(13, 'controllerTemplate', 'String'),
	(14, 'repositoryTemplate', 'String'),
	(15, 'serviceTemplate', 'String');
/*!40000 ALTER TABLE `property` ENABLE KEYS */;

-- Dumping structure for table springboot.template
CREATE TABLE IF NOT EXISTS `template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` longtext,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.template: 1 rows
/*!40000 ALTER TABLE `template` DISABLE KEYS */;
INSERT INTO `template` (`id`, `text`, `name`) VALUES
	(2, 'package iamus.net.components.component;\n\nimport java.util.ArrayList;\nimport java.util.List;\n\nimport iamus.net.components.property.Property;\n\nimport javax.persistence.Entity;\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.GenerationType;\nimport javax.persistence.Id;\nimport javax.persistence.ManyToMany;\n\n\n@Entity\npublic class Component {\n\n	@Id\n	@GeneratedValue(strategy = GenerationType.IDENTITY)\n	private int id;\n	private String name;\n\n	@ManyToMany(targetEntity = Property.class)\n	private List<Property> properties = new ArrayList<>();\n\n	public int getId() {\n		return id;\n	}\n\n	public void setId(int id) {\n		this.id = id;\n	}\n\n	public String getName() {\n		return name;\n	}\n\n	public void setName(String name) {\n		this.name = name;\n	}\n\n	public List<Property> getProperties() {\n		return properties;\n	}\n\n	public void setProperties(List<Property> properties) {\n		this.properties = properties;\n	}\n\n	public Component() {\n\n	}\n\n	public Component(int id, String name, List<Property> properties) {\n		super();\n		this.id = id;\n		this.name = name;\n		this.properties = properties;\n	}\n\n}\n', 'ComponentTemplate');
/*!40000 ALTER TABLE `template` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
