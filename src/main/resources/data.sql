DROP TABLE IF EXISTS gameResultBoard;

CREATE TABLE gameResultBoard (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  playedGames INT NOT NULL,
  gamesIsWin INT NOT NULL,
  tries INT NOT NULL,
  percent DOUBLE NOT NULL
);