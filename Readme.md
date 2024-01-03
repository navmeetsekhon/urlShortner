# URL Shortener and QR Code Generator

Welcome to the URL Shortener and QR Code Generator, a full-stack application built with Vanilla JavaScript for the front end and Spring Boot, MySQL, Maven, and Hibernate JPA for the backend.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Frontend Setup](#frontend-setup)
  - [Backend Setup](#backend-setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
<!-- - [Database Schema](#database-schema) -->
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Introduction

URL Shortener and QR Code Generator is a web application that allows users to shorten long URLs and generate QR codes for easy sharing. The application features a simple and intuitive user interface for shortening URLs and retrieving them.

## Features

- URL Shortening: Shorten long URLs into compact, shareable links.
- QR Code Generation: Generate QR codes for shortened URLs and any text.
- Backend Storage: Store and manage URLs in a MySQL database using Spring Boot and Hibernate JPA.
- Full Stack: Utilizes Vanilla JavaScript for the frontend and Spring Boot for the backend.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 17 or later
- Apache Maven
- MySQL Database
- Node.js and npm (for the frontend)

## Getting Started

Follow the steps below to set up and run the URL Shortener and QR Code Generator on your local machine.

### Backend Setup

1. Clone the repository:

   ```bash
   git clone git@github.com:navmeetsekhon/urlShortner.git

2. Navigate to the server directory:

    ```bash
    cd server

3. Update the application.properties file with your database connection details:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/urlShortnerDb
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl-auto=update
    short-url.allowed-characters=${ALLOWED_CHARS:abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789}
    short-url.key-length=${KEY_LENGTH:6}

4. Run the application:

    ```bash
    mvn spring-boot:run

The backend will be accessible at http://localhost:8080.

### Front-end Setup

1. Navigate to the client directory:

    ```bash
    cd client

2. Open `index.html` in any browser.

### Usage
Visit the frontend application `index.html` to start shortening URLs and generating QR codes. The backend API endpoints are available at http://localhost:8080/api.

### Contributing
We welcome contributions! If you'd like to contribute to the project, please follow our contribution guidelines.

### License
This project is licensed under the MIT License. See the LICENSE file for details.

### Acknowledgments
Thank you to the Spring Boot, Hibernate, and Node.js communities for their excellent tools and documentation.
Special thanks to contributors and collaborators who have helped improve the project.

