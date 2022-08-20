package ro.myClass.models;

public class Orders extends OrderDetails {
    private int customerID;
    private int ammount;
    private String orderDate;

    public Orders(String name,float price,String image,int stock,int orderId,int productId,int quantity,int customerID,int ammount,String orderDate){
        super(name, price, image, stock, orderId, productId, quantity);
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.ammount = ammount;
    }
    public Orders(String text){
        super(text);
        String[] proprietes = text.split(",");
        this.customerID = Integer.parseInt(proprietes[7]);
        this.orderDate = proprietes[8];
        this.ammount = Integer.parseInt(proprietes[9]);

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
        text += "\n Customer ID:" + customerID;
        text += "\n Order date: " + orderDate;
        text += "\n Ammount:  " + ammount;
        text += "\n==================================================\n";
        return text;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
