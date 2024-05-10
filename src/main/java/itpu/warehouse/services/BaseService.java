package main.java.itpu.warehouse.services;

import main.java.itpu.warehouse.dto.ProductDto;

import java.util.List;

public interface BaseService {

    List<ProductDto> list();
    ProductDto getById(Integer id);
    ProductDto add(ProductDto dto);
    ProductDto edit(ProductDto dto);
    void delete(Integer id);
}
