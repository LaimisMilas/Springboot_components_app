"# Springboot_components_app" 

sudo mysql springboot < springboot.sql

CREATE USER 'ais'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON *.* TO 'ais'@'localhost'WITH GRANT OPTION;
