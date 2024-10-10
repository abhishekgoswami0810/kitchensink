# Kitchensink Application

This project is a modernized version of the classic **Kitchensink** application, rebuilt using **Spring Boot**, **MongoDB**, and **Thymeleaf** for the UI. The application was initially built on **JBoss** and **JSF** but has been migrated to leverage a more modern tech stack.

The application provides a simple web interface for managing user registrations, roles, and displaying registered members. It features an **Admin Portal** with role-based access, login/logout functionality, and a user profile section.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Getting Started](#getting-started)
3. [Project Structure](#project-structure)
4. [Features](#features)
5. [Environment Configuration](#environment-configuration)
6. [Running the Application](#running-the-application)
7. [Testing and Debugging](#testing-and-debugging)
8. [API Endpoints](#api-endpoints)
9. [Technology Stack](#technology-stack)
10. [PPT Presentation](#ppt-presentation)

## Prerequisites

Before you begin, ensure you have the following prerequisites installed:

- **Java 21 JDK**: The project uses Java 21 as the runtime environment.
- **Maven**: For building and running the application.
- **MongoDB**: Database used for storing application data.
- **MongoDB Compass** (optional): GUI tool to test and manage MongoDB connections.
- **Git**: To clone the repository.
- **Thymeleaf**: For building the frontend components.
- **Spring Security**: For handling authentication and authorization.

## Getting Started

Follow these instructions to set up and run the application on your local machine:

1. **Clone the Repository**  
   Open your terminal or command prompt and run:
   ```bash
   git clone https://github.com/abhishekgoswami0810/kitchensink.git
2. **Build the Application**
   Navigate to the project directory and run the following command to build the application:
   mvn clean install
3. **Configure Environment Variables**
   Set up the creds.env file in the src/main/resources folder. This file should contain necessary environment variables like database credentials and JWT secret keys. Make sure to include it in your run/debug configurations.
4. **Run the application**
5. **Access the Application**
   Open your browser and navigate to:

    Login URL: http://localhost:8080/login
    Use the default Admin credentials:
    Email: admin@mail.com
    Password: adminpass
6. **Admin Home Page**
   After logging in, you will be redirected to the Admin Home page where you can register new members, edit or delete existing members, and view member details.

