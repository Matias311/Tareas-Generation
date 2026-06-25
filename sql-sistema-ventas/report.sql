-- =====================================
-- REPORTE SQL - CHALLENGER SISTEMA VENTAS
-- =====================================

-- 1. Mostrar todos los clientes registrados
SELECT * FROM clientes;


-- 2. Mostrar todos los productos disponibles
SELECT * FROM productos;

-- 3. Mostrar todas las ventas realizadas
SELECT * FROM ventas;

-- 4. Mostrar solo nombre y email de clientes
SELECT clientes.nombre, clientes.email FROM clientes;

-- 5. Mostrar solo nombre y precio de productos
SELECT productos.nombre, productos.precio FROM productos;

-- 6. Productos con precio mayor a 50000
SELECT * FROM productos WHERE precio > 50000;

-- 7. Ventas realizadas el 2026-04-02
SELECT * FROM ventas WHERE fecha = '2026-04-02';

-- 8. Productos ordenados de mayor a menor precio
SELECT * FROM productos ORDER BY precio ;

-- 9. Clientes ordenados por nombre
SELECT * FROM clientes ORDER BY nombre;

-- 10. Detalles de venta con cantidad >= 2
SELECT * FROM detalle_venta WHERE cantidad >= 2;

-- 11. Total de clientes
SELECT count(*) FROM clientes;

-- 12. Total de productos
SELECT count(*) FROM productos;

-- 13. Total de ventas
 SELECT count(*) FROM ventas;

-- 14. Precio promedio de productos
SELECT avg(precio) AS promedio FROM productos;

-- 15. Suma total de precios de productos
SELECT sum(productos.precio) AS precio_total FROM productos;

-- 16. Mostrar venta + nombre del cliente + fecha
SELECT c.nombre, v.fecha FROM ventas v
JOIN clientes c ON v.id_cliente = c.id_cliente;

-- 17. Mostrar detalle de ventas con id_venta + nombre producto + cantidad
SELECT dv.id_venta, p.nombre, dv.cantidad FROM detalle_venta dv
JOIN public.productos p on dv.id_producto = p.id_producto;

-- 18. Mostrar nombre del cliente + id de venta + fecha
SELECT v.id_venta, v.fecha, c.nombre FROM ventas v
                                              JOIN clientes c ON v.id_cliente = c.id_cliente;

-- 19. Mostrar nombre del producto + cantidad vendida + id de venta
SELECT p.nombre, dv.cantidad, dv.id_venta FROM detalle_venta dv
JOIN public.productos p on p.id_producto = dv.id_producto;

-- 20. Mostrar cuántas ventas ha realizado cada cliente
SELECT c.nombre, count(v.id_venta) FROM ventas v
    JOIN public.clientes c on c.id_cliente = v.id_cliente GROUP BY c.nombre ;

-- 21. Mostrar solo los clientes con más de una venta
SELECT c.id_cliente, c.nombre, c.email,  count(v.id_venta)
FROM clientes c JOIN public.ventas v on c.id_cliente = v.id_cliente
GROUP BY c.id_cliente, c.nombre, c.email HAVING count(v.id_venta) > 1;

-- 22. Mostrar cuántas veces aparece cada producto en detalle_venta
SELECT p.nombre, count(dv.id_producto) AS total_veces_producto FROM detalle_venta dv
JOIN public.productos p on p.id_producto = dv.id_producto GROUP BY p.nombre;

-- 23. Mostrar solo los productos que aparecen más de una vez
SELECT p.nombre, count(dv.id_producto) AS total_veces_producto FROM detalle_venta dv
     JOIN public.productos p on p.id_producto = dv.id_producto GROUP BY p.nombre
HAVING count(dv.id_producto)>1;

-- 24. Mostrar las ventas que tienen más de un producto asociado
select id_venta, count(*) AS cantidad_productos
FROM detalle_venta GROUP BY id_venta
HAVING count(*) > 1;

-- 25. Mostrar clientes cuya suma total de unidades compradas sea mayor a 2
SELECT c.id_cliente, c.nombre, SUM(dv.cantidad) as suma_total_unidades_compradas FROM detalle_venta dv
JOIN public.ventas v on v.id_venta = dv.id_venta
JOIN public.clientes c on c.id_cliente = v.id_cliente
GROUP BY c.id_cliente, c.nombre HAVING SUM(dv.cantidad) > 2;

-- 26. Consulta trampa que no devuelva resultados
-- Explicar por qué el resultado vacío es correcto
-- Clientes que han comprado un producto con precio mayor a $1.000.000
SELECT c.nombre, p.nombre, p.precio
FROM clientes c
JOIN ventas v ON c.id_cliente = v.id_cliente
JOIN detalle_venta dv ON v.id_venta = dv.id_venta
JOIN productos p ON dv.id_producto = p.id_producto
WHERE p.precio > 1000000;

-- Si en la tabla productos no existe ningún producto
--con un precio superior a $1.000.000,
-- entonces ninguna fila cumple la condición: p.precio > 1000000
-- Entonces si no se cumple eso postgres retorna 0 rows