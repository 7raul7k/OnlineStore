package ro.myClass.models;

public class Order {
    private int id;
    private int customerID;
    private float ammount;
    private String orderDate;

    public Order(int id,int customerID, float ammount, String orderDate){
      this.id = id;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.ammount = ammount;
    }
    public Order(String text){
        String[] proprietes = text.split(",");
        if(text!="") {
            this.id = Integer.parseInt(proprietes[0]);
            this.customerID = Integer.parseInt(proprietes[1]);
            this.orderDate = proprietes[2];
            this.ammount = Float.parseFloat(proprietes[3]);
        }
    }
    public String showOrders(){
        String text = "";
        text += "ID:" + id;
        text += "\nCustomer ID:" + customerID;
        text += "\nOrder Date: " + orderDate;
        text += "\nAmmount: " + ammount;
        text += "\n==========================================\n";
        return text;
    }

    @Override
    public String toString(){
        String text = "";
        text += "ID:" + id;
        text += "\nCustomer ID:" + customerID;
        text += "\nOrder Date: " + orderDate;
        text += "\nAmmount: " + ammount;
        text += "\n========================================\n";
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Order order = (Order) obj;
        return order.customerID==this.customerID;
    }

    public String toSave(){
        return id+","+customerID+","+orderDate+","+ammount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
