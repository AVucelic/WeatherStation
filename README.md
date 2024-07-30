# Weather Station

## Overview
Weather Station is a Java application designed to monitor and track air temperatures, air pressure, and humidity. The application utilizes the Factory Pattern to create sensor objects and the Observer Pattern to update and display the data in real-time.

## Features
- **Track Air Temperature:** Monitor and log air temperature readings.
- **Track Air Pressure:** Monitor and log air pressure readings.
- **Track Humidity:** Monitor and log humidity readings.
- **Real-time Updates:** Utilize the Observer Pattern to ensure real-time data updates.
- **Extensible Design:** Use the Factory Pattern to easily add new types of sensors.

## Design Patterns Used
1. **Factory Pattern:** To create instances of sensors (temperature, pressure, humidity).
2. **Observer Pattern:** To notify and update display components whenever sensor data changes.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- An IDE such as IntelliJ IDEA or Eclipse

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/WeatherStation.git
