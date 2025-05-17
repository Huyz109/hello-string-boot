# Hello Spring Boot Project
Project to start learning Java Spring Boot

## Init project
Go to spring start website to init project [spring initializr](https://start.spring.io/)

## Docker guideline
### Create network:
`docker create network hello-spring-boot-network`
### Start MySQL in hello-spring-boot-network
`docker run --network hello-spring-boot-network --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.36-debian`
### Run your application in hello-spring-boot-network
`docker run --name identity-service --network hello-spring-boot-network -p 8080:8080 -e DBMS_CONNECTION=jdbc:mysql://mysql:3306/identity_service identity-service:0.9.0`