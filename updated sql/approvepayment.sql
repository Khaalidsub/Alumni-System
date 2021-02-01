-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2021 at 06:25 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `event module`
--

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `approvepayment`
--
ALTER TABLE `approvepayment`
  ADD KEY `FK_staffID` (`staffID`),
  ADD KEY `FK_eventID` (`eventID`),
  ADD KEY `FK_paymentID` (`paymentID`),
  ADD KEY `FK_alumniID` (`AlumniID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `approvepayment`
--
ALTER TABLE `approvepayment`
  ADD CONSTRAINT `FK_alumniID` FOREIGN KEY (`AlumniID`) REFERENCES `alumni` (`AlumniID`),
  ADD CONSTRAINT `FK_eventID` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`),
  ADD CONSTRAINT `FK_paymentID` FOREIGN KEY (`paymentID`) REFERENCES `payment` (`paymentID`),
  ADD CONSTRAINT `FK_staffID` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
