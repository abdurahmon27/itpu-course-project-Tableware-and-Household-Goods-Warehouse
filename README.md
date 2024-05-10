### Tableware and Household Goods Warehouse Management System

This Java application is a simple warehouse management system designed to manage tableware and household goods inventory. It provides a command-line interface (CLI) for users to interact with the system.

#### Features

- **Search Products**: Search for products by their name.
- **List All Products**: Display a list of all products available in the inventory.
- **Clear Console**: Clear the console screen for better readability.
- **Help Command**: Display available commands and their usage.
- **Exit**: Exit the application.

#### Requirements

- Java Development Kit (JDK) installed on your system.

#### Installation

1. Clone or download the repository.
2. Compile the Java files using `javac`.
   ```bash
   javac main/java/itpu/warehouse/Main.java
   ```
3. Run the compiled `Main` class.
   ```bash
   java main/java/itpu/warehouse/Main
   ```

#### Usage

Upon running the application, you will be greeted with a welcome message and a list of available commands. Use the following commands to interact with the system:

- **help**: Display available commands.
- **search <product name>**: Search for a product by its name.
- **list all**: List all products in the inventory.
- **exit**: Exit the application.

#### Example

```bash
Tableware and Household Goods Warehouse Management System
Version: 1.0.0
Creator: Raxmon Mamadiyorov | raxmon_mamadiyorov@student.itpu.uz | bekzotovich.uz
Email: bekzotovich12@gmail.com

Available Commands:
* help
* search <product name>
* list all
* clear
* exit

Enter command: search Plate
Search Results:
ID: 101, Name: Plate, Category: Kitchenware, Price: $5.99, Quantity: 50
ID: 102, Name: Plate, Category: Kitchenware, Price: $6.99, Quantity: 30

Enter command: list all
All Products:
--------------------------------------------------------------
ID    Name            Category        Price ($)   Quantity
--------------------------------------------------------------
101   Plate           Kitchenware     $5.99       50
102   Plate           Kitchenware     $6.99       30
103   Bowl            Kitchenware     $3.49       40
104   Fork            Cutlery         $1.99       100
105   Spoon           Cutlery         $2.49       80
106   Knife           Cutlery         $2.99       70
--------------------------------------------------------------

Enter command: exit
Exiting...
```

#### Contributors

- Raxmon Mamadiyorov (raxmon_mamadiyorov@student.itpu.uz | bekzotovich.uz)
