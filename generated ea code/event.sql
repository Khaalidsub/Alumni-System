IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[FK_Event_ManageEvent]') AND OBJECTPROPERTY(id, 'IsForeignKey') = 1) 
ALTER TABLE [Event] DROP CONSTRAINT [FK_Event_ManageEvent]
;

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[Event]') AND OBJECTPROPERTY(id, 'IsUserTable') = 1) 
DROP TABLE [Event]
;

CREATE TABLE [Event]
(
	[date] String,
	[eventID] String NOT NULL,
	[eventName] String,
	[fee] String,
	[organizer] String,
	[time] String,
	[venue] String,
	[manageEventID] Integer
)
;

ALTER TABLE [Event] 
 ADD CONSTRAINT [PK_Event]
	PRIMARY KEY CLUSTERED ([eventID])
;

ALTER TABLE [Event] ADD CONSTRAINT [FK_Event_ManageEvent]
	FOREIGN KEY ([manageEventID]) REFERENCES [ManageEvent] ([manageEventID]) ON DELETE No Action ON UPDATE No Action
;
