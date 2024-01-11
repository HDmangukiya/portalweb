# Use a base image with Java and Maven installed for building the Spring Boot app
FROM maven:3.8.4-jdk-11 AS build

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the project files into the container
COPY . .

# Build the Maven project and clean up unnecessary files
RUN mvn clean package -DskipTests \
    && mvn clean

# Use a lightweight base image for the final runtime of the Spring Boot app
FROM openjdk:11-jre-slim

# Set metadata and labels
LABEL maintainer="Your Name <your.email@example.com>"
LABEL description="Your application description"

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file from the build stage to the final container
COPY --from=build /usr/src/app/target/*.jar /app/app.jar

# Expose the port that the Spring Boot application uses (8181)
EXPOSE 8181

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
