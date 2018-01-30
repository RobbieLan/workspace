create table if not exists BATCHPERSON
(
  id          INT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(20),
  age         INT,
  nation      VARCHAR(20),
  address     VARCHAR(20),
  PRIMARY KEY (id)
);

