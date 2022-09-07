package ro.myClass.controller;

import org.junit.jupiter.api.Test;
import ro.myClass.models.Administrator;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

import static org.junit.jupiter.api.Assertions.*;

class ControllerCustomersTest {

    @Test
    public void removeTest() {
        ControllerUser controllerUser = new ControllerUser();
        int size = controllerUser.size();
        controllerUser.delete("schiopu");
        assertEquals(size-1, controllerUser.size());

    }

    @Test
    public void saveTest() {
        ControllerUser controllerUser = new ControllerUser();
        Customer customer = new Customer(231, "Popescu", "Alex", "popescualex@gmail.com", "popescualex@gmail.com2022", 32, 5, true);
        int size = controllerUser.size();
        controllerUser.add(customer);
        controllerUser.save();
        assertEquals(size + 1, controllerUser.size());
    }

    @Test
    public void findbyEmail() {
        ControllerUser controllerUser = new ControllerUser();
        Customer customer = new Customer(231, "Popescu", "Alex", "popescualex1@gmail.com", "popescualex@gmail.com2022", 32, 5, true);
        boolean flag = controllerUser.findbyEmail(customer.getEmail());
        boolean pos = controllerUser.findbyEmail("marcualex@gmail.com");
        assertEquals(false, flag);
        assertEquals(true, pos);

    }

    @Test
    public void findUserbyNameTest() {
        ControllerUser controllerUser = new ControllerUser();
        assertEquals(true,controllerUser.findUserByName("alin"));
        assertEquals(false,controllerUser.findUserByName("giani"));
    }
    @Test
    public void show(){
        ControllerUser controllerUser = new ControllerUser();
        String text = controllerUser.show();
        assertEquals(text,controllerUser.show());
    }

    @Test
    public void findbyNameTest(){
        ControllerUser controllerUser = new ControllerUser();
        User user = new User(controllerUser.generateUserID(), "Marian","Petrea","petreamarian@gmail.com","petreamarian@gmail.com2022","customer");
        assertEquals(controllerUser.findbyName("Marian"),controllerUser.findbyName("Marian"));

    }

}