DROP DATABASE IF EXISTS `online_nutrition_store`;
set @@global.time_zone = '+00:00' ; 
set @@session.time_zone = '+00:00' ;
CREATE SCHEMA `online_nutrition_store`;

CREATE TABLE `online_nutrition_store`.`category` (
  `categoryID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`language` (
  `languageID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`languageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`translation` (
  `translationID` int NOT NULL AUTO_INCREMENT,
  `label` varchar(45) NOT NULL,
  `CategoryFK` int NOT NULL,
  `LanguageFK` int NOT NULL,
  PRIMARY KEY (`translationID`),
  FOREIGN KEY (`CategoryFK`) REFERENCES `category` (`categoryID`),
  FOREIGN KEY (`LanguageFK`) REFERENCES `language` (`languageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`customer` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `birthDate` date NOT NULL,
  `nbFidelityPoints` int DEFAULT '0',
  `streetName` varchar(45) NOT NULL,
  `streetNumber` varchar(45) NOT NULL,
  `locality` varchar(45) NOT NULL,
  `zipCode` int NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`customerID`),
  UNIQUE KEY (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`discount` (
  `discountID` int NOT NULL AUTO_INCREMENT,
  `discount` int NOT NULL,
  `label` varchar(45) NOT NULL,
  PRIMARY KEY (`discountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`item` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `label` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `brand` varchar(45) NOT NULL,
  `currentInventory` int NOT NULL,
  `CategoryID` int NOT NULL,
  `DiscountID` int DEFAULT NULL,
  PRIMARY KEY (`itemID`),
  FOREIGN KEY (`CategoryFK`) REFERENCES `category` (`categoryID`),
  FOREIGN KEY (`DiscountFK`) REFERENCES `discount` (`discountID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`order` (
  `orderID` int NOT NULL,
  `date` date NOT NULL,
  `isPaid` tinyint NOT NULL,
  `reduction` int DEFAULT NULL,
  `CustomerFK` int DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  FOREIGN KEY (`CustomerFK`) REFERENCES `customer` (`customerID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`orderLine` (
  `orderLineID` int NOT NULL,
  `price` double NOT NULL,
  `deliveryDate` date NOT NULL,
  `quantity` int NOT NULL,
  `ItemFK` int DEFAULT NULL,
  `OrderFK` int DEFAULT NULL,
  PRIMARY KEY (`orderLineID`),
  FOREIGN KEY (`ItemFK`) REFERENCES `item` (`itemID`) ON DELETE SET NULL,
  FOREIGN KEY (`OrderFK`) REFERENCES `order` (`orderID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP trigger IF EXISTS online_nutrition_store.decreaseStock;

DELIMITER |
create trigger online_nutrition_store.decreaseStock 
after insert on orderLine
 for each row
 begin 
 update item 
 set item.currentInventory = item.currentInventory - NEW.quantity
 where item.itemID = NEW.ItemFK;
 end|
 
 DROP trigger IF EXISTS online_nutrition_store.decreaseFidelityPoints;

DELIMITER |
create trigger online_nutrition_store.decreaseFidelityPoints
after insert on `order`
 for each row
 begin 
 DECLARE user_FidelityPoint integer;
 SELECT nbFidelityPoints INTO user_FidelityPoint FROM customer WHERE customerID = NEW.CustomerFK;
 if(user_FidelityPoint >= 100) THEN
 update customer 
 set customer.nbFidelityPoints =  customer.nbFidelityPoints -  100
 where customer.customerID = NEW.CustomerFK;
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

INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Protéines', 1, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Proteins', 1, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Développement musculaire', 2, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Muscle development', 2, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Energie (et endurance)', 3, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Energy (and endurance)', 3, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Brûleurs de graisse et perte de poids', 4, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Fat burners and weight loss', 4, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Vitamines', 5, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Vitamins', 5, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Snacks et boissons', 6, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Snack and drinks', 6, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Accessoires', 7, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `CategoryFK`, `LanguageFK`) VALUES ('Accessories', 7, 2);

INSERT INTO `online_nutrition_store`.`customer` (`email`, `password`, `firstName`, `lastName`, `phoneNumber`, `birthDate`, `streetName`, `streetNumber`, `locality`, `zipCode`, `country`) VALUES ('nico6041@hotmail.be', 'nico4587', 'Nicolas', 'Gatta', '0479837036', '1997-11-25', 'rue des bouleaxu', '27', 'Courcelles', 5780, 'Belgique');
INSERT INTO `online_nutrition_store`.`customer` (`email`, `password`, `firstName`, `lastName`, `phoneNumber`, `birthDate`, `streetName`, `streetNumber`, `locality`, `zipCode`, `country`) VALUES ('dylan.sohet@gmail.com', 'password123', 'Dylan', 'Sohet', '0478070905', '2000-11-20', 'Rue du chêne', '50A', 'Belfosse', 9532, 'Belgique');
INSERT INTO `online_nutrition_store`.`customer` (`email`, `password`, `firstName`, `lastName`, `phoneNumber`, `birthDate`, `streetName`, `streetNumber`, `locality`, `zipCode`, `country`) VALUES ('Michou7854@outlook.be', 'azerty789', 'Michel', 'Forever', '0471258963', '1995-06-11', 'Rue Tonight', '85A', 'Fiesta', 4578, 'Belgique');

INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (15, 'Christmas');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (70, 'Destocking');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (40, 'Black Friday');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (25, 'Cyber Monday');

INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `currentInventory`, `CategoryFK`, `DiscountFK`) VALUES ('Whey', 'A protein powder', 20, 'Prozis', 150, 1, 1);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `currentInventory`, `CategoryFK`, `DiscountFK`) VALUES ('Whey isolate', 'A protein powder with less sugar and fat', 35, 'Prozis', 100, 1, NULL);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `currentInventory`, `CategoryFK`, `DiscountFK`) VALUES ('Mass gainer', 'A protein powder that will help you to gain mass', 40, 'MyProtein', 200, 2, 3);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `currentInventory`, `CategoryFK`, `DiscountFK`) VALUES ('BCAA', 'Amino acids in powder', 30, 'Prozis', 150, 1, NULL);
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `currentInventory`, `CategoryFK`, `DiscountFK`) VALUES ('BCAA', 'Amino acids in caps', 25, 'Prozis', 200, 1, NULL);