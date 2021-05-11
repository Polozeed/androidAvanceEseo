-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 11 mai 2021 à 16:24
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `test`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
                          `id_client` int(11) NOT NULL,
                          `login` varchar(30) NOT NULL,
                          `mdp` varchar(30) NOT NULL,
                          `token` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `login`, `mdp`, `token`) VALUES
(1, 'couriemaputmodif', '4567', 'def'),
(2, 'couriema', '4567', 'def'),
(21, 'couriema', '4567', 'def'),
(27, 'martin', 'ezz', 'eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWFydGluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYyMDI5MzU2NCwiZXhwIjoxNjIwMjk0MTY0fQ.HsoFA-IoAKyBa70KoK0b-HH_S6WEIC5fEMGWN0tmUbTum3nLW5tnmI-dh_J2TXWL0gY6jtYCPcEOhGfkeUqOqA'),
(28, 'martinaaaa', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWFydGluYWFhYSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAyOTM3NzIsImV4cCI6MTYyMDI5NDM3Mn0.nwLQ4w-1LQBMJVeGhJRAKmc1YDjQM8rv58I3qd3PLVHtSjkIibMkuTeP1sy8UXEjxNC9D-YqTJDDHnxZua48mQ'),
(29, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjA1NzY4MDksImV4cCI6MTYyMDU3NzQwOX0.Y6LDSwl7tprvO2jpRkRDcwnm1cFdLlE5pTn-xM32kcsQm0Gk-oeHyAWalGkbuSM09bRIMcCpmrWDmZhW5cCnAA'),
(30, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAyOTkyMjYsImV4cCI6MTYyMDI5OTgyNn0.PGlKJ0fCYlk8Mbzh8hfcxhMCNAhxdQqKSj6WLXoS_lns_DAqv1nc4Vky4xmBlhfjGBWdD5-WO4a_81NpWtq3rA'),
(31, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAyOTk2ODEsImV4cCI6MTYyMDMwMDI4MX0.h2CeFn6LSUkc_jWFKX-7dzPaVCVSqtycbuTM-UWSlpnCSUUZWgLw3f94olcRHW3XG_o5DtRAtIY0OidAhiy6KA'),
(32, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAyOTk3MDQsImV4cCI6MTYyMDMwMDMwNH0.CQRDxRvZMoHHwtDSfIPWMJHDhr0E73I4iFSsLxm5htb2dbntHWEE9j2Dbhj_6mxX_TnttfsD5AnaTdDP-6Z0dA'),
(33, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAyOTk4NTMsImV4cCI6MTYyMDMwMDQ1M30.W6hGGAgYCCJIwvujATw9GiGM3l0pbUYN9qFFvkdVXQwvIvwWWwsGxThOoMJMsXHwXvtLwIU6WhOwDO1X-DRFkw'),
(34, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAzMDAwNjMsImV4cCI6MTYyMDMwMDY2M30.0aN3_uFjRm3DhQduBXB_QosbE1Gn656NJyA24c5gb9TRsYhJUAfzpuXa6aTBlblUrjekgaUrY4k0-Kcl1ZCTjA'),
(35, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAzMDAzNjQsImV4cCI6MTYyMDMwMDk2NH0.ylc6UCyI0h6b-CFrdLWK4iYD5xydcyXJ7pcqOf5jTJw2MUmdq3PoCFy68TaC_Zv8Tgac-9eXoZGRdmoBkgCYcQ'),
(36, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAzMDIyMDgsImV4cCI6MTYyMDMwMjgwOH0.QISBdQTGcNzbOuamUDoVfKigAiVAbSQfT9BSzeRGL9SyHdo8dCKxZnKAftvwFu9R3SKc9baooRGcbqQSZDi4MQ'),
(37, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAzMDI2ODUsImV4cCI6MTYyMDMwMzI4NX0.nlVMSo7s_ekYR9DbywWFX7QFDnlUYRnG8HpzOWvT1dxB_BdPxY1gBuxH5Mp9vGXu5yBdgrLnPdLu6nyb4npu8Q'),
(38, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAzMDM0ODksImV4cCI6MTYyMDMwNDA4OX0.b6dHt4ti4jrWL-R3BYVlzHny_6ErU11CSNlTx6uDjixh1o3Gps5z6AwWjbxf2hVid_c9-eV2lwCgf_khtTmlGg'),
(39, 'm', 'ezz', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjAzMDM1ODksImV4cCI6MTYyMDMwNDE4OX0.OLVZ5sv7w6x_a0kOtWRuC8Q3G-MumnhuijrodIxXOYhlBtjIJjIVPGOaSVTi_g9WRPuTKIihJjSHh4RVnm7lHQ'),
(40, 'maxime', 'test', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWF4aW1lIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYyMDY3NzA2NiwiZXhwIjoxNjIwNjc3NjY2fQ.-KoHPj--h6GlvmJ6oTbdp2vcJrolklqy_vnyp3DusjRQg3Fhd4qaNXoWxFo65syNnTFEx1HiGfnWyk4iTkxnfw'),
(41, 'maxime', 'test', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWF4aW1lIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYyMDY3MTU0NywiZXhwIjoxNjIwNjcyMTQ3fQ.ABWS7Tsluzx1SValuZKVWWeu-O31Vv71ukQ6WOfWUl0OZLujRzd_MA5gKJy4qttH_cIhpX5GFLd9XeMI4H1mqw'),
(42, 'mar', 'test', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWFyIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYyMDY3NzA4NSwiZXhwIjoxNjIwNjc3Njg1fQ.MDrXXVrt7DPD4JcZu7I4IXBBIUYXd7TDp5ADchqVdswWZUnSx4nNsx4ejjA-5DUeo86WBZleTGcLUFTZyjZblQ'),
(43, 'mar2', 'test', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWFyMiIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjA2NzcwOTcsImV4cCI6MTYyMDY3NzY5N30.qlit1Veg9T9hxZQIVYSohsnCO6jpVNQ_BxRfV9VzWE58LU4kq0N8YGkJLaPXZ71vpX15GmxIRvtgMRp05l2yuA'),
(44, 'mar2', 'test', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWFyMiIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjA2Nzc2OTQsImV4cCI6MTYyMDY3ODI5NH0.HIM9Qw2g2A0sudiJ95seVuw5onc38dhJfqEcELOAnWKU6BWUPnapX7QpIqA_-ymPz0nxIpTmFTIzNK_niYINOA'),
(45, 'm', 'test', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjA2Nzc3MjgsImV4cCI6MTYyMDY3ODMyOH0.ZKoVKGaQi1RcWvyG5Vd2Hd6Z_CLAWU2j0c-fm7Y3W5n7R1uIqsOqf8anQA4Gkb2jVq9aVI63LddCqqQP1Aq8UQ'),
(46, 'm', 'd', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjA2Nzc5ODUsImV4cCI6MTYyMDY3ODU4NX0.mTZ_UG_1Bkuun3FrvoAOQ6ACTx_LKm_k9ZOb4y629wYmTY3yYpf2jIconSb8ezyn_L7xVLDS1EgKvLCWO2p5eQ'),
(47, 'm', 'dd', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjA2NzgxMTEsImV4cCI6MTYyMDY3ODcxMX0.kP0-kLnqyNfYZWOeMO6yB6yoIi-rHvof3g6MEp_GsF6yFzxvMRfug-jVaAJNpf32Ok9q9bybF3LZxfxyzrz0QA'),
(51, 'modif', 'modif', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MjA2NzkzNzUsImV4cCI6MTYyMDY3OTk3NX0.1GpaBRsWon-4CUmTDO-LyZXz3DNzFepyejj2yiokuO9beoXQNguKVKU8E2VItGW-6H4s6_aEDMvFSDCoZFZVWA'),
(52, 'login', 'login', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibG9naW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjIwNzQwOTgyLCJleHAiOjE2MjA3NDE1ODJ9.22-9IAYWad5-erv1Af1D3Mk2EPk97mXjmd-tTb2Dw5f3ntqp38gJAoQJMOKEEHJFdFwHV8jL8Dqmqi6sHK8K4w'),
(53, 'login', 'login', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibG9naW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjIwNjc5ODcwLCJleHAiOjE2MjA2ODA0NzB9.DABZDP5khfYSYd-cr6iZZGAASdiWAa43wrPnjhyqPqZd8yCmUFR94j8Ht0bqhUOC323zyuEVeZjSPo3p5BhG7A'),
(54, 'martintestId', 'aaa', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWFydGludGVzdElkIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYyMDc0Mjk1MywiZXhwIjoxNjIwNzQzNTUzfQ.q38ni58MJLzRdSrskfDm0O8TRBmVOnzaULwDwQAo03k1gyLKHCFZ0_r5rYxPzxoVP36oRjSqZqt1eAdHID-uzA'),
(55, 'login', 'login', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibG9naW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjIwNjgzODExLCJleHAiOjE2MjA2ODQ0MTF9.3B43YpmXj2m36Gg6M-U2f8qQm5oI4RosY3OvkIkgBzs-KREXA1R1lzLJtPYqHogeaBg-NWtAjVJuLoThm78peA'),
(56, 'login', 'login', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibG9naW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjIwNjgzODIxLCJleHAiOjE2MjA2ODQ0MjF9.WhlYbJ512gIJuOO4lICmDZd_xzGEVcP7PjJ2tIZWhU3HUiP_5Id5yfE1lk0yzfK2oUbighEQF8mpXHlDb9UnLQ'),
(57, 'login', 'login', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibG9naW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjIwNzI0OTU2LCJleHAiOjE2MjA3MjU1NTZ9.ASmGFcuN-8J_4Pq8J8iPHoK8i1MKKdd1vGQKrweh-yOQPXqcsfCE2K4kvhta19asqrhKflG2SZ-1xBv2y1UAVw'),
(58, 'martintestId', 'aaa', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoibWFydGludGVzdElkIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYyMDc0MTQ1MSwiZXhwIjoxNjIwNzQyMDUxfQ.xp8sVg5BA1KIukXEZclH-vNGCJynAp_6d9_TdVWQbVd9eoiK8_EAq3q5Jx2bZltYJuHbD3TAuzP6Qu4c_P2mDA');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(63),
(63);

-- --------------------------------------------------------

--
-- Structure de la table `historique_api`
--

CREATE TABLE `historique_api` (
                                  `id_hist_api` int(11) NOT NULL,
                                  `id_client` int(11) NOT NULL,
                                  `dateheure` datetime NOT NULL,
                                  `id_info` int(11) NOT NULL,
                                  `type_comm` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `historique_api`
--

INSERT INTO `historique_api` (`id_hist_api`, `id_client`, `dateheure`, `id_info`, `type_comm`) VALUES
(1, 1, '2021-04-04 09:09:12', 1, 'get'),
(2, 1, '2021-05-04 11:11:12', 2, 'post'),
(3, 2, '2020-10-03 14:09:29', 3, 'put');

-- --------------------------------------------------------

--
-- Structure de la table `historique_info`
--

CREATE TABLE `historique_info` (
                                   `id_hist_info` int(11) NOT NULL,
                                   `dateheure` datetime NOT NULL,
                                   `id_info` int(11) NOT NULL,
                                   `id_client` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `historique_info`
--

INSERT INTO `historique_info` (`id_hist_info`, `dateheure`, `id_info`, `id_client`) VALUES
(1, '2020-10-03 13:09:29', 1, NULL),
(2, '2020-10-04 14:09:29', 2, NULL),
(3, '2020-10-05 11:06:29', 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `information`
--

CREATE TABLE `information` (
                               `id_info` int(11) NOT NULL,
                               `luminosite` int(11) DEFAULT NULL,
                               `proximite` int(11) DEFAULT NULL,
                               `gravite` int(11) DEFAULT NULL,
                               `acceleration` int(11) DEFAULT NULL,
                               `latitude` int(11) DEFAULT NULL,
                               `longitude` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `information`
--

INSERT INTO `information` (`id_info`, `luminosite`, `proximite`, `gravite`, `acceleration`, `latitude`, `longitude`) VALUES
(1, 0, 78, 90, 23, 54, 31),
(2, 54, 65, 100, 0, 89, 9),
(3, 45, 0, 100, 19, 9, 43),
(59, 0, 78, 90, 23, 54, 31),
(60, 0, 78, 90, 23, 54, 31),
(61, 0, 78, 0, 23, 54, 31),
(62, 0, 78, 0, 23, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `tutorials`
--

CREATE TABLE `tutorials` (
                             `id` bigint(20) NOT NULL,
                             `description` varchar(255) DEFAULT NULL,
                             `published` bit(1) DEFAULT NULL,
                             `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
    ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `historique_api`
--
ALTER TABLE `historique_api`
    ADD PRIMARY KEY (`id_hist_api`),
    ADD KEY `id_info` (`id_info`),
    ADD KEY `FKce3gwl3c2wmwmpos2kp1aj010` (`id_client`);

--
-- Index pour la table `historique_info`
--
ALTER TABLE `historique_info`
    ADD PRIMARY KEY (`id_hist_info`),
    ADD KEY `id_info` (`id_info`);

--
-- Index pour la table `information`
--
ALTER TABLE `information`
    ADD PRIMARY KEY (`id_info`);

--
-- Index pour la table `tutorials`
--
ALTER TABLE `tutorials`
    ADD PRIMARY KEY (`id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `historique_api`
--
ALTER TABLE `historique_api`
    ADD CONSTRAINT `FKce3gwl3c2wmwmpos2kp1aj010` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
    ADD CONSTRAINT `historique_api_ibfk_2` FOREIGN KEY (`id_info`) REFERENCES `information` (`id_info`);

--
-- Contraintes pour la table `historique_info`
--
ALTER TABLE `historique_info`
    ADD CONSTRAINT `historique_info_ibfk_1` FOREIGN KEY (`id_info`) REFERENCES `information` (`id_info`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
