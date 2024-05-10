package main.java.itpu.warehouse.services;

import main.java.itpu.warehouse.dto.ProductDto;

import java.util.List;

public interface PlateService extends BaseService {

    @Override
    default List<ProductDto> list() {
        return null;
    }

    @Override
    default ProductDto getById(Integer id) {
        return null;
    }

    @Override
    default ProductDto add(ProductDto dto) {
        return null;
    }

    @Override
    default ProductDto edit(ProductDto dto) {
        return null;
    }

    @Override
    default void delete(Integer id) {

    }
}
