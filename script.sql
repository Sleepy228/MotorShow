-- MySQL Script generated by MySQL Workbench
-- Thu Dec 10 19:19:38 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema motorshow
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema motorshow
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `motorshow` DEFAULT CHARACTER SET utf8 ;
USE `motorshow` ;

-- -----------------------------------------------------
-- Table `motorshow`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` SMALLINT(8) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `motorshow`.`Passport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`Passport` (
  `passportNumber` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `middleName` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `dateOfBirth` DATE NOT NULL,
  PRIMARY KEY (`passportNumber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `motorshow`.`CarBrand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`CarBrand` (
  `idCarBrand` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCarBrand`),
  UNIQUE INDEX `brand_UNIQUE` (`brand` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `motorshow`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`Client` (
  `idClient` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(13) NOT NULL,
  `Passport_passportNumber` INT NOT NULL,
  PRIMARY KEY (`idClient`, `Passport_passportNumber`),
  INDEX `fk_Client_Passport_idx` (`Passport_passportNumber` ASC) VISIBLE,
  UNIQUE INDEX `Passport_passportNumber_UNIQUE` (`Passport_passportNumber` ASC) VISIBLE,
  CONSTRAINT `fk_Client_Passport`
    FOREIGN KEY (`Passport_passportNumber`)
    REFERENCES `motorshow`.`Passport` (`passportNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `motorshow`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`Employee` (
  `idEmployee` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NOT NULL,
  `salary` INT NOT NULL,
  `Passport_passportNumber` INT NOT NULL,
  `User_idUser` INT NOT NULL,
  PRIMARY KEY (`idEmployee`, `Passport_passportNumber`, `User_idUser`),
  INDEX `fk_Employee_Passport1_idx` (`Passport_passportNumber` ASC) VISIBLE,
  INDEX `fk_Employee_User1_idx` (`User_idUser` ASC) VISIBLE,
  UNIQUE INDEX `User_idUser_UNIQUE` (`User_idUser` ASC) VISIBLE,
  UNIQUE INDEX `Passport_passportNumber_UNIQUE` (`Passport_passportNumber` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Passport1`
    FOREIGN KEY (`Passport_passportNumber`)
    REFERENCES `motorshow`.`Passport` (`passportNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Employee_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `motorshow`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `motorshow`.`CarModel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`CarModel` (
  `idCarModel` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL,
  `CarBrand_idCarBrand` INT NOT NULL,
  PRIMARY KEY (`idCarModel`, `CarBrand_idCarBrand`),
  INDEX `fk_CarModel_CarBrand1_idx` (`CarBrand_idCarBrand` ASC) VISIBLE,
  CONSTRAINT `fk_CarModel_CarBrand1`
    FOREIGN KEY (`CarBrand_idCarBrand`)
    REFERENCES `motorshow`.`CarBrand` (`idCarBrand`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `motorshow`.`Car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`Car` (
  `VIN` INT NOT NULL,
  `power` INT NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `dateOfRelease` DATE NOT NULL,
  `bodyType` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `CarModel_idCarModel` INT NOT NULL,
  PRIMARY KEY (`VIN`, `CarModel_idCarModel`),
  INDEX `fk_Car_CarModel1_idx` (`CarModel_idCarModel` ASC) VISIBLE,
  CONSTRAINT `fk_Car_CarModel1`
    FOREIGN KEY (`CarModel_idCarModel`)
    REFERENCES `motorshow`.`CarModel` (`idCarModel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `motorshow`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `motorshow`.`Order` (
  `idOrder` INT NOT NULL AUTO_INCREMENT,
  `DateOfSale` DATE NOT NULL,
  `Employee_idEmployee` INT NOT NULL,
  `Client_idclient` INT NOT NULL,
  `Car_VIN` INT NOT NULL,
  PRIMARY KEY (`idOrder`, `Employee_idEmployee`, `Client_idclient`, `Car_VIN`),
  INDEX `fk_Document_Employee1_idx` (`Employee_idEmployee` ASC) VISIBLE,
  INDEX `fk_Document_Client1_idx` (`Client_idclient` ASC) VISIBLE,
  INDEX `fk_Order_Car1_idx` (`Car_VIN` ASC) VISIBLE,
  UNIQUE INDEX `Car_VIN_UNIQUE` (`Car_VIN` ASC) VISIBLE,
  CONSTRAINT `fk_Document_Employee1`
    FOREIGN KEY (`Employee_idEmployee`)
    REFERENCES `motorshow`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Document_Client1`
    FOREIGN KEY (`Client_idclient`)
    REFERENCES `motorshow`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Car1`
    FOREIGN KEY (`Car_VIN`)
    REFERENCES `motorshow`.`Car` (`VIN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
