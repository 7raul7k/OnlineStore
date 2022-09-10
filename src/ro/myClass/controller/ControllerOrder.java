package ro.myClass.controller;

import org.junit.jupiter.api.Test;
import ro.myClass.models.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOrder {
    ArrayList<Order> orders;
    public ControllerOrder(){
        this.orders = new ArrayList<>();
        load();
    }
    public void load(){
        try{
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\orders.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                this.orders.add(new Order(scanner.nextLine()));
            }

        }catch (Exception e){
             e.printStackTrace();
        }
    }
    public String showOrders(){
       String text  = "";
       for(int i = 0 ; i < orders.size();i++){
           text+= orders.get(i);
       }
       return text;
    }
    public int findOrderByID(int id,int orderID){
        for (int i = 0 ; i < orders.size() ;i++){
            if(orders.get(i).getId() == id && orders.get(i).getCustomerID() == orderID  ){
                return i;
            }
        }
        return -1;
    }
    public void addOrder(Order order){
        int flag = findOrderByID(order.getId(),order.getCustomerID());
        if(flag == -1 ){
            this.orders.add(order);
        }
    }
    public void removeOrder(int id,int orderId){
        int pos = findOrderByID(id,orderId);
        if(pos != -1){
            this.orders.remove(pos);
        }
    }
    public String toString(){
        String text = "";
        for (int i = 0; i < orders.size();i++){
            text += orders.get(i).toSave() +"\n";
        }
        return text;
    }
    public void save(){
     try{
        File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\orders.txt");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(this);
        printWriter.flush();
         printWriter.close();
    }catch (Exception e){
         e.printStackTrace();
     }
    }
    public int size(){
        return orders.size();
    }
    public int generateOrderID(){
        if(this.orders.size()>0){
            return this.orders.get(orders.size()-1).getCustomerID()+1;
        }
        return 1;
    }
    public boolean findsavedOrder(int id,int customerID){
        for (Order m : orders){
            if(m.getId() == id && m.getCustomerID() == customerID){
                return true;
            }
        }
        return false;
    }
    public int[] activeUser(){
        int[] order = new int[10000];
      for(Order m : orders){
          order[m.getCustomerID()]++;
      }
      return order;
    }
    public int mostActiveUser(){
        int[] order = activeUser();
        int idCustomer= 0,max = 0;
        for (int i = 0;i < order.length;i++){
            if(order[i]> max){
                idCustomer = i;
                max = order[i];
            }

        }
        return idCustomer;
    }
    public String returnOrderByCustomerID(int customerId){
        String text = "";
        for(int i = 0 ; i < orders.size();i++){
            if(orders.get(i).getCustomerID() == customerId){
                text += orders.get(i);
            }

        }
        return text;
    }

}
