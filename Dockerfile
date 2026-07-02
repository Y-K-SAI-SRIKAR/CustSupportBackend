# -----------------------------
# Stage 1: Build the application
# -----------------------------
FROM amazoncorretto:21 AS builder

WORKDIR /app

# Copy project files
COPY . .

# Make Gradle Wrapper executable
RUN chmod +x gradlew

# Build the application (skip tests)
RUN ./gradlew clean build -x test --no-daemon

# -----------------------------
# Stage 2: Runtime image
# -----------------------------
FROM amazoncorretto:21

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/NexVitalsSupportBackend-0.0.1-SNAPSHOT.jar app.jar

# Render provides PORT automatically
EXPOSE 8080

# Start the Spring Boot application
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]