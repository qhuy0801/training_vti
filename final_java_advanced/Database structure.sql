-- create database
DROP DATABASE IF EXISTS JavaAdvanced;
CREATE DATABASE JavaAdvanced;
USE JavaAdvanced;

-- create table : account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Username	 			NVARCHAR(20) NOT NULL UNIQUE KEY,
    `Password`				NVARCHAR(100) NOT NULL
);

-- create table: group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID		 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName	 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    `Member`				SMALLINT UNSIGNED NOT NULL,
    Creator					TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(Creator) REFERENCES `Account`(AccountID) ON DELETE SET NULL
);