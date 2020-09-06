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
  PRIMARY KEY (`account_id`),
  PRIMARY KEY (`user_name`)
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

    
   --  CREATE TABLE `lemon_tee_shop`.`picture` (
--   `picture_id` INT NOT NULL AUTO_INCREMENT,
--   `picture_link` VARCHAR(255) NOT NULL,
--   `product_id` INT NOT NULL,
--   PRIMARY KEY (`picture_id`),
--     FOREIGN KEY (`product_id`)
--     REFERENCES `lemon_tee_shop`.`products` (`product_id`)
--     );
--     INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://cdn-image.myrecipes.com/sites/default/files/styles/4_3_horizontal_-_1200x900/public', '1');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://cdn.sunbasket.com/954142a1-3a66-4258-a9b5-34bfba93a627.jpg', '2');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://servingjoy.com/wp-content/uploads/2014/12/Lychee-fizzy-drink-with-mint-Lychee-Mojito-.jpg', '3');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://divascancook.com/wp-content/uploads/2017/04/strawberry-sweet-tea-1024x768.jpg', '4');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://thehealthytart.com/wp-content/uploads/2017/03/Ginger-and-Lemon-tea.jpg', '5');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://cdn2.stylecraze.com/wp-content/uploads/2014/11/2-Simple-Ways-To-Prepare-Mango-Tea1.jpg', '6');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('http://www.jkteashop.com/blog/wp-content/uploads/2017/03/lizhihongcha.jpg', '7');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://getinmymouf.com/wp-content/uploads/2015/04/DSC_0136.jpg', '8');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://food-fanatic-res.cloudinary.com/iu/s---KYwQzp1--/f_auto,q_auto/v1430103572/sweet-mango-green-tea-photo', '9');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://img.taste.com.au/xeXqY0vO/taste/2016/11/apple-and-mint-iced-tea-54697-1.jpeg', '10');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://i.pinimg.com/736x/b6/b0/61/b6b061d2e47b61d94027788f1c33f7b2--easy-coffee-instant-coffee.jpg', '11');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://www.cheatsheet.com/wp-content/uploads/2015/07/Passion-fruit-juice.jpg', '12');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://www.eatme.eu/uploads/images/recepten/kumquat_ijsthee_1.jpg', '13');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://chinatown.co.uk/wp-content/uploads/2017/06/shutterstock_584243260-e1498137425460.jpg', '14');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://bakedbree.com/wp-content/uploads/2012/09/lime-mint-tea-cooler_23.jpg', '15');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://i2.wp.com/foodsogoodmall.com/wp-content/uploads/2014/03/Pineapple-Iced-Tea.jpg?resize=500%2C335&ssl=1', '16');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('http://2.bp.blogspot.com/_jc2ZAw5kem4/TU_-VvRHz2I/AAAAAAAAFU0/keVHC0A4XsQ/s1600/Fruit+Tea+1.jpg', '17');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://the.republicoftea.com/wp-content/uploads/2016/02/Mango-Coconut-Water-Iced-Tea-Glass.jpg', '18');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://sifu.unileversolutions.com/image/en-US/recipe-topvisual/2/1260-709/apple-cinnamon-tea-50202275.jpg', '19');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('http://v.img.com.ua/nxs125/b/600x500/b/74/c2eca869a147c9f57889e31e39c4774b.jpg', '20');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('http://4.bp.blogspot.com/--M3SrHqJ0hQ/VV1OHLY79xI/AAAAAAAAeU4/RMQD9_aippk/s640/Mua-thu-va-Tra-hoa-cuc-cam-xuc-hoa-quyen-2.jpg', '21');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgAkFRJAEnQCecUuqrwaZaO6FxMdaZu7Fxc0TB0kdVJ0YeYmh+JWVgG4ACcubXJPTPGXfTffTelmzYdmzOys10/aTMyINfZ', '22');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGB8zODMtNygtLisBCgoKDg0OGxAQGy', '23');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhSggGBonHRc8zODMsNygtLiB/9k=', '24');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMSEhlIBoYITEhJSkrLi4uG0OGxAQOn/2Q==', '25');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxQSEhUSExIVFRUWGBcVGRUgICD/9k=', '26');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTExMVFRUWGBUXFhYXFRUVvIA//9k=', '27');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTExMWFhUWGB0bGRcXGBgXGhoYGhgaHRgYHRcYHSggGB//9k=', '28');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR8qpe9k-KIF4WCQqeOQVVKuXylfn35VxyhAA&usqp=CAU', '29');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUSExMVFRUXFxcbGBgYFhcdGBgXFhtNyghNP//Z', '30');
-- INSERT INTO `lemon_tee_shop`.`picture` (`picture_link`, `product_id`) VALUES ('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTExMWFhUXFxgbFxgWGBsBF5fWDZdKAN3ueb/9k=', '31');
    
    
CREATE TABLE `lemon_tee_shop`.`table` (
  `table_id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`table_id`));
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
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
INSERT INTO `lemon_tee_shop`.`table` (`status`) VALUES ('Clear');
    
    
    
    CREATE TABLE `lemon_tee_shop`.`order` (
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
  `order_details_id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `amount` INT NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`order_details_id`),
    FOREIGN KEY (`order_id`)
    REFERENCES `lemon_tee_shop`.`order` (`order_id`),
    FOREIGN KEY (`product_id`)
    REFERENCES `lemon_tee_shop`.`products` (`product_id`)
    
);


