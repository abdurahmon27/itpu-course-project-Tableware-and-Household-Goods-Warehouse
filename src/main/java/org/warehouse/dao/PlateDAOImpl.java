package org.warehouse.dao;

import org.warehouse.entity.Product;
import org.warehouse.Constants;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlateDAOImpl extends ProductDAOImpl implements PlateDAO {

    @Override
    public Optional<Product> findById(Integer id) {
        return Constants.products.values().stream().filter(product -> product.getId().equals(id) && Constants.PRODUCT_PLATE.equals(product.getCategory()))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return Constants.products.values().stream().filter(product -> Constants.PRODUCT_PLATE.equals(product.getCategory()))
                .findAny().stream().collect(Collectors.toList());
    }
}
