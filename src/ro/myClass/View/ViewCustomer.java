package ro.myClass.View;

import ro.myClass.controller.ControllerOrder;
import ro.myClass.controller.ControllerOrderDetail;
import ro.myClass.controller.ControllerProduct;
import ro.myClass.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewCustomer {
    private ControllerOrder controllerOrder;
    private ControllerProduct controllerProduct;
    private ControllerOrderDetail controllerOrderDetail;

    private Customer customer;

    private Order order;

    Scanner scanner;

    public ViewCustomer(User user) {
        controllerOrder = new ControllerOrder();
        controllerOrderDetail = new ControllerOrderDetail();
        controllerProduct = new ControllerProduct();
        customer = (Customer) user;
        scanner = new Scanner(System.in);
        order = new Order(controllerOrder.generateOrderID(),customer.getId(),0,"10 october");
        this.play();
    }

    public void show() {
        System.out.println("Press 1 to show information about products");
        System.out.println("Press 2 to add to cart");
        System.out.println("Press 3 to show your order");
        System.out.println("Press 4 to view products you bought");
        System.out.println("Press 5 to empty cart");
        System.out.println("Press 6 to update quantity of product");
        System.out.println("Press 7 to show your order history");

    }

    public void play() {
        boolean running = true;
        while (running) {
            show();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println(controllerProduct.showProduct());
                    break;
                case 2:
                    addCart();
                    break;
                case 3:
                    System.out.println(order.showOrders());
                    break;
                case 4: buyingproducts();
                    break;
                case 5: emptyProduct();
                break;
                case 6: updateQuantityProduct();
                break;
                case 7: orderHistory();
                break;
                default:

            }
        }
    }

    public void addCart() {

        System.out.println("Input product name");
        String nameProduct = scanner.nextLine();
        Product product =controllerProduct.findProduct(nameProduct);

        if( product != null) {

            System.out.println("How many product do you want?");

            int quantity = Integer.parseInt(scanner.nextLine());

            if (quantity < product.getStock()) {

                product.setStock(product.getStock() - quantity);

                order.setAmmount(order.getAmmount()+product.getPrice()*quantity);

                OrderDetail orderDetail = new OrderDetail(controllerOrderDetail.generateOrderDetailID(), order.getId(), product.getId(), quantity);

                this.controllerOrderDetail.addOrderDetail(orderDetail);

            }else {
                System.out.println("Not stock available");
                System.out.println("Try to buy another products");
            }

        }

    }
    public void buyingproducts(){

     ArrayList<OrderDetail> order = controllerOrderDetail.returnOrderDetails(this.order.getId());
     String text = "";
     int price = 0;
     for(int i = 0 ; i < order.size() ;i++) {

          Product product= controllerProduct.returnProductbyID(order.get(i).getProductId());

          if(order.get(i).getOrderId() == this.order.getId()) {
              price += order.get(i).getQuantity() * product.getPrice();
              text += "Add it in your cart:";
              text += "\n You added " + order.get(i).getQuantity() + " x " + product.getName() + " in cart\n";

          }

     }
        text += "Total price: " + price;
        System.out.println(text);

    }
    public void emptyProduct(){
        System.out.println("Input a product name you want do delete");
        String text = scanner.nextLine();
        Product product = controllerProduct.returnProductbyName(text);
        OrderDetail orders = controllerOrderDetail.returnOrderbyProductID(this.order.getId(),product.getId());

        if(orders!=null ){

              this.controllerOrderDetail.removeOrderDetail(orders.getOrderId(),product.getId());
              order.setAmmount(order.getAmmount() - orders.getQuantity() * product.getPrice());
        }else{
            System.out.println("Order doesnt exist");
        }

        }
        public void updateQuantityProduct(){
            System.out.println("Input a product name you want to update");
            String text = scanner.nextLine();
            Product product = controllerProduct.returnProductbyName(text);
            System.out.println("Input quantity");
            int quantity = Integer.parseInt(scanner.nextLine());
            OrderDetail orders = controllerOrderDetail.returnOrderbyProductID(this.order.getId(),product.getId());
            if(orders!=null){
                 orders.setQuantity(quantity);
                 if (orders.getQuantity() > quantity)
                 {
                     float ammount = orders.getQuantity() - quantity * product.getPrice();
                     order.setAmmount(order.getAmmount() - ammount);
                 }else{
                     float ammount = quantity - orders.getQuantity() * product.getPrice();
                     order.setAmmount(order.getAmmount() + ammount);
                 }
            }else{
                System.out.println("Product doesn't exist");
            }

        }
        public void orderHistory() {
            ArrayList<OrderDetail> orderDetails = controllerOrderDetail.returnAllOrderDetailsByOrderId(this.order.getCustomerID());
            String text = "";
            for (OrderDetail m : orderDetails) {
                text += controllerOrderDetail.returnDetailsbyOrderID(m.getId());
            }
            System.out.println(text);

        }
}