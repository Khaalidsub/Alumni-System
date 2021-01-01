SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `Alumni` CASCADE
;

CREATE TABLE `Alumni`
(
	`AlumniAddress` String,
	`AlumniCurrentJob` String,
	`AlumniEmail` String,
	`AlumniGraduateYear` int,
	`AlumniLocation` String,
	`AlumniMembershipNo` String,
	`AlumniName` String,
	`AlumniPhoneNo` String,
	`AlumniPreviousJob` String,
	`AlumniSalaryPrevious` double,
	`AlumniSalaryuCurrent` double,
	`AlumniSatus` String,
	`alumniID` Integer NOT NULL,
	CONSTRAINT `PK_Alumni` PRIMARY KEY (`alumniID`)
)
;

ALTER TABLE `Alumni` 
 ADD CONSTRAINT `FK_Alumni_User`
	FOREIGN KEY (`alumniID`) REFERENCES `User` (`userID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
