package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static main.java.itpu.warehouse.Constants.PRODUCT_KNIFE;
import static main.java.itpu.warehouse.Constants.products;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public Optional<Product> findById(Integer id) {
        return products.values().stream().filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> findByCategory(String category) {
        return products.values().stream().filter(product -> PRODUCT_KNIFE.equals(product.getCategory()))
                .findAny().stream().collect(Collectors.toList());
    }

    @Override
    public List<Product> findByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return products.values().stream().filter(product -> name.equals(product.getName()))
                .findAny().stream().collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void delete(Integer id) {
        products.remove(id);
    }
}
