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
                this.products.add(new Product(scanner.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showProduct() {
        for (Product m : products) {
            System.out.println(m.showProduct());
        }
    }

    public int findbyName(String name) {
        for (int i = 0; i <= products.size(); i++) {
            if (products.get(i).getImage().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Product product) {
        int pos = findbyName(product.getName());
        if (pos == -1) {
            this.products.add(product);
        }
    }

    public void remove(String name) {
        int pos = findbyName(name);
        if (pos != -1) {
            this.products.remove(pos);
        }
    }

    public String toString() {
        String text = "";
        for (int i = 0; i <= products.size(); i++) {
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
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
