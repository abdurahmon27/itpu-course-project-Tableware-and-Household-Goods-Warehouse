package main.java.itpu.warehouse;

import main.java.itpu.warehouse.entity.Product;

import java.util.HashMap;

public interface Constants {
    public static String PRODUCT_CUP = "Cup";
    public static String PRODUCT_KNIFE = "Knife";
    public static String PRODUCT_PLATE = "Plate";

//    in this case everybody can put their own csv file.)
    public static String filePath = "src/main/resources/Products.csv";

    public static HashMap<Integer, Product> products = new HashMap<>();
}


