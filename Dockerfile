FROM openjdk:8-jdk-alpine
EXPOSE 8090
ADD target/dep-1.0.jar dep-1.0.jar
ENTRYPOINT ["java","-jar","/dep-1.0.jar"]



#FROM maven:3.8.3-openjdk-17 AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/home/app/target/achat_rest_docker.jar"]