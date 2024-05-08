package main.java.itpu.warehouse.dao;

import main.java.itpu.warehouse.entity.Product;
import main.java.itpu.warehouse.dao.KnifeDAOImpl;
import main.java.itpu.warehouse.dao.CupDAOImpl;
import main.java.itpu.warehouse.dao.PlateDAOImpl;

import java.util.List;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    private KnifeDAOImpl knifeDAO = new KnifeDAOImpl();
    private CupDAOImpl cupDAO = new CupDAOImpl();
    private PlateDAOImpl plateDAO = new PlateDAOImpl();

    @Override
    public Product findById(int id) {
        Product product = knifeDAO.findById(id);
        if (product == null) {
            product = cupDAO.findById(id);
        }
        if (product == null) {
            product = plateDAO.findById(id);
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(knifeDAO.findAll());
        allProducts.addAll(cupDAO.findAll());
        allProducts.addAll(plateDAO.findAll());
        return allProducts;
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        result.addAll(knifeDAO.findByCategory(category));
        result.addAll(cupDAO.findByCategory(category));
        result.addAll(plateDAO.findByCategory(category));
        return result;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        result.addAll(knifeDAO.findByName(name));
        result.addAll(cupDAO.findByName(name));
        result.addAll(plateDAO.findByName(name));
        return result;
    }

    @Override
    public void save(Product product) {
        if (product instanceof main.java.itpu.warehouse.entity.Knife) {
            knifeDAO.save(product);
        } else if (product instanceof main.java.itpu.warehouse.entity.Cup) {
            cupDAO.save(product);
        } else if (product instanceof main.java.itpu.warehouse.entity.Plate) {
            plateDAO.save(product);
        }
    }

    @Override
    public void update(Product product) {
        if (product instanceof main.java.itpu.warehouse.entity.Knife) {
            knifeDAO.update(product);
        } else if (product instanceof main.java.itpu.warehouse.entity.Cup) {
            cupDAO.update(product);
        } else if (product instanceof main.java.itpu.warehouse.entity.Plate) {
            plateDAO.update(product);
        }
    }

    @Override
    public void delete(Product product) {
        if (product instanceof main.java.itpu.warehouse.entity.Knife) {
            knifeDAO.delete(product);
        } else if (product instanceof main.java.itpu.warehouse.entity.Cup) {
            cupDAO.delete(product);
        } else if (product instanceof main.java.itpu.warehouse.entity.Plate) {
            plateDAO.delete(product);
        }
    }
}
