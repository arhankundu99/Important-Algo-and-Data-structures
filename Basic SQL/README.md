# SQL Basics

### What is SQL?
Sql stands for structural query language. We can use sql to access and manipulate data in relational database management systems (RDBMS). <br/>
A database often contains one or more tables. The tables can be broken down into records (rows) and fields (col).

### Most used keywords in SQL
Query   | Function
--------|--------------------------------------
|SELECT | extracts data from a database
|UPDATE | updates data in a database
|DELETE | deletes data from a database
|INSERT INTO | inserts new data into a database
|CREATE DATABASE | creates a new database
|ALTER DATABASE | modifies a database
|CREATE TABLE | creates a new table
|ALTER TABLE | modifies a table
|DROP TABLE | deletes a table
|CREATE INDEX | creates an index (search key)
|DROP INDEX | deletes an index

Note: Sql Keywords are NOT Case-sensitive

### SELECT keyword
This keyword is used to select data from databases. The selected data is returned in the form of a table. Consider the "Customers" table below 

CustomerID |	        CustomerName  	     |   ContactName
-----------|-------------------------------|---------------------
1          |         Alfreds Futterkiste	 |  Maria Anders	
2	         |         Ana Trujillo          |  Emparedados
3	         |         Antonio Moreno        |	Antonio Moreno	
4          |         Thomas                |  Hardy
5	         |         Berglunds snabbköp	   |  Christina Berglund	


```sql
SELECT * from Customers;
```
The above command will return the full table.

```sql
SELECT CustomerID, CustomerName from Customers;
```
The above command returns the following table

CustomerID	|        CustomerName  	         	
------------|---------------------
1           |        Alfreds Futterkiste	    	
2	          |        Ana Trujillo            
3	          |        Antonio Moreno        		
4           |        Thomas                  
5	          |        Berglunds snabbköp

### SELECT Distinct Keyword
The SELECT DISTINCT statement is used to return only distinct (different) values. Consider the table below

City	      |        State  	         	
------------|---------------------
Kanpur      |        UP	    	
Varanasi	  |        UP            
Dispur	    |        Assam        		
Guwahati    |        Assam                  
Hyderabad	  |        Telangana

```sql
SELECT DISTINCT State from table
```
This command will return the following column

|State|
|------|
|UP|
|Assam|
|Telangana|

```sql
SELECT DISTINCT State, City from table
```
This command will return the following table

City	      |        State  	         	
------------|---------------------
Kanpur      |        UP	    	            
Dispur	    |        Assam        		              
Hyderabad	  |        Telangana

### WHERE Keyword

```sql
SELECT Col1, Col2
FROM table
where condition
```

#### Examples

```sql
SELECT * from table
WHERE City = 'Hyd'
```

```sql
SELECT * from table
WHERE NOT City = 'Hyd'
```

```sql
SELECT * from table
WHERE City = 'Hyd'
AND id = 1
```

```sql
SELECT * from table
WHERE City = 'Hyd'
OR id = 1
```

### Operators in WHERE Clause

OPERATOR | DESCRIPTION
---------|------------
=        | EQUAL
<>       | NOT EQUAL
BETWEEN  | Between a certain range
IN       | To specify multiple possible values for a column
LIKE     | To Search for a pattern
NOT      | Not equal

```sql
SELECT * from table
WHERE ID in (1, 2)
```

```sql
SELECT * from table
WHERE ID BETWEEN (1, 10)
```
NOTE: In the range (1, 10), 1 and 10 are inclusive

### ORDER BY Keyword

ORDER BY Keyword is used to sort the selected records

```sql
SELECT * FROM Customers
ORDER BY Country ASC, CustomerName DESC;
```

The above query first sorts the records in ascending order wrt Country, if two countries are same, then it sorts the record in descending order wrt CustomerName

### INSERT INTO

This keyword is used to insert records in database

```sql
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
```

Example
```sql
INSERT INTO Customers (CustomerName, City, Country)
VALUES('Mike', 'Dubai', 'UAE');
```
In the remaining columns, values will be null

### NULL Keyword
```sql
SELECT column_names
FROM table_name
WHERE column_name IS NULL;
```

```sql
SELECT column_names
FROM table_name
WHERE column_name IS NOT NULL;
```
Always use IS NULL to look for NULL values.

### UPDATE Keyword
```sql
UPDATE table_name
SET col1 = value1, col2 = value2
WHERE Condition
```

### DELETE Keyword
```sql
DELETE FROM table_name
WHERE Keyword
```

### SQL SELECT TOP Keyword
Selects top k records
```sql
SELECT TOP number|percent col1, col2, col3
FROM table_name
WHERE condition
```

### SQL MIN, MAX, COUNT, AVG, SUM
```sql
SELECT MIN(COL1)
FROM table_name
where condition
```
Same syntax for other functions
Count gives us the number of records selected

### SQL LIKE Keyword

OPERATOR | DESCRIPTION
---------|-------------
%        | zero or one or more characters
_        | one character
\#        | represents any single numerical character. (2\#5) can mean 205, 215,.....295
\[]       | Represents any single character. a[bd]c can mean abc, adc
!        | Represents character which are not in brackets a[!bd]c means aac, acc, aec...etc
\-        | Represents range of characters a[b-z]c means abc, acz, adz, aez....azz

```sql
SELECT * 
FROM table_name
WHERE Col1 LIKE 'a%n'
```
The above query selects words which start with a and end with n

### SQL Aliases

SQL Aliases are used to give the table or columns of the table a temporary name.
Why are they used? TO MAKE THE COLUMN NAMES MORE READABLE.
This alias will only exist till the duration of the query.

```sql
SELECT col1 AS alias_name
from table_name;

SELECT col1
from table_name AS alias_name

SELECT col1 AS [alias name]
from table_name;
/* if alias name contains space, then use bracket */

SELECT col1 as c1, col2 + ", " + col3 + ", " + col4 as c2
from table_name;
/* column concatenation */

SELECT t1.col1, t2.col1
from table1 as t1, table2 as t2
where condition;
/* selecting data from multiple tables */
```

