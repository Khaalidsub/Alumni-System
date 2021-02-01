-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2021 at 06:10 AM
-- Server version: 10.4.13-MariaDB-log
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `event_module`
--

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `joinevent_payment`
--
ALTER TABLE `joinevent_payment`
  ADD KEY `eventID` (`eventID`,`paymentID`),
  ADD KEY `FK_payment_ID` (`paymentID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `joinevent_payment`
--
ALTER TABLE `joinevent_payment`
  ADD CONSTRAINT `FK_event` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`),
  ADD CONSTRAINT `FK_payment_ID` FOREIGN KEY (`paymentID`) REFERENCES `payment` (`paymentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
