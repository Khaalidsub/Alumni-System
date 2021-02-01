SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `PaymentsInterface` CASCADE
;

CREATE TABLE `PaymentsInterface`
(
	`paymentsInterfaceID` Integer NOT NULL,
	CONSTRAINT `PK_PaymentsInterface` PRIMARY KEY (`paymentsInterfaceID`)
)
;

SET FOREIGN_KEY_CHECKS=1
