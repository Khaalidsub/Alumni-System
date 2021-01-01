SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ApprovePayementInterface` CASCADE
;

CREATE TABLE `ApprovePayementInterface`
(
	`approvePayementInterfaceID` Integer NOT NULL,
	CONSTRAINT `PK_ApprovePayementInterface` PRIMARY KEY (`approvePayementInterfaceID`)
)
;

SET FOREIGN_KEY_CHECKS=1
