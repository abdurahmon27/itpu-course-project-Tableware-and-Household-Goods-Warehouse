package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    Optional<Product> findById(Integer id);
    List<Product> findAll();
    List<Product> findByCategory(String category);
    List<Product> findByName(String name);
    void save(Product product);
    void update(Product product);
    void delete(Integer id);
}
