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

-- Dumping data for table springboot.component: 2 rows
/*!40000 ALTER TABLE `component` DISABLE KEYS */;
INSERT INTO `component` (`id`, `name`) VALUES
	(1, 'house'),
	(13, 'Computer');
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
	(13, 10),
	(1, 6),
	(1, 8),
	(1, 11),
	(1, 10);
/*!40000 ALTER TABLE `component_properties` ENABLE KEYS */;

-- Dumping structure for table springboot.module
CREATE TABLE IF NOT EXISTS `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `component_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsrqenqtkgrpougfx43u87d24k` (`component_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.module: 4 rows
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` (`id`, `name`, `component_id`) VALUES
	(2, 'HouseModule', 1),
	(16, 'HouseService', 1),
	(15, 'HouseController', 1),
	(17, 'HouseRepository', 1);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;

-- Dumping structure for table springboot.module_templates
CREATE TABLE IF NOT EXISTS `module_templates` (
  `module_id` int(11) NOT NULL,
  `templates_id` int(11) NOT NULL,
  KEY `FKkw4i7iv4xssn2fd2carvlaj1w` (`templates_id`),
  KEY `FKjk393phxhmnk69nen42wy2jq6` (`module_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.module_templates: 5 rows
/*!40000 ALTER TABLE `module_templates` DISABLE KEYS */;
INSERT INTO `module_templates` (`module_id`, `templates_id`) VALUES
	(2, 5),
	(16, 7),
	(15, 6),
	(17, 8),
	(2, 9),
	(2, 7),
	(2, 6);
/*!40000 ALTER TABLE `module_templates` ENABLE KEYS */;

-- Dumping structure for table springboot.project
CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.project: 2 rows
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`id`, `name`) VALUES
	(1, 'HouseProject'),
	(2, 'Test 2');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;

-- Dumping structure for table springboot.project_modules
CREATE TABLE IF NOT EXISTS `project_modules` (
  `project_id` int(11) NOT NULL,
  `modules_id` int(11) NOT NULL,
  KEY `FKocfqox59i6wienpi4edogg3e5` (`modules_id`),
  KEY `FKgo9qewo8ghgvhjf5klastib5r` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.project_modules: 4 rows
/*!40000 ALTER TABLE `project_modules` DISABLE KEYS */;
INSERT INTO `project_modules` (`project_id`, `modules_id`) VALUES
	(1, 2);
/*!40000 ALTER TABLE `project_modules` ENABLE KEYS */;

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
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.template: 5 rows
/*!40000 ALTER TABLE `template` DISABLE KEYS */;
INSERT INTO `template` (`id`, `text`, `name`) VALUES
	(9, 'package iamus.net.components.generated.$project.getName();\n\nimport javax.persistence.Entity;\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.GenerationType;\nimport javax.persistence.Id;\n\nimport org.hibernate.annotations.Type;\n\n@Entity\npublic class $Utils.nameToUpperCase($component.getName()) {\n	\n	@Id\n	@GeneratedValue(strategy=GenerationType.IDENTITY)\n	int id;\n#foreach($property in $properties)\n	$property.getType() $property.getName();\n#end\n	\n	public int getId() {\n		return id;\n	}\n\n	public void setId() {\n		this.id = id;\n	}\n\n#foreach($property in $properties)\n	public $property.getType() get$property.getName()() {\n		return $property.getName();\n	}\n\n	public void set$property.getName()() {\n		this.$property.getName() = $property.getName();\n	}\n\n	public $Utils.nameToUpperCase($module.getComponent().getName()) {\n	}\n\n#end\n	public $Utils.nameToUpperCase($module.getComponent().getName()) ( #set( $n = \' \')\n#foreach($property in $properties)$property.getType() $property.getName(),$n#end int id) {\n		this.id = id;\n#foreach($property in $properties)\n		this.$property.getName() = $property.getName();\n#end\n}\n', 'Component'),
	(5, 'package iamus.net.components.generated.$project.getName();\n\nimport java.util.List;\nimport java.util.Optional;\n\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.http.MediaType;\nimport org.springframework.web.bind.annotation.CrossOrigin;\nimport org.springframework.web.bind.annotation.PathVariable;\nimport org.springframework.web.bind.annotation.RequestBody;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RequestMethod;\nimport org.springframework.web.bind.annotation.RestController;\n\n\n	@CrossOrigin\n	@RestController\n	@RequestMapping("/api")\n	public class $upperController {\n	\n	\n\n		@Autowired\n	\n	@RequestMapping("/$lower/{id}")\n		public Optional<$upper> get(@PathVariable int id) {\n			return $upperService.get(id);\n		}\n		\n		@RequestMapping(method=RequestMethod.POST, value="/Templates", consumes = MediaType.APPLICATION_JSON_VALUE)\n		public void addTemplate(@RequestBody Template template) {\n			TemplateService.createTemplate(template);\n		}\n		\n		@RequestMapping(method=RequestMethod.PUT, value="/Templates/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)\n		public void updateTemplate(@RequestBody Template Template, @PathVariable String id) {\n			TemplateService.updateTemplate(Template, id);\n		}\n		\n		@RequestMapping(method=RequestMethod.DELETE, value="/Templates/{id}")\n		public void deleteTemplate(@PathVariable int id) {\n			TemplateService.deleteTemplate(id);\n		}\n	\n}\n', 'ComponentController'),
	(6, 'package iamus.net.components.ProjectName;\n\nimport java.util.List;\nimport java.util.Optional;\n\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.http.MediaType;\nimport org.springframework.web.bind.annotation.CrossOrigin;\nimport org.springframework.web.bind.annotation.PathVariable;\nimport org.springframework.web.bind.annotation.RequestBody;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RequestMethod;\nimport org.springframework.web.bind.annotation.RestController;\n\n\n	@CrossOrigin\n	@RestController\n	@RequestMapping("/api")\n	public class ComponentNameController {', 'ComponentRepository'),
	(7, 'package iamus.net.components.generated.ProjectName;\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.util.Optional;\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Service;\n\n\n\n\n@Service\npublic class ComponentNameService {', 'ComponentService'),
	(8, 'package iamus.net.components.generated.ProjectName;\n\nimport java.util.Optional;\n\nimport org.springframework.data.repository.CrudRepository;\nimport org.springframework.transaction.annotation.Transactional;\n\nimport iamus.net.components.generated.ProjName.UpperCompName;\n\n\n\npublic interface ComponentNameRepository extends CrudRepository <ComponentName, String> {', 'test');
/*!40000 ALTER TABLE `template` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
