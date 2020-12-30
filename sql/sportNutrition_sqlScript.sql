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
  UNIQUE KEY (`username`),
  CONSTRAINT chk_phone CHECK(phone_number != '')
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
  `file_path` varchar(45) NOT NULL,
  PRIMARY KEY (`item_id`),
  FOREIGN KEY (`category_fk`) REFERENCES `category` (`category_id`),
  FOREIGN KEY (`discount_fk`) REFERENCES `discount` (`discount_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `delivery_date` date NOT NULL,
  `is_paid` tinyint NOT NULL,
  `reduction` int DEFAULT NULL,
  `customer_fk` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`customer_id`) ON DELETE SET NULL,
  CONSTRAINT chk_date CHECK(delivery_date > order_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_nutrition_store`.`order_line` (
  `order_line_id` int NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `item_fk` int DEFAULT NULL,
  `order_fk` int DEFAULT NULL,
  PRIMARY KEY (`order_line_id`),
  FOREIGN KEY (`item_fk`) REFERENCES `item` (`item_id`) ON DELETE SET NULL,
  FOREIGN KEY (`order_fk`) REFERENCES `order` (`order_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* ------ TRIGGER ------ */

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
 
 /* ------ FILLING ------ */

/* --- Category --- */
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();
INSERT INTO `online_nutrition_store`.`category` VALUES ();

/* --- Language --- */
INSERT INTO `online_nutrition_store`.`language` VALUES ();
INSERT INTO `online_nutrition_store`.`language` VALUES ();

/* --- Translation --- */
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Protéines', 1, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Proteins', 1, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Développement musculaire', 2, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Muscle development', 2, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Energie et endurance', 3, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Energy and endurance', 3, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Brûleurs de graisse et perte de poids', 4, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Fat burners and weight loss', 4, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Vitamines', 5, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Vitamins', 5, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Snacks et boissons', 6, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Snacks and drinks', 6, 2);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Accessoires', 7, 1);
INSERT INTO `online_nutrition_store`.`translation` (`label`, `category_fk`, `language_fk`) VALUES ('Accessories', 7, 2);

/* --- Customer --- */
INSERT INTO `online_nutrition_store`.`customer` (`username`, `password`, `authorities`, `first_name`, `last_name`, `phone_number`, `street_name`, `street_number`, `locality`, `zip_code`, `country`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('nico6041@hotmail.be', '$2a$10$7AShmOyqEhXmDW1HOOHHMe7TnVsVvqrVgMF/Fgoobd6MZJ4mSbFCi', '[ROLE_USER]', 'Nicolas', 'Gatta', '0479837036', /*'1997-11-25',*/ 'rue des bouleaxu', '27', 'Courcelles', 5780, 'Belgique', 1, 1, 1, 1);
INSERT INTO `online_nutrition_store`.`customer` (`username`, `password`, `authorities`, `first_name`, `last_name`, `phone_number`, `street_name`, `street_number`, `locality`, `zip_code`, `country`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('dylan.sohet@gmail.com', '$2a$10$7AShmOyqEhXmDW1HOOHHMe7TnVsVvqrVgMF/Fgoobd6MZJ4mSbFCi', '[ROLE_ADMIN]', 'Dylan', 'Sohet', '0478070905', /*'2000-11-20',*/ 'Rue du chêne', '50A', 'Belfosse', 9532, 'Belgique', 1, 1, 1, 1);
INSERT INTO `online_nutrition_store`.`customer` (`username`, `password`, `authorities`, `first_name`, `last_name`, `phone_number`, `street_name`, `street_number`, `locality`, `zip_code`, `country`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('Michou7854@outlook.be', '$2a$10$7AShmOyqEhXmDW1HOOHHMe7TnVsVvqrVgMF/Fgoobd6MZJ4mSbFCi', '[ROLE_USER]', 'Michel', 'Forever', '0471258963', /*'1995-06-11',*/ 'Rue Tonight', '85A', 'Fiesta', 4578, 'Belgique', 1, 1, 1, 1);
INSERT INTO `online_nutrition_store`.`customer` (`username`, `password`, `authorities`, `first_name`, `last_name`, `phone_number`, `street_name`, `street_number`, `locality`, `zip_code`, `country`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('emma.vdc@domain.be', '$2a$10$q7fL94uRfXuVozBu0JeOmuz/egNFPKT7dKOPslU.5A0UnVQouN59G', '[ROLE_USER]', 'Emma', 'Vandecasteele', '0493222296','Rue Crombouly', '123', 'Thuin', 6530, 'Belgique', 1, 1, 1, 1);

/* --- Discount --- */
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (15, 'Christmas');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (70, 'Destocking');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (40, 'Black Friday');
INSERT INTO `online_nutrition_store`.`discount` (`discount`,`label`) VALUES (25, 'Cyber Monday');

/* --- Item --- */

/* - Proteins - */
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Atomic Whey', 'A whey concentrate protein powder', 20, 'Atomic Bear', 150, 1, 1, 'atomicWhey.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Mutant Whey', 'A multi whey protein blend powder', 35, 'Mutant', 100, 1, NULL, 'mutantWhey.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Hydro Isolate Whey', 'Exceptionally bioavailable protein source', 15, 'Xcore', 150, 1, 3, 'hydroIsolateWhey.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Hydro Isolate Whey Zero', 'Exceptionally bioavailable protein source', 30, 'Xcore', 80, 1, NULL, 'hydroIsolateWheyZero.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Prime Isolate Whey', 'The most powerful whey produced in the market', 45, 'Prozis', 50, 1, NULL, 'primeIsolateWhey.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Pure Native Isolate Whey', 'Ultra high protein with stevia extract', 25, 'Prozis', 120, 1, 2, 'pureNativeIsolateWhey.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Real Isolate Whey', 'Ultra high protein with less sugars and fat', 35, 'Prozis', 150, 1, NULL, 'realIsolateWhey.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Ripped Isolate Whey', 'Your casual whey but now in pills to take it easier', 30, 'Xcore', 100, 1, NULL, 'rippedIsolateWhey.jpg');
/*INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Xtreme Iso XP', 'Extreme whey protein isolate', 40, 'Xcore', 60, 1, 4, 'xtremeIsoXP.jpg');*/

/* - Muscle dev - */
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Atomic Mass Gainer', 'Food supplement : To gain mass easily with the best brand', 25, 'Atomic Bear', 300, 2, NULL, 'massGainAtomic.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Mutant Mass', 'Muscle mass gainer reserved to mutant warriors only', 30, 'Mutant', 150, 2, 2, 'massGainMut.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Testo boost', 'Testosterone booster build muscle mass', 15, 'BioScience Nutrition', 80, 2, NULL, 'testoBoost.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Hydro Whey Mass', 'The most bioavailable protein source', 25, 'Xcore', 100, 2, 4, 'hydroWheyMass.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Mass Gainer Prime', 'Optimized multi-protein & multi-carb formula', 50, 'Prozis', 50, 2, NULL, 'massGainerPrime.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Real Mass Gainer', 'Scientificaly tested and proved. Optimized to each athlete', 30, 'Prozis', 200, 2, NULL, 'realMassGainer.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Vegan Mass Gainer', 'Plant-based protein formula specially produced for vegans', 25, 'Prozis', 90, 2, NULL, 'veganMassGainer.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Xtreme Mass Gainer', 'The most powerful gainer produced in the market', 45, 'Xcore', 100, 2, 1, 'xtremeMassGainer.jpg');

/* - Energy - */
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Amino Prime', 'BCAAs fortified with magnesium, glutamine, arginine and more', 25, 'XCore', 150, 3, NULL, 'aminoPrime.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('BCAA', 'Stimulate protein synthesis. High, purify and tested ingredient', 15, 'Atomic Bear', 250, 3, 2, 'BCAA.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Big Shot Pre-Workout', 'Increase endurance, energy and concentration during a workout', 20, 'Prozis', 150, 3, NULL, 'bigShot.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Caffeine', 'Increase energy, heartbeats and concentration', 10, 'Prozis', 130, 3, 4, 'caffeine.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Energy Gummies', 'Endurance, sports and vitamins. Easy to eat', 20, 'Prozis', 200, 3, NULL, 'energyGummies.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('L-Carnitine', 'Some pills which help to burn bad fats from body', 15, 'Prozis', 150, 3, NULL, 'LCarnitine.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Atomic 4 Pre-Workout', 'Increase endurance, energy and concentration during a workout', 25, 'Atomic Bear', 125, 3, NULL, 'preWorkout.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Ripped BCAA', 'Stimulate protein synthesis. High, purify and tested ingredient', 50, 'Xcore', 200, 3, 1, 'rippedBCAA.jpg');

/* - Fat Burners - */
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Virgin Coconut Oil', 'Highly appreciated properties and a rich nutritional profile', 20, 'Prozis', 200, 4, NULL, 'coconutOil.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Cut And Burn', 'Optimize the targeted absorption of ingredients', 30, 'Prozis', 200, 4, 2, 'cutAndBurn.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Cutgenic Women', 'Provide a complete action in accordance with your goals', 25, 'Prozis', 200, 4, NULL, 'cutgenicWomen.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Garcinia Cambogia', 'Natural source of hydroxycitric acid which help to burn fats', 20, 'Prozis', 200, 4, NULL, 'garciniaCambogia.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Ginger', 'Help to burn fats with natural properties', 20, 'Prozis', 250, 4, 3, 'ginger.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Xcess After Hours', 'Help your body stay active and perform better', 25, 'XCore', 150, 4, NULL, 'xcessAfterhours.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Xcess Burst', 'Caffeine, guarana, green coffee, green tea and more', 30, 'XCore', 120, 4, NULL, 'xcessBurst.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Xcess Day Burn', 'Help your body stay active and perform better', 35, 'XCore', 100, 4, 4, 'xcessDayBurn.jpg');

/* - Vitamins - */
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('B-Complex', 'Normal energy-yielding metabolism', 15, 'Prozis', 100, 5, NULL, 'bComplex.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Biotin', 'Contributes to normal energy-yielding metabolism', 20, 'Prozis', 150, 5, 1, 'biotin.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Folic Acid', 'Contributes to the normal immune system function', 15, 'Prozis', 200, 5, NULL, 'folicAcid.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Vitamin B12', 'Contributes to normal energy-yielding metabolism', 25, 'Prozis', 250, 5, 4, 'vitaminB12.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Vitamin C & Rose Hip', 'Contributes to the normal function of immune system', 10, 'Prozis', 300, 5, NULL, 'vitaminCAndRoseHip.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Vitamin D3', 'Contributes to the normal function of immune system', 15, 'Prozis', 150, 5, NULL, 'vitaminD3.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Vitamin E', 'Contributes to the protection of cells', 30, 'Prozis', 200, 5, NULL, 'vitaminE.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Vitamin K2', 'Contributes to normal blood clotting', 35, 'Prozis', 100, 5, 2, 'vitaminK2.jpg');

/* - Snack and drinks - */
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Cereals Edge Proteins', 'Your classic cereals but now protein boosted', 10, 'Atomic Bear', 300, 6, NULL, 'cereals.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Chocolate Waffles', 'Some delicious waffles but sugars-free', 10, 'Prozis', 200, 6, NULL, 'chocolateWaffles.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Protein Giant Bar', 'Delicious chocolat bar with zero sugar and prots', 3, 'Atomic Bear', 150, 6, NULL, 'proteinBar.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Zero Chips', 'Want to eat chips but not to get fat ?', 5, 'Prozis', 100, 6, 4, 'zeroChips.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Protein Lemonade', 'Refreshing and good taste lemonade protein boosted', 2, 'Prozis', 250, 6, NULL, 'proteinLemonade.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Protein Smoothie', 'An amazing smoothie without bad fats or sugars', 3, 'Prozis', 200, 6, NULL, 'proteinSmoothie.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Recovery Drink', 'Help to recover your strength and energy after training', 3, 'Prozis', 70, 6, 1, 'recovery.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('XXL Protein Shake', 'Easy to drink, low in sugar and protein boosted', 5, 'XCore', 50, 6, NULL, 'xxlProteinShake.jpg');

/* - Accessories - */
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Water Bottle', 'To bring your drink with your everywhere', 10, 'Atomic Bear', 100, 7, NULL, 'bottle.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Glass Bottle', 'You can put tea or fruits to make them brew', 15, 'Atomic Bear', 50, 7, NULL, 'glassBottle.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Bodybuilding Gloves', 'To protect your hands during training', 20, 'Atomic Bear', 200, 7, NULL, 'gloves.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Knee Pad', 'To protect your knees during training', 30, 'Atomic Bear', 150, 7, NULL, 'kneePad.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Pills Box', 'How to bring your food supplements without this ?', 5, 'Atomic Bear', 300, 7, NULL, 'pillsBox.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Army Shaker', 'Your shaker to easily make your blends', 10, 'Atomic Bear', 200, 7, NULL, 'prozisArmy.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Strength Belt', 'To protect your back during training', 50, 'Atomic Bear', 120, 7, NULL, 'strengthBelt.jpg');
INSERT INTO `online_nutrition_store`.`item` (`label`, `description`, `price`, `brand`, `current_inventory`, `category_fk`, `discount_fk`, `file_path`) VALUES ('Wrist Wraps', 'To protect your wrist during training', 25, 'Atomic Bear', 100, 7, NULL, 'wristWraps.jpg');