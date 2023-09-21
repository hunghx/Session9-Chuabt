package model;

import util.InputMethods;

public class Product {
    private Long id;
    private String name;
    private double price;
    private String description;
    private  Catalog catalog;

    public Product() {
    }

    public Product(Long id, String name, double price, String description, Catalog catalog) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "ID: "+id + " | Name : "+name+" | Price : "+ price + "| CatalogName: "+catalog.getName();
    }
    public void input(){
        System.out.println("Nhập tên sản phẩm");
        this.name = InputMethods.getString();
        System.out.println("Nhập tiền");
        this.price = InputMethods.getDouble();
        System.out.println("Nhâp mô tả");
        this.description=InputMethods.getString();
    }
}
