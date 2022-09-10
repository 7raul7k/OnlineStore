package ro.myClass.View;

import ro.myClass.controller.ControllerUser;
import ro.myClass.models.Administrator;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

import java.util.Scanner;

public class ViewLogin {
    ControllerUser controllerUser;
    Scanner scanner;

    public ViewLogin(){
        this.controllerUser = new ControllerUser();
        scanner = new Scanner(System.in);
    }

    public void show(){
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to register");
    }
    public void play(){
        boolean running = true;
        while(running){
            show();
            System.out.println("Input number:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 : loginUser();
                break;
                case 2 : registerUser();
                break;
                default:
            }
        }
    }
    public void loginUser(){
        System.out.println("Input email:");
        String email = scanner.nextLine();
        System.out.println("Input password");
        String password = scanner.nextLine();

        User user = this.controllerUser.userLogin(email,password);

        if (user != null) {
            if (user.getTip().equals("administrator")) {
                ViewAdministrator viewAdministrator = new ViewAdministrator(user);
                viewAdministrator.play();
            }
            if (user.getTip().equals("customer")) {
                ViewCustomer viewCustomer = new ViewCustomer(user);
                viewCustomer.play();
            }
        }
    }
    public void registerUser(){
        System.out.println("Input first name: ");
        String firstName=  scanner.nextLine();
        System.out.println("Input last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Input email:");
        String email = scanner.nextLine();
        System.out.println("Input password:");
        String password = scanner.nextLine();
        System.out.println("Input type: ");
        String type = scanner.nextLine();
        if(controllerUser.verifyEmail(email)== true){
            System.out.println("This email exist");
        }else {
            if (type.equals("customer")){
                Customer customer = new Customer(controllerUser.generateUserID(), firstName, lastName, email, password, 0, 0, true);
                controllerUser.add(customer);
                System.out.println("You have successfully registered");
            }
            if (type.equals("administrator")) {
                System.out.println("Input your domain");
                String domain = scanner.nextLine();
                Administrator administrator = new Administrator(controllerUser.generateUserID(), firstName, lastName, email, password, domain);
                controllerUser.add(administrator);
                System.out.println("You have successfully registered");
            }
        }


    }
}
