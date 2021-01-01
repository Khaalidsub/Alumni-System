SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `Admin` CASCADE
;

CREATE TABLE `Admin`
(
	`AdminEmail` String,
	`AdminID` String,
	`AdminName` String,
	`adminID` Integer NOT NULL,
	CONSTRAINT `PK_Admin` PRIMARY KEY (`adminID`)
)
;

ALTER TABLE `Admin` 
 ADD CONSTRAINT `FK_Admin_User`
	FOREIGN KEY (`adminID`) REFERENCES `User` (`userID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
