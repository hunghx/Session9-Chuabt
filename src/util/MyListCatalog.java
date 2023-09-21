package util;

import model.Catalog;

public class MyListCatalog {
    private Catalog[] array ;
    private int size=0;

    public MyListCatalog() {
        array =  new Catalog[100];
    }

    public int getSize() {
        return size;
    }

    public Catalog[] findAll(){
        return array;
    }
    public void add(Catalog t){
        if (size==array.length){
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==null){
                array[i]=t;
                size++;
                break;
            }
        }
    }
    public void update(Catalog t,int index){
        for (int i = 0; i < array.length; i++) {
            if(i == index){
                array[i] = t;
                break;
            }
        }
    }
    public void delete(int index){
        for (int i = 0; i < array.length; i++) {
            if(i == index){
                array[i] = null;
                size--;
                break;
            }
        }
    }
    public Catalog get(int index){
        for (int i = 0; i < array.length; i++) {
            if(i == index){
               return array[i];
            }
        }
        return null;
    }
}
