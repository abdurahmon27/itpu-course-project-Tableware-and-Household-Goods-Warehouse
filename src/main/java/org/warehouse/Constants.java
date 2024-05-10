package org.warehouse;

import org.warehouse.entity.Product;

import java.util.HashMap;

public interface Constants {
    String PRODUCT_CUP = "Cup";
    String PRODUCT_KNIFE = "Knife";
    String PRODUCT_PLATE = "Plate";

//    in this case everybody can put their own csv file.
String filePath = "src/main/resources/Products.csv";

    HashMap<Integer, Product> products = new HashMap<>();
}


