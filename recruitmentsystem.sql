-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 24, 2018 at 05:07 PM
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

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `countUser` ()  NO SQL
SELECT COUNT(*) FROM user$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteAdmin` (IN `value` VARCHAR(20))  NO SQL
DELETE FROM admin WHERE admin.email=value$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteJobPosts` (IN `value` INT)  NO SQL
DELETE FROM job_posts WHERE job_posts.posts_id=value$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteJobSeeker` (IN `value` VARCHAR(20))  NO SQL
DELETE FROM job_seeker WHERE job_seeker.email=value$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteRecruiter` (IN `value` VARCHAR(20))  NO SQL
DELETE FROM recruiter WHERE recruiter.email=value$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllJobSeeker` ()  NO SQL
SELECT  job_seeker.email,job_seeker.name, job_seeker.CV, USER.password FROM job_seeker, USER WHERE job_seeker.email = USER.username$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllManager` ()  NO SQL
SELECT
        admin.email, admin.name, admin.sex, admin.address, admin.phone_number, USER.username, USER.password, user_role.roleid, role.role_name
    FROM
        admin, USER, user_role, role
    WHERE
        admin.email = USER.username AND USER.username = user_role.username AND user_role.roleid = role.roleId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRecruiter` ()  NO SQL
SELECT recruiter.email, recruiter.name, recruiter.sex, recruiter.address, recruiter.company_name, recruiter.company_phone, recruiter.company_information, recruiter.company_address, USER.password FROM recruiter, USER WHERE recruiter.email = USER.username$$

DELIMITER ;

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

--
-- Triggers `admin`
--
DELIMITER $$
CREATE TRIGGER `deleteUserAdmin` AFTER DELETE ON `admin` FOR EACH ROW DELETE FROM user WHERE user.username=old.email
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `deleteUserRoleAdmin` BEFORE DELETE ON `admin` FOR EACH ROW DELETE FROM user_role WHERE user_role.username=old.email
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `career`
--

CREATE TABLE `career` (
  `careerId` int(11) NOT NULL,
  `career_name` text COLLATE utf8_bin NOT NULL
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
  `benefit` text COLLATE utf8_bin,
  `other_information` text COLLATE utf8_bin,
  `location` varchar(20) COLLATE utf8_bin NOT NULL,
  `post_date` text COLLATE utf8_bin NOT NULL,
  `posts_type` varchar(100) COLLATE utf8_bin NOT NULL,
  `posts_status` tinyint(1) NOT NULL,
  `username` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Triggers `job_posts`
--
DELIMITER $$
CREATE TRIGGER `deletePostsCareer` BEFORE DELETE ON `job_posts` FOR EACH ROW DELETE FROM posts_career WHERE posts_career.posts_id=old.posts_id
$$
DELIMITER ;

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

--
-- Triggers `job_seeker`
--
DELIMITER $$
CREATE TRIGGER `deleteUserJobSeeker` AFTER DELETE ON `job_seeker` FOR EACH ROW DELETE FROM user WHERE user.username=old.email
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `deleteUserRoleJobSeeker` BEFORE DELETE ON `job_seeker` FOR EACH ROW DELETE FROM user_role WHERE user_role.roleid=3 AND user_role.username=old.email
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `posts_career`
--

CREATE TABLE `posts_career` (
  `posts_id` bigint(20) NOT NULL,
  `careerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

--
-- Triggers `recruiter`
--
DELIMITER $$
CREATE TRIGGER `deleteUserRecruiter` AFTER DELETE ON `recruiter` FOR EACH ROW DELETE FROM user WHERE user.username=old.email
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `deleteUserRoleRecruiter` BEFORE DELETE ON `recruiter` FOR EACH ROW DELETE FROM user_role WHERE user_role.username=old.email
$$
DELIMITER ;

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
  `role_name` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `role_name`) VALUES
(1, 'admin'),
(2, 'manager'),
(3, 'job_seeker'),
(4, 'reruiter');

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
('recruiter', '123'),
('tuanTk', '123');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `roleid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`username`, `roleid`) VALUES
('admin', 1),
('recruiter', 4),
('tuanTk', 3);

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
  ADD KEY `fk_postsjob_user` (`username`);

--
-- Indexes for table `job_seeker`
--
ALTER TABLE `job_seeker`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `posts_career`
--
ALTER TABLE `posts_career`
  ADD PRIMARY KEY (`posts_id`,`careerId`),
  ADD KEY `careerId` (`careerId`);

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
  ADD PRIMARY KEY (`username`,`roleid`),
  ADD KEY `fk_userrole_role` (`roleid`);

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
  ADD CONSTRAINT `fk_postsjob_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Constraints for table `job_seeker`
--
ALTER TABLE `job_seeker`
  ADD CONSTRAINT `fk_jobseeker_user` FOREIGN KEY (`email`) REFERENCES `user` (`username`);

--
-- Constraints for table `posts_career`
--
ALTER TABLE `posts_career`
  ADD CONSTRAINT `posts_career_ibfk_1` FOREIGN KEY (`posts_id`) REFERENCES `job_posts` (`posts_id`),
  ADD CONSTRAINT `posts_career_ibfk_2` FOREIGN KEY (`careerId`) REFERENCES `career` (`careerId`);

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
  ADD CONSTRAINT `fk_userrole_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleId`),
  ADD CONSTRAINT `fk_userrole_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
