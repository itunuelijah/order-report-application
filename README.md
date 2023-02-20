# order-report-application 
Java using Spring Boot 

Introduction
The Report Application is a Spring Boot-based REST API that subscribes to Kafka to consume Order Creation Payload and provides an endpoint that returns an Order report grouped by date. The date range filter is also supported.


Architecture
The Report Application consists of the following components:

Kafka Consumer: Subscribes to the Kafka topic to consume Order Creation Payload.
REST API: Provides an endpoint to generate an Order report grouped by date.
Service Layer: Performs the business logic of generating an Order report.
Repository Layer: Provides data access to the Order reports.
Scheduler: Automatically generates Order reports at a scheduled interval.


Technology Stack
Java 17
Spring Boot 
Apache Kafka 
MySQL 
Lombok
JUnit 5
Mockito
Setup
To run the Report Application, you need to have the following installed on your machine:
JDK 11 or later
Apache Kafka
MySQL
After installing the above requirements, follow the steps below to run the Report Application:

Clone the repository from GitHub.
Open the project in your IDE.
Configure the application.properties file with your Kafka and MySQL details.

Run the project.
Endpoints
The Report Application has the following endpoints:

5.1. GET /order-report
This endpoint generates an Order report grouped by date. The date range filter is also supported. The endpoint accepts two query parameters: startDate and endDate, both in the format yyyy-MM-dd.

Sample Request: GET /api/orders/report?startDate=2022-02-01&endDate=2022-02-28

Sample Response:
{
"orderReports": [
{
"date": "2022-02-01",
"totalOrder": 4,
"totalOrderAmount": 8100.0
},
{
"date": "2022-02-02",
"totalOrder": 3,
"totalOrderAmount": 6200.0
},
{
"date": "2022-02-03",
"totalOrder": 2,
"totalOrderAmount": 3500.0
},
{
"date": "2022-02-04",
"totalOrder": 0,
"totalOrderAmount": 0.0
}
]
}

