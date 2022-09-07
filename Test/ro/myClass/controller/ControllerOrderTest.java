package ro.myClass.controller;

import org.junit.jupiter.api.Test;
import ro.myClass.models.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerOrderTest {
    @Test
    public void sizeTest(){
        ControllerOrder controllerOrder = new ControllerOrder();
        Order order = new Order(1,321,1900,"10 september");
        int size = controllerOrder.size();
        controllerOrder.addOrder(order);
        assertEquals(size+1,controllerOrder.size());
    }
    @Test
    public void addTest(){
        ControllerOrder controllerOrder = new ControllerOrder();
        Order order = new Order(2,11,2000,"14 october");
        int size = controllerOrder.size();
        controllerOrder.addOrder(order);
        assertEquals(size+1,controllerOrder.size());
    }
    @Test
    public void removeTest(){
        ControllerOrder controllerOrder = new ControllerOrder();
        Order order = new Order(4,103,100,"10 october");
        controllerOrder.addOrder(order);
        int size = controllerOrder.size();
        controllerOrder.removeOrder(4,103);
        assertEquals(size-1,controllerOrder.size());
    }
    @Test
    public void showTest(){
        ControllerOrder controllerOrder = new ControllerOrder();
        String text = controllerOrder.showOrders();
        assertEquals(text,controllerOrder.showOrders());
    }
    @Test
    public void toSaveTest(){
        ControllerOrder controllerOrder = new ControllerOrder();
        System.out.println(controllerOrder.toString());
    }
    @Test
    public void saveTest(){
        ControllerOrder controllerOrder = new ControllerOrder();
        int size = controllerOrder.size();
        Order order = new Order(231,102,1200,"10 June");
        controllerOrder.addOrder(order);
        controllerOrder.save();
        assertEquals(true,controllerOrder.findsavedOrder(231,102));
        assertEquals(false,controllerOrder.findsavedOrder(2314,4219));
    }
    @Test
    public void generateID(){
        ControllerOrder controllerOrder = new ControllerOrder();
        Order order = new Order(controllerOrder.generateOrderID(),1,12300,"10 june");
        controllerOrder.addOrder(order);
        assertEquals(controllerOrder.generateOrderID()-1,order.getId());
    }

}
