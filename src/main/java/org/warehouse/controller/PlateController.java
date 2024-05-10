package org.warehouse.controller;

import org.warehouse.dto.ProductDto;
import org.warehouse.services.PlateService;


public class PlateController {

    private final PlateService plateService;

    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    public void getAllPlates() {
        plateService.list().forEach(System.out::println);
    }

    public void getPlate(Integer id) {
        ProductDto dto = plateService.getById(id);
        if(dto != null) {
            System.out.println(dto);
        } else {
            System.out.println("Plate not found!!!");
        }
    }

    public void addPlate(ProductDto dto) {
        try {
            dto = plateService.add(dto);
            System.out.println("Plate successfully saved. ID: " + dto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void editPlate(ProductDto dto) {
        try {
            dto = plateService.edit(dto);
            System.out.println("Plate successfully edited. ID: " + dto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
