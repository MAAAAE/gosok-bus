FROM gradle:7.6.0-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and project files
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle.kts settings.gradle.kts ./

# Download dependencies
RUN ./gradlew dependencies --no-daemon

# Copy the source code
COPY src ./src

# Build the application
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim AS RUNNER

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar


# Expose the application port
EXPOSE ${PORT}

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","/app/app.jar"]
#
## Nginx stage
#FROM nginx:latest AS nginx
#
## Copy the Nginx configuration file
#COPY nginx.conf /etc/nginx/nginx.conf
#
## Expose the Nginx port
#EXPOSE 80
#
## Start Nginx and the Spring Boot application together
#CMD ["nginx", "-g", "daemon off;"]