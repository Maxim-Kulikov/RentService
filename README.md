<h1 align="center">Rent Service</h1>

## About the project

**Let's start by describing the purpose of the project**

This is a rest service that allows you to save objects of such types as a car, a user, additional user data, a car rental order. This application will be a good basis for further creation of a real car rental service.

**Subject area**

- ***Car*** - this is an entity with properties such as car ID, car model (model and make), car number, rental price for the day, description of disadvantages.
- ***Model*** - this is an entity with properties such as model ID, model name and ID of the mark to which this model belongs.
- ***Mark*** - this is an entity with properties such as mark ID and mark name. The entities of the brand and model are added automatically when creating a car. If the brand already exists in the database, then a new car model is linked to it, otherwise both the brand and the model are created, which are entered into the properties of the car.
- ***Additional user data*** - this is an entity with properties such as its ID, passport number, name, lastname, birthdate, number of driving license, phone number and register date of driving license. When creating a user entity, an empty entity of additional data is automatically created linked to it.
- ***Order*** - this is an entity with properties such as its ID, date of rent starting, date of rent finishing, status (allowed or not by admin), Id of car to rent, Id of client, Id of admin (who allowed or not), refuse reason (if admin did not allow), total price for rent.
- ***Role*** - this is an entity with properties such as its ID and name of role. Role data is automatically entered into the database when the application is first launched. There are 2 roles: admin and user.
- ***User*** - this is an entity with properties such as its ID, login, password, ID of role and ID of additional data.
 
**Opportunities** 

This service consists of 4 controllers, each of which provides a wide variety of commands for working with data. Controllers for cars, users, and additional user data provide a standard set of commands for adding, reading, editing, and deleting commands. In addition, the controller for cars allows you to get a list of cars sorted by incoming request parameters. And 4 controller allows you to create, edit and delete orders. In order for the order to become active/inactive, there is a method for performing this action.

## Main technologies

- **Spring boot** - the application is implemented by spring boot, which makes the development process much more comfortable, allowing you not to control the implementation of a large number of dependencies and focus on the efficiency and diversity of the business logic of my application.
- **Docker** - i used this technology to create my database container based on a postgres image.
- **Liquibase** - this technology has given me the ability to control the versions of my database and makes my project more flexible for further development.

## Project dependencies

- **spring-boot-starter-data-jpa** provides persisting, reading, and managing data from your Java object to relational tables in the database.
- **spring-boot-starter-web** helps to reduce the number of manually added dependencies just by adding one dependency.
- **liquibase-core** provides a database version control system, mainly it concerns the structure and to a lesser extent the contents of the database
- **lombok** provides a large number of annotations for faster and better code writing.
- **postgresql** provides postgres driver to interact with the database.
- **springdoc-openapi-ui** provides a convenient graphical interface for making requests to the server and getting results.
- **mapstruct** allows you to conveniently convert java objects of one type to another. I use this dependency to convert entities to dto and vice versa.

## Project installing and running

- **Install docker** https://docs.docker.com/engine/install/)https://docs.docker.com/engine/install/
- **Install Java Development Kit 17** https://docs.oracle.com/en/java/javase/17/install/installation-jdk-microsoft-windows-platforms.html
- **Install Gradle** https://gradle.org/install/
- **Install and set up PostgreSQL image** https://habr.com/ru/companies/first/articles/683874/
- **Install directory RunAndInstall** from my repository
- **Run docker**
- **Run run.bat in installed directory RunAndInstall**
