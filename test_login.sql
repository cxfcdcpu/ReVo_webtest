-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 18, 2021 at 05:24 AM
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
  `k_ys` varbinary(5000) DEFAULT NULL,
  `user_tree_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `match`
--

INSERT INTO `match` (`missionID`, `userID`, `registerationTime`, `L`, `attributes`, `attrSizes`, `k_is`, `revoNodes`, `revoNodeSize`, `k_ys`, `user_tree_id`) VALUES
(67, 76, '2021-09-09 20:03:26.606543', 0x2459cab8258b3e8b3ef7b2074af84b11271b49218f4a8f2f0f594a2155a7b96b0b7fef9ffca272b88b12714fe51f391428884e882ec7617d4fb2c1e804371f6c24c7caa35b36ba4cbb6cf52c7feae2ab4449c56fb8ad7b25d8763b20a4c2d27b9c81f2203919650cb0ba15fa05ff99e866543238cb4b3053f10c77daff2e71e0, 'SERGEANT, ARMOR, DISTRICT_8, LEVEL_9', '128,128,128,128', 0x7f09dc6f302e674a1ddd00736dcaf1d7450f5208445dd1ddb2bba21b4647a9c25a34a8c38fdea9d832614419b489af2c03946b9d4499fdab7fc25c93be71cf7a500f8f06ed4c139e479afb6267eced50299d437eb0a6c6f65c633f6462fea40b786ccba1f09b6b5b261a2ed7f75d7159d2b539007a7a6ac076bd30ac1ce6510e4d9a351ccfefbad7767bb7a52c849d3c8c005de67f0ee0f51ff21d867bd94b734fea094315ac26cda601c5b5daa50c58bd486595fe3a65f6af7317c2ba7c50ef2e563009df519151b652c7918ffa646a426847d2a7f424916b5ba77ceb1a14394579783b92d4240a43c806abd1c05e3cf90e29cd8e4d9f8f572388d7deeded019f1012582121c587ba5d99f9f63b0f02c4b97eb3368bba3f8829ffd75559151dc674e243bd81feb01ae60865490603f8e14e0a8258b5b9e15ad4c35ec45835c85a26b0584311f72cf7fcc94f5bd67a82aad5a365c65e57dd6e2e9776d2878ca69ba03e6b775db22d3a24bc9d84c81d47b0faf16558636ed0143397e597d4cffb23df928666560ae2d960a271575091957442c82a030170acfc4efd1d739646ee8a7fdc3e1a0a5447160f802426f3ead15337125956d40f3b05260d12c04c50e26efada49d109ba54358f146a4b5bc93efe7d7161b40f9a4a1c3171e918b433ab4712203e0f08edbdc6a257fab7e463cb2d657c69ecac138cff56761d11fbe96d, '32,16,1,2,4,8', '128,128,128,128,128,128', 0x24980d6b773ac896fb6b4f4482c7169a1b6dd96a308db6a895174629db8aef6ac5357200407f39df59e0872e984d20504ea9483b6f83d154204d8f638b7208037782b00a07ab47971c4f67f43cf01aa6bf1c57afe095a92c3747cd7f7f8fee9e1442eeed7e7b5e2558fb1c17a9988b7f5b81f7ae02c3da59c178831cb24fcc4d9184fcb0a648d992610693d63f8147101de6d84fb3fb6e5d45a625af9c6ca1338388231bd7b590e8333a98be63522a6368e6d7fb640cdb749e78f9b6bea84c9e1dab9712033b00737370a301fedbd5c8ea9c35409369371730d5cec21a66e2f30bff7c8707b11f9fd04b1483f1e63ff130f9c7b6f23953ea45edf1e8764fe4751fabc0049bc82f82863da2463fe7abc131f46d9a2a1ded81f0fab5f301328446f2ebf367945009a06ac266ed691ec96faf4746f18a0e0c16b2990f02733c84623e88fec7b73abeedc4aa11590c0f8c0a7c47e60dacc67dfcb7ca7c1d0154c207ac65972eb21ff553be616325d30564ca022b97b5bf823be294f68fda1451d5dd3067f4ec7d896df5d31f4c59c8deb2c3bd581a6ab25559d25a2c7e3686295c2eccad67278ddbf6085eb7973b61f8bc30027ed8c188089cd47c803544757635157e0ba1d77d49be752fde2e4b9db675991a4fdf5b0a401ebbb876a246f79ae224b68c8b4fa265372d07ebabc037b75a3204034fd751df3dd539dca8215341472097ce007b10f53c8b77cf08f54d2e145427518e6528b23f17fd8b7d6a72f2a4a4e9a9f1440519ba2c4ba44ec7685e9423821dac5186ebdb234cc51d1edf6c17255593fc4597580efe286b561324465750399e6a391827fcc5ae10f318aa54ef5ef7b25ccce3a3f77e393f17e2d7b7f60293edb15a1fe2cb313a20d4930f59c4bb99f1c97637a93c708a64d144678a90f7812a1ae7028c1c9dac27a34900f9a992b819eb5b4d345ee20d55fbf4ed5ce1ade3e3609a5c2f4adcea8ad6e886bfd2bf0465f415698d2ab2cb0574573731617a952e0d422e8130f23e2ac9202e144f8cc461c9b487569f074530dc409c0cc7765322f7ce0474ac8bb909ab69fe63a6c2, 1),
(67, 77, '2021-09-13 21:20:43.468933', 0x5d1b8dd59830a21494defa1668b1d5277b67e36e5b47f048f3cdcc9d562fc42228c23baeeabef9d7550854c921b5946eaa3dfee88a69cd4eada50b7f76bc5b3572c5d21e0ed53bf9d09bc8c4dbc0ef2fd268103dc6b81a577fd67205ae18303ba00320a305ccb3bb3b8a2306712faf3dd17725e2cc3cdbb35473f722f6cf853b, 'SPECIALIST, DISTRICT_8, CHEMICAL_CORPS', '128,128,128', 0x24d363d9a0228399ac6f692ed1fd81651cbff7922588941daeaf2bcf621cc7102539d38c12f776250cf845edf63f62ede05e2128eac018cf12c8a3361604a5a9106fd251c2db74f93447fd6fa98296fb03e3fb7cc6a88ced69c3f338c2d2e3cd1c8cec04c3e5ef663595223c4bdb6e8cc20fbeda10d4c502718a5113ce71f9602077fccac9659a9d2ff66d6b39b0d75984983e05644b966ed04a902e791555c91b61b8d0bcecdae1b5fadf733577ca2bb99c916853f19004119a67e3c3da7df967c2314fb6a0d28a4fc0ca4ce3c71ecca17a2f7d382ae146d80e68a0fe13aff6c97c6093a430120b7a43447b52bea8a9a79772b6e1ab4992b4a7e03f697b3daa5cde314fab6c7aec6e135c17c73490bf81f472e84956a58161c1a250ea97f648cbee1332b095263accd48af32ddb8994ec606b7a1af8069576bf90a2bcf454d8327555c07b63d263a48d6ecb3a55ac050afdbd14f954beaf409f3a69ee144d0908da8fff6bc482b4c40d3e6c2dbe0c95a6ab5cd23282a1fd387b9d0121131f06, '16,33,1,2,4,8', '128,128,128,128,128,128', 0x3281e4e6e821b882f39f2431d1527c606ed4cbce4d0c03ba3d774bcbdcc939c3cb89ad03efaa32825b916e5a9dce7ccbecd1d430080406182991feea6086be0028914802835cc14ca35643cdbbb5a3f7323b98913e8e5c38d68d9538f3d56838303f86bf7685e9d8bed42db802a206af8e1f4d96d466713171111999ec5f37e249be6d3afafe9419a91b2b8b0c26871c55b1461eb4e579791fe3fe4492f3cc4b16ddab1c1751df0adaba8ee3623b2c7311588ce1e3b4643f37b71c58ceeb4129305aaa882898723d4ccc40265ca2ae7603ded967690d6b6463bd7081a0087cefdfdf1d704cdcc3464ca1e85cad6427c6f5fa86865c31343f50aca285de4d004d92c0355162f5a2897f2ee34ba0df9e50f7fc2c3a3771c228ad5876137d8e7551b1234c287b99c01f85ccad8a8035c297b0078fb7181da5d2b2e67f2d5991c66c73013cfb5253d3825d3561a3710e1efa081b52338475620457ce16e338305efa9e576678db91b2fa58698577be27315358bd576ddd389b065a14c10a74a8fc199169a9f7a3df75a204536af7add4dd42265ebd55c82a195edd0f54d44e30922ade74b81412dfc07f1ece2a97a1fbcb8d4fdfca0a4880fb1ccee7fd82c31e23b27b7b78a7b4a661f4ef0fc172bf4b00f0c09fe36e6767bcec42bb80201f979583aab9962d96dafd7e14f94f68fcafe0fb43c1bf6fe60308fdb410055ece5fb4516d701d6a8a02a33ec1534c2d3d3adc842ad2c4c8644eee726f0674d2bb4f0199ef140ea8b1f061a30453af30ef1cda5e12dd6453c1ccf4fe916e2c94d52d20e847f799149ef0a9b10f3d5e9fa092db538d21506246015369a3659c660e4d5efc6f6a0a6ce4ee2b88ace3d9c19339ea5606feabf8533acad23b6b21d974c757dca087fc1dfca668292f7469b1d523e15acde24fab9ad693edc54c0637ac27454c82a0d2a5a05e4be26c077062a9001b921f4627b70e3abe572e2f613d0d68d7d11dccfa9e7555514730cab840f7711b87342f0a9f531b4c110a063f33e31aad62f3e895137364b3fd9abe4e5453a953773677b133307976da2825e29abe02778b, 2),
(67, 78, '2021-09-13 21:20:46.327688', 0x36db32aac2b54599ccebac4cfdf8a3c56c01871bac918c4f8d745e8785f59843ca0a50afac15334c6238fe4113496b5d4f91c3f55639d59a3e7bd6481ea8b6648f8b9bd7d00adbc41e6e1f9aa5c2f00fb65c68a4359fa3f4bd9d003aed2650bba152f8a5040d7e3150d0ffae8d377bd23fcfa2bb5abbedebfa8dd453d26cc42b, 'LIEUTENANT, COMMANDER, DISTRICT_8', '128,128,128', 0x8fdc8446324273c690b70d1426a14ea122d7e8643a5cc0e603cbcd217100d60bfd57ddbafa2db93c38ad38bdec3fb86d21eee0f161637f959ecb87b8aebfaa6787892a07ed9e0b2140f91987beee3cdd312163b944c9562fed285dc2512f70959c81c0463563a082c49b9ff632ff4e0bc73b8f26db6e200f5b589d5a1e67756e96b4c877b6fc58f4ebac2af1a4e1c6582f2a382ba3094429782dc8645e95bba48b487c15f0d91df8709be065cb82dcfda9ca93082d6ae1042275ceb4b616be587a60c4ee2c512ea770b1da6235d396e96e8eb340e47461283202262b613a70670b29ef9818fe4f17b35b7d296d08d9236da64946b358f125d6df0138cc3400a70ed76fe8537bb0dcaf1b5af308000c2140d8365c47ed851835e482201a577c325fdffd061f2b5699533155bb251fb2961f62e66e99957edbec9af7a0969092916e4348b04705e4abaebc36671ae2508ce4eda0362e264af4d402154c3f9d971a2280c94880a964554efe55904c044840c1f7c8eb2f4e117175500df7061a5c34, '17,1,34,2,4,8', '128,128,128,128,128,128', 0x57c9a46549318de3e638b40b70732d67234f806da71f4ebfe09b27b42190d0f429104d447a7c6f8945a085e0aa6e5f0e7adf7cb5d06f865b53f5a9836dff69e16f9410ed89c71497f5214b074f03da347e5e326f8ae94494ef1f94e80e54453b1736d600cae8a262416f461f2a53c4991ef0f15d1ee26ce7e8211f6b554adcbd21f32573df8d1d70989342c0abebdd660ecf4b173629e5260b9c1476b5185b0384ec81173e47ab103981a3a5b2b5ce38f1a84ce5570d1873ca42b631c14e3577955b1f1a2cfbe072e510e42e2dc3a15ad3f7d4d4de27e75fdba1d6b1cb282e8b242b9d4007e7827a16c94bf6563e14191bd20b6914fcc18072e282a7179f577508715b2245d1820073f442de403cda54c4ffe5e5d4e7f34464b20a93c9266d05eca296d29f9e80a7ac949a55faba55cde2a084cdc69b6e10069de721c992a5275c7552620cb21c3c25e5a6376208b851805e74701ae07f9893adf69aefc14fce80111f1667c840e9f9da64b6f90b527bda0d25737b1931528a3987cf86cb3d4a396faf6b128bd7f72c8e6572f39b779fe23a9bca515c4f5c29a03ec4affffae6c7d5b5668a26bba0eec9496de1f4ffd8413c66934d75704bed1959d9d9ae580844b8199cf010eb8a2d8d76098e8d47e0df52b648fac822d53a57e1b5e2d94974e43b2311d9a7b90c80249dc6dd91cae24dca967b6a4b635f70f6623b868e27019cf06c5cd8f1f8f3e0f2c7779377d0e1882c2c99a422f58cd4d73002bfda4fb2d15064df20e081c6482e3f9fbea87aeedbf84cf5fe99d824cf6e3312bc9fbbf30c26ea00db61ae3a1d12df30cc06a923444eab1a8c8bf3270ffcdb1e57b6bfbdc7790a95d58d7ee4b049347bede83a4008240bdd9533643ee90fefb1c4edc55fa6e4e5c209a28bc8b8146b714944d77a2c919c1ba64e1373a8cfc84531cab8027c5cdb02aa0f5dba6954b5701d11bdedbd31b9f078d909a7e4f6bd9e92f969620b8171aa96f71810a3844cf0618bdaba135d3f13bb935b7fc0ee810b75ac380f4b178e8a8d27e9096e835566c9c3e9ddc1ce47928a760b0c958b9188945992c1, 3),
(68, 79, '2021-09-13 21:21:02.327170', 0x51401c70d2d5d57fad38e3bc6ac60a4e2a5c9882b737d3169f5b6637be4d90ad7ec2ffe8a7d268dbedca331243a74a1432b2edc3c306a3b9d72a7a46d7bc062c6edb143563548181f60cfbc00d4db099ee9fc0c1ee99597c1015e3efc4d0864ac50373741894ebed00f0cd4aa384c2b6a39665ebf0f056216b02e17d6c90bd4b, 'CAPTAIN, AVIATION, ENGINEER', '128,128,128', 0x5f96ec2c519aa0e771d07111c893b9eb0178a80d03f2eeab4cdc9fc62ced848c2cc3b29f702364394aff31ba9054c8de0d66be7b5db3aabd1071fd28c8e3b1873eb5ca67c6f028b3aba1bf952435597c56778ca4d300e5cb4c0952297c366b212e4da5141dd765a10b455e773d30bdfaf16bab923f5d84cafe82355a84a4aaa2a6c9f5920da981cdbd9eb337777a7309649e498c92c4ff2bb662e6bb440ad8a02a6c208b787c3849c158e8e3befe730558dca383579cfd7ba33d66777f80e77a8838e7f3de6c2cf249e4956bb33a85f5e5544d8518ca1f512fcf341a718078923348e49f7122731698c74855e2c90893f2e8f0068afbfa3fae18326a7eee92dc0339e461c20607c9074cdb3f9bcd0ff3fedf0d4b102cd0630b31d2bb362fa2bcb9a692f6bbe1def5f7bbc2f7d454ade91012b0b3f661b83679cb25869ddab20570798969aa7a05881e1848a9fb20960d21894822eaed8fa12dd4341841c626d402e0f78ca303352913fe04b4116cc405955fa514953991e4055bce2bfc7fc343, '16,1,2,4,8', '128,128,128,128,128', 0x424228afcae1461ec42a328176644720e6dfc263f23eca234adb21e65e83512f2dd31daea19faaa3aefe096be33e7cac2d20c966c15bd5e01bf7d4518e84e26736ec66be209c791da40c0ae26e8554aa117cc7bb6b347242cd69a8f446176df9fcbcc98367f76fccd2e5f856eee2dfe76d31cae2a7dd413485551ea37a6194a676339d988b84e118126d33fbffeabe58b973b9e41b2ec043be970565e5eb7a604cba051ef3d2fc25003574322529c04b1fe8abffb8089075fd6a7a141d1fe75e5ff66d53ea1c1bcc6e39b67c44240695c3b4de98ae56b874ed487df8adc4044d58e7db9f3bd9a016372efe90c3b56a55cc77eaa70635da4d95501dc3ab158c498d5c10dc30671da55778227723a4a396736bc3e9955727041f67ddaa439351022262b836bb3534741866d34a622f04b8fb39a1523724dafb84d15f845d951daa2f2806d7c4ab050cf435ad90ec12d0879bb6c3ca83a944587671a2654b64a30a7509de363a4902d94c328bd743d34403d8667357733e6d7ba60ad3de32eaed289b2a71d99b8a5ae20394d882e5667c021d2a0dab15f40f4445f9fb07b2fe4d3e19f55738eb823fe429a8e6b5753c107b4d748f89615fad39e58c52c650c480b12b7b156cb566e39c006b597e5828b36ff5b648e0555d0c279e9dc4494a435018cf123344f97c35e3a5d3156e7d7e3a75a67c23d8b1aab0f42f49d21a99e520039a3f3a7de6a89f7914eb7bc5639341556d789655a5b0923223a2b5d8c83ffe0f692b17a6454570e3f2ed08f79f7dc795c219641c94a97bcdfa2140b5bb9c6d9e7034db36b7c816b949a4f0416c28f54811746a3630d5089021f2b1eedbb7d624ed8572fab620a6dcab1803d521c29e2aa7bd34070dc7694c57bf1e3ca4540fa9, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mission`
--

