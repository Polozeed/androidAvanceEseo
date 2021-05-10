TRUNCATE TABLE Client;
TRUNCATE TABLE Information; 
TRUNCATE TABLE Historique_api;
TRUNCATE TABLE Historique_info; 

INSERT INTO Client VALUES(1,"pouplama", "1234", "abc");
INSERT INTO Client VALUES(2,"couriema", "4567", "def");
INSERT INTO Information VALUES(1, NULL, 78, 90, 23, 54, 31);
INSERT INTO Information VALUES(2, 54, 65, 100, NULL, 89, 9);
INSERT INTO Information VALUES(3, 45, NULL, 100, 19, 9, 43);
INSERT INTO Historique_api VALUES(1, 1, "2021-04-04 09:09:12", 1, "get");
INSERT INTO Historique_api VALUES(2, 1, "2021-05-04 11:11:12", 2, "post");
INSERT INTO Historique_api VALUES(3, 2, "2020-10-03 14:09:29", 3, "put");
INSERT INTO Historique_info VALUES(1, "2020-10-03 13:09:29", 1);
INSERT INTO Historique_info VALUES(2, "2020-10-04 14:09:29", 2);
INSERT INTO Historique_info VALUES(3, "2020-10-05 11:06:29", 3);