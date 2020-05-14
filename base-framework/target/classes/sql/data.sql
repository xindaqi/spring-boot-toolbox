CREATE DATABASE `data_repository` DEFAULT CHARACTER SET utf8;
USE `data_repository`;

DROP TABLE IF EXISTS `questions_repository`;
CREATE TABLE `questions_repository`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `questions` VARCHAR(255) UNIQUE DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `answers_repository`;
CREATE TABLE `answers_repository`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `answers` VARCHAR(255) DEFAULT NULL,
    `questions_fk` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`questions_fk`) REFERENCES `questions_repository` (`questions`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




