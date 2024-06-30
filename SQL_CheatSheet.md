# SQL Cheat Sheet

### SQL Basics

**Create Database**
```sql
CREATE DATABASE database_name;
```

**Use Database**
```sql
USE database_name;
```

**Create Table**
```sql
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    ...
);
```

**Insert Data**
```sql
INSERT INTO table_name (column1, column2, ...)
VALUES (value1, value2, ...);
```

**Select Data**
```sql
SELECT column1, column2, ...
FROM table_name;
```

**Where Clause**
```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

**Order By**
```sql
SELECT column1, column2, ...
FROM table_name
ORDER BY column1 ASC|DESC, column2 ASC|DESC;
```

**Limit**
```sql
SELECT column1, column2, ...
FROM table_name
LIMIT number_of_rows;
```

**Update Data**
```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```

**Delete Data**
```sql
DELETE FROM table_name
WHERE condition;
```

### SQL Joins

**Inner Join**
```sql
SELECT column1, column2, ...
FROM table1
INNER JOIN table2
ON table1.column = table2.column;
```

**Left Join**
```sql
SELECT column1, column2, ...
FROM table1
LEFT JOIN table2
ON table1.column = table2.column;
```

**Right Join**
```sql
SELECT column1, column2, ...
FROM table1
RIGHT JOIN table2
ON table1.column = table2.column;
```

**Full Outer Join**
```sql
SELECT column1, column2, ...
FROM table1
FULL OUTER JOIN table2
ON table1.column = table2.column;
```

### SQL Functions

**Aggregate Functions**
```sql
SELECT COUNT(column)
FROM table_name;

SELECT SUM(column)
FROM table_name;

SELECT AVG(column)
FROM table_name;

SELECT MAX(column)
FROM table_name;

SELECT MIN(column)
FROM table_name;
```

**String Functions**
```sql
SELECT CONCAT(column1, column2)
FROM table_name;

SELECT UPPER(column)
FROM table_name;

SELECT LOWER(column)
FROM table_name;

SELECT SUBSTRING(column, start, length)
FROM table_name;
```

**Date Functions**
```sql
SELECT CURRENT_DATE;

SELECT YEAR(column)
FROM table_name;

SELECT MONTH(column)
FROM table_name;

SELECT DAY(column)
FROM table_name;
```

### SQL Subqueries

**Subquery in SELECT**
```sql
SELECT column1, (SELECT column2 FROM table2 WHERE table1.id = table2.id)
FROM table1;
```

**Subquery in WHERE**
```sql
SELECT column1, column2
FROM table1
WHERE column1 IN (SELECT column1 FROM table2 WHERE condition);
```

**Subquery in FROM**
```sql
SELECT *
FROM (SELECT column1, column2 FROM table1) AS subquery
WHERE condition;
```

### SQL Views

**Create View**
```sql
CREATE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

**Use View**
```sql
SELECT *
FROM view_name;
```

**Update View**
```sql
CREATE OR REPLACE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

**Drop View**
```sql
DROP VIEW view_name;
```

### SQL Transactions

**Begin Transaction**
```sql
BEGIN;
```

**Commit Transaction**
```sql
COMMIT;
```

**Rollback Transaction**
```sql
ROLLBACK;
```

### SQL Indexes

**Create Index**
```sql
CREATE INDEX index_name
ON table_name (column1, column2, ...);
```

**Create Unique Index**
```sql
CREATE UNIQUE INDEX index_name
ON table_name (column1, column2, ...);
```

**Drop Index**
```sql
DROP INDEX index_name
ON table_name;
```

**Launching  mysql using Terminal only**
```bash
sudo mysql -u root -p
```