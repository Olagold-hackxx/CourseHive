FROM maven:3.6.3 AS build
COPY src /backend/src
COPY pom.xml /backend
WORKDIR /backend

FROM openjdk:17-jdk-slim
RUN mvn -f /backend/pom.xml clean package
COPY --from=build target/coursehive-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]