# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile the Java application
RUN javac main/Main1.java

# Command to run the application
CMD ["java", "main.Main1"]