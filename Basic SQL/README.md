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

State
------
UP
Assam
Telangana

```sql
SELECT DISTINCT State, City from table
```
This command will return the following table

City	      |        State  	         	
------------|---------------------
Kanpur      |        UP	    	            
Dispur	    |        Assam        		              
Hyderabad	  |        Telangana


