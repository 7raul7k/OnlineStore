package ro.myClass;

import ro.myClass.View.ViewAdministrator;
import ro.myClass.View.ViewCustomer;
import ro.myClass.View.ViewLogin;
import ro.myClass.controller.ControllerUser;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

public class Main {
    public static void main(String[] args) {

//        ControllerUser controllerUser = new ControllerUser();
//
//        Customer customer = new Customer(231,"Popescu","Alex","popescualex@gmail.com","popescualex@gmail.com2022",32,5,true);
//
//        controllerUser.add(customer);
//        controllerUser.save();
//        controllerUser.load();
//
//        ViewCustomer viewCustomer = new ViewCustomer();
//        viewCustomer.play();

//        ViewAdministrator viewAdministrator = new ViewAdministrator();
//        viewAdministrator.play();

        ViewLogin viewLogin = new ViewLogin();
        viewLogin.play();


    }
}