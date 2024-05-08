// PlateDAOImpl.java
package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Plate;
import main.java.itpu.warehouse.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlateDAOImpl implements ProductDAO {
    private Map<Integer, Product> plateMap;

    public PlateDAOImpl() {
        this.plateMap = new HashMap<>();
        // Example plates
        save(new Plate(1, "Dinner Plate", "Plate", 10.99, 60));
        save(new Plate(2, "Salad Plate", "Plate", 8.99, 50));
        save(new Plate(3, "Soup Bowl", "Plate", 7.99, 40));
    }

    @Override
    public Product findById(int id) {
        return plateMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(plateMap.values());
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product plate : plateMap.values()) {
            if (plate.getCategory().equalsIgnoreCase(category)) {
                result.add(plate);
            }
        }
        return result;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product plate : plateMap.values()) {
            if (plate.getName().equalsIgnoreCase(name)) {
                result.add(plate);
            }
        }
        return result;
    }

    @Override
    public void save(Product product) {
        plateMap.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        plateMap.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        plateMap.remove(product.getId());
    }
}
