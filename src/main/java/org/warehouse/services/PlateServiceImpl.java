package org.warehouse.services;

import org.warehouse.Constants;
import org.warehouse.dao.KnifeDAO;
import org.warehouse.dto.ProductDto;
import org.warehouse.entity.Cup;
import org.warehouse.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PlateServiceImpl implements PlateService {

    private final KnifeDAO dao;

    public PlateServiceImpl(KnifeDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<ProductDto> list() {
        return dao.findAll().stream().map(Product::todDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Integer id) {
        return dao.findById(id).orElse(new Cup(id)).todDto();
    }

    @Override
    public ProductDto add(ProductDto dto) {
        dao.save(new Cup(dto));
        return dto;
    }

    @Override
    public ProductDto edit(ProductDto dto) {
        Cup cup;
        cup = (Cup) Constants.products.get(dto.getId());
        if (cup != null) {
            cup.setName(dto.getName());
            cup.setPrice(dto.getPrice());
            cup.setQuantity(dto.getQuantity());
            dao.update(cup);
        } else {
            throw new RuntimeException("Cup not found. ID: " + dto.getId());
        }
        return dto;
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

}
