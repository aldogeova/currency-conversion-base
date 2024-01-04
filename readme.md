# Currency Conversion Base

## Description
This is the base project, `currency-conversion-base`, built using Spring Boot Reactive and Gradle. It serves as a foundational microservice that will be utilized by other microservices within our architecture. The project features centralized exception handling, a model for MongoDB document entities, utility classes for currency conversion processing, as well as standard and custom validators. It also includes a comprehensive list of error handling for streamlined troubleshooting and maintenance.

## Prerequisites
Before you begin, ensure you have met the following requirements:

- JDK 21
- Google Cloud SDK
- Gradle 8.5

Make sure that these tools are properly installed and configured on your system.

## Compilation Guide
To compile the project, follow these steps:

1. Open your terminal or command prompt.
2. Navigate to the project's root directory where the `build.gradle` file is located.
3. Run the following commands:
   ```shell
   gradle clean
   gradle build
   ```
   
Or you can use a preferred IDE as IntelliJ and import this project as a gradle project

