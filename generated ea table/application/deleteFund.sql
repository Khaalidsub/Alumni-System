SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `DeleteFunding` CASCADE
;

CREATE TABLE `DeleteFunding`
(
	`deleteFundingID` Integer NOT NULL,
	`manageFundingID` Integer,
	CONSTRAINT `PK_DeleteFunding` PRIMARY KEY (`deleteFundingID`)
)
;

ALTER TABLE `DeleteFunding` 
 ADD CONSTRAINT `FK_DeleteFunding_ManageFunding`
	FOREIGN KEY (`manageFundingID`) REFERENCES `ManageFunding` (`manageFundingID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
