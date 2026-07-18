# Build stage
# Build stage (Java 21 இமேஜைப் பயன்படுத்தவும்)
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN ./mvnw clean package -DskipTests

# Run stage (Java 21 இமேஜைப் பயன்படுத்தவும்)
FROM eclipse-temurin:21-jre-jammy
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
