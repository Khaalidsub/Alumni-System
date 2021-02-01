SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `CreateFunding` CASCADE
;

CREATE TABLE `CreateFunding`
(
	`createFundingID` Integer NOT NULL,
	CONSTRAINT `PK_CreateFunding` PRIMARY KEY (`createFundingID`)
)
;

SET FOREIGN_KEY_CHECKS=1
