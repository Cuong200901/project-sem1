CREATE SCHEMA `lemon_tee_shop` DEFAULT CHARACTER SET utf8 ;
USE lemon_tee_shop;
CREATE TABLE `lemon_tee_shop`.`accounts` (
  `account_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `phone_number` INT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `start_time` VARCHAR(45) NOT NULL,
  `shift` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`account_id`)
 
  );
  
INSERT INTO `lemon_tee_shop`.`accounts` (`user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`, `shift`) VALUES ('nguyenson', '123123', 'Nguyen', 'Son', '2020-1-1', '0123456789', '.', 'Admin', '2020-1-1', 'Full time');
INSERT INTO `lemon_tee_shop`.`accounts` (`user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`, `shift`) VALUES ('hoangcuong', '123123', 'Hoang', 'Cuong', '2020-1-1', '0123456789', '.', 'Staff', '2020-1-1', '6h-12h');
INSERT INTO `lemon_tee_shop`.`accounts` (`user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`, `shift`) VALUES ('cuonghaodung', '123123', 'Hoang', 'Cuong', '2020-1-1', '123456789', '.', 'Staff', '2020-1-1', '13h-18h');
INSERT INTO `lemon_tee_shop`.`accounts` (`user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`, `shift`) VALUES ('cuonghmc', '123123', 'Hoang', 'Cuong', '2020-1-1', '123456879', '.', 'Staff', '2020-1-1', '18h-22h');

CREATE TABLE `lemon_tee_shop`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NOT NULL,
  `cost` DOUBLE NOT NULL,
  `discount` INT NULL DEFAULT NULL,
  `price` DOUBLE NOT NULL,
  `promotion` VARCHAR(45) NULL DEFAULT NULL,
  `category` VARCHAR(45) NOT NULL,
  `products_in_stock` INT NOT NULL,
  PRIMARY KEY (`product_id`));
  
  INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra dau tay tranh vang', '20000', '0', '20000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra xoai chanh vang', '20000', '0', '20000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra dua leo tao xanh', '20000', '0', '20000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Sua tuoi chan chau duong den', '25000', '0', '25000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra chanh xoai', '10000', '0', '10000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Chanh dao nhiet doi', '10000', '0', '10000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra tao xanh', '15000', '0', '10000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Me da', '10000', '0', '10000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Chanh tuoi', '10000', '0', '10000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Chanh leo', '15000', '0', '15000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Mojito', '15000', '0', '15000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Quat lac sua', '15000', '0', '15000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Gao non dua hau', '25000', '0', '25000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Sua tuoi sot xoai, dau', '25000', '0', '25000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Hoa Qua nhiet doi', '30000', '0', '30000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra dao cam xa', '25000', '0', '25000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Chanh leo kim quat', '20000', '0', '20000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra vai kim cuong', '20000', '0', '20000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Cam dua kim quat', '20000', '0', '20000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Dau nhiet doi', '25000', '0', '25000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tra xanh buoi hong', '25000', '0', '25000', '0', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Huong duong (1 goi)', '10000', '0', '10000', '0', 'Do an vat', '100');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Khoai lang ken (1 hop)', '25000', '0', '25000', '0', 'Do an vat', '20');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Nem chua ran (1 hop)', '50000', '0', '50000', '0', 'Do an vat', '20');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Lap xuong (1 cai)', '8000', '0', '8000', '0', 'Do an vat', '100');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Xuch Xich (1 cai)', '10000', '0', '10000', '0', 'Do an vat', '100');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Koai le pho (1 hop)', '30000', '0', '30000', '0', 'Do an vat', '20');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Kho ga (1 goi)', '30000', '0', '30000', '0', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Hoa Qua (1 dia)', '30000', '0', '30000', '0', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Ca vien chien (1 hop)', '25000', '0', '25000', '0', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Khoai tay lac pho mai (1 hop)', '30000', '0', '30000', '0', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Them 1 phan tran chau trang', '5000', '0', '5000', '0', 'Topping', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Them 1 phan nha dam', '5000', '0', '5000', '0', 'Topping', '50');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Da tui', '0', '0', '0', '0', 'Nguyen lieu', '25');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Coc nhua', '0', '0', '0', '0', 'Nguyen lieu', '350');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Ong hut', '0', '0', '0', '0', 'Nguyen lieu', '350');
INSERT INTO `lemon_tee_shop`.`products` (`name`, `cost`, `discount`, `price`, `promotion`, `category`, `products_in_stock`) VALUES ('Tui mang di', '0', '0', '0', '0', 'Nguyen lieu', '1000');

    
 
    
CREATE TABLE `lemon_tee_shop`.`table` (
  `table_id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`table_id`));
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Exist');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
    
    
    
    CREATE TABLE `lemon_tee_shop`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  -- `order_status` VARCHAR(45) NOT NULL,
  `account_id` INT NOT NULL,
  `note` VARCHAR(255) NULL,
  `table_id` INT,
  PRIMARY KEY (`order_id`), 
    FOREIGN KEY (`account_id`)
    REFERENCES `lemon_tee_shop`.`accounts` (`account_id`),
      FOREIGN KEY (`table_id`)
  REFERENCES `lemon_tee_shop`.`table` (`table_id`)
    );
    
    CREATE TABLE `lemon_tee_shop`.`order_details` (
  `product_id` INT NOT NULL,
  `amount` INT NOT NULL,
  `order_id` INT NOT NULL,
 
    FOREIGN KEY (`order_id`)
    REFERENCES `lemon_tee_shop`.`orders` (`order_id`),
    FOREIGN KEY (`product_id`)
    REFERENCES `lemon_tee_shop`.`products` (`product_id`)
    
);


