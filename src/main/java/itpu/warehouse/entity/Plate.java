package main.java.itpu.warehouse.entity;

import main.java.itpu.warehouse.Constants;

public class Plate extends Product {
    public Plate(Integer id, String name, Float price, Integer quantity) {
        super(id, name, Constants.PRODUCT_PLATE, price, quantity);
    }
}