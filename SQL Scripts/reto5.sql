USE inventario;

CREATE TABLE Productos (
	codigo BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(80) not null,
	precio DOUBLE,
    inventario INT,
    PRIMARY KEY(codigo)
);
    
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Manzana',5000.0,25);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Limones',2300.0,15);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Peras',2700.0,33);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Arandanos',9300.0,5);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Tomates',2100.0,42);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Fresas',4100.0,3);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Helado',4500.0,41);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Galletas',500.0,8);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Chocolates',3500.0,80);
INSERT INTO Productos (nombre,precio,inventario) VALUES ('Jamon',15000.0,10);

SELECT * FROM Productos;

DROP TABLE Productos