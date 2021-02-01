SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ManageFunding` CASCADE
;

CREATE TABLE `ManageFunding`
(
	`manageFundingID` Integer NOT NULL,
	`createFundingID` Integer,
	CONSTRAINT `PK_ManageFunding` PRIMARY KEY (`manageFundingID`)
)
;

ALTER TABLE `ManageFunding` 
 ADD CONSTRAINT `FK_ManageFunding_CreateFunding`
	FOREIGN KEY (`createFundingID`) REFERENCES `CreateFunding` (`createFundingID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
