FROM maven:3.9.9-eclipse-temurin-21

EXPOSE 8081
WORKDIR /app
COPY . .
RUN mvn clean install
ENTRYPOINT ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
