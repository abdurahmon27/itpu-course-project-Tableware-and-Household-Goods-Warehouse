package org.warehouse.entity;

import org.warehouse.Constants;
import org.warehouse.dto.ProductDto;

public class Cup extends Product {

    public Cup() {

    }

    public Cup(Integer id, String name, Float price, Integer quantity) {
        super(id, name, Constants.PRODUCT_CUP, price, quantity);
    }

    public Cup(ProductDto dto) {
        super(dto.getId(), dto.getName(), Constants.PRODUCT_CUP, dto.getPrice(), dto.getQuantity());
    }

    public Cup(Integer id) {
    }
}