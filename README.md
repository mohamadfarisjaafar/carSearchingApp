# carSearchingApp
Application for searching cars and exports as XML


**Implementation Plan**
	1. Domain Object (Car)
	2. Attributes: length, weight, velocity, color.
	3. Stored in an PostgreSQL database with proper schema definition.
	4. Develop an endpoint (e.g., /search-cars) using Spring Boot.
	6. Query the database using criteria passed via request parameters (e.g., length, weight, etc.).
	7. Result Download
	8. Allow users to download search results as an XML file.


 Endpoint available :
 
 INSERT : POST http://localhost:8080/api/cars/insert
         BODY : 
	 {
	  "length": 12.5,
	  "weight": 1500,
	  "velocity": 180,
	  "color": "blue"
	}

GET SPECIFIC: [http://localhost:8080/api/cars/all](http://localhost:8080/api/cars/search?length=12.5&weight=1500.0&velocity=180.0&color=blue)

GET ALL : http://localhost:8080/api/cars/all

DOWNLOAD ALL : http://localhost:8080/api/cars/export

DOWNLOAD SPECIFIC : http://localhost:8080/api/cars/download?length=12.5&weight=1500.0&velocity=180.0&color=blue


 
