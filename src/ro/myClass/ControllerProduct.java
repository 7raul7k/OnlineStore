package ro.myClass;

import ro.myClass.models.Products;

import java.io.File;
import java.util.ArrayList;

public class ControllerProduct {
    ArrayList<Products> products;
    public ControllerProduct(){
        this.products = new ArrayList<>();
        this.load();

    }
    public void load(){
        try {
            File file = new File();
        }catch (Exception e){

            e.printStackTrace();
        }

    }

}
