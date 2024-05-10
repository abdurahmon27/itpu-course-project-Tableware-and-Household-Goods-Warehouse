package main.java.itpu.warehouse.services;

import main.java.itpu.warehouse.Constants;
import main.java.itpu.warehouse.dao.KnifeDAO;
import main.java.itpu.warehouse.dto.ProductDto;
import main.java.itpu.warehouse.entity.Cup;
import main.java.itpu.warehouse.entity.Knife;
import main.java.itpu.warehouse.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class KnifeServiceImpl implements KnifeService {

    private final KnifeDAO dao;

    public KnifeServiceImpl(KnifeDAO dao) {
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
        Knife knife = (Knife) Constants.products.get(dto.getId());
        if(knife != null) {
            knife.setName(dto.getName());
            knife.setPrice(dto.getPrice());
            knife.setQuantity(dto.getQuantity());
            dao.update(knife);
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
