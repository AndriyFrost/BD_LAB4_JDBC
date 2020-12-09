drop database if exists `andriy_moroz`;
create database `andriy_moroz`;

use `andriy_moroz`;

CREATE TABLE IF NOT EXISTS `country` (
  `id` int not null primary key auto_increment,
  `capital` VARCHAR(45) NOT NULL,
  `population` INT NOT NULL,
  `area_in_sk` DOUBLE NOT NULL,
  `country_name` VARCHAR(100) NOT NULL);

CREATE TABLE IF NOT EXISTS `cinema` (
  `id` int not null primary key auto_increment,
  `city` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `country_id` INT NOT NULL,
  UNIQUE INDEX `address_UNIQUE` (`address` ASC) VISIBLE,
  CONSTRAINT `fk_cinema_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `andriy_moroz`.`country` (`id`));

CREATE TABLE IF NOT EXISTS `film` (
  `id` int not null primary key auto_increment,
  `move_title` VARCHAR(100) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `descripttion` TEXT NOT NULL,
  `release_date` VARCHAR(100) NOT NULL);


CREATE TABLE IF NOT EXISTS `hall` (
  `id` int not null primary key auto_increment,
  `number_of_seats` INT NOT NULL,
  `cinema_id` INT NOT NULL,
  CONSTRAINT `fk_hall_cinema1`
    FOREIGN KEY (`cinema_id`)
    REFERENCES `andriy_moroz`.`cinema` (`id`));


CREATE TABLE IF NOT EXISTS `man` (
  `id` int not null primary key AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `gender` VARCHAR(45) NOT NULL);

CREATE TABLE IF NOT EXISTS `actor` (
  `acting_education` INT NOT NULL,
  `biography` TEXT NOT NULL,
  `manId` INT UNIQUE NOT NULL, FOREIGN KEY(`manId`) REFERENCES `man`(`id`));

CREATE TABLE IF NOT EXISTS `review` (
`id` int not null primary key auto_increment,
  `response` TEXT NOT NULL,
  `rating` INT NOT NULL,
  `recommended` INT NOT NULL,
  `man_id` INT NOT NULL,
  `film_id` INT NOT NULL,
  CONSTRAINT `fk_review_film1`
    FOREIGN KEY (`film_id`)
    REFERENCES `andriy_moroz`.`film` (`id`),
  CONSTRAINT `fk_review_man1`
    FOREIGN KEY (`man_id`)
    REFERENCES `andriy_moroz`.`man` (`id`));

CREATE TABLE IF NOT EXISTS `film_has_actor` (
  `film_id` INT NOT NULL ,
  `actor_id` INT NOT NULL ,
  PRIMARY KEY (`film_id`, `actor_id`),
  CONSTRAINT `fk_film_has_actor_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `andriy_moroz`.`actor` (`manId`),
  CONSTRAINT `fk_film_has_actor_film1`
    FOREIGN KEY (`film_id`)
    REFERENCES `andriy_moroz`.`film` (`id`));

CREATE TABLE IF NOT EXISTS `session` (
  `id` int not null primary key auto_increment,
  `event_time` VARCHAR(45) NOT NULL,
  `ticket_price` VARCHAR(45) NOT NULL,
  `tickets_sold` VARCHAR(45) NOT NULL DEFAULT '0',
  `film_id` INT NOT NULL,
  `hall_id` INT NOT NULL,
  CONSTRAINT `fk_session_film1`
    FOREIGN KEY (`film_id`)
    REFERENCES `andriy_moroz`.`film` (`id`),
  CONSTRAINT `fk_session_hall1`
    FOREIGN KEY (`hall_id`)
    REFERENCES `andriy_moroz`.`hall` (`id`));

INSERT INTO country (capital,population,area_in_sk, country_name)VALUES
('Kyiv', '232', '55.13', 'Ukrane'),
('capital1', '234', '55.13', 'Country1'),
('capital2', '232', '55.13', 'Country2'),
('capital3', '232', '55.13', 'Country3'),
('capital4', '232', '55.13', 'Country4'),
('capital5', '232', '55.13', 'Country5'),
('capital6', '232', '55.13', 'Country6'),
('capital7', '232', '55.13', 'Country7'),
('capital8', '232', '55.13', 'Country8'),
('capital9', '232', '55.13', 'Country9'),
('capital10', '232', '55.13', 'Country10');


