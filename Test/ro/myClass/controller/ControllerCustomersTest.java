package ro.myClass.controller;

import org.junit.jupiter.api.Test;
import ro.myClass.models.Administrator;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

import static org.junit.jupiter.api.Assertions.*;

class ControllerCustomersTest {


@Test

public void test1(){
    ControllerUser controllerUser = new ControllerUser();

    Customer customer = new Customer(231,"emanuel","olariu","olariuemanuel@gmail.com","olariuemanuel@gmail.com2022",32,1,true);
    Administrator admin = new Administrator(32,"Silviu","Alexandru","silviualexandru@gmail.com","silviualexandru@gmail.com2022","marketing");

    int size = controllerUser.size();
    controllerUser.add(customer);
    controllerUser.add(admin);

    assertEquals(size+2,controllerUser.size());


    controllerUser.show();







    }
}