CREATE TABLE IF NOT EXISTS Piatti  (
 piatto_id INT NOT NULL AUTO_INCREMENT,
 descrizione varchar(255) NOT NULL,
 disponibilita bool,
 PRIMARY KEY (piatto_id)
);


CREATE TABLE IF NOT EXISTS  Ingredienti (
 ingrediente_id INT NOT NULL AUTO_INCREMENT,
 nome varchar(255) NOT NULL,
 unita_misura varchar(3) NOT NULL,
 disponibilita_magazzino INT NOT NULL,
 soglia_minima INT NOT NULL,
 PRIMARY KEY (ingrediente_id)
);



CREATE TABLE IF NOT EXISTS  Menu (
 menu_id INT NOT NULL AUTO_INCREMENT,
 nome varchar(50) NOT NULL,
 data_creazione TIMESTAMP, 
 PRIMARY KEY (menu_id)
);


CREATE TABLE IF NOT EXISTS  Cliente (
 cliente_id INT NOT NULL AUTO_INCREMENT,
 nome varchar(30) NOT NULL,
 cognome varchar(40) NOT NULL,
 indirizzo_spedizione varchar(255), 
 mail varchar(80),
 PRIMARY KEY (cliente_id)
);



CREATE TABLE IF NOT EXISTS Piatti_ingredienti (
    prodotti_ingredienti_id int NOT NULL AUTO_INCREMENT,
    piatto INT NOT NULL,
    ingrediente INT NOT NULL,
    quantita INT NOT NULL,
    PRIMARY KEY (prodotti_ingredienti_id),
    FOREIGN KEY (piatto) REFERENCES Piatti(piatto_id),
    FOREIGN KEY (ingrediente) REFERENCES Ingredienti(ingrediente_id)
);


CREATE TABLE IF NOT EXISTS Piatto_menu(
piatto_menu_id int NOT null AUTO_INCREMENT,
piatto int NOT null,
menu int NOT null,
PRIMARY KEY (piatto_menu_id),
FOREIGN KEY (piatto) REFERENCES Piatti(piatto_id),
FOREIGN KEY (menu) REFERENCES Menu(menu_id)
);

CREATE TABLE IF NOT EXISTS  Ruolo (
  ruolo_id int NOT  null AUTO_INCREMENT,
  descrizione varchar (300),
  PRIMARY KEY (ruolo_id)
);


CREATE TABLE IF NOT EXISTS  Staff(
  dipendente_id INT NOT NULL AUTO_INCREMENT,
  nome  varchar(80),
  cognome varchar(200),
  ruolo INT NOT NULL,
  PRIMARY KEY (dipendente_id),
  FOREIGN KEY (ruolo) REFERENCES Ruolo(ruolo_id) 
);

CREATE TABLE IF NOT EXISTS Stato_ordine (
  stato_ordine_id int NOT  null AUTO_INCREMENT,
  descrizione varchar (40),
  PRIMARY KEY (stato_ordine_id)
);


CREATE TABLE IF NOT EXISTS Ordine (
  ordine_id int NOT NULL AUTO_INCREMENT,
  data_ordine  TIMESTAMP,
  indirizzo_consegna varchar(300),
  stato int NOT NULL,
  cilente int NOT NULL,
  cuoco int,
  fattorino int ,
  PRIMARY KEY (ordine_id),
  FOREIGN KEY (stato) REFERENCES Stato_ordine(stato_ordine_id),
  FOREIGN KEY (cilente) REFERENCES Cliente(cliente_id),
  FOREIGN KEY (cuoco) REFERENCES Staff(dipendente_id),
  FOREIGN KEY (fattorino) REFERENCES Staff(dipendente_id)
);

CREATE TABLE IF NOT EXISTS Piatti_ordinati (
  piatti_ordinati_id INT NOT NULL AUTO_INCREMENT,
  quantita  INT NOT NULL,
  piatto_nel_menu INT NOT NULL,
  ordine INT NOT NULL,
  PRIMARY KEY (piatti_ordinati_id),
  FOREIGN KEY (piatto_nel_menu) REFERENCES Piatto_menu(piatto_menu_id),
  FOREIGN KEY (ordine) REFERENCES Ordine(ordine_id)
);


INSERT INTO Ruolo (descrizione)
VALUES
('cuoco'),
('raider'),
('cameriere');



INSERT INTO Stato_ordine (descrizione)
VALUES
('creato'),
('in preparazione'),
('cucinato'),
('spedito'),
('consegnato');