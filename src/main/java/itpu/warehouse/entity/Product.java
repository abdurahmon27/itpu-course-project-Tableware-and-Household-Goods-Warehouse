package main.java.itpu.warehouse.entity;

public class Product {
    private final int id;
    private final String name;
    private final String category;
    private final double price;
    private final int quantity;

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
