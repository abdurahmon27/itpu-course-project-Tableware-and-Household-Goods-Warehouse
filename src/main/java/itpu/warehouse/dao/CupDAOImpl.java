// CupDAOImpl.java
package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Cup;
import main.java.itpu.warehouse.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CupDAOImpl implements ProductDAO {
    private Map<Integer, Product> cupMap;

    public CupDAOImpl() {
        this.cupMap = new HashMap<>();
        // Example cups
        save(new Cup(1, "Coffee Cup", "Cup", 5.99, 100));
        save(new Cup(2, "Tea Cup", "Cup", 4.99, 80));
        save(new Cup(3, "Mug", "Cup", 7.99, 120));
    }

    @Override
    public Product findById(int id) {
        return cupMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(cupMap.values());
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product cup : cupMap.values()) {
            if (cup.getCategory().equalsIgnoreCase(category)) {
                result.add(cup);
            }
        }
        return result;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product cup : cupMap.values()) {
            if (cup.getName().equalsIgnoreCase(name)) {
                result.add(cup);
            }
        }
        return result;
    }

    @Override
    public void save(Product product) {
        cupMap.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        cupMap.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        cupMap.remove(product.getId());
    }
}
