package ro.myClass.controller;

import ro.myClass.models.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerProduct {
    ArrayList<Product> products;

    public ControllerProduct() {
        this.products = new ArrayList<>();
        loadProduct();
    }

    public void loadProduct() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\product.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();

                this.products.add(new Product(text));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String showProduct() {
        String text = "";
        for (Product m : products) {
            text += m;
        }
     return text;
    }

    public int findbyName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public void add(Product product) {
        int pos = findbyName(product.getName());
        if (pos == -1) {
            products.add(product);
        }
    }

    public void remove(String name) {
        int pos = findbyName(name);
        if (pos != -1) {
            products.remove(pos);
        }
    }
    public String toString() {
        String text = "";
        for (int i = 0; i < products.size() -1; i++) {
            text += products.get(i).toSave() + "\n";
        }
        return text;
    }
    public void save() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\product.txt");
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
        return products.size();
    }
    public boolean findByProductName(String name){
        for (Product m : products){
            if(m.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public int generateProductID(){
        if(this.products.size()>0){
            return products.get(this.products.size()-1).getId()+1;
        }
        return 1;
    }

    public Product findProduct(String nameProduct){
        for(Product m : products){
            if(m.getName().equals(nameProduct))
                return m;
        }
        return null;
    }
    public Product returnProductbyID(int productId) {
        String text = "";
        for (Product m : products) {
            if (m.getId() == productId) {
                return m;
            }

        }
        return null;
    }
    public Product returnProductbyName(String name){
        for(Product m : products){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }



}
