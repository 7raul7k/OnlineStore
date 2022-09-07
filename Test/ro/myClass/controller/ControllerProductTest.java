package ro.myClass.controller;

import org.junit.jupiter.api.Test;
import ro.myClass.models.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerProductTest {

    @Test
    public void sizeTest(){
        ControllerProduct controllerProduct = new ControllerProduct();
        int size = controllerProduct.size();
        assertEquals(size,controllerProduct.size());
    }
    @Test
    public void saveTest(){
        ControllerProduct controllerProduct = new ControllerProduct();
        Product product = new Product(252,"Laptop ",2340,"www.pcgarage.ro/laptop",231);
        int size = controllerProduct.size();
        controllerProduct.add(product);
        controllerProduct.save();
        assertEquals(size+1,controllerProduct.size());
    }
    @Test
    public void addTest(){
        ControllerProduct controllerProduct = new ControllerProduct();
        Product product = new Product (421,"Tastatura gaming",300,"www.pcgarage.ro/tastatura-gaming-razer",20);
        int size = controllerProduct.size();
        controllerProduct.add(product);

        assertEquals(size+1,controllerProduct.size());
    }

    @Test
    public void removeTest(){
        ControllerProduct controllerProduct = new ControllerProduct();
        int size = controllerProduct.size();
        controllerProduct.remove("Procesor AMD Ryzen 5 5600G 3.9GHz box");
        assertEquals(size-1,controllerProduct.size());
    }

    @Test
    public void showTest(){
        ControllerProduct controllerProduct = new ControllerProduct();
        String text = controllerProduct.showProduct();

        assertEquals(text,controllerProduct.showProduct());
    }

    @Test
    public void findByNameTest(){
        ControllerProduct controllerProduct = new ControllerProduct();
        boolean flag = controllerProduct.findByProductName("Mouse Gaming Logitech G502 Lightspeed Wireless");
        assertEquals(false,controllerProduct.findByProductName("casti"));
        assertEquals(true,flag);
    }

    @Test
    public void toSaveTest(){
        ControllerProduct controllerProduct = new ControllerProduct();
        System.out.println(controllerProduct.toString());
    }

    @Test
    public void findProduct(){
    ControllerProduct controllerProduct = new ControllerProduct();
    Product product = controllerProduct.findProduct("Casti Gaming HyperX Cloud Alpha");

    assertEquals(product,controllerProduct.findProduct("Casti Gaming HyperX Cloud Alpha"));
    assertEquals(null,controllerProduct.findProduct("Laptop"));
    }

    @Test
    public void generateProductID(){
        ControllerProduct controllerProduct = new ControllerProduct();
        Product product = new Product(controllerProduct.generateProductID(),"Laptop Asus",2530,"https/laptop.com",23);
        int size = controllerProduct.size();
        controllerProduct.products.add(product);
        assertEquals(size +1 ,controllerProduct.size());

    }

    @Test
    public void returnProductbyID(){
        ControllerProduct controllerProduct = new ControllerProduct();
        Product product = controllerProduct.returnProductbyID(8);
        assertEquals(product,controllerProduct.returnProductbyID(8));
        assertEquals(null,controllerProduct.returnProductbyID(31421));
    }

    @Test
    public void returnProductByName(){
        ControllerProduct controllerProduct = new ControllerProduct();
        assertEquals(controllerProduct.returnProductbyID(7),controllerProduct.returnProductbyName("Mouse Gaming Logitech G502 Lightspeed Wireless"));
        assertEquals(null,controllerProduct.returnProductbyName("laptop gaming x218"));
    }



}
