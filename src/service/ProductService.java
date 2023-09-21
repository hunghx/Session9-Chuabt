package service;


import model.Catalog;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductService implements IGeneric<Product,Long> {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        for (Product p: products) {
            if (Objects.equals(p.getId(), id)){
                return p;
            }
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        products.remove(findById(id));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        products.set(products.indexOf(findById(product.getId())), product);
    }

    @Override
    public Long getNewId() {
        Long idMax = 0L;
        for (Product c:products
        ) {
            if (c.getId()>idMax){
                idMax= c.getId();
            }
        }
        return idMax+1;
    }
    public boolean existByCatalogId(Long id){
        for (Product p: products) {
            if (Objects.equals(p.getCatalog().getId(), id)){
                return true;
            }
        }
        return false;
    }
    public List<Product> searchByName(String name){
        List<Product> search = new ArrayList<>();
        for (Product p: products) {
            if (p.getName().contains(name)){
                search.add(p);
            }
        }
        return search;
    }
}
