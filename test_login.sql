-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 04, 2021 at 01:11 PM
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
(2, 'Super mission', 0x31393539303137333339, '2021-07-05 21:52:36.715229', '2021-07-06 02:52:36.104000', 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2, 0x1c1da7ed5836a1cd73aa251fd2a2df7fd97597a8, 8, 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2, 0x58a1c9f65f01d1fdd2ffcbbbbf64699fc3c357d5d0010ceaa7831cd78ecb613428dad60898906cae80c0247110f5ed592c1ce95ed0ec233948c69ae2eba8aafa46f87f06f360926850818c07801f6887f4532f2d9ad99cd62866d968f40c098b7d25ef090ed087ce08c37f9be61a7567c2746f5d019d88cccc39dabeb64d0bb8, 0x58a1c9f65f01d1fdd2ffcbbbbf64699fc3c357d5d0010ceaa7831cd78ecb613428dad60898906cae80c0247110f5ed592c1ce95ed0ec233948c69ae2eba8aafa46f87f06f360926850818c07801f6887f4532f2d9ad99cd62866d968f40c098b7d25ef090ed087ce08c37f9be61a7567c2746f5d019d88cccc39dabeb64d0bb8, 0x9d3c796eeeb259b1579f45d19d30316a76134dbce81aea17238d05cbce90b5073251303cf8d5d7caa6ed5c0c28c558d5c190ea2e7ad2e24731290e329f5de6baa44a6afffb5b940bb8f7703ff3753df32b4358caaab5ec347471f2316bfc6536ded05b4aad93d4eab613b5edef7686c730421455728be55071ee77c9e42c4d6d, 0x3412a50c3292816cd6193d4de041a2bba691b6f5ca8af36d088585008461b8ea17337bbba8597feddcf0af0f7b46a645267d8a1a0ec85a78a737913a89b7ff059f675ee826f5b893b90ad0df2dcc79edfc7d0da1aab70c974aec8b2cc8f71fa17c25c93eef7199d0b0e595cdcf7886e66444b273225fb75387589e0ec901f5c2),
(3, 'Thunder Bolt', 0x31323635303936383434, '2021-07-07 13:37:17.957908', '2021-07-08 22:23:57.583000', 0x874ca24d662b074f68fcd444a645f50b0d21808981c81b12861a47473c51761008bc8a6ee83b1625c716233dcc95e30705d0c46d4e92005b1179cbc5419d6961611799194cb64ac65981c6e549a2929ad71650283365c0f3bc0f236ee42ef14ae92d0f883316475d4084052ead799accefe9a42bba4c2eaf6d873c13e7845d4c, 0x5af6c23fbc157ac537fa9468e1656eb1b3091b90, 8, 0x874ca24d662b074f68fcd444a645f50b0d21808981c81b12861a47473c51761008bc8a6ee83b1625c716233dcc95e30705d0c46d4e92005b1179cbc5419d6961611799194cb64ac65981c6e549a2929ad71650283365c0f3bc0f236ee42ef14ae92d0f883316475d4084052ead799accefe9a42bba4c2eaf6d873c13e7845d4c, 0x082261dcd1cff87521bd06ff9607f7fa47439d089d6c0d69298ba996db9e5405d9e6568028fe31c39627381c09eaba1b4875fbc29dabd97d8205e4c507e6256f554cb17bb456e6d2975411c07e7be812bcc682a818dff44d74abb48e1c660c228db999d034a2b3d59c916570171e61d80ff8bd01c8a91e089229dd024abdca8e, 0x082261dcd1cff87521bd06ff9607f7fa47439d089d6c0d69298ba996db9e5405d9e6568028fe31c39627381c09eaba1b4875fbc29dabd97d8205e4c507e6256f554cb17bb456e6d2975411c07e7be812bcc682a818dff44d74abb48e1c660c228db999d034a2b3d59c916570171e61d80ff8bd01c8a91e089229dd024abdca8e, 0x20c378512c03a6c64a7338c0144f807b8e7bd7c35fe87b79b30d169bb2dc352e431040bb09bcc8b486d9d9f23fe2828993a0d6fc8937d4420338da5924a7467407eef7ed7fd4cb91ffd251ac427aa7fdc91bfe8f83652fdff5dd4b477486c064aca3cb2df915ad2ec91eb53fa714d850a223b0cec36bdde3106b6b0e0acc625f, 0x874ca24d662b074f68fcd444a645f50b0d21808981c81b12861a47473c51761008bc8a6ee83b1625c716233dcc95e30705d0c46d4e92005b1179cbc5419d6961611799194cb64ac65981c6e549a2929ad71650283365c0f3bc0f236ee42ef14ae92d0f883316475d4084052ead799accefe9a42bba4c2eaf6d873c13e7845d4c),
(4, 'Display Port', 0x373838333533383633, '2021-07-07 13:43:00.127338', '2021-07-08 22:29:39.780000', 0x5ef42922c86e5e3e757e86e782b363a59ea8129d19903554e35c400056fce7645a231a51aa63b2b6b7385f2bffed58110c2029f69c02dd0670376d7e0309ff7587b7c86654e5533340fa80c511d5cac0a35fb863ea23a474db4dcc51e50c1d5b0806eb8250816de3111894711a2f1dcd686dbd7d0d17847aae4f70cffb39dbdc, 0x22cc02d44719d611791fa77f40d364d07848451a, 1000, 0x5ef42922c86e5e3e757e86e782b363a59ea8129d19903554e35c400056fce7645a231a51aa63b2b6b7385f2bffed58110c2029f69c02dd0670376d7e0309ff7587b7c86654e5533340fa80c511d5cac0a35fb863ea23a474db4dcc51e50c1d5b0806eb8250816de3111894711a2f1dcd686dbd7d0d17847aae4f70cffb39dbdc, 0x654cf8bab535a55e0559ede7c0b30cd01f29d1edcea437bb1c059947f6bbd3c00e30282260e64f4f5f4a545d0a1c02455829d1d933e2bdcc2e45934853fac8496904dd487c2b10a9bc0fb2eb7c23acf3f7796dafd17327d295fa7f6fc379a48a74fbfc547750df6ae28d5500c9223a8ef300526a35ec1ce93b7a6bdc228d5455, 0x654cf8bab535a55e0559ede7c0b30cd01f29d1edcea437bb1c059947f6bbd3c00e30282260e64f4f5f4a545d0a1c02455829d1d933e2bdcc2e45934853fac8496904dd487c2b10a9bc0fb2eb7c23acf3f7796dafd17327d295fa7f6fc379a48a74fbfc547750df6ae28d5500c9223a8ef300526a35ec1ce93b7a6bdc228d5455, 0x6d19994f8662310c8276bd80c59b89cfe0c70a05c81077b682da0af3aa0b233991c7a42a6bb29ac95a0b89276ec9216121e0bf2b944dbe7e9cc89ba178394f434ecd38c4430ec567e10f746fa516e2fe814170c18a3d88cf7f18fe8417fba8de79afe92df6bd8088136b483918e6af385241518701ed28c334ef4f2368ea6c82, 0x5ef42922c86e5e3e757e86e782b363a59ea8129d19903554e35c400056fce7645a231a51aa63b2b6b7385f2bffed58110c2029f69c02dd0670376d7e0309ff7587b7c86654e5533340fa80c511d5cac0a35fb863ea23a474db4dcc51e50c1d5b0806eb8250816de3111894711a2f1dcd686dbd7d0d17847aae4f70cffb39dbdc),
(5, 'updated dog house', 0x36353530323830, '2021-08-04 18:05:57.677934', NULL, 0xa04868c962f3b90a300c7570b1697fd0de445ee40f0827d017a71a160fa14e0e9a6d13f4888e68fbb76331eeaedb554b34a545e79b6159f0e8ae3d9cd6ce522004656bc1f55e880718c924873966348ff6cc254022a3fe98806d3982e936024410218e18966e00649b400ea53aefcd6ca12edfbc992572d6992ad4fdb34d316f, 0x3bc007b02da5f454017927580710e7dcb69b8216, 10, 0x9b410a2169eb2156ce8b2825ea26db36c48121a70db2eb2d9d2a9a8ba57f023d8ae8cef37ab7a303650a5ef249b3a25bf25177c65659fbeb78174654aa281cb9a680dc922a67c156cd8005aad07184dca6a82443e9fdea2718e402f78cc1ebe86ee7697718281973b9e96a8234ebc19b921a485c87921dac9150be48fe8156a9, 0x61f0357cca085a21fbca648489044fe029f8f66bfe8bff46379d212216578965f8b098a2a9f90fe278c12bc46cc05df9e40ab782deec5175ca42332823133d9f9a701da2a547f9fe77ae43f4da01a47991a5fe11d6948f02e5856aa4d7fb7d5ea25f4efb4f6910e6d09084b36e14ad2ea74ebe9c98514f3c5c6a5bf7a6f7cc15, 0x348156cc2b45055665d1024b84d4d47a3f6c7624cb5a50bffacc2b53815e86f29d78d5e85f31135b3b1c0498c285add042a884aaa2190176ace32683b75aa0a85496b747055a27f29a2548cff7e076744c8539fb06ad22018a6996691de7cc448388b1203fd325c1e5231a96eb76780115768ac5f3348adab33b23237d357fa8, 0x2cb072589cdddfc9fd83009a36ce03eb565cb69a469b0374a314e28914b2f7fa8d8ecee6a6b5cbf3bfe8b412ba5fa4259ffbfc44752b81d9982cc934d2ebee1ba684108144daae6e0c523904b66648a2d14629f91baf47822847d9ca1fdbd1a7e1305a1563ac20097ce9d2df09f9b986f405733d2c801b8fe9bdeb8a58c96f41, 0x0e44b5208d0b0064cca75df0240ee4b67e7426846b6cb714aa10b2fb3a0439f37fcea8d079460d24b7a1dc7c6fc2bcb57396cc8ad6c73eee6604004f42960760401d4db015cbdd99397c119f387d103cc09e40cb25200570083e17c851b1f6ee6c3744691b105ba035ce06ed4eb1bfef9ad156ebc341b260a1dd2d76ef27f0ce),
(6, 'updated1 dog house', 0x3239343838353934, '2021-08-04 18:09:38.445752', NULL, 0x02c33effd00abdb09d769e0f78f8dc33c541a0e2c18579c412da80a09358a7314f9b81996e3b12049ebca251ce9ba0c4f5a13c4378e46ea7eda1efe92774f9037f88961adf4383f68c5d7f208eb7ec30b20b6f80b5a99d4c345469d6c57831ccb2c9e55ac3f74e2e2496848f6527fc67dd49d83cfb9db3c82e9d186bde7265ad, 0x041fdb7de3fcc03332ebcbd79d64b401199f2561, 10, 0x816eacdbec8a620718b2c13c15697cb452c1efc9dff997b4f2059b5901cd48e9fd4cd8b6967c963791253a4a9c98744e31b13ba8f2677fb4c36f2f5393c56aa12cf18dd2d9da482f46fc86cd7d28be495560b895f272ac8474a001c99bcf13789942c888396c45a818cfd814db5e69c9923a5bb6dd1e3931657edf5630c7d07a, 0x75da21129f619abed5d3b3d4dc60c26dd0c2b7b267ed668c2dc8bc3460eaf60df2912632e0ee80dbb08619a273e6def3cbd710c555e6403b49a99d49732b9dd25e6ae66ff2f5fb69064b31bed5fcad7a7c37ecf631656e1bf680134040569d1bfe4dcae6dad9792d4dae01703f499d6137746e38e66b67d02721b571977b1241, 0x0cf29d57011a0737196a6b7732c6233dda12b62dfe261d91d04ea4f0f8901f79f68de80aff735a5f7f6671693cf229c8fb6df19445357e0c7737170ec01c500892886bdd9fe9f2599bc53b14c3ccc0acdb4b2b157619cc3a9ab2f8e9d36361b426110c864f6c027592a7af8f0cfaafbea4327ab5be16a197b6bed9fbb6c55a3e, 0x6f9475453f61cdeb90f001200dd8a8f06592f2a5810a8703643146aaa3b29d623e667520897562aa66fbd2c35e2ee548869479873a8ba36a092df9a0abbc6ecf9da0153db7f6bfd797bf5d33df7abad343ef792443575ef2d90d6d1d3a320ab914645b2b4d2e18cbb590c8fd3c104f1f447177af863cd1f16e51682914460e60, 0x96e7333e5b02fe50772e759ba4e319040af1e7da85abd6d16844eb8a0702125e312ca34bd78d3ca7760b4489313ff113033555c5b28b32670be21d5bc4a503cfa0e879e5634ba6abc7e38452a5d076bf618db14e3752b85ec1e30d904feec5d661f653bea836832650a13aae2d145643970044430b26ba004900530c61965fa2);

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
(4, 'DummyUser0', '1234', 'Captain,District 1,Connector', 'Dummy', 'User', '2021-07-06 01:41:59'),
(5, 'updated d1', 'p1', 'a1, a2, a3, a4, a5', 'first_d1', 'last_d1', '2021-08-04 15:10:23'),
(6, 'updated1 d1', 'p1', 'a1, a2, a3, a4, a5', 'first_d1', 'last_d1', '2021-08-04 18:08:43');

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
  MODIFY `missionID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
