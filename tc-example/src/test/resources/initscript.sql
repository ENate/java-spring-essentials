DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id         SERIAL PRIMARY KEY,
  userName VARCHAR(16),
  firstName VARCHAR(30),
  lastName  VARCHAR(30)
);

INSERT INTO user VALUES (1, 'Little', 'Rtzuer', 'Suellinger');