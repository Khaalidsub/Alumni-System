SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `AnnouncementController` CASCADE
;

CREATE TABLE `AnnouncementController`
(
	`announcementControllerID` Integer NOT NULL,
	CONSTRAINT `PK_AnnouncementController` PRIMARY KEY (`announcementControllerID`)
)
;

SET FOREIGN_KEY_CHECKS=1
