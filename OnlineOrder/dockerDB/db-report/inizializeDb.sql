CREATE TABLE IF NOT EXISTS  ingredienti (
    ingrediente_id INT NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    unita_misura varchar(10) NOT NULL,
    disponibilita_magazzino float NOT NULL,
    soglia_minima INT NOT NULL,
    PRIMARY KEY (ingrediente_id)
    );
INSERT INTO ingredienti (nome, unita_misura, disponibilita_magazzino, soglia_minima)
VALUES
    ('pennette Rigate','kg', 25,3),
    ('armigiano Reggiano','kg', 30,2),
    ('groviera ','kg', 30.0,2),
    ('sale fino','kg',10.0,1),
    ('pepe nero','kg',10.0,1),
    ('taleggio','kg',30.0,2),
    ('latte intero','l',30.0,1),
    ('pepe Bianco','kg',20.0,1),
    ('pesce spada', 'kg',10.0,1),
    ('olive verdi', 'kg',10.0,1),
    ('aglio', 'kg', 5.0,1),
    ('origano', 'kg', 2.0,1),
    ('pomodorini','kg',3.0,1),
    ('olio extravergine','l',12.0,5),
    ('pinoli','kg',2.0,1),
    ('mascarpone','kg',5.0,1),
    ('savoiardi','kg',2.0,1),
    ('caffe','kg',12.0,3),
    ('uova','unita',40.0,5),
    ('zucchero','kg',7.0,1);





CREATE TABLE IF NOT EXISTS piatti  (
    piatto_id INT NOT NULL AUTO_INCREMENT,
    descrizione varchar(100) NOT NULL,
    disponibilita boolean,
    PRIMARY KEY (piatto_id)
    );
INSERT INTO piatti (descrizione,disponibilita)
VALUES
    ('pasta 4 formaggi',true),
    ('pesce spada alla siciliana',true),
    ('tiramisu',true);


CREATE TABLE IF NOT EXISTS piatti_ingredienti (
    prodotti_ingredienti_id int NOT NULL AUTO_INCREMENT,
    piatto INT NOT NULL,
    ingrediente INT NOT NULL,
    quantita INT NOT NULL,
    PRIMARY KEY (prodotti_ingredienti_id),
    FOREIGN KEY (piatto) REFERENCES piatti(piatto_id),
    FOREIGN KEY (ingrediente) REFERENCES ingredienti(ingrediente_id)
    );

INSERT INTO piatti_ingredienti(piatto,ingrediente,quantita)
VALUES
    (1,1,0.320),
    (1,2,0.080),
    (1,3,0.080),
    (1,3,0.080),
    (1,4,0.0001),
    (1,5,0.080),
    (1,6,0.080),
    (1,7,0.180),
    (1,8,0.0001),
    (2,9,0.300),
    (2,10,0.001),
    (2,11,0.001),
    (2,5,0.001),
    (2,12,0.300),
    (2,13,0.030),
    (2,14,0.010),
    (2,4,0.010),
    (3,15,0.750),
    (3,15,0.250),
    (3,16,0.300),
    (3,17,5.0),
    (3,18,0.120);




CREATE TABLE IF NOT EXISTS  menu (
    menu_id INT NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    data_creazione TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    abilitato boolean,
    PRIMARY KEY (menu_id)
    );
INSERT INTO menu(nome, abilitato )
VALUES
    ('menu estivo 2023', true);


CREATE TABLE IF NOT EXISTS piatto_menu(
     piatto_menu_id int NOT null AUTO_INCREMENT,
     piatto int NOT null,
     menu int NOT null,
     prezzo float NOT null,
     PRIMARY KEY (piatto_menu_id),
     FOREIGN KEY (piatto) REFERENCES piatti(piatto_id),
     FOREIGN KEY (menu) REFERENCES menu(menu_id)
    );
INSERT INTO piatto_menu(piatto,menu,prezzo)
VALUES
    (1,1,10.0),
    (2,1,13.0),
    (3,1,7.0);




CREATE TABLE IF NOT EXISTS  cliente (
    cliente_id INT NOT NULL AUTO_INCREMENT,
    nome varchar(30) NOT NULL,
    cognome varchar(40) NOT NULL,
    indirizzo_spedizione varchar(255),
    mail varchar(80),
    PRIMARY KEY (cliente_id)
    );

INSERT INTO cliente (nome, cognome, indirizzo_spedizione, mail)
VALUES
    ('Davide','Candalino','Milano via gatti 34', 'davide.candalino@tiscali.it');


CREATE TABLE IF NOT EXISTS  ruolo (
    ruolo_id int NOT  null AUTO_INCREMENT,
    descrizione varchar (300),
    PRIMARY KEY (ruolo_id)
    );

INSERT INTO ruolo (descrizione)
VALUES
    ('cuoco'),
    ('raider'),
    ('cameriere');



CREATE TABLE IF NOT EXISTS  staff(
    dipendente_id INT NOT NULL AUTO_INCREMENT,
    nome  varchar(80),
    cognome varchar(200),
    ruolo INT NOT NULL,
    PRIMARY KEY (dipendente_id),
    FOREIGN KEY (ruolo) REFERENCES ruolo(ruolo_id)
    );

INSERT INTO staff (nome,cognome,ruolo)
VALUES
    ('Mario','Rossi',1),
    ('Giovanni', 'Storti', 2),
    ('Jone','Doe',3);



CREATE TABLE IF NOT EXISTS stato_ordine (
    stato_ordine_id int NOT  null AUTO_INCREMENT,
    descrizione varchar (40),
    PRIMARY KEY (stato_ordine_id)
    );
INSERT INTO stato_ordine (descrizione)
VALUES
    ('inSospeso'),
    ('creato'),
    ('inPreparazione'),
    ('cucinato'),
    ('Inconsegna'),
    ('consegnato'),
    ('avvenutaConsegna');


CREATE TABLE IF NOT EXISTS ordine (
    ordine_id int NOT NULL AUTO_INCREMENT,
    data_ordine  TIMESTAMP,
    indirizzo_consegna varchar(300),
    stato int NOT NULL,
    cilente int NOT NULL,
    cuoco int,
    fattorino int ,
    PRIMARY KEY (ordine_id),
    FOREIGN KEY (stato) REFERENCES stato_ordine(stato_ordine_id),
    FOREIGN KEY (cilente) REFERENCES cliente(cliente_id),
    FOREIGN KEY (cuoco) REFERENCES staff(dipendente_id),
    FOREIGN KEY (fattorino) REFERENCES staff(dipendente_id)
    );

CREATE TABLE IF NOT EXISTS piatti_ordinati (
    piatti_ordinati_id INT NOT NULL ,
    quantita  INT NOT NULL,
    piatto_nel_menu INT NOT NULL,
    ordine INT NOT NULL,
    PRIMARY KEY (piatti_ordinati_id),
    FOREIGN KEY (piatto_nel_menu) REFERENCES piatto_menu(piatto_menu_id),
    FOREIGN KEY (ordine) REFERENCES ordine(ordine_id)
    );