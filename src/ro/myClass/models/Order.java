package ro.myClass.models;

public class Orders {
    private int customerID;
    private int ammount;
    private String orderDate;

    public Orders(int customerID,int ammount,String orderDate){
      this.customerID = customerID;
        this.orderDate = orderDate;
        this.ammount = ammount;
    }
    public Orders(String text){
        String[] proprietes = text.split(",");
        this.customerID = Integer.parseInt(proprietes[0]);
        this.orderDate = proprietes[1];
        this.ammount = Integer.parseInt(proprietes[2]);

    }
    public String showOrders(){
        String text = "";
        text += "Customer ID:" + customerID;
        text += "\nOrder Date: " + orderDate;
        text += "\nAmmount: " + ammount;
        text += "\n==========================================\n";
        return text;
    }

    @Override
    public String toString(){
        String text = "";
        text += "Customer ID:" + customerID;
        text += "\nOrder Date: " + orderDate;
        text += "\nAmmount: " + ammount;
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Orders orders = (Orders) obj;
        return orders.customerID==this.customerID;
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
