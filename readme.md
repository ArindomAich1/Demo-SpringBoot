# Spring Boot CRUD demo

This is a simple Spring Boot demo project using JPA and H2 database. It has the basic CRUD operations and uses the Lombok library to generate getters and setters.

## Packages used

* spring-boot-starter-actuator
* spring-boot-starter-data-jpa
* spring-boot-starter-web
* mysql-connector-java
* lombok
* spring-boot-starter-test
* spring-boot-maven-plugin

The APIs in the ProductController are:

GET /api/v1/products - Returns all the products in the system

Request: None

Response:

[
  {
    "id": 1,
    "name": "Product 1",
    "description": "This is product 1",
    "price": 100.0
  },
  {
    "id": 2,
    "name": "Product 2",
    "description": "This is product 2",
    "price": 200.0
  }
]


POST /api/v1/products - Creates a new product

Request:

{
  "name": "Product 3",
  "description": "This is product 3",
  "price": 300.0
}

Response:

{
  "id": 3,
  "name": "Product 3",
  "description": "This is product 3",
  "price": 300.0
}


GET /api/v1/products/{id} - Returns a product by id

Request: None

Response:

{
  "id": 1,
  "name": "Product 1",
  "description": "This is product 1",
  "price": 100.0
}


PUT /api/v1/products/{id} - Updates a product

Request:

{
  "name": "Product 1 - Updated",
  "description": "This is product 1 - Updated",
  "price": 500.0
}

Response:

{
  "id": 1,
  "name": "Product 1 - Updated",
  "description": "This is product 1 - Updated",
  "price": 500.0
}


DELETE /api/v1/products/{id} - Deletes a product

Request: None

Response: None

