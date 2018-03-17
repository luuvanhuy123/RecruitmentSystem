-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2018 at 10:02 AM
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
('huyluu', 'huyluu', 'F', 'huyluu', 'huyluu');

-- --------------------------------------------------------

--
-- Table structure for table `career`
--

CREATE TABLE `career` (
  `careerId` int(11) NOT NULL,
  `career_name` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `career`
--

INSERT INTO `career` (`careerId`, `career_name`) VALUES
(1, 'QUẢN TRỊ KINH DOANH'),
(2, 'CÔNG NGHỆ THÔNG TIN'),
(3, 'KẾ TOÁN'),
(4, 'MAKETING'),
(5, 'MÔ GIỚI BẤT ĐỘNG SẢN'),
(6, 'QUẢN TRỊ NHÀ HÀNG KHÁCH SẠN'),
(7, 'BẢO HỘ LAO ĐỘNG'),
(8, 'BÁC SĨ'),
(9, 'BÁN HÀNG'),
(10, 'BẤT ĐỘNG SẢN'),
(11, 'BẢO HIỂM'),
(12, 'TÀI CHÍNH NGÂN HÀNG'),
(13, 'CƠ KHÍ'),
(14, 'DƯỢC SĨ');

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
  `location` text COLLATE utf8_bin NOT NULL,
  `post date` text COLLATE utf8_bin NOT NULL,
  `posts_type` int(11) NOT NULL,
  `posts_status` int(11) NOT NULL,
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `careerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `job_seeker`
--

CREATE TABLE `job_seeker` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` text COLLATE utf8_bin NOT NULL,
  `CV` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `job_seeker`
--

INSERT INTO `job_seeker` (`email`, `name`, `CV`) VALUES
('luuvanhuy123@gmail.com', 'luu van huy', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `recruiter`
--

CREATE TABLE `recruiter` (
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` text COLLATE utf8_bin NOT NULL,
  `sex` char(1) COLLATE utf8_bin NOT NULL,
  `address` text COLLATE utf8_bin NOT NULL,
  `company_name` text COLLATE utf8_bin NOT NULL,
  `company_phone` text COLLATE utf8_bin NOT NULL,
  `company_information` text COLLATE utf8_bin NOT NULL,
  `company_address` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `recruiter`
--

INSERT INTO `recruiter` (`email`, `name`, `sex`, `address`, `company_name`, `company_phone`, `company_information`, `company_address`) VALUES
('admin', 'admin', 'F', 'admin', 'admin', 'admin', 'admin', 'admin');

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
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `role_name` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `role_name`) VALUES
(1, 'admin'),
(2, 'manager'),
(3, 'joob seeker'),
(4, 'recruiter');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'admin'),
('huyluu', 'huyluu'),
('luuvanhuy123@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `roleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`username`, `roleId`) VALUES
('admin', 4),
('huyluu', 1),
('luuvanhuy123@gmail.com', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `career`
--
ALTER TABLE `career`
  ADD PRIMARY KEY (`careerId`);

--
-- Indexes for table `job_posts`
--
ALTER TABLE `job_posts`
  ADD PRIMARY KEY (`posts_id`),
  ADD KEY `fk_postsjob_user` (`username`),
  ADD KEY `fk_postsjob_career` (`careerId`);

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
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`username`,`roleId`),
  ADD KEY `fk_userrole_role` (`roleId`);

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
  ADD CONSTRAINT `fk_postsjob_career` FOREIGN KEY (`careerId`) REFERENCES `career` (`careerId`),
  ADD CONSTRAINT `fk_postsjob_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

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
  ADD CONSTRAINT `fk_rehistory_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_userrole_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`),
  ADD CONSTRAINT `fk_userrole_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
