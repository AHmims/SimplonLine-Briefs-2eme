CREATE DATABASE Brief_09;
USE Brief_09;
-- ----
CREATE TABLE Pepiniere (
	idPepiniere int PRIMARY KEY auto_increment,
    nomPepiniere varchar(200),
    capacitePepiniere int
);
-- ----
INSERT INTO Pepiniere(nomPepiniere, capacitePepiniere) VALUES ("Pepiniere_1",100), ("Pepiniere_2",125), ("Pepiniere_3",150);