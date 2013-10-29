#Punto 3 - Alan Szpigiel

SELECT N.fecha 'Noche Toca'
FROM Banda B
JOIN Banda_Noche BN  ON N.id = BN.noche
JOIN Noche N ON B.id = BN.banda
WHERE B.nombre LIKE 'Catupecu Machu'