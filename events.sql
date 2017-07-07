-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 07 jul 2017 om 14:13
-- Serverversie: 10.1.21-MariaDB
-- PHP-versie: 7.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `TIME` time NOT NULL,
  `DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `event_table`
--

INSERT INTO `event_table` (`ID`, `SUBJECT`, `DESCRIPTION`, `NOTE`, `TIME`, `DATE`) VALUES
(1, 'Test', 'Dit is een test', 'Test voor CI', '03:12:21', '2017-07-19'),
(2, 'New', 'Test123', 'New test', '05:08:13', '2017-07-13'),
(3, 'sdsdf', 'sdfsdf', '', '01:01:00', '2017-07-06'),
(4, 'Vakantie', 'Frankrijk met de fam', '', '12:00:00', '2017-07-14'),
(5, 'noordwijk', '', 'bas gaat mee', '11:00:00', '2017-07-04'),
(6, 'uiteten', 'witsand', 'ik wil pizza', '20:00:00', '2017-07-05');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `users`
--

CREATE TABLE `users` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('Maurits', '123'),
('sad', 'asd'),
('asd', 'asd'),
('Testuser', 'test'),
('test2', '123'),
('bob', '123'),
('bas', '123');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `event_table`
--
ALTER TABLE `event_table`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `event_table`
--
ALTER TABLE `event_table`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
