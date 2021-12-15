SET NAMES utf8mb4;

DROP DATABASE IF EXISTS facultative;
CREATE DATABASE facultative CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE facultative;

CREATE TABLE roles (
	id INT NOT NULL PRIMARY KEY,
	role VARCHAR(20) NOT NULL UNIQUE)
ENGINE=InnoDB;

INSERT INTO roles (id, role) VALUES (0, 'admin');
INSERT INTO roles (id, role) VALUES (1, 'teacher');
INSERT INTO roles (id, role) VALUES (2, 'student');

CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	login VARCHAR(20) NOT NULL UNIQUE,
	password CHAR(64) NOT NULL,
	salt CHAR(6) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	status VARCHAR(20) NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	role_id INT NOT NULL,
	FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE)
ENGINE=InnoDB;

INSERT INTO users VALUES (default, 'admin', '76b149339c08889b4b76899f619e2a65e390661ce37fa8d8ae37e54fcc97c534', 'kLSMsZ', 'admin@facultative.org', 'active', 'Admin', 'Admin', 0);
INSERT INTO users VALUES (default, 'smith', '676770b947e6c3107f41b8f698dd7d6d8e8a5ced70f23cec4c942f8f53670dd0', 'jG9LMp', 'smith@gmail.com', 'active', 'John', 'Smith', 1);
INSERT INTO users VALUES (default, 'goldsmith', '873803985a7ee02cd081eb936d8850d0e33a9008cf309524ca12afada6fb1a4c', 'o0MTl2', 'goldsmith@gmail.com', 'active', 'Jack', 'Goldsmith', 1);
INSERT INTO users VALUES (default, 'jackson', '4daf10b13dc509e78b9beff076786fb76fbf78d609735552ee0fe958e308c48a', 'W1yJii', 'jackson@gmail.com', 'active', 'James', 'Jackson', 1);
INSERT INTO users VALUES (default, 'muller', '1a5bc5b79639fa5debf3c67e63bd42a56ee1349b9e9e4a89e304cb60385e8163', 'wmt99L', 'muller@gmail.com', 'active', 'Andreas', 'Muller', 1);
INSERT INTO users VALUES (default, 'hoffman', '4e4c79bc257638c5611e9c14631261ca338a80636e125d82447a5e4857b89bea', 'A7b16k', 'hoffman@gmail.com', 'active', 'Kurt', 'Hoffman', 1);
INSERT INTO users VALUES (default, 'ramble', '66d89c136907f0e91e0331c5453660073233ec99763a61f1f5817095ce4fd793', 'l1WM0l', 'ramble@gmail.com', 'active', 'Frank', 'Ramble', 1);
INSERT INTO users VALUES (default, 'dubua', '48afbedb6bcbbe9600a6ed81302a3b30f808345071fa932376cf9138a97fe810', 'S5hBxT', 'dubua@gmail.com', 'active', 'Marceille', 'Dubua', 1);
INSERT INTO users VALUES (default, 'lopez', '95fc5a9cb5d57cbef5124aae02f3b78333c7f1ad58f99633fb9a4cf52fa95616', 'dby17J', 'lopez@gmail.com', 'active', 'Rodrigo', 'Lopez', 1);
INSERT INTO users VALUES (default, 'garcia', 'f3bcbff33bc805d09ff6c4e4e0a871b5ea399e6c32703b4cd3cebaf0dd3a5903', 'CoSmt2', 'garcia@gmail.com', 'active', 'Federico', 'Garcia', 1);
INSERT INTO users VALUES (default, 'petrenko', '8a16937d86bc15f7027da88df209027adabade4b840b9c62bc703c2118ebe81f', 'b8Mp7g', 'petrenko@gmail.com', 'active', 'Олександр', 'Петренко', 1);
INSERT INTO users VALUES (default, 'korolenko', '334ff858eb64c989f4e094bb5bd73c402329146d36491c9900b9e47a190ce9c8', 'G31MsA', 'korolenko@gmail.com', 'active', 'Андрій', 'Короленко', 1);
INSERT INTO users VALUES (default, 'petrov', '798a79e48e56764c5ffbde2adfa2fa82c0577839422f7b12fac4e2c4eed4b2c9', 'gX9eGJ', 'petrov@gmail.com', 'active', 'Петро', 'Петров', 2);
INSERT INTO users VALUES (default, 'ivanov', 'cbacc395ee517385d0ecdc9b9a5cc7da66c5b60923f1f9cee3b9c9ade049fff4', 'TxoP8L', 'ivanov@gmail.com', 'active', 'Ivan', 'Ivanov', 2);
INSERT INTO users VALUES (default, 'sidorov', 'cbe2aee4dcdcf9cc61ee06ed176e6c7095c3597947ad6c11c37614ffb2a2dc7a', 'Psc1tW', 'sidorov@gmail.com', 'active', 'Sidor', 'Sidorov', 2);
INSERT INTO users VALUES (default, 'savchuk', '6a6a45d8639094c4c0d7a358fd7f0bbfda4f14394447f6f1ce35bf345ba59f07', 'yLs5FG', 'savchuk@gmail.com', 'active', 'Alexander', 'Savchuk', 2);
INSERT INTO users VALUES (default, 'tarasenko', '816d1b6e5c28fcf255dc15fa883b4d7f59732b9e6cd9a57c048cfe2f7d011359', 'Ose0Mp', 'tarasenko@gmail.com', 'active', 'Тарас', 'Тарасенко', 2);
INSERT INTO users VALUES (default, 'zorin', 'b49e9df2eca01af4b8cf3f21fce5bc7afc06c56d5abfba653b5fd9f50e17c547', 'sW6MpQ', 'zorin@gmail.com', 'active', 'Зорян', 'Зорін', 2);
INSERT INTO users VALUES (default, 'olegov', 'bd6497a06caa6847bd550be8cb0f63803cb192b59bed076ad9cb31fb11b19b8b', 'MB4sp6', 'olegov@gmail.com', 'active', 'Oleg', 'Olegov', 2);
INSERT INTO users VALUES (default, 'helenova', 'e3515a0759a30fdcda178d00f9d5e3a5bb362a527c1380c880f1a419e62b64b5', 'l1o01L', 'helenova@gmail.com', 'active', 'Helena', 'Helenova', 2);
INSERT INTO users VALUES (default, 'kuzmenko', '72f5081295f0cfa6ff21824f2de75374e38972b5caf0ac5072e72b9657740784', 'jzYe5M', 'kuzmenko@gmail.com', 'active', 'Кузьма', 'Кузьменко', 2);
INSERT INTO users VALUES (default, 'annina', 'c6031bbfaef56d1e608ab1f2d7437ffa5861bbe86a1294159f1aa2561d44f483', 'ijk65R', 'annina@gmail.com', 'active', 'Anna', 'Annina', 2);
INSERT INTO users VALUES (default, 'lesenko', '6074ce3950a04045e99246bf0bcb468f1001e223e4b9350c5389cd088173fd5c', 'ZOG0l1', 'lesenko@gmail.com', 'active', 'Lesya', 'Lesenko', 2);
INSERT INTO users VALUES (default, 'gabriliuk', '9c1ef62cad68b39025b12f426fc386c3fc0f53925050eb66acaf80cf69c4cab9', 'mQp2Gk', 'gabriliuk@gmail.com', 'active', 'Габріела', 'Габрілюк', 2);

