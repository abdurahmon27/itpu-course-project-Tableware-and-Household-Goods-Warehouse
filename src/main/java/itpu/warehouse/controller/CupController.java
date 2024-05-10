package main.java.itpu.warehouse.controller;

import main.java.itpu.warehouse.dto.ProductDto;
import main.java.itpu.warehouse.services.CupService;

public class CupController {

    private final CupService cupService;

    public CupController(CupService cupService) {
        this.cupService = cupService;
    }

    public void getAllCups() {
        cupService.list().forEach(System.out::println);
    }

    public void getCup(Integer id) {
        ProductDto dto = cupService.getById(id);
        if(dto != null) {
            System.out.println(dto.toString());
        } else {
            System.out.println("Cup not found!!!");
        }
    }

    public void addCup(ProductDto dto) {
        try {
            dto = cupService.add(dto);
            System.out.println("Cup successfully saved. ID: " + dto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void editCup(ProductDto dto) {
        try {
            dto = cupService.edit(dto);
            System.out.println("Cup successfully edited. ID: " + dto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
