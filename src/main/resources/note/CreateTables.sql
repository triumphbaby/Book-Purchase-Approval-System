/*学院*/
CREATE TABLE `institute` (
	`id` VARCHAR(100),
	`name` VARCHAR(255) NOT NULL,
	`remarks` VARCHAR(255),
	PRIMARY KEY ( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*专业*/
CREATE TABLE `major` (
	`id` VARCHAR(100),
	`name` VARCHAR(255) NOT NULL,
	`institute_id` VARCHAR(100),
	`remarks` VARCHAR(255),
	PRIMARY KEY ( `id` ),
	CONSTRAINT `fk_major_institute` FOREIGN KEY(`institute_id`) REFERENCES `institute` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*人员*/
CREATE TABLE `staff` (
	`id` VARCHAR(100),
	`name` VARCHAR(150),
	`pwd` VARCHAR(255) DEFAULT "123456"
	`major_id` VARCHAR(100) NOT NULL,
	`institute_id` VARCHAR(100) NOT NULL,
	`tel` VARCHAR(50),
	`remarks` VARCHAR(255),
	PRIMARY KEY ( `id` ),
	CONSTRAINT `fk_staff_major` FOREIGN KEY(`major_id`) REFERENCES `major` (`id`),
	CONSTRAINT `fk_staff_institute` FOREIGN KEY(`institute_id`) REFERENCES `institute` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*角色*/
CREATE TABLE `role` (
	`id` VARCHAR(100),
	`type` INT NOT NULL,
	`remarks` VARCHAR(255),
	CONSTRAINT `fk_role_staff` FOREIGN KEY(`id`) REFERENCES `staff` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*学期*/
CREATE TABLE `term`(
    `id` INT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*课程*/
CREATE TABLE `course`(
    `id` VARCHAR(100),
    `term_id` INT UNSIGNED NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `period` INT UNSIGNED,
    `credit` INT UNSIGNED,
    `usable_range` VARCHAR(255) NOT NULL,
    `student_num` INT UNSIGNED NOT NULL,
    `teacher_num` INT UNSIGNED NOT NULL,
    `principal_id` VARCHAR(100),
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id`,`term_id`),
    CONSTRAINT `fk_course_staff` FOREIGN KEY(`principal_id`) REFERENCES `staff` (`id`),
    CONSTRAINT `fk_course_term` FOREIGN KEY(`term_id`) REFERENCES `term` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*教材等级*/
CREATE TABLE `level`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*书*/
CREATE TABLE `book`(
    `id` VARCHAR(150) NOT NULL,
    `name` VARCHAR(200) NOT NULL,
    `author` VARCHAR(255) NOT NULL,
    `publisher` VARCHAR(255) NOT NULL,
    `publish_date` VARCHAR(60) NOT NULL,
    `edition` INT UNSIGNED,
    `nation` VARCHAR(255),
    `type` INT UNSIGNED,
    `purpose` INT UNSIGNED,
    `level_id` INT UNSIGNED NOT NULL,
    `price` INT NOT NULL,
    `renew` bit ,
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id`),
    CONSTRAINT `fk_book_level` FOREIGN KEY(`level_id`) REFERENCES `level` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*课程用书*/
CREATE TABLE `subject`(
    `id` INT UNSIGNED AUTO_INCREMENT,
    `course_id` VARCHAR(100) NOT NULL ,
    `term_id` INT UNSIGNED NOT NULL,
    `book_id` VARCHAR(150) NOT NULL,
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id`),
    CONSTRAINT `fk_subject_term` FOREIGN KEY(`term_id`) REFERENCES `term` (`id`),
    CONSTRAINT `fk_subject_book` FOREIGN KEY(`book_id`) REFERENCES `book` (`id`),
    CONSTRAINT `fk_subject_course` FOREIGN KEY(`course_id`) REFERENCES `course` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*审批表*/
CREATE TABLE `approval`(
    `subject_id` INT UNSIGNED,
    `option_lab` VARCHAR(250) NOT NULL,
    `option_unit` VARCHAR(250) NOT NULL,
    `option_dean` VARCHAR(250) NOT NULL,
    CONSTRAINT `fk_approval_subject` FOREIGN KEY(`subject_id`) REFERENCES `subject` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*教研处*/
CREATE TABLE `laboratory`(
    `id` INT UNSIGNED AUTO_INCREMENT,
    `content` VARCHAR(255) NOT NULL,
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*开课教学单位*/
CREATE TABLE `teaching_unit`(
    `id` INT UNSIGNED AUTO_INCREMENT,
    `content` VARCHAR(255) NOT NULL,
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*教务处*/
CREATE TABLE `dean_office`(
    `id` INT UNSIGNED AUTO_INCREMENT,
    `content` VARCHAR(255) NOT NULL,
    `remarks` VARCHAR(255),
    PRIMARY KEY ( `id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
