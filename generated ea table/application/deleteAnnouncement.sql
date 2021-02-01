SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `deleteAnnouncement` CASCADE
;

CREATE TABLE `deleteAnnouncement`
(
	`deleteAnnouncementID` Integer NOT NULL,
	`manageAnnouncementID` Integer,
	CONSTRAINT `PK_deleteAnnouncement` PRIMARY KEY (`deleteAnnouncementID`)
)
;

ALTER TABLE `deleteAnnouncement` 
 ADD CONSTRAINT `FK_deleteAnnouncement_ManageAnnouncement`
	FOREIGN KEY (`manageAnnouncementID`) REFERENCES `ManageAnnouncement` (`manageAnnouncementID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
