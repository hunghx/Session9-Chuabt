package service;

import model.Catalog;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CatalogService implements IGeneric<Catalog,Long> {
    private List<Catalog> catalogs = new ArrayList<>();

    @Override
    public List<Catalog> findAll() {
        return catalogs;
    }

    @Override
    public Catalog findById(Long id) {
        for (Catalog cat: catalogs) {
            if (Objects.equals(cat.getId(), id)){
                return cat;
            }
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        catalogs.remove(findById(id));
    }

    @Override
    public void add(Catalog catalog) {
        catalogs.add(catalog);
    }

    @Override
    public void update(Catalog catalog) {
        catalogs.set(catalogs.indexOf(findById(catalog.getId())),catalog);
    }

    @Override
    public Long getNewId() {
        Long idMax = 0L;
        for (Catalog c:catalogs
             ) {
            if (c.getId()>idMax){
                idMax= c.getId();
            }
        }
        return idMax+1;
    }
}
