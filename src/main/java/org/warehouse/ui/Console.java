// Console.java
package org.warehouse.ui;

import org.warehouse.dao.ProductDAO;
import org.warehouse.entity.Product;

import java.util.List;

public class Console {
    public void printWelcomeMessage() {
        System.out.println("Tableware and Household Goods Warehouse Management System");
        System.out.println("Version: 1.0.0");
        System.out.println("Creator: Raxmon Mamadiyorov | raxmon_mamadiyorov@student.itpu.uz| bekzotovich.uz");
        System.out.println("Email: bekzotovich12@gmail.com | raxmon_mamadiyorov@student.itpu.uz");

        System.out.println("\nAvailable Commands:");
        System.out.println("* help");
        System.out.println("* search <product name>");
        System.out.println("* list all");
        System.out.println("* exit");
    }

    public void handleSearchCommand(String[] parts, ProductDAO productDAO) {
        if (parts.length >= 2) {
            StringBuilder pName = new StringBuilder();
            for (int i=1; i<parts.length; i++) {
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
            System.out.println("Invalid command format. Usage: search <product name>");
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
        System.out.println("* search <product name>: Search for a product by name.");
        System.out.println("* list all: List all products in the inventory.");
        System.out.println("* clear: Clear the console screen.");
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