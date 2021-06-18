-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:18889
-- Generation Time: Jun 18, 2021 at 01:23 AM
-- Server version: 5.7.24
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test_login`
--

-- --------------------------------------------------------

--
-- Table structure for table `mission`
--

CREATE TABLE `mission` (
  `missionID` int(4) NOT NULL,
  `missionName` char(66) NOT NULL,
  `missionCode` char(66) NOT NULL,
  `startTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `endTime` timestamp(6) NULL DEFAULT NULL,
  `capacity` int(4) DEFAULT NULL,
  `masterKeys` char(255) DEFAULT NULL,
  `publicKeys` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mission`
--

INSERT INTO `mission` (`missionID`, `missionName`, `missionCode`, `startTime`, `endTime`, `capacity`, `masterKeys`, `publicKeys`) VALUES
(1, 'Thunder bolt', 'dafdghragfdsaferqwqafgdsafdsafdsa', '2021-06-15 22:45:16.461324', '2021-09-16 05:00:00.000000', 1234, 'dafdghragfdsaferqwqafgdsafdsafdsa', 'dafdghragfdsaferqwqafgdsafdsafdsa');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(4) NOT NULL,
  `username` char(66) NOT NULL,
  `password` char(255) NOT NULL,
  `attributes` char(255) DEFAULT NULL,
  `firstname` char(66) NOT NULL,
  `lastname` char(66) NOT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `username`, `password`, `attributes`, `firstname`, `lastname`, `registerTime`) VALUES
(1, 'Pengpeng', '1234', 'king', 'Pengpeng', 'Hu', '2021-06-15 22:04:48');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`missionID`),
  ADD UNIQUE KEY `missionName` (`missionName`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mission`
--
ALTER TABLE `mission`
  MODIFY `missionID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
