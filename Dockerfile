# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-slim

# Set the working directory in the container
WORKDIR /app

# Copy all project directories into the container
COPY LemigoHotel /app/LemigoHotel
COPY RealConstructor /app/RealConstructor
COPY RwandaPolice /app/RwandaPolice

# Compile all Java files
RUN find . -name "*.java" > sources.txt \
    && javac @sources.txt

# Include student ID in the image metadata
LABEL studentID="26500"

# Default command to run the container (can be overridden)
CMD ["/bin/bash"]