package main.java.itpu.warehouse.dto;

public class ProductDto {
    private Integer id;
    private String name;
    private String category;
    private Float price;
    private Integer quantity;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, String category, Float price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Category: %s, Price: $%.2f, Quantity: %d", id, name, category, price, quantity);
    }
}
