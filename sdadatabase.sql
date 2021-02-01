-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2021 at 12:12 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test_2`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(10) NOT NULL,
  `adminName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adminEmail` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `adminPassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `adminName`, `adminEmail`, `adminPassword`) VALUES
(1, 'Aidiel', 'aidiel@um.com', '123'),
(2, 'Kamal', 'kamarul@gmail.com', 'kama1');

-- --------------------------------------------------------

--
-- Table structure for table `alumni`
--

CREATE TABLE `alumni` (
  `AlumniID` int(11) NOT NULL,
  `Batchname` varchar(250) DEFAULT NULL,
  `Alumniname` varchar(250) DEFAULT NULL,
  `Alumnimatric` varchar(250) DEFAULT NULL,
  `Gender` varchar(250) DEFAULT NULL,
  `Alumnicitizenship` varchar(250) DEFAULT NULL,
  `Edulevel` varchar(250) DEFAULT NULL,
  `Coursename` varchar(250) DEFAULT NULL,
  `Alumniemail` varchar(250) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `Phoneno` varchar(250) DEFAULT NULL,
  `AlumniaddressID` varchar(250) DEFAULT NULL,
  `Graduateyear` varchar(250) DEFAULT NULL,
  `Title` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `alumni`
--

INSERT INTO `alumni` (`AlumniID`, `Batchname`, `Alumniname`, `Alumnimatric`, `Gender`, `Alumnicitizenship`, `Edulevel`, `Coursename`, `Alumniemail`, `password`, `Phoneno`, `AlumniaddressID`, `Graduateyear`, `Title`) VALUES
(1, '35', 'TAN HUI MIN', 'DX200001', 'Female', 'MALAYSIA', 'Diploma', 'DIPLOMA SENI BINA', 'yali@salute.moscow', '123456', '0135894176', 'Aid001', '2002', 'Ms'),
(2, '35', 'NUR LIYANA BINTI ENCHIK ARIS', 'DX20002', 'Female', 'Malaysia', 'Diploma', 'DIPLOMA SENI BINA', 'ljo_oow@theoriginsprogram.net', '123456', '0115894276', 'Aid002', '2002', 'Ms'),
(3, '35', 'NUR SYAZWANI BINTI MOHD KHAIRI', 'TK3243245', 'Female', 'MALAYSIA', 'Diploma', 'DIPLOMA SENI BINA', '6naseer.far@wditu.com', '123456', '0123325453', 'Aid003', '2002', 'Mr'),
(4, '35', 'ONG TEE YAU', 'DX20003', 'Male', 'MALAYSIA', 'Diploma', 'DIPLOMA SENI BINA', 'zfranci@vitaminc.news', '123456', '0165894756', 'Aid004', '2002', 'Mr'),
(5, '35', 'PANG LAI KIN', 'DX20004', 'Female', 'MALAYSIA', 'Diploma', 'DIPLOMA SENI BINA', 'iahmadmahmoud612@usn.pw', '123456', '0139584716', 'Aid005', '2002', 'Ms'),
(6, '35', 'RAJA MOHD ZULKARNAIN', 'DX20005', 'Male', 'SINGAPORE', 'Diploma', 'DIPLOMA SENI BINA', '9macielbob@michiganpepsi.com', '123456', '0196847534', 'Aid006', '2002', 'Ir'),
(7, '35', 'SAZLI BIN YAHAYA', 'DX20006', 'Male', 'MALAYSIA', 'Diploma', 'DIPLOMA SENI BINA', 'cworawitsamartb@usn.pw', '123456', '0195874568', 'Aid007', '2002', 'Mr'),
(8, '35', 'THIAN SOO YING', 'DX20007', 'Female', 'MALAYSIAN', 'Diploma', 'DIPLOMA SENI BINA', 'hyoun@culturesnacks.us', '123456', '0195486278', 'Aid008', '2002', 'Dr'),
(9, '35', 'SITI SARAH BINTI MUKTATI', 'DX20008', 'Female', 'MALAYSIA', 'Diploma', 'DIPLOMA SENI BINA', 'ksimo.laasri.501d@lotomoneymaker.com', '123456', '0132654139', 'Aid009', '2002', 'Dr'),
(10, '35', 'NUR \'ATIKAH BINTI ROHAIZAN', 'DX20009', 'Female', 'MALAYSIA', 'Diploma', 'DIPLOMA SENI BINA', 'jhsha451t@arunachalnews.com', '123456', '01119583214', 'Aid010', '2002', 'Ir');

-- --------------------------------------------------------

--
-- Table structure for table `alumniaddress`
--

CREATE TABLE `alumniaddress` (
  `City` varchar(250) DEFAULT NULL,
  `Country` varchar(250) DEFAULT NULL,
  `Houseno` varchar(250) DEFAULT NULL,
  `Postalcode` varchar(250) DEFAULT NULL,
  `Region` varchar(250) DEFAULT NULL,
  `State` varchar(250) DEFAULT NULL,
  `Streetname` varchar(250) DEFAULT NULL,
  `AlumniaddressID` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `alumniaddress`
--

INSERT INTO `alumniaddress` (`City`, `Country`, `Houseno`, `Postalcode`, `Region`, `State`, `Streetname`, `AlumniaddressID`) VALUES
('BATU CAVES', 'MALAYSIA', '116', '68100', 'TAMAN BIDARA', 'SELANGOR', 'JALAN BIDARA 2/2', 'Aid001'),
('KUALA LUMPUR', 'MALAYSIA', 'NO 11', '54000', NULL, 'KUALA LUMPUR', 'LORONG BUKIT KERAMAR', 'Aid002'),
('BAYAN BARU', 'MALAYSIA', 'NO 30', '11950', 'TAMAN SRI TUNAS', 'PULAU PINANG', 'LORONG MAYANG ASIR 2', 'Aid003'),
('SITIAWAN', 'MALAYSIA', 'NO 1', '32000', 'PADANG HARROF', 'PERAK', 'JALAN HAJI MOHD ALI', 'Aid004'),
('SEREMBAN', 'MALAYSIA', 'NO 44', '70300', 'TAMAN RASAH JAYA', 'NEGERI SEMBILAN', 'JALAN RJ 1/1', 'Aid005'),
('SINGAPORE', 'SINGAPORE', 'BLK 815', '640815', 'JURONG WEST', '#02-222', 'STREET 81 ', 'Aid006'),
('IPOH', 'MALAYSIA', 'NO 24', '31650', 'KAMPUNG PASIR PUTEH TAMBAHAN', 'PERAK', 'LORONG SERI KINTA', 'Aid007'),
('KUALA LUMPUR', 'MALAYSIA', 'NO 59', '58100', 'TAMAN DESA', 'KUALA LUMPUR', 'JALAN DESA MESRA', 'Aid008'),
('JOHOR BAHRU', 'MALAYSIA', 'NO 29', '81110', 'TAMAN SERI PULAI', 'JOHOR', 'JALAN ARA 13', 'Aid009'),
('KUALA LUMPUR', 'MALAYSIA', 'NO 11', '50480', 'BUKIT TUNKU', 'KUALA LUMPUR', 'CHANGKAT TUNKU', 'Aid010');

-- --------------------------------------------------------

--
-- Table structure for table `alumniuser`
--

CREATE TABLE `alumniuser` (
  `Name` varchar(200) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `CurrentJob` varchar(200) DEFAULT NULL,
  `qualification` varchar(100) NOT NULL,
  `GraduateYear` int(50) DEFAULT NULL,
  `PhoneNo` varchar(200) DEFAULT NULL,
  `PreviousJob` varchar(200) DEFAULT NULL,
  `SalaryPrevious` double DEFAULT NULL,
  `SalaryCurrent` double DEFAULT NULL,
  `Status` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `alumniuser`
--

INSERT INTO `alumniuser` (`Name`, `password`, `Address`, `Email`, `CurrentJob`, `qualification`, `GraduateYear`, `PhoneNo`, `PreviousJob`, `SalaryPrevious`, `SalaryCurrent`, `Status`) VALUES
('muaz', '1234', '092,Jalan angka', 'la@yahoo.com', 'student', '', 2020, '01123412', 'kerani', 900, 3000, 'single'),
('ahmad', 'wawa', 'Jalan ampang', 'ahmad@gmail.com', 'software engineer', '', 2019, '01233413', 'Cikgu', 2000, 5000, 'single'),
('afiq', '', 'Jalan Panglima 3', 'afiq@gmail.com', 'Monitor', '', 2021, '012341234', 'Kedai Runcit', 2323, 4000, 'Single'),
('Burhan', 'haha', 'kemamang', 'bob12@gmail.com', 'cosplayer', '', 2017, '01234213', 'cuci rumah', 800, 9000, 'complicated'),
('Hafiz', 'haha', 'Jalan Kampung', 'hafiz@gmail.com', 'engineer', '', 2019, '01234233', 'Teacher', 1000, 3000, 'single'),
('Afiq Zaidin', '123', '96, TAMAN LAKSAMANA, JALAN TEMENGGONG AHMAD', 'afiqz@gmail.com', 'Jobless', 'Qualified', 2016, '21234', 'Programmer', 4000, 1000, 'Single'),
('Adel', '123', '96, TAMAN LAKSAMANA', 'aidiel@gmail.com', 'Jobless', 'Qualified', 2017, '334', 'Programmer', 2333, 425, 'Single'),
('Melo', '123', 'adfaw', 'melo@gmail.com', 'Jobless', 'Unqualified', 2014, '213213', 'Programmer', 2333, 1000, 'Single'),
('Buni', '123', 'Taman Naga', 'buni@gmail.com', 'Jobless', 'Unqualified', 2012, '21234', 'Programmer', 4000, 425, 'Single'),
('Arbaah', '123', 'Taman Naga', 'arbaah@gmail.com', 'Jobless', 'Unqualified', 2017, '334', 'Programmer', 4000, 1000, 'Single'),
('Syamsul', '123', '96, TAMAN LAKSAMANA, JALAN TEMENGGONG AHMAD', 'syamsul@gmail.com', 'Jobless', 'Qualified', 2005, '123', 'Programmer', 4000, 1000, 'Single');

-- --------------------------------------------------------

--
-- Table structure for table `announcement`
--

CREATE TABLE `announcement` (
  `announcementID` varchar(10) NOT NULL,
  `announcementName` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `date` varchar(10) NOT NULL,
  `description` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `announcement`
--

INSERT INTO `announcement` (`announcementID`, `announcementName`, `author`, `date`, `description`) VALUES
('A001', 'Jemputan ke Program Cabaran Mahasiswa Norma Baharu', 'Nadhirah Sulaiman', '1 Januari ', 'Assalamualaikum w.b.t / Salam Sejahtera\r\n\r\nWarga UTM dijemput untuk menyertai Program Cabaran Mahasiswa Norma Baharu anjuran Majlis Perwakilan Pelajar UTM yang akan diadakan pada ketentuan berikut :\r\n\r\nProgram : Cabaran Mahasiswa Norma Baharu\r\nTarikh: 10 Disember 2021\r\nMasa : 9.00 a.m\r\n\r\nTonton melalui:\r\nFACEBOOK LIVE MPP UTM'),
('A002', 'Invitation to Join the Virtual Streaming Workshop', 'Nadhirah Sulaiman', '1 January ', 'Assalamualaikum w.b.t / Salam Sejahtera\r\n\r\nUTM residents are invited to participate in the Virtual Streaming Workshop organized by the PERSAKA UTM which will be held on the following terms:\r\n\r\nProgram: Virtual Streaming Workshop\r\nDate: 11 November 2021\r\nTime: 2.00 p.m - 3.00 p.m\r\n\r\nWatch via:\r\nFACEBOOK LIVE PERSAKA UTM'),
('A003', 'Invitation to Compfair\'21 Program', 'Nadhirah Sulaiman', '1 January ', 'Assalamualaikum w.b.t / Salam Sejahtera\r\n\r\nUTM residents are invited to participate in the Compfair\'21 Program organized by PERSAKA UTM which will be held on the following terms:\r\n\r\nProgram: Compfair\'21\r\nDate: 9 October 2021\r\nTime: 9.00 a.m - 5.00 p.m\r\n\r\nWatch via:\r\nFACEBOOK LIVE PERSAKA UTM');

-- --------------------------------------------------------

--
-- Table structure for table `approvepayment`
--

CREATE TABLE `approvepayment` (
  `paymentID` varchar(10) NOT NULL,
  `AlumniID` int(11) NOT NULL,
  `staffID` varchar(10) NOT NULL,
  `eventID` varchar(10) NOT NULL,
  `paymentStatus` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `approvepayment`
--

INSERT INTO `approvepayment` (`paymentID`, `AlumniID`, `staffID`, `eventID`, `paymentStatus`) VALUES
('P001', 1, 'S1', 'E001', 'Approved'),
('P001', 9, 'S2', 'E001', 'Rejected');

-- --------------------------------------------------------

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

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventID`, `eventName`, `date`, `time`, `venue`, `organizer`, `fee`, `fundingID`) VALUES
('E001', 'Cabaran Mahasiswa Norma Baharu', '10 December 2021', '9:00 a.m', 'Facebook Live MPP UTM', 'MPP UTM', 'RM1.00', ''),
('E002 ', 'Virtual Streaming Workshop', '11 November 2021', '2:00 p.m - 3:00 p.m', 'Facebook Live PERSAKA UTM', 'PERSAKA UTM', 'Free', 'F001'),
('E003 ', 'COMPFAIR21', '9 October 2021', '9:00 a.m - 5:00 p.m', 'Facebook Live PERSAKA UTM', 'PERSAKA UTM', 'Free', '');

-- --------------------------------------------------------

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

--
-- Dumping data for table `funding`
--

INSERT INTO `funding` (`fundingID`, `fundingName`, `date`, `description`, `eventID`) VALUES
('F001', 'Virtual Streaming Workshop Sponsorship', '1 November 2021 - 10 November 2021', 'You may sponsor the event until 10 November 2021.', 'E002 ');

-- --------------------------------------------------------

--
-- Table structure for table `joinevent_payment`
--

CREATE TABLE `joinevent_payment` (
  `AlumniID` varchar(250) NOT NULL,
  `Alumniname` varchar(250) NOT NULL,
  `eventID` varchar(10) NOT NULL,
  `eventName` varchar(200) NOT NULL,
  `paymentID` varchar(10) NOT NULL,
  `fileName` varchar(250) NOT NULL,
  `paidDate` varchar(250) NOT NULL,
  `paidTime` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `joinevent_payment`
--

INSERT INTO `joinevent_payment` (`AlumniID`, `Alumniname`, `eventID`, `eventName`, `paymentID`, `fileName`, `paidDate`, `paidTime`) VALUES
('1', 'TAN HUI MIN', 'E001', 'Cabaran Mahasiswa Norma Baharu', 'P001', 'screenshotpayment', '7 December 2021', '6:00 p.m'),
('9', 'SITI SARAH BINTI MUKTATI', 'E001', 'Cabaran Mahasiswa Norma Baharu', 'P001', 'payment', '1 December 2021', '5:00 p.m');

-- --------------------------------------------------------

--
-- Table structure for table `logactivity`
--

CREATE TABLE `logactivity` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `eventName` varchar(30) NOT NULL,
  `sponsorship` varchar(3) NOT NULL,
  `qualified` varchar(100) NOT NULL,
  `nationality` varchar(100) NOT NULL,
  `addeddate` varchar(20) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logactivity`
--

INSERT INTO `logactivity` (`id`, `name`, `eventName`, `sponsorship`, `qualified`, `nationality`, `addeddate`) VALUES
(11, 'Ali', 'Cabaran Mahasiswa Norma Baharu', 'Yes', 'Master', 'Malaysian', '2021-01-09 01:44:59'),
(12, 'Abu', 'Virtual Streaming Workshop', 'Yes', 'Diploma', 'Malaysian', '2021-01-09 01:45:25'),
(13, 'Ahmad', 'COMPFAIR21', 'No', 'Diploma', 'Malaysian', '2021-01-09 01:45:44'),
(14, 'Razak', 'Virtual Streaming Workshop', 'No', 'Diploma', 'Malaysian', '2021-01-09 01:46:22'),
(15, 'Osman', 'Cabaran Mahasiswa Norma Baharu', 'Yes', 'Degree', 'Malaysian', '2021-01-09 01:46:43'),
(16, 'Omar', 'Cabaran Mahasiswa Norma Baharu', 'Yes', 'Master', 'Egypt', '2021-01-09 01:47:09'),
(17, 'Jannah', 'Cabaran Mahasiswa Norma Baharu', 'Yes', 'Master', 'Indonesia', '2021-01-09 01:47:38'),
(18, 'Razak', 'Cabaran Mahasiswa Norma Baharu', 'No', 'Diploma', 'Indonesia', '2021-01-14 00:46:01');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentID` varchar(10) NOT NULL,
  `fee` varchar(50) NOT NULL,
  `eventID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `fee`, `eventID`) VALUES
('P001', 'RM1.00', 'E001');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` varchar(10) NOT NULL,
  `staffName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `staffName`) VALUES
('S1', 'Nadhirah Sulaiman'),
('S2', 'Iskandar Shah');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alumni`
--
ALTER TABLE `alumni`
  ADD PRIMARY KEY (`AlumniID`),
  ADD KEY `FK_Alumni_Alumniaddress` (`AlumniaddressID`);

--
-- Indexes for table `alumniaddress`
--
ALTER TABLE `alumniaddress`
  ADD PRIMARY KEY (`AlumniaddressID`);

--
-- Indexes for table `announcement`
--
ALTER TABLE `announcement`
  ADD PRIMARY KEY (`announcementID`);

--
-- Indexes for table `approvepayment`
--
ALTER TABLE `approvepayment`
  ADD KEY `FK_staffID` (`staffID`),
  ADD KEY `FK_eventID` (`eventID`),
  ADD KEY `FK_paymentID` (`paymentID`),
  ADD KEY `FK_alumniID` (`AlumniID`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventID`),
  ADD KEY `fundingID` (`fundingID`);

--
-- Indexes for table `funding`
--
ALTER TABLE `funding`
  ADD PRIMARY KEY (`fundingID`),
  ADD KEY `eventID` (`eventID`);

--
-- Indexes for table `joinevent_payment`
--
ALTER TABLE `joinevent_payment`
  ADD KEY `eventID` (`eventID`,`paymentID`),
  ADD KEY `FK_payment_ID` (`paymentID`);

--
-- Indexes for table `logactivity`
--
ALTER TABLE `logactivity`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentID`),
  ADD KEY `eventID` (`eventID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`),
  ADD KEY `staffID` (`staffID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alumni`
--
ALTER TABLE `alumni`
  MODIFY `AlumniID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `logactivity`
--
ALTER TABLE `logactivity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alumni`
--
ALTER TABLE `alumni`
  ADD CONSTRAINT `FK_Alumni_Alumniaddress` FOREIGN KEY (`AlumniaddressID`) REFERENCES `alumniaddress` (`AlumniaddressID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `funding`
--
ALTER TABLE `funding`
  ADD CONSTRAINT `FK_event_id` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FK_even` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
