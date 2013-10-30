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
			
