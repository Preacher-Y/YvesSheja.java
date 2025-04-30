FROM openjdk:11-slim

# Create a working directory
WORKDIR /usr/src/app

# Copy all project directories into the container
COPY RealConstructor1/ RealConstructor1/
COPY LemigoHotel1/ LemigoHotel1/
COPY RwandaPolice/ RwandaPolice/
COPY start.sh .

# Make the script executable
RUN chmod +x start.sh

# Set the default command
CMD ["./start.sh"]
