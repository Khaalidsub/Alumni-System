SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ViewAnnouncement` CASCADE
;

CREATE TABLE `ViewAnnouncement`
(
	`announcementID` string,
	`announcementName` string,
	`description` string,
	`viewAnnouncementID` Integer NOT NULL,
	CONSTRAINT `PK_ViewAnnouncement` PRIMARY KEY (`viewAnnouncementID`)
)
;

SET FOREIGN_KEY_CHECKS=1
