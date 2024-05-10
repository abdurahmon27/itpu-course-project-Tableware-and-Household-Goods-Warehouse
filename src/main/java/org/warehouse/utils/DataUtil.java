package org.warehouse.utils;

import org.warehouse.Constants;
import org.warehouse.entity.Cup;
import org.warehouse.entity.Knife;
import org.warehouse.entity.Plate;
import org.warehouse.entity.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataUtil {

    private static final String DELIMITER = ",";

    public static void loadDataFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.filePath))) {
            reader.readLine(); // Skip the header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                Integer id = Integer.valueOf(row[0]);
                String name = row[1];
                Float price = Float.valueOf(row[3]);
                Integer quantity = Integer.valueOf(row[4]);
                Product product = new Product();
                switch (row[2]) {
                    case "Cup": product = new Cup(id); break;
                    case "Knife": product = new Knife(id, name, price, quantity); break;
                    case "Plate": product = new Plate(id, name, price, quantity); break;
                }
                Constants.products.put(product.getId(), product);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + Constants.filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + Constants.filePath, e);
        }
    }
}
