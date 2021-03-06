# TodoList-Api-With-Auth
A todolist api with user authentication and authorization using Json Web Token(JWT) written with springboot


# Getting Started

## Prerequisites
* Git
* IntelliJ IDEA (or similar)
* Datagrip (or similar)
* Docker
* Postman

### About

This is a mini project practicing on building secured API's with Spring Boot and JWT. The idea was to 
build a User Todo-List API that performs CRUD operations, and can be consumed by a frontend/mobile app.

Endpoints except, **/signup**, **/login** can only be accessed with a JWT token(Sent via httpHeader) which is generated when the user **/login** and invalidated when **/log-out**. 

It was made using **Spring Boot**, **Spring Web**, **Spring Security**, **Spring Data JPA** and **Docker**. 
A postgres Database linked to the app image with docker-compose and deployed on docker-hub.

An API Documentation, created/updated using **Swagger**.


|Endpoint  |   |  Functionality  |   |   |
|---|---|---|---|---|
|**Post** /signup   |  |  Signup |   |   |
|**Post** /login   |   | Login  |   |   |
|**GET** /log-out  |   | Logout  |   |   |
|**GET** /todos  |   | Get todos  |   |   |
|**Post** /todos   |   | Create todo  |   |   |
|**GET**/todos/{todoId} |   |Get a todo   |   |   |
|**PUT**/todos/{todoId}   |   |Update a todo   |   |   |
|**DELETE**/todos/{todoId}   |   |Delete a todo   |   |   |


# How To Run

**Step 1**
* Visit http://localhost:8080/swagger-ui.html to view API Docs and Test Endpoints.

**Step 2**
* To obtain an authorization code, Open **POSTMAN** 
``http://localhost:8080/login``

````
{
    "email": "test@gmail.com",
    "password": "test"
}
````

Copy the "Bearer token"  code from response header and paste as api key in authorize button.

            You can now access all the endpoints as test@gmail.com user.
 
To signup new user, provide the required data as stated on the docs in json from and go back to **STEP 2**.
 


### Locally
Clone the app repo & pull the **Docker** database image from **DockerHub**

* After cloning 

**Configuration**
Folder src/resources/ contains config files for todolist-API.

src/resources/application.properties - main configuration file.

Confirm the datasource url is : ``jdbc:postgresql://localhost:5432/todo_db?user=postgres&password=postgres`` to access locally.

* Visit   ``http://localhost:8080/swagger-ui.html`` to view API docs or use **Postman** to test endpoints. 


 



