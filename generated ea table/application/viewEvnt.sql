SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ViewEvent` CASCADE
;

CREATE TABLE `ViewEvent`
(
	`viewEventID` Integer NOT NULL,
	CONSTRAINT `PK_ViewEvent` PRIMARY KEY (`viewEventID`)
)
;

SET FOREIGN_KEY_CHECKS=1
