package service;


import model.Product;
import util.MyListCatalog;
import util.MyListProduct;

import java.util.Objects;

public class ProductService implements IGeneric<Product,Long> {
    private MyListProduct productMyList = new MyListProduct();
    @Override
    public Product[] findAll() {
        return productMyList.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productMyList.get(findIndexById(id));
    }

    @Override
    public void delete(Long id) {
        productMyList.delete(findIndexById(id));
    }

    @Override
    public void add(Product product) {
        productMyList.add(product);
    }

    @Override
    public void update(Product product) {
        productMyList.update(product,findIndexById(product.getId()));
    }

    @Override
    public int findIndexById(Long id) {
        for (int i = 0; i < findAll().length; i++) {
            Product pro = findAll()[i];
            if (pro!=null && Objects.equals(pro.getId(), id)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public Long getNewId() {
        Long idMax = 0L;
        for (Product cat:findAll()) {
            if (cat!=null&& cat.getId()>idMax){
                idMax = cat.getId();
            }
        }
        return idMax+1;
    }
    public int size(){
        return productMyList.getSize();
    }
    public Product[] searchByName(String name){
        MyListProduct pros = new MyListProduct();
        for (Product pro:findAll()) {
            if (pro!=null&& pro.getName().contains(name)){
                pros.add(pro);
            }
        }
        return pros.findAll();
    }
    public boolean existByCatalogId(Long catId){
        for (Product p: findAll()) {
            if (p!=null && Objects.equals(p.getCatalog().getId(), catId)){
                return true;
            }
        }
        return false;
    }
}
