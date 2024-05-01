package main.java.org.warehouse.dao;

import main.java.org.warehouse.entity.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO {
    private Map<Integer, Product> productMap;

    public ProductDAOImpl() {
        this.productMap = new HashMap<>();
        // Initialize with some sample products
        // Add appropriate logic to read from database or file if required
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        productMap.remove(product.getId());
    }
}
