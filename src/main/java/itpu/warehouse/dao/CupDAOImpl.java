package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static main.java.itpu.warehouse.Constants.PRODUCT_CUP;
import static main.java.itpu.warehouse.Constants.products;

public class CupDAOImpl extends ProductDAOImpl implements CupDAO {

    @Override
    public Optional<Product> findById(Integer id) {
        return products.values().stream().filter(product -> product.getId().equals(id) && PRODUCT_CUP.equals(product.getCategory()))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream().filter(product -> PRODUCT_CUP.equals(product.getCategory()))
                .findAny().stream().collect(Collectors.toList());
    }
}
