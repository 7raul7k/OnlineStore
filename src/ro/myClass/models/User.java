package ro.myClass.models;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private String password;

    private String tip;

    public User(int id,String firstName,String lastName,String email,String password,String tip){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.tip = tip;
    }
    public User(String text){
        String[] proprietes = text.split(",");
        this.tip = proprietes[0];
        this.id = Integer.parseInt(proprietes[1]);
        this.firstName = proprietes[2];
        this.lastName = proprietes[3];
        this.email = proprietes[4];
        this.password = proprietes[5];

    }
    public String showUser(){
        String text = "";
        text += "Id: " + id;
        text += "\nFirst Name: " + firstName;
        text += "\nLast Name: " + lastName;
        text += "\nEmail: " + email;
        text +="\nTip: " + tip;
        return text;
    }

    @Override
    public String toString(){
        String text = "";
        text += "Id: " + id;
        text += "\nFirst Name: " + firstName;
        text += "\nLast Name: " + lastName;
        text += "\nEmail: " + email;
        text +="\nTip: " + tip;
        return text;
    }

    @Override
    public boolean equals(Object obj){
        User user = (User) obj;
        return user.id==this.id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String toSave(){
        return id+","+lastName+","+firstName+","+email+","+password+","+tip;
    }
}
