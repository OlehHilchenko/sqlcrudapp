CREATE TABLE specialty (
  id integer primary key auto_increment,
  developerId integer not null,
  name varchar(25) not null,
  description varchar(25) not null);