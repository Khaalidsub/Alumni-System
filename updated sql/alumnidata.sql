-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2021 at 05:29 AM
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
-- Database: `alumni`
--

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
  `Phoneno` varchar(250) DEFAULT NULL,
  `AlumniaddressID` varchar(250) DEFAULT NULL,
  `Graduateyear` varchar(250) DEFAULT NULL,
  `Title` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `alumni`
--

INSERT INTO `alumni` (`AlumniID`, `Batchname`, `Alumniname`, `Alumnimatric`, `Gender`, `Alumnicitizenship`, `Edulevel`, `Coursename`, `Alumniemail`, `Phoneno`, `AlumniaddressID`, `Graduateyear`, `Title`) VALUES
(1, '35', 'TAN HUI MIN', NULL, 'P', 'MALAYSIA', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid001', NULL, 'MRS'),
(2, '35', 'NUR LIYANA BINTI ENCHIK ARIS', NULL, 'P', NULL, 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid002', NULL, 'MRS'),
(3, '35', 'NUR SYAZWANI BINTI MOHD KHAIRI', NULL, 'P', 'MALAYSIA', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid003', NULL, 'MRS'),
(4, '35', 'ONG TEE YAU', NULL, 'L', 'MALAYSIA', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid004', NULL, 'MR'),
(5, '35', 'PANG LAI KIN', NULL, 'P', 'MALAYSIA', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid005', NULL, 'MRS'),
(6, '35', 'RAJA MOHD ZULKARNAIN', NULL, 'L', 'SINGAPORE', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid006', NULL, 'MR'),
(7, '35', 'SAZLI BIN YAHAYA', NULL, 'L', 'MALAYSIA', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid007', NULL, 'MRS'),
(8, '35', 'THIAN SOO YING', NULL, 'P', 'MALAYSIAN', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid008', NULL, 'MRS'),
(9, '35', 'SITI SARAH BINTI MUKTATI', NULL, 'P', NULL, 'DIPLOMA ', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid009', NULL, 'MRS'),
(10, '35', 'NUR \'ATIKAH BINTI ROHAIZAN', NULL, 'P', 'MALAYSIA', 'DIPLOMA', 'DIPLOMA SENI BINA', NULL, NULL, 'Aid010', NULL, 'MRS');

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
(NULL, 'SINGAPORE', 'BLK 815', '640815', 'JURONG WEST', '', 'STREET 81 #02-222', 'Aid006'),
('IPOH', 'MALAYSIA', 'NO 24', '31650', 'KAMPUNG PASIR PUTEH TAMBAHAN', 'PERAK', 'LORONG SERI KINTA', 'Aid007'),
('KUALA LUMPUR', 'MALAYSIA', 'NO 59', '58100', 'TAMAN DESA', 'KUALA LUMPUR', 'JALAN DESA MESRA', 'Aid008'),
('JOHOR BAHRU', 'MALAYSIA', 'NO 29', '81110', 'TAMAN SERI PULAI', 'JOHOR', 'JALAN ARA 13', 'Aid009'),
('KUALA LUMPUR', 'MALAYSIA', 'NO 11', '50480', 'BUKIT TUNKU', 'KUALA LUMPUR', 'CHANGKAT TUNKU', 'Aid010');

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alumni`
--
ALTER TABLE `alumni`
  MODIFY `AlumniID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alumni`
--
ALTER TABLE `alumni`
  ADD CONSTRAINT `FK_Alumni_Alumniaddress` FOREIGN KEY (`AlumniaddressID`) REFERENCES `alumniaddress` (`AlumniaddressID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;