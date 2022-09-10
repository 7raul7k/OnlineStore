package ro.myClass.controller;

import ro.myClass.models.Order;
import ro.myClass.models.OrderDetail;
import ro.myClass.models.Product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOrderDetail {
    ArrayList<OrderDetail> orderDetails;

    public ControllerOrderDetail() {
        this.orderDetails = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\orderdetails.txt");
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                this.orderDetails.add(new OrderDetail(scanner.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String showOrderDetails() {
        String text = "";
        for (OrderDetail m : orderDetails) {
            text += m;
        }
        return text;
    }

    public int findbyProductID(int orderId,int productID) {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i).getOrderId() == orderId && orderDetails.get(i).getProductId() == productID) {
                return i;
            }
        }
        return -1;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        int pos = findbyProductID(orderDetail.getProductId(),orderDetail.getProductId());
        if (pos == -1) {
            this.orderDetails.add(orderDetail);
        }
    }

    public void removeOrderDetail(int orderId,int productID) {
        int pos = findbyProductID(orderId,productID);
        if (pos != -1) {
            this.orderDetails.remove(pos);
        }
    }

    public String toString() {
        String text = "";
        for (int i = 0; i < orderDetails.size() - 1; i++) {
            text += orderDetails.get(i).toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\orderdetails.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int size() {
        return orderDetails.size();
    }

    public int generateOrderDetailID() {
        if (orderDetails.size() > 0) {
            return this.orderDetails.get(orderDetails.size() - 1).getOrderId() + 1;
        }
        return 1;
    }

    public String showOrder(int orderId) {
        String text = "";
        for (OrderDetail m : orderDetails) {
            if (m.getOrderId() == orderId) {
                text += m;
            }
        }
        return text;
    }

    public ArrayList<OrderDetail> returnOrderDetails(int orderId) {
        ArrayList<OrderDetail> orders = new ArrayList<>();
        for (OrderDetail m : orderDetails) {
            if (m.getOrderId() == orderId) {
                orders.add(m);
            }
        }
        return orders;
    }

    public  OrderDetail returnOrderbyProductID(int orderID, int productID) {

        for (OrderDetail m : orderDetails) {
            if (m.getOrderId() == orderID && m.getProductId() == productID) {
               return  m;
            }
        }
         return null;
    }
    public ArrayList<OrderDetail> returnAllOrderDetailsByOrderId(int orderId){
        ArrayList<OrderDetail> orderDetail = new ArrayList<>();
        for(OrderDetail m : orderDetails){
            if(m.getOrderId() == orderId){
                orderDetail.add(m);
            }
        }
        return orderDetail;
    }
   public String returnDetailsbyOrderID(int id){
        ControllerProduct controllerProduct = new ControllerProduct();
        String text = "";
        float totalPrice = 0;
        for (OrderDetail m : orderDetails){
            if(m.getId() == id){
                Product product = controllerProduct.returnProductbyID(m.getProductId());
                text += "ID: " + m.getId();
                text += "\nName of product: " + product.getName();
                text += "\nPrice: " + product.getPrice();
                text += "\nQuantity: " + m.getQuantity();
                text += "\nTotal: " + totalPrice;
                text += "\n=====================================\n";
            }
        }
       return text;
   }
   public int[] mostSoldProduct(){
        int[] product = new int[1000];
        for(OrderDetail m : orderDetails){
            product[m.getProductId()]++;
        }
        return product;
   }
   public int bestSellerProduct(){
        int[] products = mostSoldProduct();
        int productID = 0;int max = 0;
        for(int i = 0 ; i < products.length;i++){
            if(products[i]>max){
                productID = i;
                max = products[i];
            }
        }
        return productID;
   }

}