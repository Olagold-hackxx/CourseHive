FROM openjdk:25-jdk-slim
WORKDIR /backend
COPY target/coursehive-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]