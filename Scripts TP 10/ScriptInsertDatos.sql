
INSERT INTO Cliente (id, nombre, apellido) VALUES (1, 'Tomas', 'Gropper')
INSERT INTO Cliente (id, nombre, apellido) VALUES (2, 'Brian', 'Zuznicki')
INSERT INTO Cliente (id, nombre, apellido) VALUES (3, 'Chuck', 'Espigiel')
INSERT INTO Cliente (id, nombre, apellido) VALUES (4, 'Elizer', 'UriPeta')


INSERT INTO Puesto_Venta (id, descripcion) VALUES (1, 'Abasto')
INSERT INTO Puesto_Venta (id, descripcion) VALUES (2, 'Alto Palermo')

INSERT INTO Noche (id, fecha) VALUES (1, '26/05/13')
INSERT INTO Noche (id, fecha) VALUES (2, '27/10/13')

INSERT INTO Descuento (id, precio) VALUES (1, 50)
INSERT INTO Descuento (id, precio) VALUES (2, 100)

INSERT INTO Descuento_Noche (noche, descuentos) VALUES (1, 1)
INSERT INTO Descuento_Noche (noche, descuentos) VALUES (1, 2)
INSERT INTO Descuento_Noche (noche, descuentos) VALUES (2, 1)

INSERT INTO Categoria_Banda (id, tipo, precio_extra) VALUES (1, 'Nacional', 100)
INSERT INTO Categoria_Banda (id, tipo, precio_extra) VALUES (2, 'Internacional poco conocido', 200)
INSERT INTO Categoria_Banda (id, tipo, precio_extra) VALUES (3, 'Internacional', 500)

INSERT INTO Banda (id, nombre, categoria) VALUES (1, 'Pimpinela', 1)
INSERT INTO Banda (id, nombre, categoria) VALUES (2, 'Besruit', 1)
INSERT INTO Banda (id, nombre, categoria) VALUES (3, 'Catupecu Machu', 2)
INSERT INTO Banda (id, nombre, categoria) VALUES (4, 'Rolling', 3)
INSERT INTO Banda (id, nombre, categoria) VALUES (5, 'Aerosmith', 3)
INSERT INTO Banda (id, nombre, categoria) VALUES (6, 'Bandana', 1)

INSERT INTO Banda_Noche (noche, banda, comienzo, fin) VALUES (1, 1, 19, 22)
INSERT INTO Banda_Noche (noche, banda, comienzo, fin) VALUES (2, 2, 19, 22)
INSERT INTO Banda_Noche (noche, banda, comienzo, fin) VALUES (1, 3, 17, 19)
INSERT INTO Banda_Noche (noche, banda, comienzo, fin) VALUES (2, 4, 17, 19)
INSERT INTO Banda_Noche (noche, banda, comienzo, fin) VALUES (1, 5, 15, 17)
INSERT INTO Banda_Noche (noche, banda, comienzo, fin) VALUES (2, 6, 15, 17)

INSERT INTO Categoria_Persona (id, clase, precio_descuento, porcentaje_descuento) VALUES (1, 'Jubilados', 20, 20)
INSERT INTO Categoria_Persona (id, clase, precio_descuento, porcentaje_descuento) VALUES (2, 'Menores', 10, 10)

INSERT INTO Sector (id, nombre) VALUES (1, 'A')
INSERT INTO Sector (id, nombre) VALUES (2, 'B')
INSERT INTO Sector (id, nombre) VALUES (3, 'C')

INSERT INTO Rango_Filas (id, desde, hasta, precio, cantAsientos, sector) VALUES (1, 1, 10, 500, 100, 1)
INSERT INTO Rango_Filas (id, desde, hasta, precio, cantAsientos, sector) VALUES (2, 11, 20, 250, 100, 2)
INSERT INTO Rango_Filas (id, desde, hasta, precio, cantAsientos, sector) VALUES (3, 21, 50, 50, 100, 3)

INSERT INTO Entrada (id, sector, noche, categoria_persona, fila, asiento, cliente, puesto_venta) VALUES (1, 1, 1, 1, 1, 1, 1, 1)
INSERT INTO Entrada (id, sector, noche, categoria_persona, fila, asiento, cliente, puesto_venta) VALUES (2, 2, 2, 2, 2, 2, 2, 2)



