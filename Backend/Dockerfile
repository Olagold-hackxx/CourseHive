FROM maven:3.9.3-eclipse-temurin-17-alpine AS build
WORKDIR /backend
COPY src /backend/src
COPY pom.xml /backend
RUN mvn clean package -DskipTests -Dspring-boot.repackage.skip=true

FROM openjdk:17-jdk-slim
WORKDIR /backend
COPY --from=build /backend/target/coursehive-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]