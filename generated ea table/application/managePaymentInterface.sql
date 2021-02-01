SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `ManagePaymentInterface` CASCADE
;

CREATE TABLE `ManagePaymentInterface`
(
	`managePaymentInterfaceID` Integer NOT NULL,
	CONSTRAINT `PK_ManagePaymentInterface` PRIMARY KEY (`managePaymentInterfaceID`)
)
;

SET FOREIGN_KEY_CHECKS=1
