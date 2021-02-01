--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `eventID` varchar(10) NOT NULL,
  `eventName` varchar(200) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `venue` varchar(100) NOT NULL,
  `organizer` varchar(250) NOT NULL,
  `fee` varchar(10) NOT NULL,
  `fundingID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `event` (`eventID`, `eventName`, `date`, `time`, `venue`, `organizer`, `fee`, `fundingID`) VALUES
('E001', 'Cabaran Mahasiswa Norma Baharu', '10 December 2021', '9:00 a.m', 'Facebook Live MPP UTM', 'MPP UTM', 'RM1.00', ''),
('E002 ', 'Virtual Streaming Workshop', '11 November 2021', '2:00 p.m - 3:00 p.m', 'Facebook Live PERSAKA UTM', 'PERSAKA UTM', 'Free', 'F001'),
('E003 ', 'COMPFAIR21', '9 October 2021', '9:00 a.m - 5:00 p.m', 'Facebook Live PERSAKA UTM', 'PERSAKA UTM', 'Free', '');


--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventID`),
  ADD KEY `fundingID` (`fundingID`);
COMMIT;
