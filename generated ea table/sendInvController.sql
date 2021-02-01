SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `SendInvitationController` CASCADE
;

CREATE TABLE `SendInvitationController`
(
	`sendInvitationControllerID` Integer NOT NULL,
	CONSTRAINT `PK_SendInvitationController` PRIMARY KEY (`sendInvitationControllerID`)
)
;

SET FOREIGN_KEY_CHECKS=1
