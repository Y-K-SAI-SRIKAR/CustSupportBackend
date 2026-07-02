# -----------------------------
# Build Stage
# -----------------------------
FROM eclipse-temurin:26-jdk AS builder

WORKDIR /app

# Copy Gradle wrapper and configuration
COPY gradlew .
COPY gradlew.bat .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Copy source
COPY src src

# Make wrapper executable
RUN chmod +x gradlew

# Build Spring Boot JAR
RUN ./gradlew clean bootJar -x test --no-daemon

# -----------------------------
# Runtime Stage
# -----------------------------
FROM eclipse-temurin:26-jre

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]