package ro.myClass.controller;

import ro.myClass.models.Order;

import java.io.File;
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
    public void showOrders(){
        for(Order m : orders){
            System.out.println(m.showOrders());
        }
    }
    public int findOrderByID(int id){
        for (int i = 0 ; i<= orders.size();i++){
            if(orders.get(i).getCustomerID() == id ){
                return i;
            }
        }
        return -1;
    }
    public void addOrder(Order order){
        int flag = findOrderByID(order.getCustomerID());
        if(flag == -1 ){
            this.orders.add(order);
        }
    }
    public void removeOrder(int id){
        int pos = findOrderByID(id);
        if(pos != -1){
            this.orders.remove(pos);
        }
    }
    public String toString(){
        String text = "";
        for (int i = 0; i <= orders.size();i++){
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
        printWriter.close();
    }catch (Exception e){
         e.printStackTrace();
     }
    }


}
