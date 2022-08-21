package ro.myClass.models;

public class Customers extends User{

      private int ultimaComanda;
      private int nrComenzi;
      boolean activ;

      public Customers(int id,String firstName,String lastName,String email,String password,String tip,int ultimaComanda,int nrComenzi,boolean activ){
          super(id, firstName, lastName, email, password, tip);
          this.ultimaComanda = ultimaComanda;
          this.nrComenzi = nrComenzi;
          this.activ = activ;
      }
      public Customers(String text){
          super(text);
          String[] proprietes = text.split(",");
          this.ultimaComanda = Integer.parseInt(proprietes[6]);
          this.nrComenzi = Integer.parseInt(proprietes[7]);
          this.activ = Boolean.parseBoolean(proprietes[8]);
      }

      public String showCustomers(){
          String text = "";
          text += super.showUser();
          text += "\n Ultima comanda: " + ultimaComanda;
          text += "\n Nr Comenzi: " + nrComenzi;
          text += "\n Activ: " + activ;
          return text;
      }

      @Override
      public String toSave(){
          return super.toSave() +"," +ultimaComanda+","+nrComenzi+","+activ;
      }


    public int getUltimaComanda() {
        return ultimaComanda;
    }

    public void setUltimaComanda(int ultimaComanda) {
        this.ultimaComanda = ultimaComanda;
    }

    public int getNrComenzi() {
        return nrComenzi;
    }

    public void setNrComenzi(int nrComenzi) {
        this.nrComenzi = nrComenzi;
    }

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }
}
