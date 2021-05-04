/*   	Commandes de création de la base  */
DROP TABLE IF EXISTS  Client;
DROP TABLE IF EXISTS Historique_info;
DROP TABLE IF EXISTS Historique_api;
DROP TABLE IF EXISTS Information;

CREATE TABLE Client(id_client INTEGER NOT NULL, 
                         login VARCHAR (30) NOT NULL ,
                         mdp VARCHAR (30) NOT NULL,
			 token VARCHAR (30) NOT NULL,
                         PRIMARY KEY (id_client));
 
CREATE TABLE Information (id_info   INTEGER NOT NULL,
                          luminosite  INTEGER,
                          niv_batt  INTEGER,
		 	  pression  INTEGER,
			  temperature  INTEGER,
		          latitude  INTEGER,
			  longitude  INTEGER,
                          PRIMARY KEY (id_info));

CREATE TABLE Historique_info  (id_hist_info INTEGER NOT NULL,
                       dateheure DATETIME NOT NULL,
                       id_info INTEGER NOT NULL,
                       PRIMARY KEY (id_hist_info),
                       FOREIGN KEY (id_info) REFERENCES Information(id_info));

CREATE TABLE Historique_api  (id_hist_api INTEGER NOT NULL,
		    id_client INTEGER NOT NULL,
                    dateheure    DATETIME NOT NULL,
                    id_info    INTEGER NOT NULL,
                    type_comm  VARCHAR(30) NOT NULL,
                    PRIMARY KEY (id_hist_api),
                    FOREIGN KEY (id_client) REFERENCES Client(id_client),
		    FOREIGN KEY (id_info) REFERENCES Information(id_info));