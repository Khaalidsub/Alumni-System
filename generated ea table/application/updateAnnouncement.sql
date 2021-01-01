SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `updateAnnouncement` CASCADE
;

CREATE TABLE `updateAnnouncement`
(
	`updateAnnouncementID` Integer NOT NULL,
	CONSTRAINT `PK_updateAnnouncement` PRIMARY KEY (`updateAnnouncementID`)
)
;

SET FOREIGN_KEY_CHECKS=1
