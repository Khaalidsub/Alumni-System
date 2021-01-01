SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `PaymentController` CASCADE
;

CREATE TABLE `PaymentController`
(
	`paymentControllerID` Integer NOT NULL,
	CONSTRAINT `PK_PaymentController` PRIMARY KEY (`paymentControllerID`)
)
;

SET FOREIGN_KEY_CHECKS=1
