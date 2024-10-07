# kitchensink

This is a simple web application built with spring boot with mongodb and thymeleaf for UI. 
This application is migrated to a newer framework from kitchensink application built on JBoss and JSF

## Prerequisites

Before you begin, ensure you have the following prerequisites installed:

- Java 21 jdk installed
- env file for credentials (in resources folder)
- Mongodb compass to test the connection (not mandatory)

## Getting Started

To get started with the application in your local system, follow these steps:

1. Clone the repository:
    git clone https://github.com/abhishekgoswami0810/kitchensink.git
2. mvn clean install
3. setup env file (creds.env) in run/debug configurations
4. run app
5. hit the member login url - http://localhost:8080/login
6. Login with Admin privileges (email/password : admin@mail.com/adminpass)

PPT for more details - https://docs.google.com/presentation/d/14Q4zLUja75BgI5quOxa3KpaMV3QClob9RQuZj_cgI8o/edit#slide=id.g287fa921f8d_0_1382