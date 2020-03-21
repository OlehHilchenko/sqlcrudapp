CREATE TABLE developer_skills (
  developer_id integer not null,
  skill_id integer not null,
  PRIMARY KEY (developer_id, skill_id));

/*CREATE TABLE skills (
  id integer primary key autoincrement,
  developerId integer not null,
  name varchar(25) not null);*/