package org.warehouse.dao;

import org.warehouse.entity.Product;
import org.warehouse.Constants;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public Optional<Product> findById(Integer id) {
        return Constants.products.values().stream().filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(Constants.products.values());
    }

    @Override
    public List<Product> findByCategory(String category) {
        return Constants.products.values().stream().filter(product -> Constants.PRODUCT_KNIFE.equals(product.getCategory()))
                .findAny().stream().collect(Collectors.toList());
    }

    @Override
    public List<Product> findByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return Constants.products.values().stream().filter(product -> name.equals(product.getName()))
                .findAny().stream().collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        Constants.products.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        Constants.products.put(product.getId(), product);
    }

    @Override
    public void delete(Integer id) {
        Constants.products.remove(id);
    }
}
