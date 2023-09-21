package service;

import model.Catalog;
import util.MyListCatalog;

import java.util.Objects;

public class CatalogService implements IGeneric<Catalog,Long> {
    private MyListCatalog catalogMyList = new MyListCatalog();
    @Override
    public Catalog[] findAll() {
        return catalogMyList.findAll();
    }

    @Override
    public Catalog findById(Long id) {
      return catalogMyList.get(findIndexById(id));
    }

    @Override
    public void delete(Long id) {
        catalogMyList.delete(findIndexById(id));
    }

    @Override
    public void add(Catalog catalog) {
        catalogMyList.add(catalog);
    }

    @Override
    public void update(Catalog catalog) {
        catalogMyList.update(catalog,findIndexById(catalog.getId()));
    }

    @Override
    public int findIndexById(Long id) {
        for (int i = 0; i < findAll().length; i++) {
            Catalog cat = findAll()[i];
            if (cat!=null && Objects.equals(cat.getId(), id)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Long getNewId() {
        Long idMax = 0L;
        for (Catalog cat:findAll()) {
            if (cat!=null&& cat.getId()>idMax){
                idMax = cat.getId();
            }
        }
        return idMax+1;
    }
    public int size(){
        return catalogMyList.getSize();
    }
}
