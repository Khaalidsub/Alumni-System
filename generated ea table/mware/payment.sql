SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `Payment` CASCADE
;

CREATE TABLE `Payment`
(
	`alumniID` String,
	`alumniName` String,
	`eventID` int,
	`eventName` String,
	`fee` float(0),
	`fileName` String,
	`paidDate` String,
	`paidTime` String,
	`paymentID` int NOT NULL,
	CONSTRAINT `PK_Payment` PRIMARY KEY (`paymentID`)
)
;

SET FOREIGN_KEY_CHECKS=1
