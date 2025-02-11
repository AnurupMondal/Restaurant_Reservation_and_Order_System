# Restaurant Reservation and Order System

A command-line Java application that allows users to manage restaurant reservations and orders. This project supports both dine-in reservations and takeaway orders, provides a pre-defined restaurant menu, automatically generates order IDs, and allows users to view all reservations and orders made during the session.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies](#technologies)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Dine-In Reservations:**  
  Create dine-in reservations by specifying a reservation time and table number.

- **Takeaway Orders:**  
  Place takeaway orders without a fixed reservation time; simply provide a pickup location.

- **Predefined Menu:**  
  The application includes a pre-generated restaurant menu. Users can select items from this menu when placing orders.

- **Automatic Order ID Generation:**  
  Each order is assigned a unique order ID automatically (e.g., ORD1, ORD2, …).

- **View Reservations and Orders:**  
  Easily view all reservations and orders created during the session.

- **Command-Line Interface:**  
  Simple text-based menu navigation to interact with the application.

## Project Structure

The project follows a standard Maven directory structure:

```
restaurant-system/
├── pom.xml
└── src
  └── main
    └── java
      └── com
        └── restaurant
            ├── Main.java
            ├── Reservation.java
            ├── DineInReservation.java
            ├── TakeawayReservation.java
            ├── Order.java
            ├── OrderItem.java
            └── MenuItem.java
```

- **Main.java:**  
  The entry point for the application. It provides the main menu and handles user interactions.

- **Reservation.java:**  
  An abstract class defining common properties and methods for reservations.

- **DineInReservation.java:**  
  A concrete class extending `Reservation` to handle dine-in specific details.

- **TakeawayReservation.java:**  
  A concrete class extending `Reservation` to handle takeaway order details.

- **Order.java:**  
  Manages customer orders, including a list of ordered items and automatic order ID generation.

- **OrderItem.java:**  
  Represents an individual order item (menu item, quantity, and price).

- **MenuItem.java:**  
  Defines menu items available for ordering, including details such as name, price, and description.

## Technologies

- **Java 11** (or your specified version)
- **Maven** for build and dependency management
- **Maven Shade Plugin** for packaging the application as an executable JAR

## Installation

### Prerequisites

- **Java 11** (or later, as specified in the POM)
- **Maven** installed and configured on your system

### Steps

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/restaurant-reservation-order-system.git
   cd restaurant-reservation-order-system
   ```

2. **Build the Project:**

   Run the following Maven command to compile the project and package it into an executable JAR:

   ```bash
   mvn clean package
   ```

   This will create a JAR file in the target directory, for example:
   `target/restaurant-reservation-order-system-1.0.jar`

## Usage

Run the application from the command line by executing:

```bash
java -jar target/restaurant-reservation-order-system-1.0.jar
```

### Application Menu

- **Create Reservation/Order:**  
  Create a new dine-in reservation or place a takeaway order by providing the required details (such as reservation time for dine-in or pickup location for takeaway).

- **Place Order:**  
  View the restaurant menu, select items to add to your order, and specify the quantity. The system will automatically generate a unique order ID.

- **View Reservations:**  
  Display all reservations (both dine-in and takeaway) that have been created.

- **View Orders:**  
  Display all orders along with their respective order items.

- **Exit:**  
  Terminate the application.

Follow the on-screen prompts to navigate through the various options.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes with clear messages.
4. Push your changes to your fork.
5. Open a pull request describing your changes.

## License

This project is licensed under the MIT License.

