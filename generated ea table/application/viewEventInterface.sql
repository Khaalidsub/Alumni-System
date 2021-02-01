SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ViewEventInterface` CASCADE
;

CREATE TABLE `ViewEventInterface`
(
	`viewEventInterfaceID` Integer NOT NULL,
	CONSTRAINT `PK_ViewEventInterface` PRIMARY KEY (`viewEventInterfaceID`)
)
;

SET FOREIGN_KEY_CHECKS=1
