package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static main.java.itpu.warehouse.Constants.*;

public class PlateDAOImpl extends ProductDAOImpl implements PlateDAO {
    public PlateDAOImpl() {
        
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return products.values().stream().filter(product -> product.getId().equals(id) && PRODUCT_PLATE.equals(product.getCategory()))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream().filter(product -> PRODUCT_PLATE.equals(product.getCategory()))
                .findAny().stream().collect(Collectors.toList());
    }
}
