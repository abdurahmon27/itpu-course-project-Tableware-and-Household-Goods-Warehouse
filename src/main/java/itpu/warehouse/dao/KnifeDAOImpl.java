package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Knife;
import main.java.itpu.warehouse.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnifeDAOImpl implements ProductDAO {
    private Map<Integer, Product> knifeMap;

    public KnifeDAOImpl() {
        this.knifeMap = new HashMap<>();
        // Example knives
        save(new Knife(1, "Chef's Knife", "Knife", 25.99, 50));
        save(new Knife(2, "Utility Knife", "Knife", 12.99, 70));
        save(new Knife(3, "Paring Knife", "Knife", 9.99, 40));
    }

    @Override
    public Product findById(int id) {
        return knifeMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(knifeMap.values());
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product knife : knifeMap.values()) {
            if (knife.getCategory().equalsIgnoreCase(category)) {
                result.add(knife);
            }
        }
        return result;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product knife : knifeMap.values()) {
            if (knife.getName().equalsIgnoreCase(name)) {
                result.add(knife);
            }
        }
        return result;
    }

    @Override
    public void save(Product product) {
        knifeMap.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        knifeMap.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        knifeMap.remove(product.getId());
    }
}