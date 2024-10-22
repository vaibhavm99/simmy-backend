# Step 1: Use the official Maven image to build the application
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Step 4: Copy the source code to the container
COPY src /app/src

# Step 5: Package the application using Maven
RUN mvn clean package -DskipTests

# Step 6: Use the OpenJDK image to run the Spring Boot app
FROM openjdk:17-jdk-slim

# Step 7: Set the working directory
WORKDIR /app

# Step 8: Copy the packaged JAR file from the Maven build stage
COPY --from=build /app/target/*.jar app.jar

# Step 9: Expose the port on which the Spring Boot app will run (default is 8080)
EXPOSE 8080

# Step 10: Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
