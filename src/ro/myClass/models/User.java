package ro.myClass.models;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String tip;

    public User(int id,String firstName,String lastName,String email,int age,String tip){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.tip = tip;
    }
    public User(String text){
        String[] proprietes = text.split(",");
        this.id = Integer.parseInt(proprietes[0]);
        this.firstName = proprietes[1];
        this.lastName = proprietes[2];
        this.email = proprietes[3];
        this.age = Integer.parseInt(proprietes[4]);
        this.tip = proprietes[5];
    }
    public String showUser(){
        String text = "";
        text += "Id: " + id;
        text += "\nFirst Name: " + firstName;
        text += "\nLast Name: " + lastName;
        text += "\nEmail: " + email;
        text += "\nAge: " + age;
        text +="\nTip: " + tip;
        text +="\n==================================\n";
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
