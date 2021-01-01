SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `createAnnouncement` CASCADE
;

CREATE TABLE `createAnnouncement`
(
	`createAnnouncementID` Integer NOT NULL,
	`manageAnnouncementID` Integer,
	CONSTRAINT `PK_createAnnouncement` PRIMARY KEY (`createAnnouncementID`)
)
;

ALTER TABLE `createAnnouncement` 
 ADD CONSTRAINT `FK_createAnnouncement_ManageAnnouncement`
	FOREIGN KEY (`manageAnnouncementID`) REFERENCES `ManageAnnouncement` (`manageAnnouncementID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
