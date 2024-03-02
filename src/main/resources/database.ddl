CREATE SCHEMA `java_labs`;
USE java_labs;
CREATE TABLE students (
	id			INT PRIMARY KEY AUTO_INCREMENT,
	last_name		VARCHAR(50) NOT NULL,
	first_name		VARCHAR(50) NOT NULL,
	patronymic		VARCHAR(50),
	birthday		DATE NOT NULL,
	record_book		INT NOT NULL UNIQUE);
INSERT INTO students (last_name, first_name, patronymic, birthday, record_book) 
	VALUES ('Atamanchuk', 'Oleksandra', 'Anatoliivna', '2003-05-17', 0001),
    ('Bekish', 'Hleb', 'Evgeniyovych', '2003-08-09', 0002),
    ('Burlaka', 'Oleksandr', 'Sergiyovych', '2002-12-24', 0003),
    ('But', 'Anastasia', 'Sergiivna', '2003-07-27', 0004),
    ('Vatamanyuk', 'Vladlena', 'Volodymyrivna', '2002-11-14', 0005),
    ('Heyko', 'Sofia', 'Kostiantynivna', '2003-05-13', 0006),
    ('Honcharov', 'Maksym', 'Sergiyovych', '2003-04-23', 0007),
    ('Diduh', 'Stanislav', 'Kostiantynovych', '2002-12-08', 0008),
    ('Kamenskiy', 'Vitaliy', 'Sergiyovych', '2003-07-29', 0009),
    ('Kasterov', 'Viacheslav', 'Oleksandrovych', '2003-03-02', 0010),
    ('Kondrat', 'Anna', 'Dmytrivna', '2002-11-07', 0011),
    ('Kusnetsov', 'Dmytro', 'Kostiantynovych', '2003-02-01', 0012),
    ('Mishenko', 'Mykyta', 'Sergiyovych', '2001-11-10', 0013),
    ('Mudruk', 'Viktoria', 'Dmytrivna', '2002-10-22', 0014),
    ('Namestnykova', 'Alina', 'Andriivna', '2003-03-25', 0015),
    ('Panhenko', 'Dmytro', 'Anatoliyovych', '2002-09-15', 0016),
    ('Piven', 'Ivan', 'Sergiyovych', '2002-12-17', 0017),
    ('Polishuk', 'Denys', 'Dmytrovych', '1996-11-15', 0018),
    ('Potebenko', 'Yehor', 'Dmytrovych', '2003-05-19', 0019),
    ('Sergiienko', 'Oleksandr', 'Sergiyovych', '2002-01-19', 0020);