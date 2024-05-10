package org.warehouse.entity;

import org.warehouse.Constants;

public class Plate extends Product {
    public Plate(Integer id, String name, Float price, Integer quantity) {
        super(id, name, Constants.PRODUCT_PLATE, price, quantity);
    }
}