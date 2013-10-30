SELECT N.fecha, S.nombre, CP.clase, C.nombre + ' ' + C.apellido AS Cliente, P.descripcion AS PuestoVenta
FROM Noche N JOIN Entrada E ON E.noche = N.id
			JOIN Sector S ON E.sector = S.id
			JOIN Categoria_Persona CP ON E.categoria_persona = CP.id
			JOIN Cliente C ON E.cliente = C.id
			JOIN Puesto_Venta P ON  E.puesto_venta = P.id
			