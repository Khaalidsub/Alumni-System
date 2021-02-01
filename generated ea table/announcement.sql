IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[FK_Announcement_ManageAnnouncement]') AND OBJECTPROPERTY(id, 'IsForeignKey') = 1) 
ALTER TABLE [Announcement] DROP CONSTRAINT [FK_Announcement_ManageAnnouncement]
;

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[Announcement]') AND OBJECTPROPERTY(id, 'IsUserTable') = 1) 
DROP TABLE [Announcement]
;

CREATE TABLE [Announcement]
(
	[announcementID] String NOT NULL,
	[announcementName] String,
	[author] String,
	[date] String,
	[description] String,
	[manageAnnouncementID] Integer
)
;

ALTER TABLE [Announcement] 
 ADD CONSTRAINT [PK_Announcement]
	PRIMARY KEY CLUSTERED ([announcementID])
;

ALTER TABLE [Announcement] ADD CONSTRAINT [FK_Announcement_ManageAnnouncement]
	FOREIGN KEY ([manageAnnouncementID]) REFERENCES [ManageAnnouncement] ([manageAnnouncementID]) ON DELETE No Action ON UPDATE No Action
;
