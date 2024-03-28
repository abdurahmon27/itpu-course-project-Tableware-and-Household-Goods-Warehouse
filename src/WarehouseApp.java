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
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

class WarehouseManager {
    private List<Product> inventory;

    public WarehouseManager() {
        this.inventory = new ArrayList<>();
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
        System.out.println("1. search <product name>");
        System.out.println("2. list all");
        System.out.println("3. exit");

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
                            System.out.println("No products found with the name: " + productName);
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
                        manager.displayAllProducts();
                    } else {
                        System.out.println("Invalid command format. Usage: list all");
                    }
                    break;
                case "exit":
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }
}
