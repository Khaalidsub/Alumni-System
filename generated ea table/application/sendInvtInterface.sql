SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `SendInvitationInterface` CASCADE
;

CREATE TABLE `SendInvitationInterface`
(
	`sendInvitationInterfaceID` Integer NOT NULL,
	CONSTRAINT `PK_SendInvitationInterface` PRIMARY KEY (`sendInvitationInterfaceID`)
)
;

SET FOREIGN_KEY_CHECKS=1
