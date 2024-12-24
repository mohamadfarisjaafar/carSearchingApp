# carSearchingApp
Application for searching cars and exports as XML


**Implementation Plan**
Domain Object (Car)
Attributes: length, weight, velocity, color.
Stored in an SQL database with proper schema definition.
Web Search
Develop an endpoint (e.g., /search-cars) using Spring Boot.
Query the database using criteria passed via request parameters (e.g., length, weight, etc.).
Ensure all criteria are applied simultaneously (using AND conditions in SQL).
Result Download
Allow users to download search results as an XML file.
Implement an endpoint (e.g., /download-cars) that generates XML from search results.
Proving Requirements
Unit Tests: Test each service layer component using JUnit.
Integration Tests: Test REST APIs with tools like Postman or Spring Test.
Database Validation: Ensure criteria queries return correct results.
Performance Tests: Use JMeter or similar tools to test execution quality under load.
