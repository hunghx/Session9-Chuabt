package run;

import model.Catalog;
import model.Product;
import service.CatalogService;
import service.ProductService;
import util.InputMethods;

public class Shop {
    private static CatalogService catalogService = new CatalogService();
    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=================MENU===================");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    catalogManager();
                    break;
                case 2:
                    productManager();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập không hợp lệ");
            }
        }
    }

    public static void catalogManager() {
        while (true) {
            System.out.println("=================Catalog===================");
            System.out.println("1. Danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhât");
            System.out.println("4. Xóa");
            System.out.println("5. Quay lại");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    displayAllCatalog();
                    break;
                case 2:
                    addNewCatalog();
                    break;
                case 3:
                    editCatalog();
                    break;
                case 4:
                    delete();
                    break;
                case 5:

                    break;
                default:
                    System.err.println("Nhập không hợp lệ");
            }
            if (choice == 5) {
                break;
            }
        }
    }

    // hiển thị danh sachs dnah mục
    public static void displayAllCatalog() {
        for (Catalog cat : catalogService.findAll()) {
            if (cat != null) {
                System.out.println(cat);
            }
        }
    }

    // thêm mới
    public static void addNewCatalog() {
        Catalog catalog = new Catalog();
        catalog.setId(catalogService.getNewId());
        // nhập tên
        catalog.input();
        catalogService.add(catalog);
    }

    // chỉnh sửa
    public static void editCatalog() {
        // nhập vào id
        Long id = InputMethods.getLong();
        int index = catalogService.findIndexById(id);
        if (index == -1) {
            System.err.println("id không tồn tại");
            return;
        }
        // cho phép sửa
        Catalog catalog = catalogService.findById(id);
        catalog.input();
        catalogService.update(catalog);
    }

    // xóa
    public static void delete() {
        Long id = InputMethods.getLong();
        int index = catalogService.findIndexById(id);
        if (index == -1) {
            System.err.println("id không tồn tại");
            return;
        }
        if(productService.existByCatalogId(id)){
            System.err.println("danh mục này có sản phẩm nên ko thể xóa");
            return;
        }
        // cho phép xóa
        catalogService.delete(id);
    }


    public static void productManager() {
        while (true) {
            System.out.println("=================Product===================");
            System.out.println("1. Danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhât");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Quay lại");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    displayAllProduct();
                    break;
                case 2:
                   addNewProduct();
                    break;
                case 3:
                   editProduct();
                    break;
                case 4:
                  delete();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:

                    break;
                default:
                    System.err.println("Nhập không hợp lệ");
            }
            if (choice == 6) {
                break;
            }
        }
    }
    public static void displayAllProduct() {
        for (Product pro : productService.findAll()) {
            if (pro != null) {
                System.out.println(pro);
            }
        }
    }

    // thêm mới
    public static void addNewProduct() {
        // kieemr tra danh sach ddanh muc cos null khong
        if (catalogService.size()==0){
            System.err.println("danh muc trong");
            return;
        }
        Product pro = new Product();
        pro.setId(productService.getNewId());
        displayAllCatalog();
        // nhaapj id danh mucj
        while (true){
            System.out.println("Nhập id danh mục muốn thêm cho sp");
            Long idCat =InputMethods.getLong();
            if(catalogService.findIndexById(idCat)!=-1){
                pro.setCatalog(catalogService.findById(idCat));
                break;
            }
            System.err.println("id không tồn tại, nhập lại");
        }
        // chonj danh muc
        // nhập tên
        pro.input();
        productService.add(pro);
    }

    // chỉnh sửa
    public static void editProduct() {
        // nhập vào id
        Long id = InputMethods.getLong();
        int index = productService.findIndexById(id);
        if (index == -1) {
            System.err.println("id không tồn tại");
            return;
        }
        // cho phép sửa
        Product pro = productService.findById(id);
        displayAllCatalog();
        // nhaapj id danh mucj
        while (true){
            System.out.println("Nhập id danh mục muốn thêm cho sp");
            Long idCat =InputMethods.getLong();
            if(catalogService.findIndexById(idCat)!=-1){
                pro.setCatalog(catalogService.findById(idCat));
                break;
            }
            System.err.println("id không tồn tại, nhập lại");
        }
        pro.input();
        productService.update(pro);
    }

    // xóa
    public static void deleteProduct() {
        Long id = InputMethods.getLong();
        int index = productService.findIndexById(id);
        if (index == -1) {
            System.err.println("id không tồn tại");
            return;
        }
        // cho phép xóa
        productService.delete(id);
    }
    public static void searchByName() {
        System.out.println("Nhập chuỗi");
        String name =InputMethods.getString();
        for (Product pro : productService.searchByName(name)) {
            if(pro!=null){
                System.out.println(pro);
            }
        }
    }
}
