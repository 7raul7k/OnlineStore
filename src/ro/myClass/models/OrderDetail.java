package ro.myClass.models;

public class OrderDetail {
    private int orderId;
    private int productId;
    private int quantity;

    public OrderDetail(int orderId, int productId, int quantity){
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
    public OrderDetail(String text){
        String[] proprietes = text.split(",");
        this.orderId = Integer.parseInt(proprietes[0]);
        this.productId = Integer.parseInt(proprietes[1]);
        this.quantity = Integer.parseInt(proprietes[2]);
    }
    public String showOrder(){
        String text ="";
        text += "Order id: " + orderId;
        text += "Product id: " + productId;
        text += "Quantity: " + quantity;
        text += "\n==================================\n";
        return text;
    }



    @Override
    public String toString(){
        String text ="";
        text += "Order id: " + orderId;
        text += "Product id: " + productId;
        text += "Quantity: " + quantity;
        return text;

    }


    @Override
    public boolean equals(Object obj){
        OrderDetail orderDetails = (OrderDetail) obj;

        return orderDetails.orderId==this.orderId;
    }

    public String toSave(){
        return orderId+","+productId+","+quantity;
    }
    public int getOrderId() {
        return orderId;
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
