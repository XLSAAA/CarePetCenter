# 删除数据库
DROP DATABASE IF EXISTS care_pet_center_db;

# 创建数据库
CREATE DATABASE IF NOT EXISTS care_pet_center_db
DEFAULT CHARACTER SET utf8;

USE care_pet_center_db;

# User
CREATE TABLE IF NOT EXISTS `user`(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	username VARCHAR(20) UNIQUE,
	PASSWORD VARCHAR(32),
	category VARCHAR(5),
	error_count INT,
	freeze_time DATETIME,
	`status` INT
);

# e10adc3949ba59abbe56e057f20f883e -> 123456 的 md5 码
INSERT INTO USER
VALUES
(1, "root", "admin", "e10adc3949ba59abbe56e057f20f883e", "admin", 0, NOW(), 0);

# master
CREATE TABLE IF NOT EXISTS MASTER(
	master_id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	gender INT,
	tel VARCHAR(11) UNIQUE,
	mail VARCHAR(50),
	address VARCHAR(50),
	balance INT,
	vip INT
);

# pet
CREATE TABLE IF NOT EXISTS pet(
	pet_id INT PRIMARY KEY AUTO_INCREMENT,
	master_id INT,
	NAME VARCHAR(20),
	age INT,
	gender INT,
	kind VARCHAR(30),
	FOREIGN KEY (master_id) REFERENCES MASTER(master_id)
);

# nurse
CREATE TABLE IF NOT EXISTS nurse(
	nurse_id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	gender INT,
	`describe` VARCHAR(100)
);

# item
CREATE TABLE IF NOT EXISTS item(
	item_id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	price INT,
	`DESCRIBE` VARCHAR(50),
	checkout_time INT
);

# nurse & item 
CREATE TABLE IF NOT EXISTS nurse_item(
	nurse_id INT,
	item_id INT,
	FOREIGN KEY (nurse_id) REFERENCES nurse(nurse_id),
	FOREIGN KEY (item_id) REFERENCES item(item_id),
	
	PRIMARY KEY (nurse_id, item_id)
	
);

# order
CREATE TABLE IF NOT EXISTS `order`(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	item_id INT,
	master_id INT,
	pet_id INT,
	nurse_id INT,
	user_id INT, 
	pay INT,
	create_time DATETIME,
	end_time DATETIME,
	remake VARCHAR(50),
	STATUS INT,
	FOREIGN KEY (item_id) REFERENCES item(item_id),
	FOREIGN KEY (master_id) REFERENCES `master`(master_id),
	FOREIGN KEY (pet_id) REFERENCES pet(pet_id),
	FOREIGN KEY (nurse_id) REFERENCES nurse(nurse_id),
	FOREIGN KEY (user_id) REFERENCES `user`(user_id)

);

# mail
CREATE TABLE IF NOT EXISTS mail(
	mail_id INT PRIMARY KEY AUTO_INCREMENT,
	master_email VARCHAR(50),
	pet_name VARCHAR(20),
	item_name VARCHAR(20),
	order_id INT, 
	send_date DATETIME,
	STATUS INT,
	FOREIGN KEY (order_id) REFERENCES `order`(order_id)
);

################################             TEST                ###############################################################

# User Test

SELECT * FROM USER;

INSERT INTO USER
VALUES
(2, "test", "moquan", "e10adc3949ba59abbe56e057f20f883e", "admin", 4, DATE_ADD(NOW(), INTERVAL 1 DAY), 2);


INSERT INTO USER
VALUES
(3, "test", "mq", "e10adc3949ba59abbe56e057f20f883e", "admin", 4, NOW(), 0);

UPDATE USER
SET freeze_time = DATE_ADD(freeze_time, INTERVAL 1 DAY)
WHERE user_id = 2 OR user_id = 3

# Master Test

SELECT * FROM MASTER;

DELETE FROM MASTER;

UPDATE MASTER
SET mail = "moquanmail@163.com";

# Pet Test

SELECT * FROM pet;

# Item Test

SELECT * FROM item;

INSERT INTO item
VALUES
(100, '洗澡', 100, '专业洗澡技师对宠物进行洗澡服务', 90),
(101, '剪指甲', 50, '专业技师修建宠物爪子', 90),
(102, '耳部清洁', 30, '专业宠物技师对宠物耳朵进行清洁服务', 90),
(103, '毛发修剪', 130, '专业造型技师对宠物进行造型服务', 90);

# Nurse Test

SELECT * FROM nurse;

INSERT INTO nurse
VALUES
(20, '张三', 1, 'xxxxxxxxxxxxxxx'),
(21, '李四', 1, 'xxxxxxxxxxxxxxx'),
(22, '王五', 1, 'xxxxxxxxxxxxxxx'),
(23, '毛六', 1, 'xxxxxxxxxxxxxxx'),
(24, '赵七', 1, 'xxxxxxxxxxxxxxx');

INSERT INTO nurse
VALUES
(25, '钱八', 0, 'xxxxxxxxxxxxxxx');

SELECT * FROM nurse
WHERE NAME LIKE "%赵%七%";


# nurse_item Test

SELECT * FROM nurse_item;

DELETE FROM nurse_item;

	#drop table nurse_item;

INSERT INTO nurse_item
VALUES
(20, 100),
(20, 101),
(20, 102),
(20, 103),
(21, 100),
(22, 101),
(23, 102),
(24, 103);

INSERT INTO nurse_item
VALUES
(21, 103),
(22, 102);
	# 该项目谁会
SELECT n.nurse_id, n.name, n.gender, n.describe FROM nurse_item ni
LEFT JOIN nurse n
	ON n.nurse_id = ni.nurse_id
WHERE ni.item_id = 103;
	# 该项目谁不会
SELECT n.nurse_id, n.name, n.gender, n.describe FROM nurse_item ni
LEFT JOIN nurse n
	ON n.nurse_id = ni.nurse_id
WHERE ni.nurse_id NOT IN(
		SELECT nurse_id 
		FROM nurse_item
		WHERE item_id = 102
	)
GROUP BY nurse_id;

	# 该技师会啥
SELECT i.item_id, NAME, price, `describe`, checkout_time FROM nurse_item ni
LEFT JOIN item i
	ON i.item_id = ni.item_id
WHERE ni.nurse_id = 22;
	# 该技师不会啥
SELECT i.item_id, NAME, price, `describe`, checkout_time FROM nurse_item ni
LEFT JOIN item i
	ON i.item_id = ni.item_id
WHERE ni.item_id NOT IN(
		SELECT item_id 
		FROM nurse_item
		WHERE nurse_id = 22
	)			
GROUP BY item_id;

#order Test
SELECT * FROM USER;
SELECT * FROM `item`;
SELECT * FROM `mail`;
SELECT * FROM `master`;
SELECT * FROM `nurse`;
SELECT * FROM `nurse_item`;
SELECT * FROM `order`;
SELECT * FROM `pet`;
	#drop table `ORDER`;

#mail test

	#drop table mail;
	
SELECT * FROM mail;





