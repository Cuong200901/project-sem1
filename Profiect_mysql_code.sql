CREATE SCHEMA `lemon_tee_shop` DEFAULT CHARACTER SET utf8 ;
USE lemon_tee_shop;
CREATE TABLE `lemon_tee_shop`.`accounts` (
  `account_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `phone_number` INT NOT NULL UNIQUE,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `position` VARCHAR(45) NOT NULL,
  `start_time` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`account_id`)
 
  );
  
INSERT INTO `lemon_tee_shop`.`accounts` (`account_id`, `user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`) VALUES ('1', 'nguyenson', '123123', 'Nguyen', 'Son', '2020-01-01', '123456789', '.', 'Admin', '2020-1-1');
INSERT INTO `lemon_tee_shop`.`accounts` (`account_id`, `user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`) VALUES ('2', 'hoangcuong', '123123', 'Hoang', 'Cuong', '2020-01-01', '123654789', '..', 'Staff', '2020-1-1');
INSERT INTO `lemon_tee_shop`.`accounts` (`account_id`, `user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`) VALUES ('3', 'cuonghaodung', '123123', 'Hoang', 'Cuong', '2020-01-01', '123444789', '...', 'Staff', '2020-1-1');
INSERT INTO `lemon_tee_shop`.`accounts` (`account_id`, `user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`) VALUES ('4', 'cuonghmc', '123123', 'Hoang', 'Cuong', '2020-01-01', '123', '.3', 'Staff', '2020-1-1');


CREATE TABLE `lemon_tee_shop`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NOT NULL,
  `price` DOUBLE NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `products_in_stock` INT NOT NULL,
  PRIMARY KEY (`product_id`));
  
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('1', 'Tra dau tay tranh vang', '20000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('2', 'Tra xoai chanh vang', '20000', 'Do uong', '0');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('3', 'Tra dua leo tao xanh', '20000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('4', 'Sua tuoi chan chau duong den', '25000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('5', 'Tra chanh xoai', '10000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('6', 'Chanh dao nhiet doi', '10000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('7', 'Tra tao xanh', '10000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('8', 'Me da', '10000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('9', 'Chanh tuoi', '10000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('10', 'Chanh leo', '15000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('11', 'Mojito', '15000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('12', 'Quat lac sua', '15000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('13', 'Gao non dua hau', '25000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('14', 'Sua tuoi sot xoai, dau', '25000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('15', 'Hoa Qua nhiet doi', '30000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('16', 'Tra dao cam xa', '25000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('17', 'Chanh leo kim quat', '20000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('18', 'Tra vai kim cuong', '20000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('19', 'Cam dua kim quat', '20000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('20', 'Dau nhiet doi', '25000', 'Do uong', '500');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('21', 'Tra xanh buoi hong', '25000', 'Do uong', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('22', 'Huong duong (1 goi)', '10000', 'Do an vat', '100');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('23', 'Khoai lang ken (1 hop)', '25000', 'Do an vat', '20');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('24', 'Nem chua ran (1 hop)', '50000', 'Do an vat', '20');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('25', 'Lap xuong (1 cai)', '8000', 'Do an vat', '100');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('26', 'Xuch Xich (1 cai)', '10000', 'Do an vat', '100');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('27', 'Koai le pho (1 hop)', '30000', 'Do an vat', '20');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('28', 'Kho ga (1 goi)', '30000', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('29', 'Hoa Qua (1 dia)', '30000', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('30', 'Ca vien chien (1 hop)', '25000', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('31', 'Khoai tay lac pho mai (1 hop)', '30000', 'Do an vat', '35');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('32', 'Them 1 phan tran chau trang', '5000', 'Topping', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('33', 'Them 1 phan nha dam', '5000', 'Topping', '50');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('34', 'Da tui', '0', 'Nguyen lieu', '25');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('35', 'Coc nhua', '0', 'Nguyen lieu', '350');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('36', 'Ong hut', '0', 'Nguyen lieu', '350');
INSERT INTO `lemon_tee_shop`.`products` (`product_id`, `name`, `price`, `category`, `products_in_stock`) VALUES ('37', 'Tui mang di', '0', 'Nguyen lieu', '1000');

 
    

    
    CREATE TABLE `lemon_tee_shop`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
`note` VARCHAR(45) NOT NULL,
   `card_number` INT ,
   `order_status` VARCHAR(45) NOT NULL,
    `total_bill` DOUBLE NOT NULL,
     `account_id` INT NOT NULL,
  PRIMARY KEY (`order_id`), 
    FOREIGN KEY (`account_id`)
    REFERENCES `lemon_tee_shop`.`accounts` (`account_id`)
    );
    
    CREATE TABLE `lemon_tee_shop`.`order_details` (
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `amount` INT NOT NULL,
  `monney` DOUBLE NOT NULL,

    FOREIGN KEY (`order_id`)
    REFERENCES `lemon_tee_shop`.`orders` (`order_id`),
    FOREIGN KEY (`product_id`)
    REFERENCES `lemon_tee_shop`.`products` (`product_id`),
  
		PRIMARY KEY (`order_id`,`product_id`)
);


