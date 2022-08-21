package ro.myClass.models;

public class Products {
    private int id;
    private String name;
    private float price;
    private String image;
    private int stock;

    public Products(int id,String name,float price,String image,int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.stock = stock;
    }
    public Products(String text){
        String[]  proprietes = text.split(",");
        this.id = Integer.parseInt(proprietes[0]);
        this.name = proprietes[1];
        this.price = Float.parseFloat(proprietes[2]);
        this.image = proprietes[3];
        this.stock = Integer.parseInt(proprietes[4]);

    }


    public String showProduct(){
        String text= "";
        text += "ID:" + id;
        text += "\n Name product: " + name;
        text += "\n Price: " + price;
        text += "\n Image: " + image;
        text += "\n Stock: " + stock;
        text += "\n====================================\n";
        return text;
    }

    @Override
    public String toString(){
        String text= "";
        text += "ID:" + id;
        text += "\n Name product: " + name;
        text += "\n Price: " + price;
        text += "\n Image: " + image;
        text += "\n Stock: " + stock;
        return text;
    }
    @Override
    public boolean equals(Object obj){
        Products products = (Products) obj;

        return  products.getId()==this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return image;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public int getStock(){
        return stock;
    }
}
