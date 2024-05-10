package org.warehouse.entity;

import org.warehouse.dto.ProductDto;

public class Product {
    private Integer id;
    private String name;
    private String category;
    private Float price;
    private Integer quantity;

    public Product(Integer id, String name, String category, Float price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setCategory(String category) {
//        this.category = category;
//    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Category: %s, Price: $%.2f, Quantity: %d", id, name, category, price, quantity);
    }

    public ProductDto todDto() {
        return new ProductDto(getId(), getName(), getCategory(), getPrice(), getQuantity());
    }
}
