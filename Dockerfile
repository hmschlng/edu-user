# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-slim

# Install required tools
RUN apt-get update && apt-get install -y \
    telnet \
    curl \
    jq \
    && rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar edu-user-app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "edu-user-app.jar"]