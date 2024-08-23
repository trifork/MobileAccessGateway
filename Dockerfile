# Maven builder image
FROM maven:3.9.9-eclipse-temurin-11 AS build
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests

# Use an official OpenJDK image as the base image
FROM eclipse-temurin:11
# Set the working directory in the container
WORKDIR /app
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en' LC_ALL='en_US.UTF-8'
EXPOSE 9090
EXPOSE 9091
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/*spring-boot.jar app.jar
# Set the command to run the application
CMD ["java", "-jar", "app.jar"]
#CMD ["java", "-jar", "app.jar", "-Dspring.config.additional-location=optional:file:/config/application.yml"]
