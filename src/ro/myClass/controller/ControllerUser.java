package ro.myClass.controller;

import ro.myClass.models.Administrator;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

import java.io.*;
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
                switch (text.split(",")[5]) {
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

    public String show() {
        String text = "";
       for(int i = 0 ;i < users.size();i++){
           text += users.get(i);
       }
       return text;
    }

    public int size() {
        return users.size();
    }

    public void add(User user) {
        boolean pos = findbyEmail(user.getEmail());

        if (pos == false) {

            this.users.add(user);

        }

    }

    public int findbyName(String firstName) {
        for (int i = 0; i < users.size() ; i++) {
            if (users.get(i).getFirstName().equals(firstName)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String firstName) {
        int pos = findbyName(firstName);
        if (pos != -1) {
            users.remove(pos);
        }
    }

    public String toString() {
        String text = "";
        for (int i = 0; i < users.size() - 1; i++) {
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
            printWriter.flush();
            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean findbyEmail(String email) {

        for (User m : users) {

            if (m.getEmail().equals(email)) {

                return true;
            }

        }

        return false;

    }

    public boolean findUserByName(String firstName) {
     for (User m : users){
         if(m.getFirstName().equals(firstName))
             return true;
     }
        return false;
    }
    public int generateUserID(){

         if(this.users.size()>0){

             return  this.users.get(this.users.size()-1).getId()+1;
         }
        return 1;
    }

    public User userLogin(String email, String password) {
        for (User m : users){
            if(m.getEmail().equals(email) && m.getPassword().equals(password)){
                return m;
            }
        }
        return null;
    }

    public boolean verifyEmail(String email) {
        for (User m : users){
            if(m.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}

