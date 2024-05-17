// Console.java
package org.warehouse.ui;

import org.warehouse.dao.ProductDAO;
import org.warehouse.entity.Product;


import java.util.Optional;
import java.util.List;

public class Console {
    public void printWelcomeMessage() {
        System.out.println("Tableware and Household Goods Warehouse Management System");
        System.out.println("Version: 1.0.0");
        System.out.println("Creator: Raxmon Mamadiyorov | raxmon_mamadiyorov@student.itpu.uz| bekzotovich.uz");
        System.out.println("Email: bekzotovich12@gmail.com | raxmon_mamadiyorov@student.itpu.uz");

        System.out.println("\nAvailable Commands:");
        System.out.println("* help");
        System.out.println("* search <id> <name>");
        System.out.println("* list all");
        System.out.println("* add");
        System.out.println("* exit");
    }

    public void handleAddCommand(String[] parts, ProductDAO productDAO) {
        if (parts.length == 6) {
            try {
                Integer id = Integer.valueOf(parts[1]);
                String name = parts[2];
                String category = parts[3];
                Float price = Float.parseFloat(parts[4]);
                Integer quantity = Integer.parseInt(parts[5]);

                Product newProduct = new Product(id, name, category, price, quantity);
                productDAO.save(newProduct);

                System.out.println("Product added successfully.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid price or quantity format. Please enter valid numbers.");
            }
        } else {
            System.out.println("Invalid command format. Usage: add <id> <name> <category> <price> <quantity>");
        }
    }

    public void handleSearchCommand(String[] parts, ProductDAO productDAO) {
        if (parts.length >= 2) {
            String searchType = parts[1].toLowerCase();
            switch (searchType) {
                case "id":
                    if (parts.length == 3) {
                        try {
                            int id = Integer.parseInt(parts[2]);
                            Optional<Product> result = productDAO.findById(id);
                            if (result.isPresent()) {
                                System.out.println("Search Result:");
                                System.out.println(result.get());
                            } else {
                                System.out.println("No product found with ID: " + id);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID format. Please enter a valid integer ID.");
                        }
                    } else {
                        System.out.println("Invalid command format. Usage: search id <product ID>");
                    }
                    break;
                case "category":
                    if (parts.length >= 3) {
                        String category = parts[2];
                        List<Product> searchResults = productDAO.findByCategory(category);
                        if (searchResults.isEmpty()) {
                            System.out.println("No products found in category: " + category);
                        } else {
                            System.out.println("Search Results in category " + category + ":");
                            for (Product product : searchResults) {
                                System.out.println(product);
                            }
                        }
                    } else {
                        System.out.println("Invalid command format. Usage: search category <category>");
                    }
                    break;
                case "name":
                    if (parts.length >= 3) {
                        StringBuilder pName = new StringBuilder();
                        for (int i = 2; i < parts.length; i++) {
                            pName.append(parts[i]).append(" ");
                        }
                        String productName = pName.toString().trim();
                        List<Product> searchResults = productDAO.findByName(productName);
                        if (searchResults.isEmpty()) {
                            System.out.println("No products found for: " + productName);
                        } else {
                            System.out.println("Search Results:");
                            for (Product product : searchResults) {
                                System.out.println(product);
                            }
                        }
                    } else {
                        System.out.println("Invalid command format. Usage: search name <product name>");
                    }
                    break;
                default:
                    System.out.println("Invalid search type. Available search types: id, category, name.");
                    break;
            }
        } else {
            System.out.println("Invalid command format. Usage: search <search type> <search query>");
        }
    }


    public void handleListCommand(String[] parts, ProductDAO productDAO) {
        if (parts.length == 2 && parts[1].equalsIgnoreCase("all")) {
            System.out.println("All Products:");
            System.out.println("--------------------------------------------------------------");
            System.out.printf("%-5s %-15s %-15s %-10s %-8s\n", "ID", "Name", "Category", "Price ($)", "Quantity");
            System.out.println("--------------------------------------------------------------");
            List<Product> allProducts = productDAO.findAll();
            for (Product product : allProducts) {
                System.out.println(product);
            }
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("Invalid command format. Usage: list all");
        }
    }

    public void displayHelp() {
        System.out.println("\nAvailable Commands:");
        System.out.println("* search id <product ID>: Search for a product by ID.");
        System.out.println("* search category <category>: Search for products by category.");
        System.out.println("* search name <product name>: Search for a product by name.");
        System.out.println("* list all: List all products in the inventory.");
        System.out.println("* clear: Clear the console screen.");
        System.out.println("* add :You can add product while application is working.");
        System.out.println("* help: Display available commands.");
        System.out.println("* exit: Exit the application.");
    }


    public void printExitMessage() {
        System.out.println("Exiting...");
    }

    public void printInvalidCommandMessage() {
        System.out.println("Invalid command.");
    }

    public void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}