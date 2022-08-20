package ro.myClass.models;

public class OrderDetails extends Products {
    private int orderId;
    private int productId;
    private int quantity;

    public OrderDetails(String name,float price,String image,int stock,int orderId,int productId,int quantity){
        super(name, price, image, stock);
        this.orderId = orderId;
        this.productId = productId;
    }
    public OrderDetails(String text){
        super(text);
        String[] proprietes = text.split(",");
        this.productId = Integer.parseInt(proprietes[5]);
        this.quantity = Integer.parseInt(proprietes[6]);
    }

    @Override
    public String showProduct(){
        String text = "";
        text += "Name:" + super.getName();
        text += "\nPrice: " + super.getPrice();
        text += "\nImage:" + super.getImage();
        text += "\nStock:" + super.getStock();
        text += "\nProduct id:" + productId;
        text += "\n Quantity: " +quantity;
        text += "\n================================================\n";
        return text;
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
