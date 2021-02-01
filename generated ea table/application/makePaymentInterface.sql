SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `MakePaymentInterface` CASCADE
;

CREATE TABLE `MakePaymentInterface`
(
	`makePaymentInterfaceID` Integer NOT NULL,
	CONSTRAINT `PK_MakePaymentInterface` PRIMARY KEY (`makePaymentInterfaceID`)
)
;

SET FOREIGN_KEY_CHECKS=1
