# Stage 1: Build the application
FROM openjdk:19-jdk AS build
WORKDIR /app

# Copy the necessary files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src src

# Ensure the Maven wrapper has execute permissions
RUN chmod +x ./mvnw

# Build the project and skip tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the final Docker image
FROM openjdk:19-jdk
WORKDIR /app

# Expose the default Spring Boot port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
