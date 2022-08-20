package ro.myClass.models;

public class Customers extends Orders{
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    public Customers(String name,float price,String image,int stock,int orderId,int productId,int quantity,int customerID,int ammount,String orderDate,String email,String password,String firstName,String lastName){
        super(name, price, image, stock, orderId, productId, quantity, customerID, ammount, orderDate);
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Customers(String text) {
        super(text);
        String[] proprietes = text.split(",");
        this.email = proprietes[10];
        this.password = proprietes[11];
        this.firstName = proprietes[13];
        this.lastName = proprietes[14];
    }
    @Override
    public String showProduct(){
        String text = "";
        text += "Name:" + super.getName();
        text += "\nPrice: " + super.getPrice();
        text += "\nImage: " + super.getImage();
        text += "\nStock: " + super.getStock();
        text += "\nOrder ID: " + super.getOrderId();
        text += "\nProduct ID:" + super.getProductId();
        text += "\n Quantity: " + super.getQuantity();
        text += "\n Customer ID:" + super.getCustomerID();
        text += "\n Order date: " + super.getOrderDate();
        text += "\n Ammount:  " + super.getAmmount();
        text += "\n Email: " + email;
        text += "\n First name: " + firstName;
        text += "\n Last name: " + lastName;
        text += "\n=================================================\n";
        return text;
    }
}
