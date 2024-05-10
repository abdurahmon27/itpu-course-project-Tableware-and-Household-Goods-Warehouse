package main.java.itpu.warehouse.controller;

import main.java.itpu.warehouse.dto.ProductDto;
import main.java.itpu.warehouse.services.KnifeService;


public class KnifeController {

    private final KnifeService knifeService;

    public KnifeController(KnifeService knifeService) {
        this.knifeService = knifeService;
    }

    public void getAllKnifes() {
        knifeService.list().forEach(System.out::println);
    }

    public void getKnife(Integer id) {
        ProductDto dto = knifeService.getById(id);
        if(dto != null) {
            System.out.println(dto.toString());
        } else {
            System.out.println("Knife not found!!!");
        }
    }

    public void addKnife(ProductDto dto) {
        try {
            dto = knifeService.add(dto);
            System.out.println("Knife successfully saved. ID: " + dto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void editKnife(ProductDto dto) {
        try {
            dto = knifeService.edit(dto);
            System.out.println("Knife successfully edited. ID: " + dto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
