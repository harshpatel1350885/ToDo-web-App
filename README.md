# ToDo-web-App
A simple web ToDo App using Angular and Java Spring Boot. Using MySQL as the database.

To create a database. Start MySql server and do:
1. mysql> create database tododb;
2. mysql> create user 'TodoUser'@'%' identified by 'ThePassword';
3. mysql> grant all on tododb.* to 'TodoUser'@'%';
  
 
After creating database, start up Java Spring Boot server on terminal by:
1. cd ToDo_Proj/todo_back
2. ./mvnw spring-boot:run 
  
To Start the Angular do:
1. ng serve
