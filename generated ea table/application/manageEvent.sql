SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ManageEvent` CASCADE
;

CREATE TABLE `ManageEvent`
(
	`manageEventID` Integer NOT NULL,
	`createEventID` Integer,
	`deleteEventID` Integer,
	`updateEventID` Integer,
	CONSTRAINT `PK_ManageEvent` PRIMARY KEY (`manageEventID`)
)
;

ALTER TABLE `ManageEvent` 
 ADD CONSTRAINT `FK_ManageEvent_CreateEvent`
	FOREIGN KEY (`createEventID`) REFERENCES `CreateEvent` (`createEventID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `ManageEvent` 
 ADD CONSTRAINT `FK_ManageEvent_DeleteEvent`
	FOREIGN KEY (`deleteEventID`) REFERENCES `DeleteEvent` (`deleteEventID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `ManageEvent` 
 ADD CONSTRAINT `FK_ManageEvent_UpdateEvent`
	FOREIGN KEY (`updateEventID`) REFERENCES `UpdateEvent` (`updateEventID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1
