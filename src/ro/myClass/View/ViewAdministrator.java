package ro.myClass.View;

import ro.myClass.controller.ControllerOrder;
import ro.myClass.controller.ControllerOrderDetail;
import ro.myClass.controller.ControllerProduct;
import ro.myClass.controller.ControllerUser;
import ro.myClass.models.Administrator;
import ro.myClass.models.Product;
import ro.myClass.models.User;

import java.util.Scanner;

public class ViewAdministrator {
    private ControllerProduct controllerProduct;
    private ControllerOrderDetail controllerOrderDetail;
    private ControllerOrder controllerOrder;

    private ControllerUser controllerUser;
    private Administrator admin;

    Scanner scanner;

    public ViewAdministrator(User user){
        this.controllerOrder = new ControllerOrder();
        this.controllerProduct = new ControllerProduct();
        this.controllerOrderDetail = new ControllerOrderDetail();
        this.admin = (Administrator) user;
        scanner = new Scanner(System.in);
    }
    public void show(){
        System.out.println("Press 1 to view all products");
        System.out.println("Press 2 to add product");
        System.out.println("Press 3 to edit product");
        System.out.println("Press 4 to view all orders");
        System.out.println("Press 5 to show user with most orders");
        System.out.println("Press 6 to delete a product");
        System.out.println("Press 7 to show best-selling product");

    }

    public void play(){
        boolean running = true;
        while (running){
            show();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 : System.out.println(controllerProduct.showProduct());
                break;
                case 2 : addProduct();
                break;
                case 3 : editProduct();
                break;
                case 4 : System.out.println(controllerOrder.showOrders());
                break;
                case 5: mostActiveUser();
                    break;
                case 6: deleteProduct();
                break;
                case 7: bestSellingProduct();
                break;
                default :
            }
        }
    }
    public void addProduct(){
        int id = controllerProduct.generateProductID();
        System.out.println("Input name of product");
        String productName = scanner.nextLine();
        System.out.println("Input price: ");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("Input image-link with product");
        String image = scanner.nextLine();
        System.out.println("Input stock of product");
        int stock = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id,productName,price,image,stock);
        controllerProduct.add(product);
    }
    public void editProduct(){
        System.out.println("Input product name");
        String productName = scanner.nextLine();
        System.out.println("Input what do you want to edit : price/image/stock ? ");
        String choice = scanner.nextLine();
        switch (choice){
            case "price":
                System.out.println("Input  price");
                float price = Float.parseFloat(scanner.nextLine());
                controllerProduct.updatePrice(productName,price);
            break;
            case "image":
                System.out.println("Input image");
                String image = scanner.nextLine();
                controllerProduct.updateImage(productName,image);
                break;
            case "stock":
                System.out.println("Input stock");
                int stock = Integer.parseInt(scanner.nextLine());
                controllerProduct.updateStock(productName,stock);
        }
    }
    public void mostActiveUser(){
        int activeUser = controllerOrder.mostActiveUser();
        String text = controllerOrder.returnOrderByCustomerID(activeUser);
        System.out.println("Most active user is: " + activeUser);
        System.out.println(text);
    }
    public void deleteProduct(){
        System.out.println("Input name of product");
        String nameProduct = scanner.nextLine();
        controllerProduct.remove(nameProduct);
    }
    public void bestSellingProduct(){
        int productID = controllerOrderDetail.bestSellerProduct();
        Product product = controllerProduct.returnProductbyID(productID);
        System.out.println("Best-seller product is: " + product.getName()+ "\n");
        System.out.println(product.showProduct());
    }
}
