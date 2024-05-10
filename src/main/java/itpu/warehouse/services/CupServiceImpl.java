package main.java.itpu.warehouse.services;

import main.java.itpu.warehouse.Constants;
import main.java.itpu.warehouse.dao.CupDAO;
import main.java.itpu.warehouse.dto.ProductDto;
import main.java.itpu.warehouse.entity.Cup;
import main.java.itpu.warehouse.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class CupServiceImpl implements CupService {

    private final CupDAO dao;

    public CupServiceImpl(CupDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<ProductDto> list() {
        return dao.findAll().stream().map(Product::todDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Integer id) {
        return dao.findById(id).orElse(new Cup()).todDto();
    }

    @Override
    public ProductDto add(ProductDto dto) {
        dao.save(new Cup(dto));
        return dto;
    }

    @Override
    public ProductDto edit(ProductDto dto) {
        Cup cup = (Cup) Constants.products.get(dto.getId());
        if(cup != null) {
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
