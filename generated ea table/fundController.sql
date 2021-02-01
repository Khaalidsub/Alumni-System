SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `FundingController` CASCADE
;

CREATE TABLE `FundingController`
(
	`fundingControllerID` Integer NOT NULL,
	CONSTRAINT `PK_FundingController` PRIMARY KEY (`fundingControllerID`)
)
;

SET FOREIGN_KEY_CHECKS=1
