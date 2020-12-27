DROP DATABASE IF EXISTS `online_nutrition_store`;
set @@global.time_zone = '+00:00' ; 
set @@session.time_zone = '+00:00' ;
CREATE SCHEMA `online_nutrition_store`;

CREATE TABLE `online_nutrition_store`.`category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`language` (
  `language_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`translation` (
  `translation_id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(45) NOT NULL,
  `category_fk` int NOT NULL,
  `language_fk` int NOT NULL,
  PRIMARY KEY (`translation_id`),
  FOREIGN KEY (`category_fk`) REFERENCES `category` (`category_id`),
  FOREIGN KEY (`language_fk`) REFERENCES `language` (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `authorities` varchar(15) DEFAULT 'ROLE_USER',
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  /*`birth_date` date NOT NULL,*/
  `nb_fidelity_points` int DEFAULT 0,
  `street_name` varchar(45) NOT NULL,
  `street_number` varchar(45) NOT NULL,
  `locality` varchar(45) NOT NULL,
  `zip_code` int NOT NULL,
  `country` varchar(45) NOT NULL,
  `account_non_expired` tinyint DEFAULT 1,
  `account_non_locked` tinyint DEFAULT 1,
  `credentials_non_expired` tinyint DEFAULT 1,
  `enabled` tinyint DEFAULT 1,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`discount` (
  `discount_id` int NOT NULL AUTO_INCREMENT,
  `discount` int NOT NULL,
  `label` varchar(45) NOT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `brand` varchar(45) NOT NULL,
  `current_inventory` int NOT NULL,
  `category_fk` int NOT NULL,
  `discount_fk` int DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  FOREIGN KEY (`category_fk`) REFERENCES `category` (`category_id`),
  FOREIGN KEY (`discount_fk`) REFERENCES `discount` (`discount_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `is_paid` tinyint NOT NULL,
  `reduction` int DEFAULT NULL,
  `customer_fk` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`customer_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`order_line` (
  `order_line_id` int NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `delivery_date` date NOT NULL,
  `quantity` int NOT NULL,
  `item_fk` int DEFAULT NULL,
  `order_fk` int DEFAULT NULL,
  PRIMARY KEY (`order_line_id`),
  FOREIGN KEY (`item_fk`) REFERENCES `item` (`item_id`) ON DELETE SET NULL,
  FOREIGN KEY (`order_fk`) REFERENCES `order` (`order_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*CREATE TABLE `online_nutrition_store`.`hibernate_sequence` (
  `sequence_name` varchar(255) NOT NULL,
	`next_val` INTEGER NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

DROP trigger IF EXISTS online_nutrition_store.decrease_stock;

DELIMITER |
create trigger online_nutrition_store.decrease_stock 
after insert on order_line
 for each row
 begin 
 update item 
 set item.current_inventory = item.current_inventory - NEW.quantity
 where item.item_id = NEW.item_fk;
 end|
 
 DROP trigger IF EXISTS online_nutrition_store.decrease_fidelity_points;

DELIMITER |
create trigger online_nutrition_store.decrease_fidelity_points
after insert on `order`
 for each row
 begin 
 DECLARE user_fidelity_points integer;
 SELECT nb_fidelity_points INTO user_fidelity_points FROM customer WHERE customer_id = NEW.customer_fk;
 if(user_fidelity_points >= 100) THEN
 update customer 
 set customer.nb_fidelity_points =  customer.nb_fidelity_points -  100
 where customer.customer_id = NEW.customer_fk;
 END IF;
 end|

INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();

INSERT INTO `online_nutrition_store`.`language` VALUES ();
INSERT INTO `online_nutrition_store`.`language` VALUES ();

INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Protéines', 1, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Proteins', 1, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Développement musculaire', 2, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Muscle development', 2, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Energie (et endurance)', 3, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Energy (and endurance)', 3, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Brûleurs de graisse et perte de poids', 4, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Fat burners and weight loss', 4, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Vitamines', 5, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Vitamins', 5, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Snacks et boissons', 6, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Snack and drinks', 6, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Accessoires', 7, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Accessories', 7, 2);

INSERT INTO `online_nutrition_store`.`customer` (`username`, `password`, `authorities`, `first_name`, `last_name`, `phone_number`, /*`birth_date`,*/ `street_name`, `street_number`, `locality`, `zip_code`, `country`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('nico6041@hotmail.be', '$2a$10$7AShmOyqEhXmDW1HOOHHMe7TnVsVvqrVgMF/Fgoobd6MZJ4mSbFCi', 'ROLE_USER', 'Nicolas', 'Gatta', '0479837036', /*'1997-11-25',*/ 'rue des bouleaxu', '27', 'Courcelles', 5780, 'Belgique', 1, 1, 1, 1);
INSERT INTO `online_nutrition_store`.`customer` (`username`, `password`, `authorities`, `first_name`, `last_name`, `phone_number`, /*`birth_date`,*/ `street_name`, `street_number`, `locality`, `zip_code`, `country`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('dylan.sohet@gmail.com', '$2a$10$7AShmOyqEhXmDW1HOOHHMe7TnVsVvqrVgMF/Fgoobd6MZJ4mSbFCi', 'ROLE_ADMIN', 'Dylan', 'Sohet', '0478070905', /*'2000-11-20',*/ 'Rue du chêne', '50A', 'Belfosse', 9532, 'Belgique', 1, 1, 1, 1);
INSERT INTO `online_nutrition_store`.`customer` (`username`, `password`, `authorities`, `first_name`, `last_name`, `phone_number`, /*`birth_date`,*/ `street_name`, `street_number`, `locality`, `zip_code`, `country`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('Michou7854@outlook.be', '$2a$10$7AShmOyqEhXmDW1HOOHHMe7TnVsVvqrVgMF/Fgoobd6MZJ4mSbFCi', 'ROLE_USER', 'Michel', 'Forever', '0471258963', /*'1995-06-11',*/ 'Rue Tonight', '85A', 'Fiesta', 4578, 'Belgique', 1, 1, 1, 1);

INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (15, 'Christmas');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (70, 'Destocking');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (40, 'Black Friday');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (25, 'Cyber Monday');

INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`) VALUES ('Whey', 'A protein powder', 20, 'Prozis', 150, 1, 1);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`) VALUES ('Whey isolate', 'A protein powder with less sugar and fat', 35, 'Prozis', 100, 1, NULL);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`) VALUES ('Mass gainer', 'A protein powder that will help you to gain mass', 40, 'MyProtein', 200, 2, 3);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`) VALUES ('BCAA', 'Amino acids in powder', 30, 'Prozis', 150, 1, NULL);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`) VALUES ('BCAA', 'Amino acids in caps', 25, 'Prozis', 200, 1, NULL);