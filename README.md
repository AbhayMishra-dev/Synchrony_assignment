# Synchrony_assignment
Problem Statement
The system requires an application that efficiently process data by 
●	Connecting to a Database securely with an SSL/TLS: Perform CRUD operations on a relational database MySQL
●	Redis Cache: Interact with Redis for caching frequently used data to reduce database load and improve performance.
●	Optimize performance, parallel threading must be implemented to increase throughput and handle multiple database queries and cache updates simultaneously and reduce latency. 
Requirements
1.	Database operations
a)	Establish and maintain a reliable database connection.
b)	 Handle multiple queries concurrently, ensuring thread safety during read and write operations.
2.	Redis Cache:
a)	Connect to Redis for key-value data storage and retrieval.
b)	Cache results of database queries and invalidate/update the cache when data changes.
3.	Parallel Threading:
a)	Implement multithreading or asynchronous programming to ensure tasks run concurrently.
b)	Safeguard against race conditions, deadlocks, and resource contention.
4.	Error Handling & Resilience:
a)	Handle connection failures to Redis, or the database gracefully.
b)	Ensure retry mechanisms and fallback strategies are in place.
5.	Performance Metrics:
a)	Measure and log performance metrics for thread execution and cache hit/miss rates.
b)	Optimize the system for high throughput and low latency.

Deliverables

1. Code Implementation: A module or service that connects to the database, Redis, while supporting parallel processing.
2. Documentation: Provide setup instructions, code architecture details.
3. Test Cases: Include unit and integration tests for all components (database, Redis).
4. Performance Reports: Show how parallel threading improves system throughput and latency (sequential vs parallel calls)



Technical Stack

1.	Programming Language: Java/Springboot
2.	Database: MySQL
3.	Cache: Redis
4.	Concurrency Library: excutorservice (preferably) 

Note: You can have MySQL and REDIS installed locally in your system and upload the code to a public github and share the link back to recruitment team.
