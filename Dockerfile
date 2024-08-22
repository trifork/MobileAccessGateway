# Use an official Maven image as the base image
FROM maven:3.9.9-eclipse-temurin-11 AS build
# Set the working directory in the container
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
COPY --from=build /app/target/*.jar app.jar
# Set the command to run the application
#CMD ["java", "-jar", "app.jar", "-Djavax.net.ssl.trustStore=cacerts", "-Djavax.net.ssl.trustStorePassword=changeit", "-Dspring.config.additional-location=optional:file:/config/application.yml"]
CMD ["java", "-jar", "app.jar"]
