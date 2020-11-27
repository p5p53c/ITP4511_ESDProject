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

DROP TABLE IF EXISTS `technician`;
CREATE TABLE `technician` (
    `techID`   int(10)     	NOT NULL    AUTO_INCREMENT,
    `name`      VARCHAR(20) NOT NULL,
    `password`  VARCHAR(20) NOT NULL,
    CONSTRAINT `staff_pk` PRIMARY KEY(`techID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `senior`;
CREATE TABLE `senior` (
    `seniorID`   int(10)    NOT NULL    AUTO_INCREMENT,
    `name`      VARCHAR(20) NOT NULL,
    `password`  VARCHAR(20) NOT NULL,
    CONSTRAINT `staff_pk` PRIMARY KEY(`seniorID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
    `equipmentID`   int(10)     NOT NULL    AUTO_INCREMENT,
    `name`          VARCHAR(20) NOT NULL,
    `qty`           int(3)      NOT NULL,
	`availableqty`	int(3)		NOT NULL,
    `status`        VARCHAR(10) NOT NULL,
    CONSTRAINT `equipment_pk` PRIMARY KEY(`equipmentID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
    `borrowID`      	int(10)     NOT NULL    AUTO_INCREMENT,
    `equipmentID`   	int(10)     NOT NULL,
    `studentID`     	int(10)     NOT NULL,
    `status`        	VARCHAR(10) NOT NULL,
    `applicationTime`   DATE    	DEFAULT     CURRENT_TIMESTAMP,
	`borrowTime`		DATE		NULL,
	`returnTime`		DATE		NULL,
	`actualreturnTime`	DATE		NULL,
    `techID`       		int(10)     NULL,
    CONSTRAINT `borrow_pk` PRIMARY KEY(`borrowID`),
    CONSTRAINT `equipment_fk` FOREIGN KEY (`equipmentID`)
		REFERENCES `equipment`(`equipmentID`),
    CONSTRAINT `student_fk` FOREIGN KEY (`studentID`)
		REFERENCES `student`(`studentID`),
    CONSTRAINT `staff_fk` FOREIGN KEY (`techID`)
		REFERENCES `technician`(`techID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*CREATE STUDENT*/
INSERT INTO `student` VALUES(1000000, "Test Student", "12345678");
SET @studentID = last_insert_id();

/*CREATE STAFF*/
INSERT INTO `technician` VALUES(2000000, "Test Technician", "87654321");
SET @staffID = last_insert_id();

/*CREATE SENIOR*/
INSERT INTO `senior` VALUES(3000000, "Test Senior", "1234");
SET @seniorID = last_insert_id();

/*CREATE EQUIPMENT*/
INSERT INTO `equipment` VALUES(3000000, "BasketBall", 100, 100, "A");
SET @equipmentID = last_insert_id();
INSERT INTO `equipment` (`name`, `qty` , `availableqty`, `status`)VALUES ("Football", 100, 100, "A");
INSERT INTO `equipment` (`name`, `qty` , `availableqty`, `status`)VALUES ("Badminton", 100, 100, "N");
INSERT INTO `equipment` (`name`, `qty` , `availableqty`, `status`)VALUES ("Chess", 100, 0, "A");

/*CREATE BORRWO*/
INSERT INTO `borrow` VALUES (4000000, 3000000, 1000000, "A", "2020-11-27", "2020-11-27", "2020-11-27", "2020-11-27", 2000000);


