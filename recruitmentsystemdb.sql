-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2018 at 11:21 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recruitmentsystemdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` text COLLATE utf8_bin NOT NULL,
  `sex` varchar(1) COLLATE utf8_bin NOT NULL,
  `address` text COLLATE utf8_bin NOT NULL,
  `phone_number` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `admin_his`
--

CREATE TABLE `admin_his` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `postid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `jobseeker_his`
--

CREATE TABLE `jobseeker_his` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `postid` bigint(20) NOT NULL,
  `status` text COLLATE utf8_bin NOT NULL,
  `feedback` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
  `benafit` text COLLATE utf8_bin,
  `other_infor` text COLLATE utf8_bin,
  `date` text COLLATE utf8_bin NOT NULL,
  `status` int(11) NOT NULL,
  `carrerid` int(11) NOT NULL,
  `locationid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `job_seeker`
--

CREATE TABLE `job_seeker` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` text COLLATE utf8_bin NOT NULL,
  `CV` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `recruiter`
--

CREATE TABLE `recruiter` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` text COLLATE utf8_bin NOT NULL,
  `sex` varchar(1) COLLATE utf8_bin NOT NULL,
  `address` text COLLATE utf8_bin NOT NULL,
  `company_name` text COLLATE utf8_bin NOT NULL,
  `company_address` text COLLATE utf8_bin NOT NULL,
  `company_phone` text COLLATE utf8_bin NOT NULL,
  `company_information` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `recruiter_his`
--

CREATE TABLE `recruiter_his` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `postid` bigint(20) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `roleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `admin_his`
--
ALTER TABLE `admin_his`
  ADD PRIMARY KEY (`email`,`postid`),
  ADD KEY `postid` (`postid`);

--
-- Indexes for table `jobseeker_his`
--
ALTER TABLE `jobseeker_his`
  ADD PRIMARY KEY (`email`,`postid`),
  ADD KEY `postid` (`postid`);

--
-- Indexes for table `job_posts`
--
ALTER TABLE `job_posts`
  ADD PRIMARY KEY (`posts_id`);

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
-- Indexes for table `recruiter_his`
--
ALTER TABLE `recruiter_his`
  ADD PRIMARY KEY (`postid`,`email`) USING BTREE,
  ADD KEY `email` (`email`);

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
  MODIFY `posts_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`username`);

--
-- Constraints for table `admin_his`
--
ALTER TABLE `admin_his`
  ADD CONSTRAINT `admin_his_ibfk_1` FOREIGN KEY (`email`) REFERENCES `admin` (`email`),
  ADD CONSTRAINT `admin_his_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `job_posts` (`posts_id`);

--
-- Constraints for table `jobseeker_his`
--
ALTER TABLE `jobseeker_his`
  ADD CONSTRAINT `jobseeker_his_ibfk_1` FOREIGN KEY (`email`) REFERENCES `job_seeker` (`email`),
  ADD CONSTRAINT `jobseeker_his_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `job_posts` (`posts_id`);

--
-- Constraints for table `job_seeker`
--
ALTER TABLE `job_seeker`
  ADD CONSTRAINT `job_seeker_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`username`);

--
-- Constraints for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD CONSTRAINT `recruiter_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`username`);

--
-- Constraints for table `recruiter_his`
--
ALTER TABLE `recruiter_his`
  ADD CONSTRAINT `recruiter_his_ibfk_1` FOREIGN KEY (`email`) REFERENCES `recruiter` (`email`),
  ADD CONSTRAINT `recruiter_his_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `job_posts` (`posts_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
