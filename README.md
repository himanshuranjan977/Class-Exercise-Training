# Wipro-Class-Exercise-Training

![repo-size-badge](https://img.shields.io/badge/Repo-Wipro--Class--Exercise--Training-blue)
![language-java](https://img.shields.io/badge/Language-Java-orange)

## Repository

**Owner:** `himanshuranjan977`

## Project Title

Wipro Class Exercise Training — Fullstack Java (Great Learning)

## Description

This repository contains exercises and projects completed as part of the **Wipro Class Exercise Training** by Great Learning. The curriculum covers Core Java, Frontend, MySQL, Spring, Spring Boot, Microservices & Security, Docker, and MongoDB. The purpose of this repo is to collect practical assignments, sample apps, notes, and runnable code for learning and demonstration.

## Table of Contents

* [About](#description)
* [Technologies & Modules](#technologies--modules)
* [Repository Structure](#repository-structure)
* [Prerequisites](#prerequisites)
* [Setup & Run (per module)](#setup--run-per-module)

  * [Core Java](#core-java)
  * [Frontend](#frontend)
  * [MySQL](#mysql)
  * [Spring / Spring Boot](#spring--spring-boot)
  * [Microservices & Security](#microservices--security)
  * [Docker](#docker)
  * [MongoDB](#mongodb)


## Technologies & Modules

* **Core:** Java (OOP, Collections, Streams, Multithreading)
* **Frontend:** HTML, CSS, JavaScript (or simple React/Angular examples if included)
* **Database (Relational):** MySQL
* **Backend:** Spring, Spring Boot
* **Architecture:** Microservices, API Gateway, Service Discovery (optional)
* **Security:** Spring Security, JWT
* **Containers:** Docker (Dockerfiles and docker-compose samples)
* **NoSQL:** MongoDB (for demos where required)

## Repository Structure (suggested)

```
Wipro-Class-Exercise-Training/
├── core-java/                   # Java exercises, console apps, OOP examples
├── frontend/                    # Static HTML/CSS/JS or React/Angular apps
├── mysql/                       # SQL scripts, ER diagrams, sample dumps
├── spring-boot/                 # Microservices / Spring Boot applications
│   ├── service-user/
│   ├── service-product/
│   └── api-gateway/
├── microservices-security/      # Security demos, auth server, resource server
├── docker/                      # Dockerfiles and docker-compose.yml
├── mongodb/                     # MongoDB seeds, scripts, sample queries
├── docs/                        # Notes, study materials, slides
└── README.md
```

## Prerequisites

* Java JDK 11 or newer
* Maven or Gradle
* Node.js + npm (if using frontend frameworks)
* MySQL server
* Docker & Docker Compose (for containerized runs)
* MongoDB (or Dockerized MongoDB)

## Setup & Run (per module)

These are general steps — adapt to the specific subproject in the repo.

### Core Java

1. Navigate to `core-java/<exercise-folder>`
2. Build using Maven (if project uses Maven):

```bash
mvn clean install
```

3. Run the main class:

```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```

Or run from your IDE (IntelliJ/Eclipse).

### Frontend

If plain HTML/CSS/JS:

1. Open `frontend/index.html` in your browser.

If a Node-based frontend (React/Angular):

```bash
cd frontend
npm install
npm start
```

### MySQL

1. Create database and user (example):

```sql
CREATE DATABASE wipro_training;
CREATE USER 'wipro_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON wipro_training.* TO 'wipro_user'@'localhost';
FLUSH PRIVILEGES;
```

2. Run provided SQL scripts in `mysql/` to create tables and seed data.

### Spring / Spring Boot

From each Spring Boot service directory:

```bash
cd spring-boot/service-name
mvn clean package
java -jar target/service-name-0.0.1-SNAPSHOT.jar
```

Configuration (application.properties / application.yml) may require DB URLs and credentials.

### Microservices & Security

* If multiple microservices exist, run service discovery (Eureka) and API gateway first (if present), then individual services.
* For JWT-based security, configure the auth-server and set the `spring.security.*` properties as required.

### Docker

Build images and run with docker-compose (example):

```bash
cd docker
docker-compose up --build
```

This will build each service Dockerfile and start containers (MySQL, MongoDB, microservices, etc.)

### MongoDB

* If running locally, ensure `mongod` is running.
* Load sample data using `mongoimport` or scripts in `mongodb/`.

## Notes & Best Practices

* Keep module-specific README.md files inside each folder explaining how to run that particular exercise.
* Use environment variables for sensitive data (DB passwords, JWT secrets). Add a `.env.example` file demonstrating required variables.
* Keep `application.properties` or `application.yml` values parameterized (use placeholders like `${DB_URL}`) and add local sample config files that are ignored by Git.

## Example `.gitignore`

```
# Java
target/
*.class

# IntelliJ
*.iml
.idea/

# Node
node_modules/

# Environment
.env
```

## Contributing

1. Fork the repository
2. Create a branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m "Add feature"`
4. Push to the branch: `git push origin feature/your-feature`
5. Create a Pull Request

Please follow the code style used in the repo and add comments where necessary.

## License

Specify a license here (for example MIT):

```
MIT License
Copyright (c) 2025 Himanshu Ranjan
```

## Contact

* GitHub: [https://github.com/himanshuranjan977](https://github.com/himanshuranjan977)
* LinkedIn: (add your profile link if you want)

---

*This README is a template — tell me if you want me to tailor it more specifically to the exact folders/projects in your repo (I can add example commands, properties, and sample `docker-compose.yml`).*
