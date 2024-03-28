import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Category: %s, Price: $%.2f, Quantity: %d", id, name, category, price, quantity);
    }
}

class WarehouseManager {
    private List<Product> inventory;

    public WarehouseManager() {
        this.inventory = new ArrayList<>();

        inventory.add(new Product(1, "Plate", "Tableware", 5.99, 100));
        inventory.add(new Product(2, "Cup", "Tableware", 3.49, 150));
        inventory.add(new Product(3, "Fork", "Cutlery", 1.99, 200));
        inventory.add(new Product(4, "Knife", "Cutlery", 2.49, 180));
    }

    public void readInventoryFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String category = data[2];
                double price = Double.parseDouble(data[3]);
                int quantity = Integer.parseInt(data[4]);
                inventory.add(new Product(id, name, category, price, quantity));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    public List<Product> searchByName(String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                results.add(product);
            }
        }
        return results;
    }

    public void displayAllProducts() {
        for (Product product : inventory) {
            System.out.println(product);
        }
    }
}

public class WarehouseApp {
    public static void main(String[] args) {
        WarehouseManager manager = new WarehouseManager();
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
                        List<Product> searchResults = manager.searchByName(productName);
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
                        manager.displayAllProducts();
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
