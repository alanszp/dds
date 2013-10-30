--Integrante 1 : Uriel Petasny

SELECT s.nombre, n.fecha, fila, asiento, c.nombre, c.apellido
FROM Entrada e
	JOIN Cliente c ON e.cliente = c.id
	JOIN Noche n ON e.noche = n.id
	JOIN Sector s ON e.sector = s.id
WHERE c.nombre = 'Brian' AND c.apellido = 'Zuznicki'

--Integrante 2: Tomas Gropper

SELECT N.fecha, S.nombre, CP.clase, C.nombre + ' ' + C.apellido AS Cliente, P.descripcion AS PuestoVenta
FROM Noche N JOIN Entrada E ON E.noche = N.id
			JOIN Sector S ON E.sector = S.id
			JOIN Categoria_Persona CP ON E.categoria_persona = CP.id
			JOIN Cliente C ON E.cliente = C.id
			JOIN Puesto_Venta P ON  E.puesto_venta = P.id
			WHERE DAY(N.fecha) = 26 AND MONTH(N.fecha) = 05 AND YEAR(N.fecha) = 2013
			
--Integrante 3: Alan Szpigiel

SELECT N.fecha 'Noche Toca'
FROM Banda B
JOIN Banda_Noche BN  ON N.id = BN.noche
JOIN Noche N ON B.id = BN.banda
WHERE B.nombre LIKE 'Catupecu Machu'

--Integrante 4: Guido Kuznicki

SELECT N.Fecha as Noche, B.Nombre as Nombre_Banda, C.Tipo as Categoria_Banda, C.PrecioExtra as Precio_Extra_Banda, BN.Comienzo as Hora_Comienzo, BN.Fin as Hora_Fin 
FROM Banda B 
	JOIN CategoriaBanda C ON C.ID = B.Categoria
	JOIN Banda_Noche BN on BN.Banda = B.ID
	JOIN Noche N ON N.ID = BN.Noche
WHERE N.Fecha="23/12/2013"



