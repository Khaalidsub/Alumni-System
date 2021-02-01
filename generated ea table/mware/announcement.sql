SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `Announcement` CASCADE
;

CREATE TABLE `Announcement`
(
	`announcementID` string NOT NULL,
	`announcementName` string,
	`author` string,
	`date` string,
	`description` string,
	CONSTRAINT `PK_Announcement` PRIMARY KEY (`announcementID`)
)
;

SET FOREIGN_KEY_CHECKS=1
