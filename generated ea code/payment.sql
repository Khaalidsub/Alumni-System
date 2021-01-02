IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[FK_Payment_ManagePaymentInterface]') AND OBJECTPROPERTY(id, 'IsForeignKey') = 1) 
ALTER TABLE [Payment] DROP CONSTRAINT [FK_Payment_ManagePaymentInterface]
;

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[Payment]') AND OBJECTPROPERTY(id, 'IsUserTable') = 1) 
DROP TABLE [Payment]
;

CREATE TABLE [Payment]
(
	[alumniID] String,
	[alumniName] String,
	[eventID] String,
	[eventName] String,
	[fee] String,
	[fileName] String,
	[paidDate] String,
	[paidTime] String,
	[paymentID] int NOT NULL,
	[managePaymentInterfaceID] Integer
)
;

ALTER TABLE [Payment] 
 ADD CONSTRAINT [PK_Payment]
	PRIMARY KEY CLUSTERED ([paymentID])
;

ALTER TABLE [Payment] ADD CONSTRAINT [FK_Payment_ManagePaymentInterface]
	FOREIGN KEY ([managePaymentInterfaceID]) REFERENCES [ManagePaymentInterface] ([managePaymentInterfaceID]) ON DELETE No Action ON UPDATE No Action
;