CREATE TABLE `mission` (
  `missionID` int(4) NOT NULL,
  `missionName` char(255) NOT NULL,
  `missionCode` char(255) NOT NULL,
  `startTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `endTime` timestamp(6) NULL DEFAULT NULL,
  `g1_alpha` varbinary(512) DEFAULT NULL,
  `beta` varbinary(512) DEFAULT NULL,
  `capacity` int(4) DEFAULT NULL,
  `g1` varbinary(512) DEFAULT NULL,
  `g2` varbinary(512) DEFAULT NULL,
  `g2_beta` varbinary(512) DEFAULT NULL,
  `e_gg_alpha` varbinary(512) DEFAULT NULL,
  `g1_a` varbinary(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mission`
--

INSERT INTO `mission` (`missionID`, `missionName`, `missionCode`, `startTime`, `endTime`, `g1_alpha`, `beta`, `capacity`, `g1`, `g2`, `g2_beta`, `e_gg_alpha`, `g1_a`) VALUES
(67, 'Reconnaissance Area 5', '1326925438', '2021-09-02 10:00:00.000000', '2022-09-02 10:00:00.000000', 0x8919d84854f8d36e01ebd46024fc5eb33c0a9d415d263ee32553912de5b2c3c3521c6d15b71ca332e024eadde46cb487cf4670b0eee55b30fd0e08440b2accbc0c0beeabc5004ff1228fbe546a3274a4b61c4c06cbf5907f316db298719b41007a20b80d20c6cda6d934a18617b2c1ad6edd28fbbf8f2f792fb7b1b0ec93cf14, 0x262abd741f59ec5b17b274ef35b82e89b0f7ba0a, 25, 0x48c57427ffd3514a3e2dd4c7ace1b0b16f03737054fd05eed3ebde7661c8dbfaa184fdbd6cd67a5eae3187259c1699f60f74ddc2c7e1c37fe929b6746d65f2039e01783b75b9b1070f9b4334f86eff401b35bb2704e63deb01475380a61ca2a1ea381ab6f2f710b5a354d94bbeca857b576ffa1319fed5805db61794f1445ffe, 0x3ab67eef8a93139ffea5649a1e631d1cdbef130e184d3ac2bce25e77073ca34a6852e93f8cb7d15d7791f180ee97602772659de3de34d0d75e01fab3e5f33a9678811ecb7b295b9d47ba688548c1ec542ee72b710b91466004b7eee469327d729af9819e63f4019f2969677aa2095256840abc6e29d8c0a1d71d93c91e21970f, 0x97b02f7d3de6d6f74b334aa88764efd4725f3df99f92e0d7fb88ca55172ecec4109ad0bcf5f6813d0c2306457d588e9b0f2c6a0562ec12f243b4863178050e59240c7ef3bf1967abdcc694f40974ecae7f76f15045416913af539ef7baf9c1e5f659651938303e339015cb8a158b0ed998b0b7790dd07000527925a2863ae4a0, 0x7138359e9dfa9c21c21e5bf69510d1f87f63abf35285243ad4b23cc31674a30209f7e11a0c9a965276cc0f354aa428b2e19a1deee10942bd1e0c8663b990d4b8910b995d2cec0ec6bf3b4433b87ab3e3315f35deae784cb1e64e33db35cc6f7f1ddc1cea9290dd578f0660d4d866a9592d9d50a0d05158d39d34a2b861c0b887, 0x985c5a09094ec0a3ce458281178eb8155f99c7cfc9e5782aeb3776801f569fba28f62b2df4eed094b7dff2cb50d05f94cb076b2b11b5e7d78d769d8d56b4d003588622a0dfe39ff8fdc1ad3059c58ea20c3d9ea9b8dcf32f4893618003d8ba8085afda12e050109bc2968c1f4a63499e8e43c00eea7fd46b293114cd442d8275),
(68, 'Backup Area 4', '913169683', '2021-09-14 02:19:57.357000', '2021-10-14 02:19:57.357000', 0x34df946e1d7af96cef210240752343d8f08a6a5d00ba9ed12ebe5c2f218de5838ba91c952edcb5a73bfb8dadb878c20a1e831abb017a2be56a2d6b15f3e53a7814fc930883a3d25130085193d0c890f0b27d78bdaf389aef76bd3b2d1f50725048af8ef738f8ce822b2ba3b015b8ce7ddb318069ac70113b01ea6a6c0b774548, 0x29552decfa52c0579d69125add721f14e5f0e496, 10, 0x5b223e82e1fb32750458c53b327dde13213b817818f7832c87b88fba34992308f0767afcf54d78ffa45190502f82431c5ed04aecc482c8a097b96af2c2c231de1f208c0fa61c0e59cb059104e69c076a342ccaa4b74dd7ae5970ae16d47849f5e012a507a0a8b6b7e54f71266fa6cb71cd7170ddb4c68c34977446c1bbf0c9b2, 0x70c0f5de62d7e8f309d13318a8104c31b2e366f42b2178e955a3fec79fa0e09767d4224e58678272c72763ec776f744d6548695f6e5288a214d4b2576a5db6c20c2e0f19e9b39c0c874cddbda7d12ccb48ba1d2f19eb8dce03ec5888f041d56d77a72835ca6c1bd364ed0525504558af191e50646e981ccf8a8a2caebdd9faa9, 0x2d6af043ba0abe6e6fca4952de7f24bc457d509172f7b2001a1a8454906f3a0f6647b794f748dc416e20d9b5846b49cee5824be67a6cea6e90a70616fdea69c875a2d46e7dafebff44ce6d8521cc72fe88c08c8d44dbcd0e3b5eac5b154eeadf0446bc739dabc38973726dd79384b93aee9a5bdaf4f4030bb2801063e119ceb1, 0x6b7267fb638b33c63843b967e8778cd4e20904cd580a2d064ee3face07e4cfe51109cbcc87f1aa1475774dd2479c0ef18b70db9189c3c2391f410d8418f8e7ab26a80f7c95c92dad122c0c421f762579fcdb79209a8031c3b1c912d68569b84e6650b55f3a832723ab16d7762f20d758f04e26d20a66d61be1fcf4ea1fce94cf, 0x4c2fa7a5420fd3a1531fbdb46f12b403d5092ff0040e3c261e6832399c5885e7f8847fbd4a701679af800fd5fbd6f90faf05cdb595de8ec7525accd80bd2728a059930d9742f0eef0ca6f1983008c75ab9cdde5f4e8372c980e1684161983f04f3f2680f2ed0209afd746c4a21e08cad537612f13333ac41ca98342d1558a482);

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
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expirationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `username`, `password`, `attributes`, `firstname`, `lastname`, `registerTime`, `expirationDate`) VALUES
(76, 'Alice', '1234', 'Sergeant, Armor, District_8, level_9', 'Alice', 'E', '2021-09-09 19:58:24', '2021-10-10 00:58:25'),
(77, 'Bob', '1234', 'Specialist, District_8, Chemical_Corps', 'Bob', 'E', '2021-09-13 21:14:06', '2021-10-14 02:14:07'),
(78, 'Colin', '1234', 'Lieutenant, Commander, District_8', 'Colin', 'E', '2021-09-13 21:15:45', '2021-10-14 02:15:45'),
(79, 'Sam', '1234', 'Captain, Aviation, Engineer', 'Sam', 'E', '2021-09-13 21:18:03', '2021-10-14 02:18:04');

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
  MODIFY `missionID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
