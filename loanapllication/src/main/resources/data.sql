DROP TABLE IF EXISTS user;
 
CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name varchar(100) not null,
  gender char(10) not null,
  salary int not null,
  age  int not null,
  pan bit not null,
  adhar bit not null
     
);

DROP TABLE IF EXISTS loan;

CREATE TABLE loan (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  userid number(250) NOT NULL,
  loanamount number NOT NULL,
  durationyears number NOT NULL,
  interestrate number NOT NULL,
  loanstartdate datetime not null,
  loadenddate datetime not null,
  emi number not null,
  CONSTRAINT `loandetails_fk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)

);