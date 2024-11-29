FROM openjdk:21-jdk
COPY target/*.jar /app.jar
LABEL authors="user"