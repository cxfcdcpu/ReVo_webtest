-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 03, 2021 at 01:11 PM
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
-- Table structure for table `match`
--

CREATE TABLE `match` (
  `missionID` int(4) NOT NULL,
  `userID` int(4) NOT NULL,
  `registerationTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `L` varbinary(500) DEFAULT NULL,
  `attributes` varchar(1000) DEFAULT NULL,
  `attrSizes` varchar(300) DEFAULT NULL,
  `k_is` varbinary(5000) DEFAULT NULL,
  `revoNodes` varchar(300) DEFAULT NULL,
  `revoNodeSize` varchar(300) DEFAULT NULL,
  `k_ys` varbinary(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(2, 'Super mission', 0x31393539303137333339, '2021-07-05 21:52:36.715229', '2021-07-06 02:52:36.104000', 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2, 0x1c1da7ed5836a1cd73aa251fd2a2df7fd97597a8, 8, 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2, 0x58a1c9f65f01d1fdd2ffcbbbbf64699fc3c357d5d0010ceaa7831cd78ecb613428dad60898906cae80c0247110f5ed592c1ce95ed0ec233948c69ae2eba8aafa46f87f06f360926850818c07801f6887f4532f2d9ad99cd62866d968f40c098b7d25ef090ed087ce08c37f9be61a7567c2746f5d019d88cccc39dabeb64d0bb8, 0x58a1c9f65f01d1fdd2ffcbbbbf64699fc3c357d5d0010ceaa7831cd78ecb613428dad60898906cae80c0247110f5ed592c1ce95ed0ec233948c69ae2eba8aafa46f87f06f360926850818c07801f6887f4532f2d9ad99cd62866d968f40c098b7d25ef090ed087ce08c37f9be61a7567c2746f5d019d88cccc39dabeb64d0bb8, 0x9d3c796eeeb259b1579f45d19d30316a76134dbce81aea17238d05cbce90b5073251303cf8d5d7caa6ed5c0c28c558d5c190ea2e7ad2e24731290e329f5de6baa44a6afffb5b940bb8f7703ff3753df32b4358caaab5ec347471f2316bfc6536ded05b4aad93d4eab613b5edef7686c730421455728be55071ee77c9e42c4d6d, 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2),
(3, 'Thunder Bolt', 0x31323635303936383434, '2021-07-07 13:37:17.957908', '2021-07-08 22:23:57.583000', 0x874ca24d662b074f68fcd444a645f50b0d21808981c81b12861a47473c51761008bc8a6ee83b1625c716233dcc95e30705d0c46d4e92005b1179cbc5419d6961611799194cb64ac65981c6e549a2929ad71650283365c0f3bc0f236ee42ef14ae92d0f883316475d4084052ead799accefe9a42bba4c2eaf6d873c13e7845d4c, 0x5af6c23fbc157ac537fa9468e1656eb1b3091b90, 8, 0x874ca24d662b074f68fcd444a645f50b0d21808981c81b12861a47473c51761008bc8a6ee83b1625c716233dcc95e30705d0c46d4e92005b1179cbc5419d6961611799194cb64ac65981c6e549a2929ad71650283365c0f3bc0f236ee42ef14ae92d0f883316475d4084052ead799accefe9a42bba4c2eaf6d873c13e7845d4c, 0x082261dcd1cff87521bd06ff9607f7fa47439d089d6c0d69298ba996db9e5405d9e6568028fe31c39627381c09eaba1b4875fbc29dabd97d8205e4c507e6256f554cb17bb456e6d2975411c07e7be812bcc682a818dff44d74abb48e1c660c228db999d034a2b3d59c916570171e61d80ff8bd01c8a91e089229dd024abdca8e, 0x082261dcd1cff87521bd06ff9607f7fa47439d089d6c0d69298ba996db9e5405d9e6568028fe31c39627381c09eaba1b4875fbc29dabd97d8205e4c507e6256f554cb17bb456e6d2975411c07e7be812bcc682a818dff44d74abb48e1c660c228db999d034a2b3d59c916570171e61d80ff8bd01c8a91e089229dd024abdca8e, 0x20c378512c03a6c64a7338c0144f807b8e7bd7c35fe87b79b30d169bb2dc352e431040bb09bcc8b486d9d9f23fe2828993a0d6fc8937d4420338da5924a7467407eef7ed7fd4cb91ffd251ac427aa7fdc91bfe8f83652fdff5dd4b477486c064aca3cb2df915ad2ec91eb53fa714d850a223b0cec36bdde3106b6b0e0acc625f, 0x874ca24d662b074f68fcd444a645f50b0d21808981c81b12861a47473c51761008bc8a6ee83b1625c716233dcc95e30705d0c46d4e92005b1179cbc5419d6961611799194cb64ac65981c6e549a2929ad71650283365c0f3bc0f236ee42ef14ae92d0f883316475d4084052ead799accefe9a42bba4c2eaf6d873c13e7845d4c),
(4, 'Display Port', 0x373838333533383633, '2021-07-07 13:43:00.127338', '2021-07-08 22:29:39.780000', 0x5ef42922c86e5e3e757e86e782b363a59ea8129d19903554e35c400056fce7645a231a51aa63b2b6b7385f2bffed58110c2029f69c02dd0670376d7e0309ff7587b7c86654e5533340fa80c511d5cac0a35fb863ea23a474db4dcc51e50c1d5b0806eb8250816de3111894711a2f1dcd686dbd7d0d17847aae4f70cffb39dbdc, 0x22cc02d44719d611791fa77f40d364d07848451a, 1000, 0x5ef42922c86e5e3e757e86e782b363a59ea8129d19903554e35c400056fce7645a231a51aa63b2b6b7385f2bffed58110c2029f69c02dd0670376d7e0309ff7587b7c86654e5533340fa80c511d5cac0a35fb863ea23a474db4dcc51e50c1d5b0806eb8250816de3111894711a2f1dcd686dbd7d0d17847aae4f70cffb39dbdc, 0x654cf8bab535a55e0559ede7c0b30cd01f29d1edcea437bb1c059947f6bbd3c00e30282260e64f4f5f4a545d0a1c02455829d1d933e2bdcc2e45934853fac8496904dd487c2b10a9bc0fb2eb7c23acf3f7796dafd17327d295fa7f6fc379a48a74fbfc547750df6ae28d5500c9223a8ef300526a35ec1ce93b7a6bdc228d5455, 0x654cf8bab535a55e0559ede7c0b30cd01f29d1edcea437bb1c059947f6bbd3c00e30282260e64f4f5f4a545d0a1c02455829d1d933e2bdcc2e45934853fac8496904dd487c2b10a9bc0fb2eb7c23acf3f7796dafd17327d295fa7f6fc379a48a74fbfc547750df6ae28d5500c9223a8ef300526a35ec1ce93b7a6bdc228d5455, 0x6d19994f8662310c8276bd80c59b89cfe0c70a05c81077b682da0af3aa0b233991c7a42a6bb29ac95a0b89276ec9216121e0bf2b944dbe7e9cc89ba178394f434ecd38c4430ec567e10f746fa516e2fe814170c18a3d88cf7f18fe8417fba8de79afe92df6bd8088136b483918e6af385241518701ed28c334ef4f2368ea6c82, 0x5ef42922c86e5e3e757e86e782b363a59ea8129d19903554e35c400056fce7645a231a51aa63b2b6b7385f2bffed58110c2029f69c02dd0670376d7e0309ff7587b7c86654e5533340fa80c511d5cac0a35fb863ea23a474db4dcc51e50c1d5b0806eb8250816de3111894711a2f1dcd686dbd7d0d17847aae4f70cffb39dbdc);

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
(1, 'Pengpeng', '1234', 'king', 'Pengpeng', 'Hu', '2021-06-16 03:04:48'),
(3, 'dummy1', '1234', 'dummy', 'mm', 'dd', '2021-07-01 21:24:22'),
(4, 'DummyUser0', '1234', 'Captain,District 1,Connector', 'Dummy', 'User', '2021-07-06 01:41:59');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `match`
--
ALTER TABLE `match`
  ADD PRIMARY KEY (`missionID`,`userID`);

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
  MODIFY `missionID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
