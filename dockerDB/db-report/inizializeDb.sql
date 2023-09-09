CREATE TABLE Piatti (
 piatto_id INT NOT NULL,
 descrizione varchar(255) NOT NULL,
 disponibilita bool,
 PRIMARY KEY (piatto_id)
);


CREATE TABLE Ingredienti(
 ingrediente_id INT NOT NULL,
 nome varchar(255) NOT NULL,
 unita_misura varchar(3) NOT NULL,
 disponibilita_magazzino INT NOT NULL,
 soglia_minima INT NOT NULL,
 PRIMARY KEY (ingrediente_id)
);



CREATE TABLE  Menu (
 menu_id INT NOT NULL,
 nome varchar(50) NOT NULL,
 data_creazione TIMESTAMP, 
 PRIMARY KEY (menu_id)
);


CREATE TABLE Cliente (
 cliente_id INT NOT NULL,
 nome varchar(30) NOT NULL,
 cognome varchar(40) NOT NULL,
 indirizzo_spedizione varchar(255), 
 mail varchar(80),
 PRIMARY KEY (cliente_id)
);



CREATE TABLE Piatti_ingredienti (
    prodotti_ingredienti_id int NOT NULL,
    piatto INT NOT NULL,
    ingrediente INT NOT NULL,
    quantita INT NOT NULL,
    PRIMARY KEY (prodotti_ingredienti_id),
    FOREIGN KEY (piatto) REFERENCES Piatti(piatto_id),
    FOREIGN KEY (ingrediente) REFERENCES Ingredienti(ingrediente_id)
);


CREATE TABLE  Piatto_menu (
piatto_menu_id int NOT  null ,
piatto int NOT null,
menu int NOT null,
PRIMARY KEY (piatto_menu_id),
FOREIGN KEY (piatto) REFERENCES Piatti(piatto_id),
FOREIGN KEY (menu) REFERENCES Menu(menu_id)
);

CREATE TABLE Ruolo (
  ruolo_id int NOT  null ,
  descrizione varchar (300),
  PRIMARY KEY (ruolo_id)
);


CREATE TABLE  Staff (
  dipendente_id INT NOT NULL,
  nome  varchar(80),
  cognome varchar(200),
  ruolo INT NOT NULL,
  PRIMARY KEY (dipendente_id),
  FOREIGN KEY (ruolo) REFERENCES Ruolo(ruolo_id) 
);

CREATE TABLE Stato_ordine (
  stato_ordine_id int NOT  null ,
  descrizione varchar (300),
  PRIMARY KEY (stato_ordine_id)
);


CREATE TABLE Ordine (
  ordine_id int NOT NULL,
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

CREATE TABLE Piatti_ordinati (
  piatti_ordinati_id INT NOT NULL,
  quantita  INT NOT NULL,
  piatto_nel_menu INT NOT NULL,
  ordine INT NOT NULL,
  PRIMARY KEY (piatti_ordinati_id),
  FOREIGN KEY (piatto_nel_menu) REFERENCES Piatto_menu(piatto_menu_id),
  FOREIGN KEY (ordine) REFERENCES Ordine(ordine_id)
)