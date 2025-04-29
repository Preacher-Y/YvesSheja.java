# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile all Java files recursively in the RwandaPolice directory and its subdirectories
RUN javac $(find . -name "*.java")

# Command to run the application
CMD ["java", "RwandaPolice.main.Main"]