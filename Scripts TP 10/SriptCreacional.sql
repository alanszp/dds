CREATE TABLE Puesto_Venta (
        id int,
        descripcion varchar(30),
        PRIMARY KEY (id)
)

CREATE TABLE Cliente (
        id int,
        nombre varchar(30),
        apellido varchar(30),
        PRIMARY KEY (id)
)


CREATE TABLE Sector(
        id int,
        nombre varchar(30),
        PRIMARY KEY (id)
)

CREATE TABLE Rango_Filas(
        id int,
        desde int,
        hasta int,
        precio int,
        cantAsientos int,
        sector int,
        PRIMARY KEY (id),
        FOREIGN KEY (sector) REFERENCES Sector(id)
)

CREATE TABLE Categoria_Persona(
        id int,
        clase varchar(30),
        precio_descuento int,
        porcentaje_descuento int,
        PRIMARY KEY (id)
)

CREATE TABLE Noche(
        id int,
        fecha datetime,
        PRIMARY KEY (id)
)

CREATE TABLE Categoria_Banda(
        id int,
        tipo varchar(30),
        precio_extra int,
        PRIMARY KEY (id)
)

CREATE TABLE Banda(
        id int,
        nombre varchar(30),
        categoria int,
        PRIMARY KEY (id),
        FOREIGN KEY (categoria) REFERENCES Categoria_Banda(id)
)

CREATE TABLE Banda_Noche(
        noche int NOT NULL,
        banda int NOT NULL,
        comienzo int,
        fin int,
        FOREIGN KEY (noche) REFERENCES Noche(id),
        FOREIGN KEY (banda) REFERENCES Banda(id)
)

CREATE TABLE Descuento(
		id int,
		precio int,
		PRIMARY KEY (id)
)

CREATE TABLE Descuento_Noche(
        noche int NOT NULL,
        descuento int NOT NULL,
        FOREIGN KEY (noche) REFERENCES Noche(id),
        FOREIGN KEY (descuento) REFERENCES Descuento(id)
)


CREATE TABLE Entrada(
        id int,
        sector int,
        noche int,
        categoria_persona int,
        fila int,
        asiento int,
        cliente int,
        puesto_venta int,
        PRIMARY KEY (id),
        FOREIGN KEY (sector) REFERENCES Sector(id),
        FOREIGN KEY (noche) REFERENCES Noche(id),
        FOREIGN KEY (categoria_persona) REFERENCES Categoria_Persona(id),
        FOREIGN KEY (cliente) REFERENCES Cliente(id),
        FOREIGN KEY (puesto_venta) REFERENCES Puesto_Venta(id)

)