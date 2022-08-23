package ro.myClass.controller;

import ro.myClass.models.Administrator;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerUser {
    private ArrayList<User> users;

    public ControllerUser() {
        this.users = new ArrayList<>();
        load();
    }

    public void load() {
        try {

            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\user.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                switch (text.split(",")[0]) {
                    case "administrator":
                        this.users.add(new Administrator(text));
                        break;
                    case "customer":
                        this.users.add(new Customer(text));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        for (User m : users) {
            System.out.println(m);
        }
    }

    public int size() {
        return users.size();
    }

    public void add(User user) {
        boolean pos = this.findbyEmail(user.getEmail());

        if (pos == false) {

        this.users.add(user);

    }

}
        public String toString() {
            String text = "";
            for (int i = 0; i <= users.size(); i++) {
                text += users.get(i).toSave() + "\n";
            }
            return text;
        }

        public void save() {
            try {
                File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineStore\\src\\ro\\myClass\\resources\\user.txt");
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.print(this);

                printWriter.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public boolean findbyEmail(String email){
        for (User m : users){
            if(m.getEmail().equals(email)){
                return true;
            }
        }
        return false;
        }
    }

