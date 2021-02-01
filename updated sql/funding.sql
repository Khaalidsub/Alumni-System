--
-- Table structure for table `funding`
--

CREATE TABLE `funding` (
  `fundingID` varchar(10) NOT NULL,
  `fundingName` varchar(200) NOT NULL,
  `date` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `eventID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `funding` (`fundingID`, `fundingName`, `date`, `description`, `eventID`) VALUES
('F001', 'Virtual Streaming Workshop Sponsorship', '1 November 2021 - 10 November 2021', 'You may sponsor the event until 10 November 2021.', 'E002 ');


--
-- Indexes for table `funding`
--
ALTER TABLE `funding`
  ADD PRIMARY KEY (`fundingID`),
  ADD KEY `eventID` (`eventID`);

--
-- Constraints for table `funding`
--
ALTER TABLE `funding`
  ADD CONSTRAINT `FK_event_id` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`);
COMMIT;