INSERT INTO cinema (city,address,country_id)VALUES
('city1', 'adress1',1),
('city2', 'adress2', 2),
('city3', 'adress3', 3),
('city4', 'adress4', 4),
('city5', 'adress5', 5),
('city6', 'adress6', 6),
('city7', 'adress7', 7),
('city8', 'adress8', 8),
('city9', 'adress9', 9),
('city10', 'adress10', 10),
('city11', 'adress11', 11);

INSERT INTO film (move_title,genre,descripttion,release_date)VALUES
('move1', 'genre1', 'some description','2000-01-01'),
('move2', 'genre2', 'some description','2000-01-01'),
('move3', 'genre1', 'some description','2000-01-01'),
('move4', 'genre2', 'some description','2000-01-01'),
('move5', 'genre1', 'some description','2000-01-01'),
('move6', 'genre3', 'some description','2000-01-01'),
('move7', 'genre1', 'some description','2000-01-01'),
('move8', 'genre3', 'some description','2000-01-01'),
('move9', 'genre2', 'some description','2000-01-01'),
('move10', 'genre1', 'some description','2000-01-01'),
('move11', 'genre3', 'some description','2000-01-01');

INSERT INTO hall (number_of_seats,cinema_id)VALUES
(252,  1),
(252, 2),
(252,  2),
(252,  3),
(252,  4),
(252,  6),
(252,  7),
(252,  4),
(252,  9),
(252,  10),
(252,  10);

INSERT INTO man (first_name,last_name,age, gender)VALUES
('first_name1', 'last_name1', 22, 'gender1'),
('first_name2', 'last_name2', 22, 'gender1'),
('first_name3', 'last_name3', 22, 'gender1'),
('first_name4', 'last_name4', 22, 'gender0'),
('first_name5', 'last_name5', 22, 'gender0'),
('first_name6', 'last_name6', 32, 'gender0'),
('first_name7', 'last_name7', 19, 'gender0'),
('first_name8', 'last_name8', 21, 'gender1'),
('first_name9', 'last_name9', 21, 'gender1'),
('first_name10', 'last_name10', 33, 'gender0'),
('first_name11', 'last_name11', 43, 'gender1');


INSERT INTO actor (acting_education,biography,manId)VALUES
(1, 'biography', 1),
(1, 'biography', 2),
(1, 'biography', 3),
(0, 'biography', 4),
(0, 'biography', 5),
(1, 'biography', 6),
(1, 'biography', 7),
(1, 'biography', 8),
(1, 'biography', 9),
(0, 'biography', 10),
(0, 'biography', 11);

INSERT INTO review (response,rating,recommended, man_id,film_id)VALUES
('response1', 4, 0, 1,2),
('response2', 7, 1, 1,5),
('response3', 9, 1, 2,3),
('response4', 10, 1, 4,5),
('response5', 5, 0, 5,5),
('response6', 7, 1, 2,4),
('response7', 9, 1, 7,7),
('response8', 10, 1, 7,7),
('response9', 2, 0, 8,7),
('response10', 5, 1, 1,9),
('response11', 7, 1, 10,10);

INSERT INTO film_has_actor (film_id,actor_id)VALUES
(1, 1),
(1,  2),
(1,  3),
(2, 4),
(7,  5),
(9,  6),
(4,  7),
(1,  8),
(1,  9),
(2,  10),
(3,  1);

INSERT INTO `session` (event_time,ticket_price,tickets_sold, film_id,hall_id)VALUES
('2020-11-11', 200, 22, 2,2),
('2020-11-11', 200, 22, 2,1),
('2020-11-11', 200, 22, 1,4),
('2020-11-11', 200, 22, 7,6),
('2020-11-11', 200, 22, 9,8),
('2020-11-11', 200, 32, 2,1),
('2020-11-11', 200, 19, 4,9),
('2020-11-11', 200, 21, 10,1),
('2020-11-11', 200, 21, 3,7),
('2020-11-11', 200, 33, 2,6),
('2020-11-11', 200, 43, 5,4);


CREATE INDEX IX_ManName
ON man(first_name);

CREATE INDEX IX_FilmTitle
ON film(move_title);
