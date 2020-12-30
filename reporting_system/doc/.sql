IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[FK_LogActivity_Alumni]') AND OBJECTPROPERTY(id, 'IsForeignKey') = 1) 
ALTER TABLE [LogActivity] DROP CONSTRAINT [FK_LogActivity_Alumni]
;

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[FK_LogActivity_LogActivityController]') AND OBJECTPROPERTY(id, 'IsForeignKey') = 1) 
ALTER TABLE [LogActivity] DROP CONSTRAINT [FK_LogActivity_LogActivityController]
;

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[FK_LogActivity_EditLog ActivityUI]') AND OBJECTPROPERTY(id, 'IsForeignKey') = 1) 
ALTER TABLE [LogActivity] DROP CONSTRAINT [FK_LogActivity_EditLog ActivityUI]
;

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[LogActivity]') AND OBJECTPROPERTY(id, 'IsUserTable') = 1) 
DROP TABLE [LogActivity]
;

CREATE TABLE [LogActivity]
(
	[activitiyType] String,
	[activityDate] String,
	[activityName] String,
	[logActivityID] Integer NOT NULL,
	[alumniID] Integer,
	[logActivityControllerID] Integer,
	[editLog ActivityUIID] Integer
)
;

ALTER TABLE [LogActivity] 
 ADD CONSTRAINT [PK_LogActivity]
	PRIMARY KEY CLUSTERED ([logActivityID])
;

ALTER TABLE [LogActivity] ADD CONSTRAINT [FK_LogActivity_Alumni]
	FOREIGN KEY ([alumniID]) REFERENCES [Alumni] ([alumniID]) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE [LogActivity] ADD CONSTRAINT [FK_LogActivity_LogActivityController]
	FOREIGN KEY ([logActivityControllerID]) REFERENCES [LogActivityController] ([logActivityControllerID]) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE [LogActivity] ADD CONSTRAINT [FK_LogActivity_EditLog ActivityUI]
	FOREIGN KEY ([editLog ActivityUIID]) REFERENCES [EditLog ActivityUI] ([editLog ActivityUIID]) ON DELETE No Action ON UPDATE No Action
;
