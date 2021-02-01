IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[FK_Funding_ManageFunding]') AND OBJECTPROPERTY(id, 'IsForeignKey') = 1) 
ALTER TABLE [Funding] DROP CONSTRAINT [FK_Funding_ManageFunding]
;

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[Funding]') AND OBJECTPROPERTY(id, 'IsUserTable') = 1) 
DROP TABLE [Funding]
;

CREATE TABLE [Funding]
(
	[alumniID] String,
	[alumniName] String,
	[eventID] int,
	[eventName] String,
	[fundingDesc] String,
	[fundingID] int NOT NULL,
	[manageFundingID] Integer
)
;

ALTER TABLE [Funding] 
 ADD CONSTRAINT [PK_Funding]
	PRIMARY KEY CLUSTERED ([fundingID])
;

ALTER TABLE [Funding] ADD CONSTRAINT [FK_Funding_ManageFunding]
	FOREIGN KEY ([manageFundingID]) REFERENCES [ManageFunding] ([manageFundingID]) ON DELETE No Action ON UPDATE No Action
;
