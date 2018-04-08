-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 08, 2018 at 10:38 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recruitmentsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` text COLLATE utf8_bin NOT NULL,
  `sex` char(1) COLLATE utf8_bin NOT NULL,
  `address` text COLLATE utf8_bin NOT NULL,
  `phone_number` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email`, `name`, `sex`, `address`, `phone_number`) VALUES
('admin', 'tuan', 'F', 'q7', 'tuantk');

-- --------------------------------------------------------

--
-- Table structure for table `job_posts`
--

CREATE TABLE `job_posts` (
  `posts_id` bigint(20) NOT NULL,
  `job_name` text COLLATE utf8_bin NOT NULL,
  `job_position` text COLLATE utf8_bin NOT NULL,
  `job_description` text COLLATE utf8_bin NOT NULL,
  `job_recruitment` text COLLATE utf8_bin NOT NULL,
  `salary` text COLLATE utf8_bin NOT NULL,
  `benefit` text COLLATE utf8_bin,
  `other_information` text COLLATE utf8_bin,
  `location` int(11) NOT NULL,
  `post_date` text COLLATE utf8_bin NOT NULL,
  `posts_status` int(11) NOT NULL,
  `careerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `job_seeker`
--

CREATE TABLE `job_seeker` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  `CV` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `job_seeker`
--

INSERT INTO `job_seeker` (`email`, `name`, `CV`) VALUES
('tuanTk', 'Tran Khanh Tuan', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `recruiter`
--

CREATE TABLE `recruiter` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  `sex` char(1) COLLATE utf8_bin NOT NULL,
  `address` text COLLATE utf8_bin NOT NULL,
  `company_name` text COLLATE utf8_bin NOT NULL,
  `company_phone` varchar(15) COLLATE utf8_bin NOT NULL,
  `company_information` text COLLATE utf8_bin NOT NULL,
  `company_address` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `recruiter`
--

INSERT INTO `recruiter` (`email`, `name`, `sex`, `address`, `company_name`, `company_phone`, `company_information`, `company_address`) VALUES
('recruiter', 'ok', 'F', 'recruiter', 'oop', 'main', 'xyz', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `recruiteregistration_history`
--

CREATE TABLE `recruiteregistration_history` (
  `posts_id` bigint(20) NOT NULL,
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `status` char(1) COLLATE utf8_bin DEFAULT NULL,
  `noties` text COLLATE utf8_bin,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `roleId` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `roleId`) VALUES
('admin', 'admin', '0'),
('recruiter', '123', '0'),
('tuanTk', '123', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `job_posts`
--
ALTER TABLE `job_posts`
  ADD PRIMARY KEY (`posts_id`),
  ADD KEY `fk_job_carr` (`careerId`),
  ADD KEY `fk_job_loca` (`location`);

--
-- Indexes for table `job_seeker`
--
ALTER TABLE `job_seeker`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `recruiteregistration_history`
--
ALTER TABLE `recruiteregistration_history`
  ADD PRIMARY KEY (`posts_id`,`username`),
  ADD KEY `fk_rehistory_user` (`username`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `job_posts`
--
ALTER TABLE `job_posts`
  MODIFY `posts_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_user` FOREIGN KEY (`email`) REFERENCES `user` (`username`);

--
-- Constraints for table `job_posts`
--
ALTER TABLE `job_posts`
  ADD CONSTRAINT `fk_jobpost_carr` FOREIGN KEY (`careerId`) REFERENCES `carrer` (`carrerId`),
  ADD CONSTRAINT `fk_jobpost_loc` FOREIGN KEY (`location`) REFERENCES `location` (`location`);

--
-- Constraints for table `job_seeker`
--
ALTER TABLE `job_seeker`
  ADD CONSTRAINT `fk_jobseeker_user` FOREIGN KEY (`email`) REFERENCES `user` (`username`);

--
-- Constraints for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD CONSTRAINT `fk_recruiter_user` FOREIGN KEY (`email`) REFERENCES `user` (`username`);

--
-- Constraints for table `recruiteregistration_history`
--
ALTER TABLE `recruiteregistration_history`
  ADD CONSTRAINT `fk_rehistory_posts` FOREIGN KEY (`posts_id`) REFERENCES `job_posts` (`posts_id`),
  ADD CONSTRAINT `fk_rehistory_user` FOREIGN KEY (`username`) REFERENCES `recruiter` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