CREATE TABLE courses (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	theme VARCHAR(255) NOT NULL,
	teacher_id INT NOT NULL,
	start_date DATE NOT NULL,
	finish_date DATE NOT NULL,
	length INT NOT NULL,
	students INT default 0 NOT NULL,
	FOREIGN KEY (teacher_id) REFERENCES users (id) ON DELETE CASCADE)
ENGINE=InnoDB;

INSERT INTO courses VALUES (default, 'Intermediate German Winter 2021', 'German', 5, '2021-02-01', '2021-07-10', 159, 3);
INSERT INTO courses VALUES (default, 'Advanced German Spring 2021', 'German', 5, '2021-03-01', '2021-08-10', 162, 1);
INSERT INTO courses VALUES (default, 'Elementary German Spring 2021', 'German', 2, '2021-05-01', '2021-07-15', 75, 10);
INSERT INTO courses VALUES (default, 'Elementary English Summer 2021', 'English', 2, '2021-06-01', '2021-09-07', 98, 12);
INSERT INTO courses VALUES (default, 'Intermediate English Autumn 2021', 'English', 2, '2021-09-01', '2021-12-23', 113, 1);
INSERT INTO courses VALUES (default, 'Advanced English Autumn 2021', 'English', 3, '2021-10-20', '2022-01-31', 103, 1);
INSERT INTO courses VALUES (default, 'Business English Autumn 2021', 'English', 4, '2021-11-01', '2022-01-31', 91, 1);
INSERT INTO courses VALUES (default, 'Technical English Summer 2021', 'English', 2, '2021-06-01', '2021-08-31', 91, 2);
INSERT INTO courses VALUES (default, 'English For Lawyers Autumn 2021', 'English', 2, '2021-09-01', '2021-12-21', 111, 1);
INSERT INTO courses VALUES (default, 'Business German Summer 2021', 'German', 6, '2021-08-20', '2021-11-30', 102, 1);
INSERT INTO courses VALUES (default, 'Technical German Winter 2022', 'German', 2, '2021-12-01', '2022-02-28', 89, 1);
INSERT INTO courses VALUES (default, 'German For Lawyers Summer 2021', 'German', 2, '2021-06-01', '2021-08-31', 91, 1);
INSERT INTO courses VALUES (default, 'Elementary French Winter 2022', 'French', 4, '2021-12-03', '2022-03-19', 106, 1);
INSERT INTO courses VALUES (default, 'Intermediate French Summer 2021', 'French', 5, '2021-07-11', '2021-11-25', 137, 1);
INSERT INTO courses VALUES (default, 'Advanced French Winter 2022', 'French', 7, '2022-01-01', '2022-07-01', 181, 1);
INSERT INTO courses VALUES (default, 'Business French Summer 2021', 'French', 6, '2021-08-21', '2021-12-06', 107, 1);
INSERT INTO courses VALUES (default, 'Technical French Autumn 2021', 'French', 7, '2021-09-05', '2021-12-31', 117, 1);
INSERT INTO courses VALUES (default, 'French For Lawyers Autumn 2021', 'French', 8, '2021-11-08', '2022-01-15', 68, 1);
INSERT INTO courses VALUES (default, 'Elementary Spanish Autumn 2021', 'Spanish', 8, '2021-08-31', '2021-11-17', 78, 1);
INSERT INTO courses VALUES (default, 'Intermediate Spanish Summer 2021', 'Spanish', 9, '2021-08-15', '2021-11-24', 101, 1);
INSERT INTO courses VALUES (default, 'Advanced Spanish Winter 2022', 'Spanish', 10, '2021-12-01', '2022-03-21', 110, 1);
INSERT INTO courses VALUES (default, 'Business Spanish Spring 2021', 'Spanish', 9, '2021-04-10', '2021-08-31', 143, 1);
INSERT INTO courses VALUES (default, 'Technical Spanish Autumn 2021', 'Spanish', 10, '2021-09-11', '2022-02-01', 143, 1);
INSERT INTO courses VALUES (default, 'Spanish For Lawyers Autumn 2021', 'Spanish', 10, '2021-11-08', '2022-02-15', 99, 1);
INSERT INTO courses VALUES (default, 'Елементарна Українська Осень 2021', 'Ukrainian', 2, '2021-09-01', '2021-12-22', 112, 1);
INSERT INTO courses VALUES (default, 'Середня Українська Весна 2021', 'Ukrainian', 11, '2021-03-25', '2021-06-30', 97, 1);
INSERT INTO courses VALUES (default, 'Продвинута Українська Осень 2021', 'Ukrainian', 12, '2021-09-01', '2022-01-20', 141, 1);
INSERT INTO courses VALUES (default, 'Українська для бізнеса Зима 2022', 'Ukrainian', 11, '2021-12-06', '2022-04-30', 145, 1);
INSERT INTO courses VALUES (default, 'Технічна Українська Осень 2021', 'Ukrainian', 2, '2021-11-01', '2022-01-30', 90, 1);
INSERT INTO courses VALUES (default, 'Українська для юристів Весна 2021', 'Ukrainian', 12, '2021-05-10', '2021-08-27', 109, 1);
INSERT INTO courses VALUES (default, 'Українська для медиків Зима 2022', 'Ukrainian', 12, '2021-12-10', '2022-03-31', 111, 1);
INSERT INTO courses VALUES (default, 'Medical English Summer 2021', 'English', 3, '2021-06-10', '2021-08-31', 82, 1);
INSERT INTO courses VALUES (default, 'Medical German Summer 2021', 'German', 6, '2021-07-01', '2021-09-27', 88, 1);

