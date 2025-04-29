# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile the Java application
RUN javac main/Main2.java

# Command to run the application
CMD ["java", "RealConstructor.main.Main2"]