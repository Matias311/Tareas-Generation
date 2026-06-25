# Sistema de Ventas - Tienda de Tecnología

## 1. Descripción del proyecto

Modelamos un sistema de base de datos PostgreSQL para una tienda de tecnología que necesita registrar la información básica de sus operaciones. El sistema permite almacenar clientes registrados, productos disponibles, ventas realizadas y el detalle de productos vendidos en cada venta.

El problema que resuelve es poder responder preguntas reales de negocio como:
- ¿qué clientes compran más?
- ¿qué productos se venden más?
- ¿cuántas ventas se realizan?
- ¿qué ventas tienen más de un producto?
- ¿qué clientes han comprado varias veces?

### Diagrama entidad-relación

```mermaid
erDiagram
    clientes {
        INT id_cliente PK
        VARCHAR nombre "NOT NULL"
        VARCHAR email "NOT NULL UNIQUE"
    }
    productos {
        INT id_producto PK
        VARCHAR nombre "NOT NULL"
        NUMERIC precio "NOT NULL CHECK >0"
    }
    ventas {
        INT id_venta PK
        DATE fecha "NOT NULL"
        INT id_cliente FK "NOT NULL"
    }
    detalle_venta {
        INT id_detalle PK
        INT id_venta FK "NOT NULL"
        INT id_producto FK "NOT NULL"
        INT cantidad "NOT NULL CHECK >0"
    }

    clientes ||--o{ ventas : realiza
    ventas ||--o{ detalle_venta : contiene
    productos ||--o{ detalle_venta : incluye
```

## 2. Tecnologías utilizadas

- PostgreSQL
- SQL (DDL, DML, Joins, Agregaciones)

## 3. Instrucciones de uso

```bash
# 1. Ejecutar schema.sql para crear la base de datos y las tablas
psql -U postgres -f schema.sql

# 2. Ejecutar seed.sql para poblar las tablas con datos de ejemplo
psql -U postgres -d postsql_sistema_ventas -f seed.sql

# 3. Ejecutar report.sql para correr las consultas del reporte
psql -U postgres -d postsql_sistema_ventas -f report.sql
```