CREATE TABLE courses_students (
	course_id INT NOT NULL,
	student_id INT NOT NULL,
	mark INT NULL,
	FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE,
	FOREIGN KEY (student_id) REFERENCES users (id) ON DELETE CASCADE)
ENGINE=InnoDB;

INSERT INTO courses_students VALUES (1, 13, 74);
INSERT INTO courses_students VALUES (2, 13, 70);
INSERT INTO courses_students VALUES (3, 13, 80);
INSERT INTO courses_students VALUES (4, 13, 84);
INSERT INTO courses_students VALUES (5, 13, default);
INSERT INTO courses_students VALUES (6, 13, default);
INSERT INTO courses_students VALUES (7, 13, default);
INSERT INTO courses_students VALUES (8, 13, 75);
INSERT INTO courses_students VALUES (9, 13, default);
INSERT INTO courses_students VALUES (10, 13, default);
INSERT INTO courses_students VALUES (11, 13, default);
INSERT INTO courses_students VALUES (12, 13, 77);
INSERT INTO courses_students VALUES (13, 13, default);
INSERT INTO courses_students VALUES (14, 13, default);
INSERT INTO courses_students VALUES (15, 13, default);
INSERT INTO courses_students VALUES (16, 13, default);
INSERT INTO courses_students VALUES (17, 13, default);
INSERT INTO courses_students VALUES (18, 13, default);
INSERT INTO courses_students VALUES (19, 13, default);
INSERT INTO courses_students VALUES (20, 13, default);
INSERT INTO courses_students VALUES (21, 13, default);
INSERT INTO courses_students VALUES (22, 13, 79);
INSERT INTO courses_students VALUES (23, 13, default);
INSERT INTO courses_students VALUES (24, 13, default);
INSERT INTO courses_students VALUES (25, 13, default);
INSERT INTO courses_students VALUES (26, 13, 91);
INSERT INTO courses_students VALUES (27, 13, default);
INSERT INTO courses_students VALUES (28, 13, default);
INSERT INTO courses_students VALUES (29, 13, default);
INSERT INTO courses_students VALUES (30, 13, 82);
INSERT INTO courses_students VALUES (31, 13, default);
INSERT INTO courses_students VALUES (32, 13, 91);
INSERT INTO courses_students VALUES (33, 13, 73);

