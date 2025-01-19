# E-Commerce Cake Microservice Website
This repository contains the microservices for an e-commerce platform dedicated to cake sales. Each microservice is built using Spring Boot, initialized through Spring Initializr, and is designed to handle different aspects of the platform such as order management, security, and product catalog.

## Microservices Overview
The project is structured into several microservices, each residing in its own directory:
- **Notification**: Handles sending notifications to users.
- **Order**: Manages order processing and tracking.
- **Security**: Responsible for authentication and authorization.
- **apiGateway**: Acts as the entry point for all microservices, routing requests.
- **category**: Manages product categories.
- **product**: Handles product details.
- **user**: Manages user information and credentials.
- **serviceDiscovery**: Enables service registration and discovery.

## Prerequisites
- Java 11 or later
- Maven 3.6 or later
- Docker (for container management)

## Installation
1. **Clone the Repository**
   git clone https://github.com/SivasankaranKaleeswaran/E-Commerce_Cake_Microservice_Website.git
2. **Navigate to Each Microservice Directory**
   For each microservice, you need to navigate into its directory from the command line and run the following commands:
   cd <microservice_name>
   mvn clean install

3. **Environment Configuration**
   Ensure you create an `.env` file in each microservice directory with the necessary environment variables configured. Example for the apiGateway:
   VITE_API_KEY=<your_api_key_here>

4. **Running the Microservices**
   Each microservice can be started with:
   mvn spring-boot:run
   Alternatively, if you are using Docker, you can navigate to the root directory and run:
   docker-compose up

## Usage
Access the apiGateway via `http://localhost:8080` to interact with the various microservices through the unified interface. Make sure all microservices are registered with the serviceDiscovery to ensure proper routing and load balancing.
