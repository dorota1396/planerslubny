-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 16 Sty 2020, 15:06
-- Wersja serwera: 10.4.8-MariaDB
-- Wersja PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `users`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `budzet`
--

CREATE TABLE `budzet` (
  `idBudzet` int(11) NOT NULL,
  `produkt` text NOT NULL,
  `cena` tinyint(1) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `budzet`
--

INSERT INTO `budzet` (`idBudzet`, `produkt`, `cena`, `id`) VALUES
(1, '33', 0, 15),
(2, '33', 0, 15),
(3, 'co tam df fdfghhfhfgdgdfg', 26, 15),
(4, 'co tam df fdfghhfhfgdgdfg', 25, 15);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `goscie`
--

CREATE TABLE `goscie` (
  `idGoscie` int(10) NOT NULL,
  `imie` varchar(45) NOT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `numer` int(11) DEFAULT NULL,
  `id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `goscie`
--

INSERT INTO `goscie` (`idGoscie`, `imie`, `nazwisko`, `numer`, `id`) VALUES
(1, 'Dorota', 'Kusek', 668916243, 15),
(2, 'Konrad', 'Czaja', 794335639, 16),
(16, 'Adam', 'Mickiewicz', 12457869, 26),
(17, 'juliusz', 'slowackinierobilkurwaczemu', 667564543, 0),
(18, 'tghh', 'hhhj', 2555, 0),
(19, 'dd', 'ddd', 2555, 0),
(20, 'hhh', 'hhh', 222, 26),
(21, 'fff', 'fff', 3333, 26),
(22, 'tadeusz', 'wajcheprzeloz', 666666666, 26),
(24, 'd', 'd', 3, 26),
(25, 'tyu', 'tre', 336, 15),
(26, 'd', 'd', 36, 15),
(27, '', '', 0, 15),
(28, '', '', 0, 15),
(29, 'tggh', 'hghhh', 2258, 26),
(30, 'Adam', 'Malysz', 22569805, 15),
(31, 'Kleofas', 'Majtek', 3365285, 15),
(32, '', '', 0, 15),
(33, 'fag', '', 0, 15),
(34, '', '', 559, 15),
(35, 'ffg', 'ggjn', 0, 15),
(36, 'xcgh', '', 6666, 15);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`id`, `name`, `email`, `password`) VALUES
(3, 'haerul', 'haerul@mail.com', '$2y$10$ljtu9WyH4PI6C562LLndLuMlfSczjUqfHQlTocGu0AXndaMUM0FQ6'),
(4, 'new user', 'newuser@mail.com', '$2y$10$4AbU/IjNMTCimsdOFIzj1.JFuamHLhe/Vu0/EwR5yiIYTXvPvavZy'),
(5, 'Haerul Muttaqin', 'haerul.muttaqin@gmail.com', '$2y$10$GPkTIe1BotEUFzI7vPB0R.2ILCJww79vE4hRfJ8NFTVx8hsKFRqXq'),
(15, 'Natalia', 'Natalia', '$2y$10$woU081OVryU5fvBdD6EDh.NtcTmeNaxiddnc6y1xGkDTQZ30CnL.u'),
(16, 'Maciej', 'krowa', '$2y$10$kuLaCtLZgPqb5NPjAMqmOOnI3hkg1ZZivkQMfijAXeYUIWBJv7EqS'),
(18, '', '', '$2y$10$7r0UnulrkT.2Ca8mq5zLquYr8oRnQYEANfAlOlRhd97KlG55M31AC'),
(19, 'eeeeeee', 'eeeeee@op.pl', '$2y$10$9AvRFAnvJym43nMLCju36u63K0hWVgmc/qeKZmpVhsGl0Cr5I5FiO'),
(20, 'oooooo', 'op@op.pl', '$2y$10$XwvWGooQGBtnNqRoPM79aunk2GPPds2jieL47sRPxdpYKXxC2fUJK'),
(21, 'ffd', 'ddd', '$2y$10$9aluN4GtALvpZi2x/xdUTezbCI.PLd3CI1T7U.RH3/dV732W8tf0.'),
(22, '', '', '$2y$10$75nRlCQkIURCwYd3glA4Bu4sj/V9OPlAhNbLMJn18C9MPbT6PT8aC'),
(23, 'Rafal', 'ggg@op.pl', '$2y$10$j1oEzEScPKuEUa.UvxOU2eN1BS6wJ8BVR2wiOuzSwZqUb.c6CnJ42'),
(24, 'ffff', 'ssff@tgg.pl', '$2y$10$7Xst/k3Z5WMwV3kfN9c9iuNm.YYIE1egdu9Na0RBrR3GfuKhsz1pW'),
(25, 'Dorota', '1234', '1234'),
(26, 'qwerty', 'dorotakusek@op.pl', '$2y$10$DW89kuMsEEzA2Ph.Y/XMUuW5v2NzgslGePXUAxdFikcvhsv/UskD.'),
(27, 'cvcb', '', '$2y$10$bV.otPdQ3IWOI0vtcoFVwe4Fo9dgdzHe8mDCELrjnwkbB8hTgbW7i'),
(28, 'fddfdff', '', '$2y$10$ZNMqPu8b1ZGNzZN9nQGmZOx0N72CZSdVm/SWBQ98g3Hn4x5P.nRUm'),
(29, '', '', '$2y$10$fcqoZzX.LwhK0LZdEgRL2uMjiYP2QsqvQ2xNivYeozoL7BxQrkfjS'),
(30, 'fddd', 'dfcv', '$2y$10$2K4WajQWzBPVEfuGzZMeSeqOUdryMnSlE9aJ0vDyXYw5CQcCbQSSi'),
(31, 'for dft', 'cxcc', '$2y$10$rpKGtwwDjGHhnNumcREU8e8Gl9Ypko9Z2wq2cTO8vSW7MO3TX.A7q'),
(32, 'Dorotka', 'slonce@op.pl', '$2y$10$yGVcfv8.PYPTB9Ix0o7qlO5MEUzduPvVO8n4Iz6NbGvzb/yg7LXQy'),
(33, 'fff', 'ok@op.ml', '$2y$10$ecAvhFp6l2an7nV60FWmT.8C/MPEIpo0zg.9sMfOsyc761B480maK'),
(34, 'fgf', 'gfhfgh@op.pl', '$2y$10$mqUfIlQj98tb1ylN7zmk9ukG4K465aZ3PeYcrwb6v7a8guUWbjLHa'),
(35, 'dsfdf', 'op@op.pl', '$2y$10$qaZRy6gB6rHjA6c9zR0tQel0rPwzVWrtTEG/4nBg7IBl7LIFUUyGK');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wykonawcy`
--

CREATE TABLE `wykonawcy` (
  `idWykonawcy` int(10) NOT NULL,
  `nazwa` text NOT NULL,
  `usluga` varchar(50) DEFAULT NULL,
  `numer` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `wykonawcy`
--

INSERT INTO `wykonawcy` (`idWykonawcy`, `nazwa`, `usluga`, `numer`, `id`) VALUES
(11, '', '', 0, 15),
(12, 'I s g h he be', 'f g gcd go', 3555, 15),
(13, 'drfg', 'fdd', 336, 15),
(14, '', '', 0, 15),
(15, 'Dziwki', 'Robi lody', 303303, 15);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `budzet`
--
ALTER TABLE `budzet`
  ADD PRIMARY KEY (`idBudzet`),
  ADD KEY `id` (`id`);

--
-- Indeksy dla tabeli `goscie`
--
ALTER TABLE `goscie`
  ADD PRIMARY KEY (`idGoscie`),
  ADD KEY `id` (`id`);

--
-- Indeksy dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `wykonawcy`
--
ALTER TABLE `wykonawcy`
  ADD PRIMARY KEY (`idWykonawcy`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `budzet`
--
ALTER TABLE `budzet`
  MODIFY `idBudzet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `goscie`
--
ALTER TABLE `goscie`
  MODIFY `idGoscie` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT dla tabeli `wykonawcy`
--
ALTER TABLE `wykonawcy`
  MODIFY `idWykonawcy` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `budzet`
--
ALTER TABLE `budzet`
  ADD CONSTRAINT `budzet_ibfk_1` FOREIGN KEY (`id`) REFERENCES `uzytkownicy` (`id`);

--
-- Ograniczenia dla tabeli `wykonawcy`
--
ALTER TABLE `wykonawcy`
  ADD CONSTRAINT `wykonawcy_ibfk_1` FOREIGN KEY (`id`) REFERENCES `uzytkownicy` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
