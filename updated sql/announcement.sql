-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2021 at 05:09 AM
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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `announcement`
--
ALTER TABLE `announcement`
  ADD PRIMARY KEY (`announcementID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
