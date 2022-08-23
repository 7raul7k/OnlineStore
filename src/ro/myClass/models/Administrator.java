package ro.myClass.models;

public class Administrator extends User {
    private String domeniu;
    public Administrator(int id,String firstName,String lastName,String email,String password,String domeniu){
        super(id, firstName, lastName, email, password, "administrator");
        this.domeniu = domeniu;
    }
    public Administrator(String text){
        super(text);
        String[] proprietes = text.split(",");
        this.domeniu = proprietes[6];
    }
    public String showAdministrator(){
        String text = "";
        text += super.showUser();
        text += "Domeniu: " + domeniu;
        return text;
    }

    @Override
    public String toString(){
        String text = "";
        text += super.showUser();
        text += "\nDomeniu: " + domeniu;
        text += "\n=================================\n";
        return text;
    }
   @Override
    public String toSave(){
        return super.toSave() +","+domeniu;
    }




}
