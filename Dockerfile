FROM amazoncorretto:21

# Install gradle
RUN yum install -y gradle

WORKDIR /app

COPY . .

RUN ./gradlew clean build -x test --no-daemon

EXPOSE 8080

CMD ["java", "-Dserver.port=${PORT}", "-jar", "build/libs/NexVitalsSupportBackend-0.0.1-SNAPSHOT.jar"]