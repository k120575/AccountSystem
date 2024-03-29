CREATE TABLE `account`.`user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `create_time` DATETIME NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

--
--
CREATE TABLE `account`.`account_detail` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `action` VARCHAR(45) NOT NULL,
    `credits` INT NOT NULL,
    `balance` INT NOT NULL,
    `income_type` VARCHAR(45) NULL,
    `expenditure_type` VARCHAR(45) NULL,
    `transfer_from` VARCHAR(45) NULL,
    `transfer_to` VARCHAR(45) NULL,
    `comment` VARCHAR(255) NULL,
    `create_user` VARCHAR(45) NOT NULL,
    `create_time` DATETIME NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;