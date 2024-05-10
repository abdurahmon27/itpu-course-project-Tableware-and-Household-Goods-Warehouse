package org.warehouse.entity;
import org.warehouse.Constants;

public class Knife extends Product {
    public Knife(Integer id, String name, Float price, Integer quantity) {
        super(id, name, Constants.PRODUCT_KNIFE, price, quantity);
    }
}