# Message Delivery Retry Application

This project demonstrates a message delivery retry system with two services: **ConsumerService** and **ProcessorService**. The application is designed to be run using Docker and Maven.

---

## Prerequisites

Before you start, ensure you have the following installed on your system:
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 11 or above)
- [Apache Maven](https://maven.apache.org/)

---

## Getting Started

### 1. Navigate to the Project Directory
```bash
cd MessageDeliveryRetry
```

### 2. Start Supporting Services with Docker Compose
```bash
docker-compose up
```

### 3. Start the ConsumerService
```bash
cd ConsumerService
mvn spring-boot:run
```

### 4. Start the ProcessorService
```bash
cd ProcessorService
mvn spring-boot:run
```