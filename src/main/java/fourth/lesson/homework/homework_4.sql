CREATE SCHEMA `cinema` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ; 
-- ----------------------------------------------------------------------------------
CREATE TABLE `cinema`.`film_tbl` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title_fld` VARCHAR(255) NOT NULL,
  `duration_tbl` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci; 
-- ---------------------------------------------------
CREATE TABLE `cinema`.`session_tbl` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `film_id` INT UNSIGNED NOT NULL,
  `time_fld` TIME NOT NULL,
  `date_fld` DATE NOT NULL,
  `price_fld` INT UNSIGNED NOT NULL,
  INDEX (`id` ASC) INVISIBLE,
  INDEX (`film_id` ASC) INVISIBLE,
  CONSTRAINT `film_id_fk_idx`
    FOREIGN KEY (`film_id`)
    REFERENCES `cinema`.`film_tbl` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- ------------------------------------------------------------
CREATE TABLE `cinema`.`tickets_tbl` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `session_id` INT UNSIGNED NOT NULL,
  `amount_fld` INT UNSIGNED NOT NULL DEFAULT 0,
  INDEX `id` (`id` ASC) INVISIBLE,
  INDEX `session_id` (`session_id` ASC) INVISIBLE,
  CONSTRAINT `session_id_fk_idx`
    FOREIGN KEY (`session_id`)
    REFERENCES `cinema`.`session_tbl` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci; 

-- ---------------------------------------------------------------------------------

INSERT INTO `cinema`.`film_tbl` (`id`, `title_fld`, `duration_tbl`) VALUES ('1', 'Film_1', '60');
INSERT INTO `cinema`.`film_tbl` (`id`, `title_fld`, `duration_tbl`) VALUES ('2', 'Film_2', '60');
INSERT INTO `cinema`.`film_tbl` (`id`, `title_fld`, `duration_tbl`) VALUES ('3', 'Film_3', '60');
INSERT INTO `cinema`.`film_tbl` (`id`, `title_fld`, `duration_tbl`) VALUES ('4', 'Film_4', '60');

-- --------------------------------------------------------------------------------------

SELECT
	f1.title_fld AS `Film_1`,
	s1.time_fld AS `Film_1 session beginning time`,
	f1.duration_fld AS `Film_1 duration`,
	f2.title_fld AS `Film_2`,
	s2.time_fld AS `Film_2 session beginning time`,
	m2.duration_fld AS `Film_2 duration`
FROM
	session_tbl AS s1
JOIN
    session_tbl AS s2
JOIN
    film_tbl AS f1
JOIN
    film_tbl AS f2
ON
	s1.film_id = f1.id AND s2.film_id = f2.id
WHERE
	s2.time_fld < (s1.time_fld+f1.duration_fld) AND s2.time_fld > s1.time_fld
ORDER BY f1.duration_fld;

-- ---------------------------------------------------------------------------
SELECT
	f1.title_fld AS `Film_1`,
	s1.time_fld AS `Film_1 session beginning time`,
	m1.duration_fld AS `Film_1 duration`,
	m2.title_fld AS `Film_2`,
	s2.time_fld AS `Film_2 session beginning time`,
	m2.duration_fld AS `Film_2 duration`,
    min(time(s2.time_fld - (s1.time_fld+f1.duration_fld))) AS `Break between films' sessions`
FROM
	session_tbl AS s1
JOIN
    session_tbl AS s2
JOIN
    film_tbl AS f1
JOIN
    film_tbl AS f2
ON
	s1.film_id = f1.id AND s2.film_id = f2.id
WHERE
	time(s2.time_fld - (s1.time_fld+f1.duration_fld))>"00:30:00"
AND
	(s2.id-s1.id)=1 
GROUP BY f1.title_fld
ORDER BY `Break between films' sessions` DESC; 

-- ------------------------------------------------------
SELECT
	s.id AS `id`,
    f.title_fld AS `Film's title`,
    sum(t.amount_fld) AS `amount of spectators`,
    avg(t.amount_fld) AS `average of spectators`,
    sum(s.price_fld*t.amount_fld) AS `Income`
FROM
	film_tbl AS f
JOIN
    session_tbl AS s
JOIN
    tickets_tbl AS t
ON
    s.film_id = f.id AND t.session_id = s.id
GROUP BY f.title_fld WITH ROLLUP
ORDER BY Income DESC; 



-- -------------------------------------------------------
SELECT
	"From 9:00 to 15:00" AS among,
	sum(t.amount_fld) AS spectators,
    sum(t.amount_fld*s.price_fld) AS income
FROM
	tickets_tbl AS t
JOIN
	session_tbl AS s
ON
	t.session_id = s.id
WHERE
	s.time_fld > "09:00:00" AND s.time_fld < "15:00:00"
UNION
SELECT
	"From 15:00 to 18:00" AS among,
	sum(t.amount_fld) AS spectators_2,
    sum(t.amount_fld*s.price_fld) AS income_2
FROM
	tickets_tbl AS t
JOIN
	session_tbl AS s
ON
	t.session_id = s.id
WHERE
	s.time_fld > "15:00:00" AND s.time_fld < "18:00:00"
UNION
SELECT
	"From 18:00 to 21:00" AS among,
	sum(t.amount_fld) AS spectators_3,
    sum(t.amount_fld*s.price_fld) AS income_3
FROM
	tickets_tbl AS t
JOIN
	session_tbl AS s
ON
	t.session_id = s.id
WHERE
	s.time_fld > "18:00:00" AND s.time_fld < "21:00:00"
UNION
SELECT
	"From 21:00 to 00:00" AS among,
	sum(t.amount_fld) AS spectators_4,
    sum(t.amount_fld*s.price_fld) AS income_4
FROM
	tickets_tbl AS t
JOIN
	session_tbl AS s
ON
	t.session_id = s.id
WHERE
	s.time_fld > "21:00:00" AND s.time_fld < "24:00:00"; 