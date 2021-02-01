SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ManageAnnouncement` CASCADE
;

CREATE TABLE `ManageAnnouncement`
(
	`manageAnnouncementID` Integer NOT NULL,
	`updateAnnouncementID` Integer,
	CONSTRAINT `PK_ManageAnnouncement` PRIMARY KEY (`manageAnnouncementID`)
)
;

ALTER TABLE `ManageAnnouncement` 
 ADD CONSTRAINT `FK_ManageAnnouncement_updateAnnouncement`
	FOREIGN KEY (`updateAnnouncementID`) REFERENCES `updateAnnouncement` (`updateAnnouncementID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
