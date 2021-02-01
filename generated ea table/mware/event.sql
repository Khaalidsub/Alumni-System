SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `Event` CASCADE
;

CREATE TABLE `Event`
(
	`date` string,
	`eventID` string NOT NULL,
	`eventName` string,
	`fee` float(0),
	`organizer` string,
	`time` string,
	`venue` string,
	CONSTRAINT `PK_Event` PRIMARY KEY (`eventID`)
)
;

SET FOREIGN_KEY_CHECKS=1
