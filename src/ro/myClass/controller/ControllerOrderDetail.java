package ro.myClass.controller;

import ro.myClass.models.OrderDetail;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOrderDetail {
    ArrayList<OrderDetail> orderDetails;
    public ControllerOrderDetail(){
        this.orderDetails = new ArrayList<>();
        load();
    }
    public void load(){
        try{
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\orderdetails.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                this.orderDetails.add(new OrderDetail(scanner.nextLine()));
            }
        }catch (Exception e){
             e.printStackTrace();
        }

        }
    public void showOrderDetails(){
        for(OrderDetail m : orderDetails)
        {
            System.out.println(m.showOrder());
        }
    }
    public int findbyProductID(int id){
        for(int i = 0;i<= orderDetails.size();i++){
            if(orderDetails.get(i).getProductId() == id){
                return i;
            }
        }
        return -1;
    }
    public void addOrderDetail(OrderDetail orderDetail){
        int pos = findbyProductID(orderDetail.getProductId());
        if(pos == -1){
            this.addOrderDetail(orderDetail);
        }
    }
    public void removeOrderDetail(int id){
        int pos = findbyProductID(id);
        if(pos != -1){
            this.orderDetails.remove(pos);
        }
    }
    public String toString(){
        String text = "";
        for (int i = 0 ; i <= orderDetails.size();i++){
            text += orderDetails.get(i).toSave() +"\n";
        }
        return text;
    }
    public void save(){
        try{
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\orderdetails.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
