SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `CreateEvent` CASCADE
;

CREATE TABLE `CreateEvent`
(
	`createEventID` Integer NOT NULL,
	CONSTRAINT `PK_CreateEvent` PRIMARY KEY (`createEventID`)
)
;

SET FOREIGN_KEY_CHECKS=1
