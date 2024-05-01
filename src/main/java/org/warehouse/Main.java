package main.java.org.warehouse;

import main.java.org.warehouse.dao.ProductDAO;
import main.java.org.warehouse.dao.ProductDAOImpl;
import main.java.org.warehouse.entity.Product;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductDAO productDAO = new ProductDAOImpl();

    public static void main(String[] args) {
        System.out.println("Tableware and Household Goods Warehouse Management System");
        System.out.println("Version: 1.0.0");
        System.out.println("Creator: Raxmon Mamadiyorov | bekzotovich.uz");
        System.out.println("Email: bekzotovich12@gmail.com");

        System.out.println("\nAvailable Commands:");
        System.out.println("* help");
        System.out.println("* search <product name>");
        System.out.println("* list all");
        System.out.println("* exit");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            switch (parts[0]) {
                case "search":
                    if (parts.length == 2) {
                        String productName = parts[1];
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
                    break;
                case "list":
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
                    break;
                case "clear":
                    clearConsole();
                    break;
                case "help":
                    displayHelp();
                    break;
                case "exit":
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }

    public static void displayHelp() {
        System.out.println("\nAvailable Commands:");
        System.out.println("* search <product name>: Search for a product by name.");
        System.out.println("* list all: List all products in the inventory.");
        System.out.println("* clear: Clear the console screen.");
        System.out.println("* help: Display available commands.");
        System.out.println("* exit: Exit the application.");
    }

    public static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
