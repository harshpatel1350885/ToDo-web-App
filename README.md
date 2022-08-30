# ToDo-web-App
A simple web ToDo App using Angular and Java Spring Boot. Using MySQL as the database.

To create a database. Start MySql server and do:

  > mysql> create database tododb;
  > mysql> create user 'TodoUser'@'%' identified by 'ThePassword';
  > mysql> grant all on tododb.* to 'TodoUser'@'%';
  
 
After creating database, start up Java Spring Boot server on terminal by:
  > cd ToDo_Proj/todo_back
  > ./mvnw spring-boot:run 
  
To Start the Angular do:
  > ng serve
