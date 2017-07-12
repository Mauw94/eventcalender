-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 12 jul 2017 om 19:19
-- Serverversie: 10.1.24-MariaDB
-- PHP-versie: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `events`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `event_table`
--

CREATE TABLE `event_table` (
  `ID` int(11) NOT NULL,
  `SUBJECT` varchar(30) NOT NULL,
  `DESCRIPTION` varchar(50) NOT NULL,
  `NOTE` varchar(50) NOT NULL,
  `TIME` varchar(10) NOT NULL,
  `DATE` varchar(50) NOT NULL,
  `ACTUALDATE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `event_table`
--

INSERT INTO `event_table` (`ID`, `SUBJECT`, `DESCRIPTION`, `NOTE`, `TIME`, `DATE`, `ACTUALDATE`) VALUES
(4, 'Vakantie', 'Frankrijk met de fam', '', '04:15', 'zaterdag, 15 juli 2017', '2017-07-15'),
(17, 'Koffer inpakken', '/', '', '14:00', 'vrijdag, 14 juli 2017', '2017-07-14');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `tasks`
--

CREATE TABLE `tasks` (
  `ID` int(11) NOT NULL,
  `SUBJECT` varchar(20) NOT NULL,
  `DESCRIPTION` varchar(50) NOT NULL,
  `DURATION` int(11) NOT NULL,
  `ESTIMATED` int(11) NOT NULL,
  `FINISHED` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'Maurits', '123'),
(2, 'Bob', '123'),
(3, 'Testuser', '123');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `event_table`
--
ALTER TABLE `event_table`
  ADD PRIMARY KEY (`ID`);

--
-- Indexen voor tabel `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`ID`);

--
-- Indexen voor tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `event_table`
--
ALTER TABLE `event_table`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT voor een tabel `tasks`
--
ALTER TABLE `tasks`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