INSERT INTO courses_students VALUES (1, 14, 85);
INSERT INTO courses_students VALUES (3, 14, 89);
INSERT INTO courses_students VALUES (4, 14, 95);
INSERT INTO courses_students VALUES (3, 15, 65);
INSERT INTO courses_students VALUES (4, 15, 88);


INSERT INTO courses_students VALUES (1, 16, 75);
INSERT INTO courses_students VALUES (4, 16, 77);
INSERT INTO courses_students VALUES (3, 17, 60);
INSERT INTO courses_students VALUES (4, 17, 79);
INSERT INTO courses_students VALUES (4, 18, 89);
INSERT INTO courses_students VALUES (8, 18, 98);
INSERT INTO courses_students VALUES (3, 19, 55);
INSERT INTO courses_students VALUES (4, 19, 69);
INSERT INTO courses_students VALUES (3, 20, 93);
INSERT INTO courses_students VALUES (4, 20, 89);
INSERT INTO courses_students VALUES (3, 21, 76);
INSERT INTO courses_students VALUES (4, 21, 81);
INSERT INTO courses_students VALUES (3, 22, 96);
INSERT INTO courses_students VALUES (4, 22, 88);
INSERT INTO courses_students VALUES (3, 23, 84);
INSERT INTO courses_students VALUES (4, 23, 90);
INSERT INTO courses_students VALUES (3, 24, 93);
INSERT INTO courses_students VALUES (4, 24, 93);
