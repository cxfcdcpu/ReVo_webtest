-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 05, 2021 at 04:55 PM
-- Server version: 5.7.34-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `missionName` char(255) NOT NULL,
  `missionCode` varbinary(3000) NOT NULL,
  `startTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `endTime` timestamp(6) NULL DEFAULT NULL,
  `g1_alpha` varbinary(3000) DEFAULT NULL,
  `beta` varbinary(3000) DEFAULT NULL,
  `capacity` int(4) DEFAULT NULL,
  `g1` varbinary(3000) DEFAULT NULL,
  `g2` varbinary(3000) DEFAULT NULL,
  `g2_beta` varbinary(3000) DEFAULT NULL,
  `e_gg_alpha` varbinary(3000) DEFAULT NULL,
  `g1_a` varbinary(3000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mission`
--

INSERT INTO `mission` (`missionID`, `missionName`, `missionCode`, `startTime`, `endTime`, `g1_alpha`, `beta`, `capacity`, `g1`, `g2`, `g2_beta`, `e_gg_alpha`, `g1_a`) VALUES
(2, 'Super mission', 0x31393539303137333339, '2021-07-05 21:52:36.715229', '2021-07-06 02:52:36.104000', 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2, 0x1c1da7ed5836a1cd73aa251fd2a2df7fd97597a8, 8, 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2, 0x58a1c9f65f01d1fdd2ffcbbbbf64699fc3c357d5d0010ceaa7831cd78ecb613428dad60898906cae80c0247110f5ed592c1ce95ed0ec233948c69ae2eba8aafa46f87f06f360926850818c07801f6887f4532f2d9ad99cd62866d968f40c098b7d25ef090ed087ce08c37f9be61a7567c2746f5d019d88cccc39dabeb64d0bb8, 0x58a1c9f65f01d1fdd2ffcbbbbf64699fc3c357d5d0010ceaa7831cd78ecb613428dad60898906cae80c0247110f5ed592c1ce95ed0ec233948c69ae2eba8aafa46f87f06f360926850818c07801f6887f4532f2d9ad99cd62866d968f40c098b7d25ef090ed087ce08c37f9be61a7567c2746f5d019d88cccc39dabeb64d0bb8, 0x9d3c796eeeb259b1579f45d19d30316a76134dbce81aea17238d05cbce90b5073251303cf8d5d7caa6ed5c0c28c558d5c190ea2e7ad2e24731290e329f5de6baa44a6afffb5b940bb8f7703ff3753df32b4358caaab5ec347471f2316bfc6536ded05b4aad93d4eab613b5edef7686c730421455728be55071ee77c9e42c4d6d, 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(4) NOT NULL,
  `username` char(255) NOT NULL,
  `password` varchar(3000) NOT NULL,
  `attributes` varchar(3000) DEFAULT NULL,
  `firstname` char(255) DEFAULT NULL,
  `lastname` char(255) DEFAULT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `username`, `password`, `attributes`, `firstname`, `lastname`, `registerTime`) VALUES
(1, 'Pengpeng', '1234', 'king', 'Pengpeng', 'Hu', '2021-06-15 22:04:48'),
(3, 'dummy1', '1234', 'dummy', 'mm', 'dd', '2021-07-01 16:24:22'),
(4, 'DummyUser0', '1234', 'Captain,District 1,Connector', 'Dummy', 'User', '2021-07-05 20:41:59');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`missionID`),
  ADD UNIQUE KEY `missionName` (`missionName`),
  ADD UNIQUE KEY `missionCode` (`missionCode`);

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
  MODIFY `missionID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
