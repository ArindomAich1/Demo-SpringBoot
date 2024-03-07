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

1. To add a single product:

	* API: POST /addProduct
	* Input:
		{
			"name": "Product X",
            "quantity": 1,
			"price": 100
		}
	* Output:
		{
			"id": 1,
			"name": "Product X",
            "quantity": 1,
			"price": 100
		}

2. To add multiple products:

	* API: POST /addMultipleProduct
	* Input:
		[
			{
				"name": "Product Y",
                "quantity": 1,
				"price": 200
			},
			{
				"name": "Product Z",
                "quantity": 1,
				"price": 300
			}
		]
	* Output:
		[
			{
				"id": 2,
				"name": "Product Y",
                "quantity": 1,
				"price": 200
			},
			{
				"id": 3,
				"name": "Product Z",
				"quantity": 1,
                "price": 300
			}
		]

3. To get all products:

	* API: GET /getProducts
	* Input: N/A
	* Output:
		[
			{
				"id": 1,
				"name": "Product X",
                "quantity": 1,
				"price": 100
			},
			{
				"id": 2,
				"name": "Product Y",
                "quantity": 1,
				"price": 200
			},
			{
				"id": 3,
				"name": "Product Z",
                "quantity": 1,
				"price": 300
			}
		]

4. To get a product by ID:

	* API: GET /getProductById
	* Input: id=2
	* Output:
		{
			"id": 2,
			"name": "Product Y",
            "quantity": 1,
			"price": 200
		}

5. To update a product:

	* API: PUT /updateProduct
	* Input:
		{
			"id": 2,
			"name": "Product Y Updated",
            "quantity": 1,
			"price": 250
		}
	* Output:
		{
			"id": 2,
			"name": "Product Y Updated",
            "quantity": 1,
			"price": 250
		}

6. To delete a product:

	* API: DELETE /deleteProduct
	* Input: id=2
	* Output: "Product with id 2 deleted successfully"
