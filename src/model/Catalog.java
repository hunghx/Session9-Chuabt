package model;

import util.InputMethods;

public class Catalog {
    private Long id;
    private String name;

    public Catalog(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Catalog() {
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

    @Override
    public String toString() {
        return "ID: "+id + " | Name : "+name;
    }
    public void input(){
        System.out.println("Nhập tên");
        this.name = InputMethods.getString();
    }
}
