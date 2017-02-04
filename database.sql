-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema logintest
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema logintest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `logintest` DEFAULT CHARACTER SET utf8 ;
USE `logintest` ;

-- -----------------------------------------------------
-- Table `logintest`.`calendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`calendar` (
  `dt` DATE NOT NULL,
  `y` SMALLINT(6) NULL DEFAULT NULL,
  `q` TINYINT(4) NULL DEFAULT NULL,
  `m` TINYINT(4) NULL DEFAULT NULL,
  `d` TINYINT(4) NULL DEFAULT NULL,
  `dw` TINYINT(4) NULL DEFAULT NULL,
  `monthName` VARCHAR(9) NULL DEFAULT NULL,
  `dayName` VARCHAR(9) NULL DEFAULT NULL,
  `w` TINYINT(4) NULL DEFAULT NULL,
  `isWeekday` BINARY(1) NULL DEFAULT NULL,
  `isHoliday` BINARY(1) NULL DEFAULT NULL,
  `holidayDescr` VARCHAR(32) NULL DEFAULT NULL,
  `isPayday` BINARY(1) NULL DEFAULT NULL,
  PRIMARY KEY (`dt`),
  INDEX `date` (`dt` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logintest`.`email_reports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`email_reports` (
  `idemail_reports` INT(11) NOT NULL AUTO_INCREMENT,
  `date_to_report` VARCHAR(45) NULL DEFAULT NULL,
  `to_address` VARCHAR(80) NULL DEFAULT NULL,
  `cc_address` VARCHAR(100) NULL DEFAULT NULL,
  `subject` VARCHAR(200) NULL DEFAULT NULL,
  `body` TEXT NULL DEFAULT NULL,
  `sent_date` DATETIME NULL DEFAULT NULL,
  `username` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`idemail_reports`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COMMENT = 'This table stores emails sent by users from the smart working application';


-- -----------------------------------------------------
-- Table `logintest`.`ints`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`ints` (
  `i` TINYINT(4) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logintest`.`planning_weeks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`planning_weeks` (
  `weekNumber` INT(11) NOT NULL,
  `weekEnabled` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`weekNumber`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'A table that lists all the weeks of the year and tells whether they are enabled for planning or not';


-- -----------------------------------------------------
-- Table `logintest`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`roles` (
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'This table stores all the possible application roles';


-- -----------------------------------------------------
-- Table `logintest`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`users` (
  `user` VARCHAR(20) NOT NULL,
  `password` VARCHAR(64) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `token` VARCHAR(45) NULL DEFAULT NULL,
  `accessedtime` DATETIME NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(60) NULL DEFAULT NULL,
  `surname` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`user`),
  UNIQUE INDEX `user_UNIQUE` (`user` ASC),
  INDEX `user` (`user` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logintest`.`users_calendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`users_calendar` (
  `userId` VARCHAR(20) NOT NULL,
  `udate` DATE NOT NULL,
  `daytype` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`, `udate`),
  INDEX `fk_date_idx` (`udate` ASC),
  CONSTRAINT `fk_date`
    FOREIGN KEY (`udate`)
    REFERENCES `logintest`.`calendar` (`dt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user`
    FOREIGN KEY (`userId`)
    REFERENCES `logintest`.`users` (`user`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logintest`.`users_planning`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`users_planning` (
  `idusers_planning` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(20) NULL DEFAULT NULL,
  `requestDate` DATE NULL DEFAULT NULL,
  `day1` DATE NULL DEFAULT NULL,
  `day2` DATE NULL DEFAULT NULL,
  `day3` DATE NULL DEFAULT NULL,
  `day4` DATE NULL DEFAULT NULL,
  `day5` DATE NULL DEFAULT NULL,
  `day6` DATE NULL DEFAULT NULL,
  `day7` DATE NULL DEFAULT NULL,
  `day8` DATE NULL DEFAULT NULL,
  `day9` DATE NULL DEFAULT NULL,
  `day10` DATE NULL DEFAULT NULL,
  `status` VARCHAR(20) NULL DEFAULT NULL,
  `notesday1` VARCHAR(100) NULL DEFAULT NULL,
  `notesday2` VARCHAR(100) NULL DEFAULT NULL,
  `notesday3` VARCHAR(100) NULL DEFAULT NULL,
  `notesday4` VARCHAR(100) NULL DEFAULT NULL,
  `notesday5` VARCHAR(100) NULL DEFAULT NULL,
  `notesday6` VARCHAR(100) NULL DEFAULT NULL,
  `notesday7` VARCHAR(100) NULL DEFAULT NULL,
  `notesday8` VARCHAR(100) NULL DEFAULT NULL,
  `notesday9` VARCHAR(100) NULL DEFAULT NULL,
  `notesday10` VARCHAR(100) NULL DEFAULT NULL,
  `planningWeek` INT(11) NULL DEFAULT NULL,
  `firstWeek` INT(11) NULL DEFAULT NULL,
  `secondWeek` INT(11) NULL DEFAULT NULL,
  `managed` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idusers_planning`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8
COMMENT = 'This table stores the smart working planning request made by users';


-- -----------------------------------------------------
-- Table `logintest`.`users_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logintest`.`users_roles` (
  `username` VARCHAR(10) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`, `role`),
  INDEX `fk_user_idx` (`username` ASC),
  INDEX `fk_role_idx` (`role` ASC),
  CONSTRAINT `fk_rolesforuser`
    FOREIGN KEY (`role`)
    REFERENCES `logintest`.`roles` (`role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userforroles`
    FOREIGN KEY (`username`)
    REFERENCES `logintest`.`users` (`user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
