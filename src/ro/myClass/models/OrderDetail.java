package ro.myClass.models;

public class OrderDetail {

    private int id;
    private int orderId;
    private int productId;
    private int quantity;

    public OrderDetail(int id,int orderId, int productId, int quantity){
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
    public OrderDetail(String text){
        if(text!="") {
            String[] proprietes = text.split(",");
            this.id = Integer.parseInt(proprietes[0]);
            this.orderId = Integer.parseInt(proprietes[1]);
            this.productId = Integer.parseInt(proprietes[2]);
            this.quantity = Integer.parseInt(proprietes[3]);
        }
    }
    public String showOrder(){
        String text ="";
        text += "Id" + id;
        text += "Order id: " + orderId;
        text += "\nProduct id: " + productId;
        text += "\nQuantity: " + quantity;
        text += "\n==================================\n";
        return text;
    }



    @Override
    public String toString(){
        String text ="";
        text += "Id" + id;
        text += "\nOrder id: " + orderId;
        text += "\nProduct id: " + productId;
        text += "\nQuantity: " + quantity;
        return text;

    }


    @Override
    public boolean equals(Object obj){
        OrderDetail orderDetails = (OrderDetail) obj;

        return orderDetails.orderId==this.orderId;
    }


    public String toSave(){
        return id+","+orderId+","+productId+","+quantity;
    }
    public int getOrderId() {
        return orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
