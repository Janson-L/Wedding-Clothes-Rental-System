-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2019 at 09:52 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wed_cloth_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `clothes`
--

CREATE TABLE `clothes` (
  `ClothesID` varchar(255) NOT NULL,
  `RentRate` double NOT NULL,
  `ClothesType` varchar(255) NOT NULL,
  `Colour` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `clothes_rental`
--

CREATE TABLE `clothes_rental` (
  `ClothesID` varchar(255) NOT NULL,
  `RentalID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentID` varchar(255) NOT NULL,
  `PaymentDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE `rental` (
  `RentalID` varchar(255) NOT NULL,
  `Date` date NOT NULL,
  `Duration` int(5) NOT NULL,
  `Total` double NOT NULL,
  `UserID` varchar(255) NOT NULL,
  `PaymentID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `PhoneNo` varchar(255) NOT NULL,
  `ICNo` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Class` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clothes`
--
ALTER TABLE `clothes`
  ADD PRIMARY KEY (`ClothesID`);

--
-- Indexes for table `clothes_rental`
--
ALTER TABLE `clothes_rental`
  ADD PRIMARY KEY (`ClothesID`,`RentalID`),
  ADD KEY `RentalID` (`RentalID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`RentalID`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `PaymentID` (`PaymentID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `clothes_rental`
--
ALTER TABLE `clothes_rental`
  ADD CONSTRAINT `clothes_rental_ibfk_1` FOREIGN KEY (`ClothesID`) REFERENCES `clothes` (`ClothesID`) ON DELETE CASCADE,
  ADD CONSTRAINT `clothes_rental_ibfk_2` FOREIGN KEY (`RentalID`) REFERENCES `rental` (`RentalID`) ON DELETE CASCADE;

--
-- Constraints for table `rental`
--
ALTER TABLE `rental`
  ADD CONSTRAINT `rental_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE,
  ADD CONSTRAINT `rental_ibfk_2` FOREIGN KEY (`PaymentID`) REFERENCES `payment` (`PaymentID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
