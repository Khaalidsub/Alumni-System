SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `UpdateFunding` CASCADE
;

CREATE TABLE `UpdateFunding`
(
	`updateFundingID` Integer NOT NULL,
	`manageFundingID` Integer,
	CONSTRAINT `PK_UpdateFunding` PRIMARY KEY (`updateFundingID`)
)
;

ALTER TABLE `UpdateFunding` 
 ADD CONSTRAINT `FK_UpdateFunding_ManageFunding`
	FOREIGN KEY (`manageFundingID`) REFERENCES `ManageFunding` (`manageFundingID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
