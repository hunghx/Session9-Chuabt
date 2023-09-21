package util;

import model.Product;

public class MyListProduct {
    private Product[] array ;
    private int size=0;

    public MyListProduct() {
        array =  new Product[100];
    }

    public int getSize() {
        return size;
    }

    public Product[] findAll(){
        return array;
    }
    public void add(Product t){
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
    public void update(Product t,int index){
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
    public Product get(int index){
        for (int i = 0; i < array.length; i++) {
            if(i == index){
                return array[i];
            }
        }
        return null;
    }
}
