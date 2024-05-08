package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Product;
import java.util.List;

public interface ProductDAO {
    Product findById(int id);
    List<Product> findAll();
    List<Product> findByCategory(String category);
    List<Product> findByName(String name);
    void save(Product product);
    void update(Product product);
    void delete(Product product);
}
