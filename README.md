# Getting Started
* Requirements: Java 17, Maven.

* this application require Postgre SQL to run, please download under 
[postgres-postgresql-downloads](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
* credentials for the DataBase should be admin/admin (feel free to configure your username/password differently but please change flyway.user/flyway.password in POM.xml accordingly)
* it is possible to replace original csv files with new data but  
  * column names and any empty lines need to be removed
  * all "" around numeric values need to be removed

# Build and Test
* `mvn clean install`.
* `mvn clean flyway:migrate`.
