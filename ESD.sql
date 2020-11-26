DROP DATABASE IF EXISTS ESD;
CREATE DATABASE ESD;
USE ESD;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
    `studentID` int(10)     NOT NULL    AUTO_INCREMENT,
    `name`      VARCHAR(20) NOT NULL,
    `password`  VARCHAR(20) NOT NULL,
    CONSTRAINT `student_pk` PRIMARY KEY (`studentID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
    `staffID`   int(10)     NOT NULL    AUTO_INCREMENT,
    `name`      VARCHAR(20) NOT NULL,
    `password`  VARCHAR(20) NOT NULL,
    CONSTRAINT `staff_pk` PRIMARY KEY(`staffID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
    `equipmentID`   int(10)     NOT NULL    AUTO_INCREMENT,
    `name`          VARCHAR(20) NOT NULL,
    `class`         VARCHAR(20) NOT NULL,
    `qty`           int(3)      NOT NULL,
    `status`        VARCHAR(10) NOT NULL,
    CONSTRAINT `equipment_pk` PRIMARY KEY(`equipmentID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
    `borrowID`      int(10)     NOT NULL    AUTO_INCREMENT,
    `equipmentID`   int(10)     NOT NULL,
    `studentID`     int(10)     NOT NULL,
    `status`        VARCHAR(10) NOT NULL,
    `borrowTime`    DATETIME    DEFAULT     CURRENT_TIMESTAMP,
    `borrowQTY`     int(3)      NOT NULL,
    `staffID`       int(10)     NULL,
    CONSTRAINT `borrow_pk` PRIMARY KEY(`borrowID`),
    CONSTRAINT `equipment_fk` FOREIGN KEY (`equipmentID`)
		REFERENCES `equipment`(`equipmentID`),
    CONSTRAINT `student_fk` FOREIGN KEY (`studentID`)
		REFERENCES `student`(`studentID`),
    CONSTRAINT `staff_fk` FOREIGN KEY (`staffID`)
		REFERENCES `staff`(`staffID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*CREATE STUDENT*/
INSERT INTO `student` VALUES(1000000, "Cheung Yui", "12345678");
SET @studentID = last_insert_id();

/*CREATE STAFF*/
INSERT INTO `staff` VALUES(2000000, "Sky Wong", "87654321");
SET @staffID = last_insert_id();

/*CREATE EQUIPMENT*/
INSERT INTO `equipment` VALUES(3000000, "BasketBall", "Ball", 100, "A");
SET @staffID = last_insert_id();