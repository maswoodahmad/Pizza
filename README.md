1. hsqldb.org
	download the db 2.6.1
2. extract the zip

3. goto the lib folder of the extracted folder

4. and start the cmd in it.

TO START THE HSQLDB SERVER -> 
	java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb


java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:myseconddb --dbname.0 xdb

5. and star the another cmd in it.

	TO START THE HSQLDB INTERFACE -> java -jar hsqldb.jar

6. once the interface appread, select the TYPE : engine server
	URL : jdbc:hsqldb:hsql://localhost/xdb
	
	xdb as the database name at the end of the URL

7. try any table creation process

		create table mydept120
		(
			deptno int,
			deptname varchar(20),
			loc varchar(20)
		)

create table books
		(
			isbn int primary
			author varchar(20),
			released int
		)

		select above create table command paragraph
		and execute it

8. explore the other commands by right clicking on the table name
