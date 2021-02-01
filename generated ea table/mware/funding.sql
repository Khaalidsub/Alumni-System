SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `Funding` CASCADE
;

CREATE TABLE `Funding`
(
	`alumniID` String,
	`alumniName` String,
	`eventID` int,
	`eventName` String,
	`fundingDesc` String,
	`fundingID` int NOT NULL,
	CONSTRAINT `PK_Funding` PRIMARY KEY (`fundingID`)
)
;

SET FOREIGN_KEY_CHECKS=1
