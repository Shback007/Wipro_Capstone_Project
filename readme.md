# Selenium Automation Framework

A robust and scalable Selenium Automation Framework built using **Java, Selenium, TestNG, Maven, Docker, and Jenkins** following the **Page Object Model (POM)** design pattern.

---

# Features

- Parallel Test Execution
- Headless Browser Execution
- Dockerized Selenium Grid Setup
- Jenkins CI/CD Integration
- Jenkins Running Inside Docker
- RemoteWebDriver Support
- Selenium Standalone Chrome Integration
- Extent Reports
- Data-Driven Testing
- Shadow DOM Handling
- SVG Element Handling
- Drag & Drop Automation
- Dynamic Web Tables
- File Upload & Download
- Utility-Based Reusable Framework

---

# Tech Stack

- Java 21
- Selenium WebDriver 4
- TestNG
- Maven
- Jenkins
- Docker & Docker Compose
- Selenium Standalone Chrome
- Log4j2
- Extent Reports
- Apache POI

---

# Project Structure

```text
TestAutomationBlogspot
│
├── .settings
├── docs
├── logs
├── reports
├── screenshots
│
├── src
│   ├── main
│   └── test
│       ├── java
│       │   ├── base
│       │   ├── listeners
│       │   ├── pages
│       │   ├── tests
│       │   └── utilities
│       │
│       └── resources
│
├── target
├── test-output
│
├── docker-compose.yml
├── Dockerfile
├── Jenkinsfile
├── pom.xml
├── testng.xml
└── README.md
```

---

# Framework Architecture

```text
               +----------------------+
               |     GitHub Repo      |
               +----------+-----------+
                          |
                          ↓
               +----------------------+
               |   Jenkins (Docker)   |
               |   Port Binding Used  |
               +----------+-----------+
                          |
                          ↓
               +----------------------+
               | Maven Test Execution |
               +----------+-----------+
                          |
                          ↓
               +----------------------+
               | Selenium Standalone  |
               | Chrome Container     |
               +----------+-----------+
                          |
                          ↓
               +----------------------+
               | RemoteWebDriver      |
               +----------+-----------+
                          |
                          ↓
               +----------------------+
               | Extent Reports       |
               +----------------------+
```

---

# Docker Setup

The framework uses **Docker Compose** to orchestrate:

- Jenkins Container
- Selenium Standalone Chrome Container

## Start Containers

```bash
docker-compose up -d
```

## Stop Containers

```bash
docker-compose down
```

---

# Jenkins Inside Docker

Jenkins is configured and executed inside a Docker container using **port binding**.

Example:

```bash
docker run -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts
```

Access Jenkins:

```text
http://localhost:8080
```

---

# Selenium Standalone Chrome

The framework uses Selenium Standalone Chrome running inside Docker.

Example Container:

```bash
docker run -d -p 4444:4444 selenium/standalone-chrome
```

Selenium Grid URL:

```text
http://localhost:4444/wd/hub
```

---

# RemoteWebDriver Configuration

The framework supports execution using `RemoteWebDriver`.

```java
ChromeOptions options = new ChromeOptions();

driver = new RemoteWebDriver(
    new URL("http://localhost:4444/wd/hub"),
    options
);
```

---

# Parallel Execution

```xml
<suite name="Suite"
       parallel="classes"
       thread-count="5">
```

---

# Headless Execution

```properties
headless=true
```

---

# Maven Commands

## Run Complete Test Suite

```bash
mvn clean test
```

## Run Specific TestNG Suite

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

# Jenkins Pipeline Execution

The Jenkins pipeline:

1. Pulls source code from GitHub
2. Builds project using Maven
3. Executes Selenium tests inside Dockerized environment
4. Connects to Selenium Chrome container using RemoteWebDriver
5. Generates Extent Reports
6. Archives reports and screenshots

---

# CI/CD Workflow

```text
 GitHub Push
      ↓
 Jenkins Pipeline (Docker)
      ↓
 Maven Build
      ↓
 Selenium Test Execution
      ↓
 RemoteWebDriver → Chrome Container
      ↓
 Extent Report Generation
      ↓
 Artifact Archive
```

---

# Screenshots

## Jenkins Pipeline
![Jenkins Pipeline](screenshots/JenkinsPipeline.png)

---

## Date Picker Automation
![Date Picker](screenshots/handleDatePicker1.png)

---

## Form Submission
![Form Submission](screenshots/verifyFormSubmission.png)

---

## Mouse Hover Action
![Mouse Hover](screenshots/verifyMouseHover2.png)

---

## Multiple File Upload
![Multiple File Upload](screenshots/verifyMultipleFileUpload.png)

---

# Extent Reports

[![Extent Report](https://img.shields.io/badge/View-Extent_Report-blue)](https://shback007.github.io/Wipro_Capstone_Project/)

```text
reports/ExtentReport.html
```

---

# Automation Concepts Covered

- Selenium WebDriver
- Page Object Model (POM)
- RemoteWebDriver
- Dockerized Test Execution
- Selenium Grid
- Jenkins CI/CD
- Parallel Execution Framework
- Data-Driven Testing
- API & UI Automation
- Extent Reporting
- File Upload & Download Automation
- Dynamic Element Handling

---

# 👨‍💻 Author

## Sagnik Hore

Passionate Automation Engineer focused on building scalable and enterprise-grade automation frameworks using:

- Java
- Selenium
- Docker
- Jenkins
- TestNG
- Maven
- CI/CD Pipelines
- UI & API Automation

---